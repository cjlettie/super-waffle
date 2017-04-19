/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMappers;

import Models.UserTheory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author crisp
 */
public class UserTheoryRowMapper implements RowMapper<UserTheory> {
    @Override 
    public UserTheory mapRow(ResultSet rs, int i) throws SQLException
    {
        int tID = rs.getInt("theoryID"); 
        String tDesc = rs.getString("theoryDescription"); 
        int tS = rs.getInt("theoryStatus");
        return new UserTheory(tID, tDesc, tS);
    } 
}

