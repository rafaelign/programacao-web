package ine5646.modelo;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author rafael
 */
public class VerificadorDePrimo {

    public boolean ehPrimo(long num) {
        if (num % 2 == 0 || num % 5 == 0) {
            return false;
        }

        Client c = ClientBuilder.newClient();
        WebTarget wt = c.target("http://localhost:8081/DivisoresREST/webresources/divisores/" + num);
        String divisoresJson = wt.request().get().readEntity(String.class);
        
        int[] divisores = new Gson().fromJson(divisoresJson, int[].class);

        return (divisores.length == 2);
    }

}
