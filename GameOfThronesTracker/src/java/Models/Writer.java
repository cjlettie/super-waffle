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
public class Writer extends User {
    private int writerID;
    
    public Writer(String username, String password, int wID)
    {
        super(username, password);
        writerID = wID; 
    }
    
    public int getReaderID()
    {
        return writerID;
    }
}