package com.tuxcuiabano.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5911492766617207751L;

	public AutorExistenteException(String mensagem) {
		
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		
		super(mensagem, causa);
	}
	
	

}
