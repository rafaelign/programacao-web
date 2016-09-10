/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author rafaelignacio
 */
@Path("divisores/{numero}")
public class DivisoresREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DivisoresREST
     */
    public DivisoresREST() {
    }

    /**
     * Retrieves representation of an instance of ine5646.DivisoresREST
     * @param numero
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("numero") int numero) {

        List<Integer> listaDivisores = new ArrayList<>();
        int min = 2, max = numero;

        if (numero > 0) {
            
            listaDivisores.add(1);
            
            if (numero > 1) {

                for (int n = min;n < max;n++) {
                    if ( (numero % n) == 0 ) {
                        listaDivisores.add(n);
                        if (n != (numero / n)) {
                            listaDivisores.add( (numero / n) );
                        }
                        max = numero / n;
                    }
                }

                listaDivisores.add(numero);

            }
            
        }
        
        Collections.sort(listaDivisores);

        return new Gson().toJson(listaDivisores);

    }

    /**
     * PUT method for updating or creating an instance of DivisoresREST
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
