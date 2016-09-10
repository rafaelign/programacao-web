/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.repositories;

import ine5646.models.Calculadora;
import ine5646.resources.MyApplicationException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

/**
 *
 * @author rafaelignacio
 */
public class CalculadoraRepository {

    private Double result;
    private String resultText;
    private String statusText;
    private Response.Status statusCode;
    
    public CalculadoraRepository() {
        this.result = new Double(0);
        this.resultText = "";
        this.statusText = "ok";
        this.statusCode = Response.Status.OK;
    }
    
    public void calcular(String calculo, String x, String y) throws MyApplicationException {

        try {
            switch(calculo) {
                case "somar":
                    this.result = Calculadora.somar(Double.parseDouble(x), Double.parseDouble(y));
                    break;
                case "subtrair":
                    this.result = Calculadora.subtrair(Double.parseDouble(x), Double.parseDouble(y));
                    break;
                case "multiplicar":
                    this.result = Calculadora.multiplicar(Double.parseDouble(x), Double.parseDouble(y));
                    break;
                case "dividir":
                    if (Double.parseDouble(y) <= 0)
                        throw new MyApplicationException("Não é possível efetuar divisões por zero.");
                    this.result = Calculadora.dividir(Double.parseDouble(x), Double.parseDouble(y));
                    break;
                default:
                    throw new MyApplicationException("Operação deve ser uma destas: somar,subtrair,multiplicar,dividir.");
            }
        } catch (NumberFormatException e) {
            throw new MyApplicationException("'" + x + "' e/ou '" + y + "' não é um número válido.");
        } catch (MyApplicationException e) {
            this.statusCode = Response.Status.BAD_REQUEST;
            this.statusText = "erro";
            throw e;
        } catch (Exception e) {
            this.statusCode = Response.Status.BAD_REQUEST;
            this.statusText = "erro";
            this.resultText = e.getMessage();
        }

    }
    
    public Response.Status getStatusCode() {
        return this.statusCode;
    }
    
    public String getResultText() {
        return this.resultText;
    }

    public List<Object> getResponse() {
        ArrayList<Object> response = new ArrayList<>();
        
        response.add(this.statusText);
        if (this.statusText.equals("erro"))
            response.add(this.resultText);
        else
            response.add(this.result);

        return response;
    }

}
