package demande;

import flotte.Barge;

import java.util.ArrayList;
import java.util.List;

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

    // Barges qui s'occupent de la demande
    private List<Barge> bargeAllouee;

    public Demande(String demandeId, String origin, String destination, int departureTime, int arrivalTime, int volume) {
        this.demandeId = demandeId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.volume = volume;
        this.bargeAllouee = new ArrayList<>();
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

    public List<Barge> getBargeAllouee() {
        return bargeAllouee;
    }

    public void setBargeAllouee(Barge bargeAllouee) {
        this.bargeAllouee .add(bargeAllouee);
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
                ", \nbargesallouees = " + bargeAllouee +
                "}\n";
    }
}
