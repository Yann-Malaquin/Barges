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

    private int index_depart = 0;
    private int index_arrive = 0;

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

    public int getIndex_depart() {
        return index_depart;
    }

    public void setIndex_depart() {
        this.index_depart+=2;
    }

    public int getIndex_arrive() {
        return index_arrive;
    }

    public void setIndex_arrive() {
        this.index_arrive+=2;
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
                ", \nindexDepart = " + index_depart +
                ", \nindexArrive = " + index_arrive +
                "}\n";
    }
}
