package com.springcoketexample.Controller;

import com.springcoketexample.Storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class UserControllar {
    @GetMapping("/register/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName){
        System.out.printf("Handling register User Request -: "+userName);
        try {
            UserStorage.getInstance().setUser(userName);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/fetchAllUsers")
    public Set<String> featchAllUsers(){
        return  UserStorage.getInstance().getUsers();
    }
}
