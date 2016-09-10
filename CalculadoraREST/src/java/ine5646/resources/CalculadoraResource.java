/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.resources;

import com.google.gson.Gson;
import ine5646.repositories.CalculadoraRepository;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rafaelignacio
 */
@Path("calculadora")
public class CalculadoraResource {

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @param calculo
     * @param x
     * @param y
     * @return an instance of javax.​ws.​rs.​core.Response
     * @throws ine5646.resources.MyApplicationException
     */
    @GET
    @Path("{calculo}/{x}/{y}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo(@PathParam("calculo") String calculo, @PathParam("x") String x, @PathParam("y") String y) throws MyApplicationException {
        CalculadoraRepository calc = new CalculadoraRepository();
        calc.calcular(calculo, x, y);
        
        if (calc.getStatusCode() == Response.Status.BAD_REQUEST)
            return Response.status( calc.getStatusCode() ).entity( calc.getResultText() ).build();
        
        return Response.status( calc.getStatusCode() ).entity( new Gson().toJson( calc.getResponse() ) ).build();
    }

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @return an instance of javax.​ws.​rs.​core.Response
     */
    @GET
    @Path("")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo() {
        return Response.status( Response.Status.BAD_REQUEST ).entity( "Número de parâmetros incorreto! Exemplo: soma/5/8" ).build();
    }

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @param calculo
     * @return an instance of javax.​ws.​rs.​core.Response
     */
    @GET
    @Path("{calculo}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo(@PathParam("calculo") String calculo) {
        return Response.status( Response.Status.BAD_REQUEST ).entity( "Número de parâmetros incorreto! Exemplo: soma/5/8" ).build();
    }

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @param calculo
     * @param a
     * @return an instance of javax.​ws.​rs.​core.Response
     */
    @GET
    @Path("{calculo}/{a}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo(@PathParam("calculo") String calculo, @PathParam("a") String a) {
        return Response.status( Response.Status.BAD_REQUEST ).entity( "Número de parâmetros incorreto! Exemplo: soma/5/8" ).build();
    }

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @param calculo
     * @param a
     * @param b
     * @param c
     * @return an instance of javax.​ws.​rs.​core.Response
     */
    @GET
    @Path("{calculo}/{a}/{b}/{c}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo(@PathParam("calculo") String calculo, @PathParam("a") String a, @PathParam("b") String b, @PathParam("c") String c) {
        return Response.status( Response.Status.BAD_REQUEST ).entity( "Número de parâmetros incorreto! Exemplo: soma/5/8" ).build();
    }

    /**
     * Retrieves representation of an instance of ine5646.resources.CalculadoraResource
     * @param calculo
     * @param a
     * @param b
     * @param c
     * @param d
     * @return an instance of javax.​ws.​rs.​core.Response
     */
    @GET
    @Path("{calculo}/{a}/{b}/{c}/{d}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getCalculo(@PathParam("calculo") String calculo, @PathParam("a") String a, @PathParam("b") String b, @PathParam("c") String c, @PathParam("d") String d) {
        return Response.status( Response.Status.BAD_REQUEST ).entity( "Número de parâmetros incorreto! Exemplo: soma/5/8" ).build();
    }

}
