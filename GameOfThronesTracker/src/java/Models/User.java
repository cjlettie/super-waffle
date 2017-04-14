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
public abstract class User {
    private String username; 
    private String password;
    
    public User(String u, String p)
    {
        username = u; 
        password = p; 
    }
    
    public String getUsername()
    {
        return username; 
    }
    
    public String getPassword()
    {
        return password;
    }
    
}
