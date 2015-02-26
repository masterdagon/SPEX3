/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Muggi
 */
@Path("text")
public class Rest {

    static HashMap map = new HashMap();

    @Context
    private UriInfo context;

    public Rest() {
//        List<String> names = new ArrayList();
//        if (names.size() == 0) {
//            names.add("James Rodriguez");
//            names.add("Thomas Mueller");
//            names.add("Messi");
//            names.add("Neymar");
//            names.add("van Persie");
//        
//        for(int i = 0 ; i < 5; i++){
//            List<String> list = new ArrayList();
//            list.add(names.get(i));
//            list.add("Neverland");
//            map.put(i+1, list);
            
            Player player = new Player("James Rodriguez","Neverland");
            map.put(1, player);
            player = new Player("Thomas Mueller", "Neverland");
            map.put(2, player);
            player = new Player("Messi", "Neverland");
            map.put(3, player);
            player = new Player("Neymar", "Neverland");
            map.put(4, player);
            player = new Player("van Persie", "Neverland");
            map.put(5, player);
        }

    @GET
    @Produces("text/plain")
    public String getAll() {
        String res = "Hello World";
        return res;
    }

//    @GET
//    @Produces("application/json")
//    @Path("/AllPlayerNames")
//    public String getJsonArray() {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("{");
//        JsonObject jo = new JsonObject();
//        JsonArray ja = new JsonArray();
//        for (int i = 0; i < map.size(); i++) {
//            jo.addProperty("id", "" + i+1);
//            ArrayList info = (ArrayList)map.get(i);
//            jo.addProperty("name", (String)info.get(0));
//            jo.addProperty("Country", (String)info.get(1));
//            ja.add(jo);
//        }
//
//        return ja.toString();
//    }

//    @GET
//    @Produces("application/json")
//    @Path("/Player/{id}")
//    public String getPlayer(@PathParam("id") int id) {
//        JsonObject jo = new JsonObject();
//        if(map.containsKey(id)){
//        jo.addProperty("id", "" + id);
//        ArrayList info = (ArrayList)map.get(id);
//        jo.addProperty("name", (String)info.get(0));
//        jo.addProperty("Country", (String)info.get(1));
//        }else{
//            jo.addProperty("errCode", "" + 404);
//            jo.addProperty("errMsg", "No player found with the given ID");
//            throw new WebApplicationException("No Player found with the given ID",Response.Status.NOT_FOUND);
//        }
//        System.out.println(jo.toString());
//        return jo.toString();
//
//    }
    
    @GET
    @Produces("application/json")
    @Path("/Player/{id}")
    public String getPlayer(@PathParam("id") int id) {
    Gson gson = new Gson();
    String player = gson.toJson(map.get(id));
    return player;
    }
    
    @GET
    @Produces("application/json")
    @Path("AllPlayerNames")
    public String getAllPlayers() {
        Gson gson = new Gson();
        String allPlayers = gson.toJson(map);
        return allPlayers;

    }
    
    @POST
    @Consumes("text/plain")
    public String putText(String content) {
        System.out.println(content);
        return content;
    }
    
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
