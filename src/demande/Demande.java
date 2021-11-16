package demande;

// Class représentant une demande avec les différents attributs utiles ( départ, capacité ...)
public class Demande {

    // L'id de la demande
    private String demandeId;

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

    public Demande(String demandeId, String origin, String destination, int departureTime, int arrivalTime, int volume) {
        this.demandeId = demandeId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.volume = volume;
    }

    public String getDemandeId() {
        return demandeId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Demande{ " +
                "demandeId = '" + demandeId + '\'' +
                ", \norigin = '" + origin + '\'' +
                ", \ndestination = '" + destination + '\'' +
                ", \ndepartureTime = " + departureTime +
                ", \narrivalTime = " + arrivalTime +
                ", \nvolume = " + volume +
                "}\n";
    }
}
