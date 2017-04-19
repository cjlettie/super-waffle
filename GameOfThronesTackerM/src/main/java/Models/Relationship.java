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
public class Relationship {
    private String otherPerson; 
    private int neutrality; 
    private int status; 
    private String relationshipDescription; 
    
    public Relationship(String oP, int n, int s, String rD)
    {
        otherPerson = oP; 
        neutrality = n; 
        status = s; 
        relationshipDescription = rD; 
    }
    
    public String getOtherPerson()
    {
        return otherPerson; 
    }
    public int getNeutrality()
    {
        return neutrality;
    }
    public int getStatus()
    {
        return status;
    }
    public String getRelDesc()
    {
        return relationshipDescription;
    }
}
