package tp3.beans;

import java.util.List;

public class Emploi {

    private List<Cours> listeCours;
    private Cours       ceCours;

    public List<Cours> getListeCours() {
        return listeCours;
    }

    public void setListeCours( List<Cours> listeCours ) {
        this.listeCours = listeCours;
    }

    public Cours getCeCours() {
        return ceCours;
    }

    public void setCeCours( Cours ceCours ) {
        listeCours.add( ceCours );
        this.ceCours = ceCours;
    }

}
