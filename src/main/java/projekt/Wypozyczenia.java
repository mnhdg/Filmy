package projekt;
import lombok.Data;

import java.util.Date;

public @Data class Wypozyczenia {

    public int id_wyp;
    public java.sql.Date data_wyp;
    public String film;
    public String klient;

    public int getId_wyp() {
        return id_wyp;
    }

    public void setId_wyp(int id_wyp) {
        this.id_wyp = id_wyp;
    }




    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getKlient() {
        return klient;
    }

    public void setKlient(String klient) {
        this.klient = klient;
    }
}