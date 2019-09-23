package com.tuxcuiabano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuxcuiabano.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
