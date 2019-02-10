package controllers;

import service.UserManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {
    @Inject
    UserManager userManager;

    @Path("/all")
    @GET
    @Produces("plain/text")
    public String getAllUsers(){
        return userManager.getZeko();
    }
}
