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
public class House {
    private String name; 
    private String banner; 
    private String words;
    private int status;
    
    public House(String n, String b, String w, int s)
    {
        name = n; 
        banner = b; 
        words = w; 
        status = s; 
    }
    
    public void setStatus(int newS)
    {
        status = newS; 
    }
    
    public String getName()
    {
        return name;
    }
    public String getBanner()
    {
        return banner; 
    }
    public String getWords()
    {
        return words; 
    }
    public int getStatus()
    {
        return status;
    }
    
}
