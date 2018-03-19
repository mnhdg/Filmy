package projekt.Controllers;

import filmy.tables.records.FilmyRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.Filmy;
import static filmy.tables.Filmy.FILMY;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class FilmyController {
    @Autowired
    private DSLContext jooq;

    @GetMapping("/filmy")
    public List<Filmy> filmy(){
        return jooq.select().from(FILMY).fetchInto(Filmy.class);
    }

    @PostMapping("/filmy")
    public void filmy(@RequestBody Filmy newfilm){
        FilmyRecord film = jooq.newRecord(FILMY);
        film.setIdFilmu(newfilm.id_filmu);
        film.setTytul(newfilm.tytul);
        film.setKrajProdukcji(newfilm.kraj_produkcji);
        film.setGatunek(newfilm.gatunek);
        film.setCena(newfilm.cena);
        film.store();
    }

    @DeleteMapping("/filmy/{id}")
    public void delete(@PathVariable String id){
        FilmyRecord film = jooq.fetchOne(FILMY, FILMY.ID_FILMU.eq(id));
        film.delete();
    }
}

