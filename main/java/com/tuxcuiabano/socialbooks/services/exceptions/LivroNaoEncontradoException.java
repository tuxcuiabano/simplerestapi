package com.tuxcuiabano.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5911492766617207751L;

	public LivroNaoEncontradoException(String mensagem) {
		
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		
		super(mensagem, causa);
	}
	
	

}
