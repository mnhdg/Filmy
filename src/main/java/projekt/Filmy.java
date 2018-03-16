package projekt;
import lombok.Data;

public @Data class Filmy {

    public String id_filmu;
    public String tytul;
    public String kraj_produkcji;
    public String gatunek;
    public int cena;

    public String getId_filmu() {
        return id_filmu;
    }

    public void setId_filmu(String id_filmu) {
        this.id_filmu = id_filmu;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getKraj_produkcji() {
        return kraj_produkcji;
    }

    public void setKraj_produkcji(String kraj_produkcji) {
        this.kraj_produkcji = kraj_produkcji;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}

