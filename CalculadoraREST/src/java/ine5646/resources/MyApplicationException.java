/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.resources;

import java.io.Serializable;

/**
 *
 * @author rafaelignacio
 */
public class MyApplicationException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    public MyApplicationException() {
        super();
    }
    public MyApplicationException(String msg)   {
        super(msg);
    }
    public MyApplicationException(String msg, Exception e)  {
        super(msg, e);
    }
}
