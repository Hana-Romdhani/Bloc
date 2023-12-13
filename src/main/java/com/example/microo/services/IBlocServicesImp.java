package com.example.microo.services;

import com.example.microo.entities.Bloc;
import com.example.microo.repositories.IBlocRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IBlocServicesImp implements IBlocServices {

    private final IBlocRepository blocRepo;


    public List<Bloc> retrieveBlocs() {
        return  blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return  blocRepo.save(bloc) ;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        bloc.setSature(false);
        return  blocRepo.save(bloc) ;
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return  blocRepo.findById ( idBloc ).orElse(null);
    }


    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc updateBloc2(Long idBloc, Bloc bloc) {
        Bloc bloc1 = blocRepo.findById(idBloc).get();
        bloc1.setNomBloc(bloc.getNomBloc());
        bloc1.setCapaciteBloc(bloc.getCapaciteBloc());

        return blocRepo.save(bloc1);
    }
    @Override
    public boolean checkIfBlocExists(String nomBloc) {
        return blocRepo.existsByNomBloc(nomBloc);
    }
    @Override
    public List<Bloc> rechercheParNomBloc(String nomBloc) {
        return blocRepo.findByNomBlocContainingIgnoreCase(nomBloc);
    }

}

