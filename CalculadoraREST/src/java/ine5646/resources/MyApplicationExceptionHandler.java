/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author rafaelignacio
 */
@Provider
public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException> 
{
    @Override
    public Response toResponse(MyApplicationException exception) 
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
    }
}
