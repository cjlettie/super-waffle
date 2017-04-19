/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowMappers;

import Models.House;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author crisp
 */
public class HouseRowMapper implements RowMapper<House>{
    @Override
    public House mapRow(ResultSet rs, int i) throws SQLException
    {
        String n = rs.getString("hName");
        String b = rs.getString("banner");
        String w = rs.getString("words");
        int s = rs.getInt("houseStatus");
        return new House(n, b, w, s);
    }
}
