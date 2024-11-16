package com.projetojava.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.app.entidades.Acess;

@Repository
public interface AcessRepository extends JpaRepository<Acess,Integer> {

	Optional<Acess> findByLoginAndPassword(String login,String password);
	
}
