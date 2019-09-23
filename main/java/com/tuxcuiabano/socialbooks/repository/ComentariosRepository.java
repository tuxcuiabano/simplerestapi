package com.tuxcuiabano.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuxcuiabano.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
