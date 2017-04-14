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
public class MainCharacter {
    private int charID;
    private String charName; 
    private String title; 
    private int charStatus; 
    private String religion;
    
    public MainCharacter(int cID, String cName, String t, int cStatus, String r)
    {
        charID = cID; 
        charName = cName; 
        title = t; 
        charStatus = cStatus; 
        religion = r; 
    }
    
    public void setStatus(int newStatus)
    {
        charStatus = newStatus; 
    }
    
    public void setReligion(String newReligion)
    {
        religion = newReligion; 
    }
    
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }
    
    public int getCharID()
    {
        return charID; 
    }
    public String getCharName()
    {
        return charName; 
    }
    public String getTitle()
    {
        return title;
    }
    public String getReligion()
    {
        return religion; 
    }
    public int getCharStatus()
    {
        return charStatus; 
    }
    
}
