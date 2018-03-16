package projekt.Controllers;

import filmy.tables.records.KlienciRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projekt.Klienci;
import static filmy.tables.Klienci.KLIENCI;

import java.util.List;

@RestController

public class KlienciController {

    @Autowired
    private DSLContext jooq;

    @GetMapping("/klienci")
    public List<Klienci> klienci(){
        return jooq.select().from(KLIENCI).fetchInto(Klienci.class);
    }

    @PostMapping("/klienci")
    public void klienci(@RequestBody Klienci newklient){
        KlienciRecord klient = jooq.newRecord(KLIENCI);
        klient.setPesel(newklient.pesel);
        klient.setImie(newklient.imie);
        klient.setNazwisko(newklient.nazwisko);
        klient.store();
    }

    @DeleteMapping("/klienci/{id}")
    public void delete(@PathVariable String id){
        KlienciRecord klient = jooq.fetchOne(KLIENCI, KLIENCI.PESEL.eq(id));
        klient.delete();
    }

}
