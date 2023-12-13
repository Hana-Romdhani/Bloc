package com.example.microo.repositories;

import com.example.microo.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface IBlocRepository extends JpaRepository<Bloc, Long> {


    boolean existsByNomBloc(String nomBloc);
    List<Bloc> findByNomBlocContainingIgnoreCase(String nomBloc);




}
