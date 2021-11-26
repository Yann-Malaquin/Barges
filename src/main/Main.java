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
        LectureDemande ld = new LectureDemande();
        LectureService ls = new LectureService();
        demandeList = ld.getListDemande();
        serviceList = ls.getListService();


        int i = 0;
        int j = 0;
        int time = 0;

        while (time < 42) {
            if (j == 15 || j == 0) {
                System.out.println("----------------------Début de semaine " + (time / 14 + 1) + "----------------------");
                i = 0;
                j = 0;
                ls = new LectureService();
                serviceList = ls.getListService();
            }
            for (int w = 0; w < demandeList.size(); w++) {
                Demande demande = demandeList.get(w);
                for (Service service : serviceList) {
                    if ((demande.getOrigin().equals(service.getOrigin()))
                            && (demande.getDestination().equals(service.getDestination()))
                            && (service.getInitialLoading() >= demande.getDepartureTime())
                            ){
                        // Si on gère une demande qui vient d'arriver ( cas pour 1 seule barge, pas de cas d'addition si gros volume)
                        if (demande.getBargeAllouee().isEmpty() && service.getInitialLoading() == i) {
                            boolean trouve = false;
                            Barge b = service.getBargeList().get(0);
                            if (service.getBargeList().size() > 0) {
                                for (int k = 1; k < service.getBargeList().size(); k++) {
                                    Barge tmp = service.getBargeList().get(k);
                                    if (tmp.isDisponible()
                                            && tmp.getPoids() >= demande.getVolume()
                                            && tmp.getPoids() < b.getPoids()) {
                                        tmp.setDisponible(false);
                                        demande.setBargeAllouee(tmp);

                                        trouve = true;
                                    }
                                }
                            }
                            if (!trouve && b.isDisponible() && b.getPoids() >= demande.getVolume()) {
                                b.setDisponible(false);
                                demande.setBargeAllouee(b);

                                System.out.println("-Service : " + service.getServiceID() + ", Chargement de la demande "
                                        + demande.getDemandeId() + " a 1/2 journee " + i + " avec la barge " + demande.getBargeAllouee());
                            }
                            else {
                                System.out.println("-Service : " + service.getServiceID() + ", Chargement de la demande "
                                        + demande.getDemandeId() + " a 1/2 journee " + i + " avec la barge " + demande.getBargeAllouee());
                            }
                            if (demande.getBargeAllouee().isEmpty()) {
                                System.out.println("Pas de barges disponibles pour " + demande.getDemandeId());
                            }
                        } else {
                            if (!demande.getBargeAllouee().isEmpty()) {
                                if (demande.getIndex_depart() + 1 < service.getDepartureTime().size()) {

                                    if (service.getDepartureTime().get(0).equals("-")) {
                                        if (service.getDeparture() == i) {
                                            int id = service.getServiceID();
                                            String s = service.getPathOfEachLeg().get(0);
                                            System.out.println("--Service " + id + " départ du point " + s + " a 1/2 journee " + i);
                                        }
                                    } else if (service.getDeparture() == i || service.getDepartureTime().get(demande.getIndex_depart() + 1).equals(Integer.toString(i))) {
                                        int id = service.getServiceID();
                                        if (service.getDepartureTime().get(demande.getIndex_depart() + 1).equals(Integer.toString(i))){
                                            demande.setIndex_depart();
                                        }
                                        String s = service.getPathOfEachLeg().get(demande.getIndex_depart());
                                        System.out.println("--Service " + id + " départ du point " + s + " a 1/2 journee " + i);

                                    }
                                }
                                if (demande.getIndex_arrive() < service.getStoppingTime().size()) {
                                    if (!service.getStoppingTime().get(0).equals("-") && service.getStoppingTime().get(demande.getIndex_arrive() + 1).equals(Integer.toString(i))) {
                                        int id = service.getServiceID();
                                        String s = service.getStoppingTime().get(demande.getIndex_arrive());
                                        System.out.println("---Service " + id + " arrive en " + s + " a 1/2 journee " + i);
                                        demande.setIndex_arrive();
                                    }
                                }

                                if (service.getArrival() == i) {
                                    int id = service.getServiceID();
                                    String s = service.getDestination();
                                    System.out.println("----Service " + id + " arrive en " + s + " a 1/2 journee " + i + " et a termine");
                                    demande.getBargeAllouee().get(0).setDisponible(true);
                                    demande.getBargeAllouee().remove(0);
                                    demandeList.remove(demande);
                                }
                            }
                        }
                    }
                }
            }
            j++;
            i++;
            time++;
        }
        System.out.println(demandeList);
    }


}

// gérer la demande 3R
// changer pour ne plus remove les pathofEachLeg
