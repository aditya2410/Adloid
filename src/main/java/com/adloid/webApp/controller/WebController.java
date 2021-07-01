package com.adloid.webApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adloid.webApp.model.*;
import com.adloid.webApp.repository.RedisRepository;

@Controller
@RequestMapping("/")
public class WebController {
    
    @Autowired
    private RedisRepository redisRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/getDetails")
    public String getDetails() {
        return "getDetails";
    }

    @RequestMapping(value = "/user",params = {"emailId"}, method = RequestMethod.GET)
    public @ResponseBody Map<String, String> getUserDetails(@RequestParam String emailId ) {
        HashMap<String, String> map = new HashMap<String, String>();
        
        User user = redisRepository.findUser(emailId);
        if(user==null) return map;
        map.put("Name", user.getName());
        map.put("age", user.getAge());
        map.put("Occupation", user.getOccupation());
        map.put("emailId", user.getEmailId());
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(
        @RequestParam String name,
        @RequestParam String age,
        @RequestParam String emailId,
        @RequestParam String occupation) {
        
        User user = new User(name, age, emailId, occupation);
        
        redisRepository.add(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   
}
