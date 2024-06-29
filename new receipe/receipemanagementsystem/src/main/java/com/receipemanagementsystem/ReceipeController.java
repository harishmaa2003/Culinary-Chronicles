package com.receipemanagementsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
public class ReceipeController {
    String jdbcurl = "jdbc:mysql://localhost:3306/receipe_management";

    //    @GetMapping("/start")
//    public String getStart(){
//        return "login";
//    }
//@GetMapping ("/login")
//public String enter(){
//        return "login";
//    }
//    @PostMapping("/signup")
//  public  String Signup(){
//        return "signup";
//  }
//  @PostMapping("/logins")
//    public String loginIndex(@RequestParam("username") String name,@RequestParam("password") String password){
//        System.out.println(name+" "+password);
//        return "index";
//  }
    @GetMapping("/index")
    public String first() {
        return "index";
    }

    @GetMapping("/signup")
    public String logins() {
        return "signup";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/create_recipe")
    public String create_recipe() {
        return "create_recipe";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "contactUs";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/recipe")
    public String recipe() {
        return "recipe";
    }
    @PostMapping("/logins")
    public String second(@RequestParam("username") String name, @RequestParam("password") String password) {
        System.out.print(name + " " + password);
        return "index";
    }

    //    @PostMapping("/signup")
//    public String third(@RequestParam("username")String name,@RequestParam("email")String email,@RequestParam("password")String password){
//        System.out.print(name+" "+email+" "+password);
//        try{
//            connect
//        }
//        return "index";
//    }
    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Inside signup method");
        System.out.println("The attributes are " + username + " " + email + " " + password);
        // model.addAttribute("message","The Signup was successful");
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(jdbcurl, "root", "harishmaa309");
            String sql = "insert into user values(?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, username);
            pstatement.setString(2, email);
            pstatement.setString(3, password);
            pstatement.execute();
            System.out.println("Database updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("The exception occured is " + e);
        }
        return "Login";
    }

    @PostMapping("/recipe")
    public String receipe(@RequestParam("rating") int rating, @RequestParam("review") String review) {
        System.out.println("Inside receipe method");
        System.out.println("The attributes are " + rating + " " + review);
        // model.addAttribute("message","The Signup was successful");
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(jdbcurl, "root", "harishmaa309");
            String sql = "insert into receipe values(?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, rating);
            pstatement.setString(2, review);
            pstatement.execute();
            System.out.println("Database updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("The exception occured is " + e);
        }
        return "index";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("message") String message) {
        System.out.println("Inside signup method");
        System.out.println("The attributes are " + name + " " + email + " " + message);
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(jdbcurl, "root", "harishmaa309");
            String sql = "insert into contact values(?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, name);
            pstatement.setString(2, email);
            pstatement.setString(3, message);
            pstatement.execute();
            System.out.println("Database updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("The exception occured is " + e);
        }
        return "index";
    }
    @PostMapping ("/createreceipe")
    public String createreceipe (@RequestParam("reciepe_name") String reciepe_name, @RequestParam("description") String description, @RequestParam("instructions") String instructions,@RequestParam("category") String category,@RequestParam("ingredient_name[]")String ingredient_name,@RequestParam("quantity[]")String quantity) {
        System.out.println("Inside signup method");
        System.out.println("The attributes are " + reciepe_name + " " + description + " " + instructions + " " + category + " " + ingredient_name + " " + quantity);
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(jdbcurl, "root", "harishmaa309");
            String sql = "insert into createreceipe values(?,?,?,?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, reciepe_name);
            pstatement.setString(2, description);
            pstatement.setString(3, instructions);
            pstatement.setString(4, category);
            pstatement.setString(5, ingredient_name);
            pstatement.setString(6, quantity);
            pstatement.execute();
            System.out.println("Database updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("The exception occured is " + e);
        }
        return "index";
    }
}

