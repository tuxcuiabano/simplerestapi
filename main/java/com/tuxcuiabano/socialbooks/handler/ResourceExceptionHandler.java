package com.tuxcuiabano.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tuxcuiabano.socialbooks.domain.DetalhesErro;
import com.tuxcuiabano.socialbooks.services.exceptions.AutorExistenteException;
import com.tuxcuiabano.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.tuxcuiabano.socialbooks.services.exceptions.LivroNaoEncontradoException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerLivroNaoEncontradoException
						(LivroNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O livro não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://errros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handlerAutorExistenteException
						(AutorExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("Autor já existente");
		erro.setMensagemDesenvolvedor("http://errros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
	}
	
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerAutorNaoEncontradoException
						(AutorNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O autor não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http://errros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handlerDataIntegrityViolationException
						(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Requisição Inválida");
		erro.setMensagemDesenvolvedor("http://errros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}

}
