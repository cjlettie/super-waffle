/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Models.Faction;
import Models.House;
import Models.MainCharacter;
import Models.Relationship;
import Models.UserTheory;
import RowMappers.CharacterRowMapper;
import RowMappers.FactionRowMapper;
import RowMappers.HouseRowMapper;
import RowMappers.RelationshipRowMapper;
import RowMappers.UserTheoryRowMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author crisp
 */
public class TestDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public String checkLogin(String username)
    {
        return this.jdbcTemplate.queryForObject("select userpassword from mainuser where username LIKE '%' || ? || '%';", new Object[]{username}, String.class);
    }
    
    //get theories + their status for a user    
    public List<UserTheory> getUserTheories(int userID)
    {
        return (List<UserTheory>) this.jdbcTemplate.query(
                "select hasatheory.theoryID, hasatheory.theoryDescription, hasatheory.theoryStatus "
                        + "from mainuser, hasatheory "
                        + "where mainuser.userID = hasatheory.userID AND mainuser.userID = ?;", new Object[]{userID}, new UserTheoryRowMapper());
    }
    

    //get % accuracy for a user's theories 
    public int getUserAccuracy(int userID)
    {
        ColumnMapRowMapper rowMapper = new ColumnMapRowMapper(); 
        
        List<Map<String, Object>> rows = this.jdbcTemplate.query("select theoryStatus, COUNT(*) as count "
                + "from mainuser, hasatheory where mainuser.userID = hasatheory.userID "
                + "AND mainuser.userID = ? group by hasatheory.theoryStatus;", new Object[]{userID}, rowMapper);
        /*ex) 1st row: {theorystatus : 0, count :1} 2nd row: {theory status 1, count: 2}*/
        int right = 0;
        int wrong = 0;
        for (Map<String, Object> row : rows)
        {
            int x = (Integer) row.get("theoryStatus");
            if(x == 0)
            {
                wrong = (Integer) row.get("count");
            }
            if(x == 1)
            {
                right = (Integer) row.get("count");
            }
            
        }
        return (right / (right + wrong)) * 100;
        
    }
    
    public List<String> getStars()
    {
        ColumnMapRowMapper rowMapper = new ColumnMapRowMapper();
        List<Map<String, Object>> rows = this.jdbcTemplate.query("select TOP 3 mainuser.username, COUNT(*) as count from mainuser,"
                + " hasatheory AND mainuser.userID = hasatheory.userID AND hasatheory.theoryStatus = 1"
                + " group by mainuser.username having count(*) > 3;", rowMapper);
        List<String> result = new ArrayList<String>(); 
        for(Map<String, Object> row: rows)
        {
            result.add((String) row.get("username"));
        }
        return result;  
    }
    
    //update theories - set accuracy 
    public boolean setTheoryStatus(int theoryID, int newStatus)
    {
        this.jdbcTemplate.update("update hasatheory set theoryStatus = ? where theoryID = ?;", new Object[]{newStatus, theoryID});
        return true;
    }
    
    //given char name, get name, title, religion, house **limit 1
    public MainCharacter getChar(String charName)
    {
        return this.jdbcTemplate.queryForObject("select TOP 1 * from mainCharacter where charName LIKE '%' || ? || '%';", new Object[]{charName}, new CharacterRowMapper());
    }
    
    //get all of that char's rels: other name, status, neutrality, description
    public List<Relationship> getCharRels(String charName)
    {
        return this.jdbcTemplate.query("select mainCharacter.charName as char2Name, relationship.neutrality, relationship.relStatus, relationship.relationDesc" 
        + "from relationship, characterhasarelationship, mainCharacter"
        + "where characterhasarelationship.charID1 = (select TOP 1 charID from mainCharacter where charName LIKE '%' || ? || '%') "
        + "AND relationship.relID = characterhasarelationship.relID" 
        + "AND characterhasarelationship.charID2 = mainCharacter.charID",new Object[]{charName}, new RelationshipRowMapper());  
    }
    
    //given house name, get name, words, banner **limit 1 
    public House getHouse(String hName)
    {
        return this.jdbcTemplate.queryForObject("select TOP 1 * from house where hName LIKE '%' || ? || '%';", new Object[]{hName}, new HouseRowMapper());
    }
    
    //get all members of that house, name, status, title
    public List<MainCharacter> getHouseMems(String hName)
    {
        return this.jdbcTemplate.query("select mainCharacter.charID, mainCharacter.charName,mainCharacter.title,"
                + " mainCharacter.charStatus, mainCharacter.religion"
                + "from mainCharacter, characterbelongstohouse"
                + "where characterbelongstohouse.hName LIKE '%' || ? || '%'"
                + "AND characterbelongstohouse.charID = mainCharacter.charID", new Object[]{hName}, new CharacterRowMapper());
    }
    
    //given faction leader *select top 1 , get char members, faction name 
    public List<Faction> getFollowers(String lName)
    {
        return this.jdbcTemplate.query("select houseisamemberfaction.hName, houseisamemberfaction.fName, maincharacter.charName as leaderName, houseisamemberfaction.factionStatus "
                + "from houseisamemberfaction, maincharacter"
                + "where houseisamemberfaction.leader IN (select TOP 1 maincharacter.charID from maincharacter where maincharacter.charName LIKE '%' || ? || '%')"
                + "AND maincharacter.charID = houseisamemberfaction.leader;", new Object[]{lName}, new FactionRowMapper());
    }
    //insert, add character given name, title, status, religion
    public boolean addCharacter(String charName, String title, int charStatus, String religion)
    {
        this.jdbcTemplate.update("insert into maincharacter (charName,\"title\",\"charStatus\",\"religion\") values (?,?,?,?);", 
                new Object[]{charName, title, charStatus, religion});
        return true; 
    }
    
    
    //get all living characters' name, status, title, religion
    public List<MainCharacter> getLivingChars()
    {
        return this.jdbcTemplate.query("select * from mainCharacter where charStatus = 1;", new CharacterRowMapper());
    }
    
    //TODO: name isn't unique
    //kill character given name
    public boolean killCharacter(String charName){
        this.jdbcTemplate.update("update maincharacter set charStatus = 0 where charName LIKE '%' || ? || '%';", new Object[]{charName});
        return true;
    }
   
}