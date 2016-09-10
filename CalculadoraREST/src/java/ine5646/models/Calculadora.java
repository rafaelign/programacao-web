/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.models;

/**
 *
 * @author rafaelignacio
 */
public class Calculadora {
    
    public static Double somar(Double x, Double y) throws Exception {
        return x + y;
    }
    
    public static Double subtrair(Double x, Double y) throws Exception {
        return x - y;
    }

    public static Double multiplicar(Double x, Double y) throws Exception {
        return x * y;
    }

    public static Double dividir(Double x, Double y) throws Exception {
        return x / y;
    }

}
