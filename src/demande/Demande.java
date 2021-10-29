package demande;

// Class représentant une demande avec les différents attributs utiles ( départ, capacité ...)
public class Demande {

    // L'id de la demande ainsi que son type
    private int demandeId;

    // Le point de départ
    private String origin;

    // Le point d'arrivée
    private String destination;

    // Le départ du point de vue du temps
    private int departureTime;

    // L'arrivée du point de vue du temps
    private int arrivalTime;

    // Capacité de allouée à la demande
    private int volume;

    public Demande(int demandeId, String origin, String destination, int departureTime, int arrivalTime, int volume) {
        this.demandeId = demandeId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.volume = volume;
    }
}
