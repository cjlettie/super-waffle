/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMappers;

import Models.MainCharacter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author crisp
 */
public class CharacterRowMapper implements RowMapper<MainCharacter>{
    
    @Override
    public MainCharacter mapRow(ResultSet rs, int i) throws SQLException
    {
        int charID = rs.getInt("charID");
        String charName = rs.getString("charName");
        String title = rs.getString("title");
        int charStatus = rs.getInt("charStatus");
        String religion = rs.getString("religion");
        return new MainCharacter(charID, charName, title, charStatus, religion);
    }
    
}
