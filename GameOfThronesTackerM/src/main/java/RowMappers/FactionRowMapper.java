/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMappers;

import Models.Faction;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author crisp
 */
public class FactionRowMapper implements RowMapper<Faction>{
    @Override 
    public Faction mapRow(ResultSet rs, int i) throws SQLException
    {
        String h = rs.getString("hName");
        String f = rs.getString("fName");
        int s = rs.getInt("factionStatus");
        String l = rs.getString("leaderName");
        return new Faction(h, f, l, s);
    }
}
