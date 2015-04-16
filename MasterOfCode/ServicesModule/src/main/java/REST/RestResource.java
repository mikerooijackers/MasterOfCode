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
    
    @POST
    @Path("startcompetition")
    public String startCompetition () {
        
        return "";
    }
    
    @POST
    @Path("pausecompetition")
    public String pauseCompetition () {
        
        return "";
    }
    
    @POST
    @Path("freezecompetition")
    public String freezeCompetition () {
        
        return "";
    }
    
    @POST
    @Path("stopcompetition")
    public String stopCompetition () {
        
        return "";
    }
    
    @POST
    @Path("startround")
    public String startRound () {
        
        return "";
    }
    
    @POST
    @Path("pauseround")
    public String pauseRound () {
        
        return "";
    }
    
    @POST
    @Path("freezeround")
    public String freezeRound () {
        
        return "";
    }
    
    @POST
    @Path("stopround")
    public String stopRound () {
        
        return "";
    }
}
