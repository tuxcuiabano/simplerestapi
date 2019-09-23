package com.tuxcuiabano.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5911492766617207751L;

	public AutorNaoEncontradoException(String mensagem) {
		
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		
		super(mensagem, causa);
	}
	
	

}
