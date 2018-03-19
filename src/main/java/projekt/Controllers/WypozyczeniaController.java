package projekt.Controllers;

import filmy.tables.records.WypozyczeniaRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.Wypozyczenia;
import static filmy.tables.Wypozyczenia.WYPOZYCZENIA;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class WypozyczeniaController {

    @Autowired
    private DSLContext jooq;

    @GetMapping("/wypozyczenia")
    public List<Wypozyczenia> wypozyczenia(){
        return jooq.select().from(WYPOZYCZENIA).fetchInto(Wypozyczenia.class);
    }

    @PostMapping("/wypozyczenia")
    public void wypozyczenia(@RequestBody Wypozyczenia newwypozyczenie){
        WypozyczeniaRecord wypozyczenie = jooq.newRecord(WYPOZYCZENIA);
        wypozyczenie.setIdWyp(newwypozyczenie.id_wyp);
        wypozyczenie.setDataWyp(newwypozyczenie.data_wyp);
        wypozyczenie.setFilm(newwypozyczenie.film);
        wypozyczenie.setKlient(newwypozyczenie.klient);
        wypozyczenie.store();
    }

    @DeleteMapping("/wypozyczenia/{id}")
    public void delete(@PathVariable int id){
        WypozyczeniaRecord wypozyczenie = jooq.fetchOne(WYPOZYCZENIA, WYPOZYCZENIA.ID_WYP.eq(id));
        wypozyczenie.delete();
    }
}


