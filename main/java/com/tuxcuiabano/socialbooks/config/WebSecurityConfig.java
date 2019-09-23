package com.tuxcuiabano.socialbooks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("tux").password("{noop}tux").roles("USER");
		
		
		
	}
	
	
	
	/*
	 * 
	 * 
	 * Dependendo da versão você precisa especificar um PasswordEncoder. Para manter a compatibilidade com o código da aula, você pode utiliza NoOpPasswordEncoder, como estamos usando uma senha não codificada (s3nh4).

Uma forma de fazer isso seria na classe WebSecurityConfig, você adicionar {noop} antes da senha, ficando assim:
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("algaworks")
    .password("{noop}s3nh4").roles("USER");
}
Ou definindo um Bean com seu passwordEncoder, criando um novo método nessa mesma classe:
@Bean
public PasswordEncoder passwordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}
	 * 
	 * 
	 * */
	
	
	

	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
		
	}
	
	
	/*
	 * Resumindo... Para conseguir fazer o cache você vai precisar utilizar isso (ao invés da classe CacheControl):
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id, HttpServletResponse response) {
		Livro livro = livrosService.buscar(id);
		
		//CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

        response.setHeader("Cache-Control", "max-age=20");
        response.setHeader("Pragma", "");        
		
		return ResponseEntity.status(HttpStatus.OK)
                    //.cacheControl(cacheControl)
                    .body(livro);
	}
Ou então, na classe WebSecurityConfig você adiciona isso:
    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/livros/**");
	}
	 * 
	 * 
	 * */
	
	
	
	
	
}
