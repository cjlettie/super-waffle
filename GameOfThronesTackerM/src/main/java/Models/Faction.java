/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author crisp
 */
public class Faction {
    private String hName; 
    private String fName;
    private String leaderName;
    private int status; 
    
    public Faction(String h, String f, String l, int s)
    {
        hName=  h; 
        fName = f; 
        leaderName = l;
        status = s;
    }
    public String getHName()
    {
        return hName;
    }
    public String getFName()
    {
        return fName; 
    }
    public int getStatus()
    {
        return status;
    }
    public String getLeader()
    {
        return leaderName;
    }
    
}
