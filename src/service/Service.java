package service;

import flotte.Barge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class représentant un service
 *
 * @author Yann Malaquin Billy Mortreux
 * @version 1.0
 * @name : LectureDemande
 * @created 15/11/2021 - 13:32
 * @project Barges
 * @copyright Yann
 **/
public class Service {

    // Identifiant du service
    private int serviceID;

    // L'origine du service
    private String origin;

    // La destination du service
    private String destination;

    // Liste des arcs correspondant à un transport
    private List<String> setOfLegs;

    // L'origine et la destination de chaque transport
    private List<String> pathOfEachLeg;

    // La duree du trajet (1/2 journee)
    private List<String> travelTime;

    // Debut du chargement
    private int initialLoading;

    // Fin de dechargement
    private int finalUnloading;

    // Pas de temps (en 1/2 journee) du premier leg emprunte
    private int departure;

    // Pas de temps (en 1/2 journee) pour l'arrivee a destination
    private int arrival;

    // Arrets effectues pendant le service
    private List<String> stoppingTime;

    // Fins des arrets effectues pendant le service
    private List<String> departureTime;

    // Capacite maximale du service en TEU
    private int capacity;

    // Les barges présentent dans le service
    private List<Barge> bargeList;


    public Service(int serviceId, String origin, String destination, List<String> setOfLegs, List<String> pathOfEachLeg,
                   List<String> travelTime, int initialLoading, int finalUnloading, int departure, int arrival,
                   List<String> stoppingTime, List<String> departureTime, int capacity,
                   List<Barge> bargeList) {
        this.serviceID = serviceId;
        this.origin = origin;
        this.destination = destination;
        this.setOfLegs = new ArrayList<>();
        this.pathOfEachLeg = new ArrayList<>();
        this.travelTime = new ArrayList<>();
        this.initialLoading = initialLoading;
        this.finalUnloading = finalUnloading;
        this.departure = departure;
        this.arrival = arrival;
        this.stoppingTime = new ArrayList<>();
        this.departureTime = new ArrayList<>();
        this.capacity = capacity;
        this.bargeList = new ArrayList<>();

        this.setOfLegs.addAll(setOfLegs);
        this.pathOfEachLeg.addAll(pathOfEachLeg);
        this.travelTime.addAll(travelTime);
        this.stoppingTime.addAll(stoppingTime);
        this.departureTime.addAll(departureTime);
        this.bargeList.addAll(bargeList);
    }

    public int getServiceID() {
        return serviceID;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public List<String> getSetOfLegs() {
        return setOfLegs;
    }

    public List<String> getPathOfEachLeg() {
        return pathOfEachLeg;
    }

    public List<String> getTravelTime() {
        return travelTime;
    }

    public int getInitialLoading() {
        return initialLoading;
    }

    public int getFinalUnloading() {
        return finalUnloading;
    }

    public int getDeparture() {
        return departure;
    }

    public int getArrival() {
        return arrival;
    }

    public List<String> getStoppingTime() {
        return stoppingTime;
    }

    public List<String> getDepartureTime() {
        return departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Barge> getBargeList() {
        return bargeList;
    }


    @Override
    public String toString() {
        return "\nService { \n" +
                "serviceID = " + serviceID +
                ", \norigin = '" + origin + '\'' +
                ", \ndestination = '" + destination + '\'' +
                ", \nsetOfLegs = " + setOfLegs +
                ", \npathOfEachLeg = " + pathOfEachLeg +
                ", \ntravelTime = " + travelTime +
                ", \ninitialLoading = " + initialLoading +
                ", \nfinalUnloading = " + finalUnloading +
                ", \ndeparture = " + departure +
                ", \narrival = " + arrival +
                ", \nstoppingTime = " + stoppingTime +
                ", \ndepartureTime = " + departureTime +
                ", \ncapacity = " + capacity +
                ", \nbargeList = " + bargeList +
                "}\n";
    }
}
