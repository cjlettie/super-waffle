/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author crisp
 * hasatheory.theoryID, hasatheory.theoryDescription, hasatheory.theoryStatus 
 */
public class UserTheory {
    private int theoryID; 
    private String theoryDesc;
    private int theoryStatus; 
    
    public UserTheory(int tID, String tDes, int tS)
    {
        theoryID = tID; 
        theoryDesc = tDes; 
        theoryStatus = tS;
    }
    
    public int getTheoryID()
    {
        return theoryID; 
    }
    public String getTheoryDesc()
    {
        return theoryDesc; 
    }
    public int getTheoryStatus()
    {
        return theoryStatus; 
    }
    
    
}
