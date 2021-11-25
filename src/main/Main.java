package main;

import demande.Demande;
import demande.LectureDemande;
import flotte.Barge;
import service.LectureService;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Demande> demandeList = new ArrayList<>();
        List<Service> serviceList = new ArrayList<>();


        int i = 0;
        int j = 0;
        int time = 0;

        while (time < 14) {
            if (j == 14 || j == 0) {
                System.out.println("----------------------Début de semaine " + (time / 14 + 1) + "----------------------");
                LectureDemande ld = new LectureDemande();
                LectureService ls = new LectureService();
                demandeList = ld.getListDemande();
                serviceList = ls.getListService();

                i = 0;
                j = 0;
            }
            for (Demande demande : demandeList) {
                for (Service service : serviceList) {
                    if ((demande.getOrigin().equals(service.getOrigin()))
                            && (demande.getDestination().equals(service.getDestination()))
                            && (demande.getVolume() <= service.getCapacity())
                            && (service.getInitialLoading() >= demande.getDepartureTime())
                            && (service.getArrival() <= demande.getArrivalTime())
                    ) {

                        // Si on gère une demande qui vient d'arriver ( cas pour 1 seule barge, pas de cas d'addition si gros volume)
                        if (demande.getBargeAllouee().isEmpty() && service.getInitialLoading() == i) {
                            boolean trouve = false;
                            Barge b = service.getBargeList().get(0);
                            if (service.getBargeList().size() > 0) {
                                for (int k = 1; k < service.getBargeList().size(); k++) {
                                    Barge tmp = service.getBargeList().get(k);
                                    if (b.isDisponible()
                                            && tmp.isDisponible()
                                            && tmp.getPoids() >= demande.getVolume()
                                            && tmp.getPoids() < b.getPoids()) {
                                        tmp.setDisponible(false);
                                        demande.setBargeAllouee(tmp);

                                        trouve = true;
                                    }
                                }
                            }
                            if (!trouve) {
                                b.setDisponible(false);
                                demande.setBargeAllouee(b);
                            }
                            System.out.println("-Charge du Service " + service.getServiceID() + " a 1/2 journee " + i);
                        } else {
                            if (!service.getDepartureTime().isEmpty()) {
                                if (service.getDepartureTime().get(0).equals("-")) {
                                    if (service.getDeparture() == i) {
                                        int id = service.getServiceID();
                                        String s = service.getPathOfEachLeg().get(0);
                                        System.out.println("--Service tiret " + id + " départ du point " + s + " a 1/2 journee " + i);
                                    }
                                } else if (service.getDeparture() == i || service.getDepartureTime().get(1).equals(Integer.toString(i))) {
                                    int id = service.getServiceID();
                                    String s = service.getPathOfEachLeg().get(0);
                                    System.out.println("--Service pas tiret " + id + " départ du point " + s + " a 1/2 journee " + i);
                                    if (service.getDepartureTime().get(1).equals(Integer.toString(i))){
                                        service.getDepartureTime().remove(0);
                                        service.getDepartureTime().remove(0);
                                    }
                                    service.getPathOfEachLeg().remove(0);
                                }
                            }
                            if (!service.getStoppingTime().isEmpty()) {
                                if (!service.getStoppingTime().get(0).equals("-") && service.getStoppingTime().get(1).equals(Integer.toString(i))) {
                                    int id = service.getServiceID();
                                    String s = service.getStoppingTime().get(0);
                                    System.out.println("---Service " + id + " arrive en " + s + " a 1/2 journee " + i);
                                    service.getStoppingTime().remove(0);
                                    service.getStoppingTime().remove(0);
                                    service.getPathOfEachLeg().remove(0);
                                }
                            }

                            if (service.getArrival() == i) {
                                int id = service.getServiceID();
                                String s = service.getDestination();
                                System.out.println("----Service " + id + " arrive en " + s + " a 1/2 journee " + i + " et a termine");
                                demande.getBargeAllouee().get(0).setDisponible(true);
                                demande.getBargeAllouee().remove(0);
                            }
                        }
                    }
                }
            }
            j++;
            i++;
            time++;
        }
    }


}

// gérer la demande 3R
