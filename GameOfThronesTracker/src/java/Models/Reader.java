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
public class Reader extends User {
    private int readerID;
    
    public Reader(String username, String password, int rID)
    {
        super(username, password);
        readerID = rID; 
    }
    
    public int getReaderID()
    {
        return readerID;
    }
    
}
