package com.tuxcuiabano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuxcuiabano.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
