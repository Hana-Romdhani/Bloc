package  com.example.microo.controller;

import com.example.microo.entities.Bloc;
import com.example.microo.services.IBlocServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController   //
@RequestMapping("/bloc")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor


public class BlocController {
    private final IBlocServices iBlocService;
    @GetMapping("/AllBlocs")
    public List<Bloc> retrieveBlocs() {
        return iBlocService.retrieveBlocs();
    }

    //@PutMapping(" /updateBloc/{idBloc}")
    //public Bloc updateBloc(@PathVariable("idBloc") Long idBloc, @RequestBody Bloc bloc) {
    // Logique de mise à jour du bloc
    //   return iBlocService.updateBloc(bloc);
    //}
    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        // Vérifier si le bloc existe déjà
        if (iBlocService.checkIfBlocExists(bloc.getNomBloc())) {
            // Gérer la logique en cas de conflit, par exemple, vous pouvez lancer une exception
            throw new IllegalArgumentException("Bloc with the same name already exists");
        }

        // Ajouter le bloc s'il n'existe pas encore
        Bloc addedBloc = iBlocService.addBloc(bloc);

        return bloc;
    }

    @PutMapping("/update2/{idBloc}")
    public ResponseEntity<String> updateUser(@PathVariable("idBloc") Long idBloc, @RequestBody Bloc bloc) {
        iBlocService.updateBloc2(idBloc, bloc);
        return ResponseEntity.ok("{\"message\": \"Bloc Updated Successfully\"}");
    }
    @GetMapping("/recherche")
    public List<Bloc> rechercheParNomBloc(@RequestParam("nomBloc") String nomBloc) {
        return iBlocService.rechercheParNomBloc(nomBloc);
    }


    @GetMapping("/getBloc/{idBloc}")
    public Bloc retrieveBloc(@PathVariable ("idBloc") long idBloc ) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/removeBloc/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        iBlocService.removeBloc(idBloc);
    }







}
