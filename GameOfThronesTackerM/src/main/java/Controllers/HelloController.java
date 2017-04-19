/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.TestDAO;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/hello")
public class HelloController implements Controller { 
    
    
    @Autowired
    TestDAO tDAO;

    @RequestMapping(value = "/login/{userID}/{password}", method = RequestMethod.GET)
    public ModelAndView loginAttempt(@PathVariable("userID") String userID, @PathVariable("password") String password)
    {
        ModelAndView model = new ModelAndView();
        String rPass = tDAO.checkLogin(userID);
        if(!rPass.equals(password))
        {
            model.addObject("error", "Invalid username and password");
        }
        else
        {
            model.addObject("msg", "Login Success");
        }
        
        return model;
    }
    
    @RequestMapping(value = "/reader/{userID}", method = RequestMethod.GET)
    public ModelAndView reader(@PathVariable("userID") int userID) {

        ModelAndView m = new ModelAndView();
        m.setViewName("/reader");
        m.addObject("theoryList", tDAO.getUserTheories(userID));
        m.addObject("accuracy", tDAO.getUserAccuracy(userID));
        m.addObject("topTheorists", tDAO.getStars());
        return m;
    }
    
    @RequestMapping(value = "/reader/theoryCall/{stuff}", method = RequestMethod.GET)
    public ModelAndView theoryUpdate(@PathVariable("stuff") List<String> stuff, ModelAndView m)
    {
        return m;
    }
    
    @RequestMapping(value = "/reader/charcall/{name}", method = RequestMethod.GET)
    public ModelAndView characterCall(@PathVariable("name") String name, ModelAndView m) 
    {
        m.addObject("charInfo", tDAO.getChar(name));
        m.addObject("charRels", tDAO.getCharRels(name));
        return m; 
    }
    
    @RequestMapping(value = "/reader/housecall/{name}", method = RequestMethod.GET)
    public ModelAndView houseCall(@PathVariable("name") String name, ModelAndView m) 
    {
        m.addObject("houseInfo", tDAO.getHouse(name));
        m.addObject("houseMems", tDAO.getHouseMems(name));
        return m; 
    }
    
    @RequestMapping(value = "/reader/factioncall/{name}", method = RequestMethod.GET)
    public ModelAndView factionCall(@PathVariable("name") String name, ModelAndView m) 
    {
        m.addObject("factionInfo", tDAO.getFollowers(name));
        return m; 
    }
    
    @RequestMapping(value = "/writer", method = RequestMethod.GET)
    public ModelAndView writer() {

        ModelAndView m = new ModelAndView();
        m.setViewName("/writer");
        m.addObject("livingChars", tDAO.getLivingChars());
        return m;
    }
    
    @RequestMapping(value = "/writer/createcharcall/{charname}/{title}/{charStatus}/{religion}")
    public ModelAndView createCharacter(@PathVariable("charname") String charname, @PathVariable("title") String title,
            @PathVariable("charStatus") int charStatus, @PathVariable("religion") String religion)
    {
        tDAO.addCharacter(charname, title, charStatus, religion);
        return writer();
        
    }
    
    @RequestMapping(value = "/writer/killchar/{charname}")
    public ModelAndView killCharacter(@PathVariable("charname") String charname)
    {
        tDAO.killCharacter(charname);
        return writer();
    }
    
    
    protected final Log logger = LogFactory.getLog(getClass()); 
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        logger.info("Returning hello view"); 
        return new ModelAndView("redirect.jsp");
    } 
}