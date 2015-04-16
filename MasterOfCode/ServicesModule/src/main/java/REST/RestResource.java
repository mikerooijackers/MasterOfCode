/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.core.*;
import javax.ws.rs.*;
import Domein.*;

/**
 * REST Web Service
 *
 * @author mikerooijackers
 */
@Path("")
public class RestResource {

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }
    
    @GET
    @Path("startcompetition")
    public String startCompetition () {
        
        return "";
    }
}
