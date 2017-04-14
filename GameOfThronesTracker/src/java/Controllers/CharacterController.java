/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAOs.CharacterDAO;
import Models.MainCharacter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author crisp
 */
@Controller
public class CharacterController {
    
    @Autowired 
    CharacterDAO cDAO; 
    
    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public ModelAndView charactersView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/characters");
        ArrayList<MainCharacter> charList = (ArrayList<MainCharacter>) cDAO.getAllCharacters();
        model.addObject("characters", charList);
        return model;
    
    }
    
    @RequestMapping(value = "/character/add/{charID}/{name}/{title}/{status}/{religion}", method = RequestMethod.GET)
    public ModelAndView addCharacter(@PathVariable("charID") int charID, @PathVariable("name") String name, 
            @PathVariable("title") String title, @PathVariable("status") int status, @PathVariable("religion") String religion)
    {
        cDAO.addCharacter(charID, name, title, status, religion);
        return charactersView();
    }
}
