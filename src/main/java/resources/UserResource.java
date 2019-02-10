package resources;

import service.UserManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

    @Inject
    private UserManager userManager;

    @Path("/all")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllUsers() {
        return userManager.getZeko();
    }
}
