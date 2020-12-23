package com.cme.demo.api;

import com.cme.demo.Models.User;
import com.cme.demo.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String create(@RequestBody Map<String,String> names){
        User u=new User();
        u.setName(names.get("name"));
        userRepository.save(u);
        return names.get("name");
    }
    @GetMapping("/CheckExist")
    public String CheckIfUserExist(){
        List<User> u= userRepository.findAll();
        if(u.isEmpty()){
            String name="Marc";
            User us=new User();
            us.setName(name);
            userRepository.save(us);
            return "User Created";
        }else{
            return "Exist";
        }
    }

}
