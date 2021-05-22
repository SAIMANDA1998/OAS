package com.cg.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer>{

}
