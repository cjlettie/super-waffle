/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Models.MainCharacter;
import RowMappers.CharacterRowMapper;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author crisp
 */
public class CharacterDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public boolean killCharacter(String charName){
        this.jdbcTemplate.update("update maincharacter set charStatus = 0 where charName LIKE '%' || ? || '%';", new Object[]{charName});
        return true;
    }
    
    public boolean addCharacter(int charID, String charName, String title, int charStatus, String religion)
    {
        this.jdbcTemplate.update("insert into maincharacter (charID,\"charName\",\"title\",\"charStatus\",\"religion\") values (?,?,?,?,?);", 
                new Object[]{charID, charName, title, charStatus, religion});
        return true; 
    }
    
    public ArrayList<String> getLivingChars()
    {
        return (ArrayList<String>) this.jdbcTemplate.queryForList("SELECT MC.charName FROM MainCharacter MC WHERE MC.charStatus = 1;", String.class);
    }
    
    public ArrayList<MainCharacter> getAllCharacters()
    {
        return (ArrayList<MainCharacter>) this.jdbcTemplate.query("select * from maincharacter order by charName;", new CharacterRowMapper());
    }   
    
}
