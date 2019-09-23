package com.tuxcuiabano.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuxcuiabano.socialbooks.domain.Autor;
import com.tuxcuiabano.socialbooks.repository.AutoresRepository;
import com.tuxcuiabano.socialbooks.services.exceptions.AutorExistenteException;
import com.tuxcuiabano.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	
	public List<Autor> listar(){
		
		return autoresRepository.findAll();
		
	}
	
	
	
	public Autor salvar(Autor autor) {
		
		if (autor.getId() != null) {
			
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			/* SEM <Optional> - versões mais antigas do Spring
			if(a != null) {
				
				throw new AutorExistenteException("O autor já existe");
				
			}		
			
			*/
			
			//com o <Optional>
			if(a.isPresent()) {				
				throw new AutorExistenteException("O autor já existe");				
			}
			
		}
		
		return autoresRepository.save(autor);
		
	}
	
	/* foi preciso usar o método .get de Optional<Autor> para devolver um objeto do tipo Autor	
	 *  ele retorna um objeto Optional<Titulo>, então se você tentar passar esse objeto para View
     *  ela não vai reconhecer como o objeto Titulo, porém o Optional tem um método get que retorna 
     *  um objeto Titulo.
	 * 
	 * */
	
	public Autor buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(!autor.isPresent()) {				
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado");				
		}	
		
		return autor.get();
		
	}
	
	
	

}
