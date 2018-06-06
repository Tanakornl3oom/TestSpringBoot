package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repositories.Userrepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/test")
public class testcontrol {

    @Autowired
    private Userrepositories repository;


    @RequestMapping("/")
    public String test(){
        return "testing /test";
    }

    @RequestMapping("/find")
    public String findAll() {
        String result = "";
        for (User u : repository.findAll()) {
            result += u.toString() + "<br>";
        }
        return result;
    }

    @RequestMapping(value = "/find/{userid}" , method = RequestMethod.GET)
    public String findById(@PathVariable("userid") long userid) {
        String result = "hello";
        result += repository.getOne(userid);
        return result;
    }

    @RequestMapping("/save")
    public String save(){
        repository.save(new User("first 1","last 1"));
        repository.save(new User("first 2","last 2"));
        repository.save(new User("first 3","last 3"));

        return "Save Done";
    }

    @RequestMapping(value="/adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody User u){

        if(u.getlastname() == "" || u.getusername() == "")
            return "body invalid";
        repository.save(new User(u.getusername(),u.getlastname()));
        return "add user Done";
    }

    @RequestMapping(value = "/edit/{userid}" , method = RequestMethod.PUT)
    public String editById(@PathVariable("userid")long userid,@RequestBody User u) {

        if(u.getlastname() == "" || u.getusername() == "")
            return "body invalid";
        User result = repository.getOne(userid);
        result.setusername(u.getusername());
        result.setlastname(u.getlastname());

        repository.save(result);

        return "edit id "+userid+" Done";
    }

    @RequestMapping(value ="/delete", method = RequestMethod.DELETE)
    public String delete(){
        repository.deleteAll();
        return "delete done";
    }
    
    @RequestMapping(value="testget" , method = RequestMethod.GET)
    public String testget(){
        return  "testing /test/testget Get method Success";
    }

    @RequestMapping(value="testpost" , method = RequestMethod.POST)
    public String testpost(@RequestBody Object o){
        return  "testing /test/testpost  Post Success";
    }

    @RequestMapping(value="testid/{testid}", method = RequestMethod.GET)
    public String testparam(@PathVariable("testid") String testid){
        return " /test/testid/{testid}  testid : "+testid ;
    }

    @RequestMapping(value="testid", method = RequestMethod.GET)
    public @ResponseBody String testquery(@RequestParam("id") String testid){
        return " /test/testid/{testid}  testid : "+testid ;
    }
}
