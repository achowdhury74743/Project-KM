package server.controllers;

import org.eclipse.jetty.server.Authentication;
import server.Logger;
import server.Logger;
import server.models.Users;
import server.models.service.UsersService;
import server.models.services.UsersService;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("user/")
public class UserController {

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String newMessage(@FormParam("username") String username,
                             @FormParam("password1") String password1,
                             @FormParam("password2") String password2) {
        Logger.log("/user/new - Creating " + username);
        UsersService.selectAllInto(Users.users);
        for (Users u: Users.users) {
            if (u.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return "Error: Username already exists";
            }
        }
        if (!password1.equals(password2)) {
            return "Error: Passwords do not match.";
        }
        String token = UUID.randomUUID().toString();
        int userId = Users.nextId();
        String success = UsersService.insert(new Users(userId, username, password));
        if (success.equals("OK")) {
            return token;
        } else {
            return "Error: Can't create new user.";
        }
    }

    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String newMessage(@FormParam("username") String username,
                             @FormParam("password") String password ) {

        Logger.log("/user/login - Attempt by " + username);
        UsersService.selectAllInto(Users.users);
        for (Users u: Users.users) {
            if (u.getUsername().toLowerCase().equals(username.toLowerCase())) {
                if (!u.getPassword().equals(password)) {
                    return "Error: Incorrect password";
                }
                String success = UsersService.update(u);
                if (success.equals("OK")) {
                    return "Login successful";
                } else {
                    return "Error: Can't create session token.";
                }
            }
        }
        return "Error: Can't find user account.";
    }



}

