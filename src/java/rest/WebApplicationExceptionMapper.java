/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Muggi
 */
public @Provider
class WebApplicationExceptionMapper implements
        ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException e) {
        JsonObject errorObj = new JsonObject();
        errorObj.addProperty("errCode", e.getResponse().getStatus());
        errorObj.addProperty("errMsg", e.getMessage());
        e.getMessage();
        int resCode = e.getResponse().getStatus();
        return Response.status(resCode).entity(new Gson().toJson(errorObj)).build();
    }
}
