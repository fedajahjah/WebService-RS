/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Feda
 */
@Path("resolve/{parameters}")
public class FedaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FedaResource
     */
    public FedaResource() {
    }

    /**
     * Retrieves representation of an instance of rs.FedaResource
     *
     * @param inputJsonObj
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/method")
    @Consumes("application/json")
    @Produces("application/json") // sends JSON
    public String getJson(@PathParam("parameters") String parameters) throws JSONException {
        //TODO return proper representation object
        JSONObject o = new JSONObject(parameters);
      double a,b,c;
      try{ 
           a = (double) o.get("a");
      }catch(ClassCastException e)
      {
      a =  Double.parseDouble(o.get("a")+".0");
      }
      try{ 
           b = (double) o.get("b");
      }catch(ClassCastException e)
      {
      b =  Double.parseDouble(o.get("b")+".0");
      }
      try{ 
           c = (double) o.get("c");
      }catch(ClassCastException e)
      {
      c =  Double.parseDouble(o.get("c")+".0");
      }
        
        double d = (b * b) - 4 * a * c;

        double x1, x2;
        if (d > 0) {
            d = Math.sqrt(d);
            x1 = (b + d) / (2 * a);
            x2 = (b - d) / (2 * a);

            return "{'x1':" + x1 + ",'x2':" + x2 + "}";

        } else if (d == 0) {
            x1 = b / (2 * a);

            return "{'x1':" + x1 + ",'x2':" + x1 + "}";

        }
        d = Math.sqrt(Math.abs(d));

        return "{'x1':'" + b + "+" + d + "i /" + 2 * a + "','x2':'" + b + "-" + d + "i /" + 2 * a + "'}";
    }

    /**
     * PUT method for updating or creating an instance of FedaResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
