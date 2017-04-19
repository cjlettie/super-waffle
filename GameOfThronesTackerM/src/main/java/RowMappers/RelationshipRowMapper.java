/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMappers;

import Models.MainCharacter;
import Models.Relationship;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author crisp
 */
public class RelationshipRowMapper implements RowMapper<Relationship>{
    
    @Override
    public Relationship mapRow(ResultSet rs, int i) throws SQLException
    {
        String oP = rs.getString("char2Name");
        int n = rs.getInt("neutrality");
        int s = rs.getInt("relStatus");
        String rD = rs.getString("relationDesc");
        return new Relationship(oP, n, s, rD);
    }
    
}
