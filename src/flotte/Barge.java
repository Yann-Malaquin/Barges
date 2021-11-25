package flotte;

/**
 * Class représentant une barge
 */
public class Barge {

    // Si la barge est disponible
    public boolean disponible;
    // Le poids de la barge (10,15,25)
    public int poids;
    // Le type de la barge (Small, Medium, Large)
    public String type;

    public Barge(){
        this.poids = 0;
        this.type = null;
    }

    /**
     * Constructeur Barge
     *
     * @param poids Le poids de la barge
     * @param type Le type de la barge
     * {id = auto-increment}
     * {disponible = false}
     */
    public Barge(int poids, String type){
        this.disponible = true;
        this.poids = poids;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "\nBarge { " +
                ",\ndisponible = " + disponible +
                ",\npoids = " + poids +
                "}\n";
    }
}
