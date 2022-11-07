package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    private String username;

    private String password;

    private static User loggedUser = null;

    public void setUsername(String u){
        this.username = u;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String p){
        this.password = p;
    }

    public String getPassword(){
        return password;
    }

    public static User getLoggedUser(){
        return loggedUser;
    }

    public static User login(String login, String password) {
        try{
            List<String[]> users = new BufferedReader(new FileReader("users.txt"))
                    .lines()
                    .map(s-> s.split(" "))
                    .filter((String[] s)->s[0].equals(login) && s[1].equals(password))
                    .collect(Collectors.toList());
            if(users.isEmpty()){
                return null;
            }
            loggedUser = new User(users.get(0)[0], users.get(0)[1]);

        }catch(Exception e){
            e.printStackTrace();
        }
        return loggedUser;
    }
}
