package flotte;

/**
 * Class représentant une barge
 */
public class Barge {

    // Permet d'incrémenter automatiquement l'id.
    private static int count = 0;
    // L'id de la barge
    public int id;
    // Si la barge est disponible
    public boolean disponible;
    // Le poids de la barge (10,15,25)
    public int poids;
    // Le type de la barge (Small, Medium, Large)
    public String type;

    /**
     * Constructeur Barge
     *
     * @param poids Le poids de la barge
     * @param type Le type de la barge
     * {id = auto-increment}
     * {disponible = false}
     */
    public Barge(int poids, String type){
        this.id = ++count;
        this.disponible = false;
        this.poids = poids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "\nid = " + id +
                ",\ndisponible = " + disponible +
                ",\npoids = " + poids +
                "}\n";
    }
}
