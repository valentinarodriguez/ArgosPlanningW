/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.exception;

/**
 *
 * @author Valentina
 */
public class ArgosWebServiceException extends Exception {


	public ArgosWebServiceException(){

	}

	public void finalize() throws Throwable {

	}

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public ArgosWebServiceException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
