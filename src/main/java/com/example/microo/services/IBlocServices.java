package com.example.microo.services;

import com.example.microo.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc);

    Bloc addBloc(Bloc bloc);

    Bloc retrieveBloc(long idBloc);

    void removeBloc(long idBloc);
    public Bloc updateBloc2(Long id, Bloc user) ;
    public List<Bloc> rechercheParNomBloc(String nomBloc);



    public boolean checkIfBlocExists(String nomBloc) ;

}
