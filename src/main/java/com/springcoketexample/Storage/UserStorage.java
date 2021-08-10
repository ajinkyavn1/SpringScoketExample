package com.springcoketexample.Storage;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

public class UserStorage {
    private static  UserStorage userinstance;
    private Set<String> users;
    private UserStorage(){
        users=new HashSet<>();
    }
    public  static synchronized UserStorage getInstance(){
        if(userinstance==null)
            userinstance=new UserStorage();
        return userinstance;
    }
    public  Set<String> getUsers(){
        return  users;
    }
    public  void  setUser(String userName) throws Exception {
        if(users.contains(userName)){
            throw  new Exception("User Already Exits: "+userName);
        }
        users.add(userName);
    }
}
