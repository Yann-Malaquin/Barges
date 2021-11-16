package main;

import demande.Demande;
import demande.LectureDemande;
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

        while (time < 140) {
            if (j == 14 || j == 0) {
                System.out.println("----------------------Début de semaine " + (time / 14 + 1) + "----------------------");
                LectureDemande ld = new LectureDemande();
                LectureService ls = new LectureService();
                demandeList = ld.getListDemande();
                serviceList = ls.getListService();

                System.out.println(serviceList.toString());

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

                        if (service.getInitialLoading() == i) {
                            System.out.println("-Charge du Service " + service.getServiceID() + " a 1/2 journee " + i);
                        }

                        if (service.getDepartureTime().get(0).equals("-")) {
                            int id = service.getServiceID();
                            String s = service.getPathOfEachLeg().get(0);
                            System.out.println("--Service " + id + " départ du point " + s + " a 1/2 journee " + i);
                        } else if (service.getDeparture() == i || service.getDepartureTime().get(1).equals(Integer.toString(i))) {
                            int id = service.getServiceID();
                            String s = service.getPathOfEachLeg().get(0);
                            System.out.println("--Service " + id + " départ du point " + s + " a 1/2 journee " + i);
                            service.getPathOfEachLeg().remove(0);
                        }

                        if (!service.getStoppingTime().get(0).equals("-") && service.getStoppingTime().get(1).equals(Integer.toString(i))) {
                            int id = service.getServiceID();
                            String s = service.getStoppingTime().get(0);
                            System.out.println("---Service " + id + " arrive en " + s + " a 1/2 journee " + i);
                            service.getPathOfEachLeg().remove(0);
                        }

                        if (service.getArrival() == i) {
                            int id = service.getServiceID();
                            String s = service.getDestination();
                            System.out.println("----Service " + id + " arrive en " + s + " a 1/2 journee " + i + " et a termine");
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

// créer class barge mettre type et occupe?
// dans le main départ placer la barge en occupe = true
// quand arrivé à destination alors occupé = false
// donc on boucle
// dans demande mettre liste barge qui s'en occupe
// comme ça on pourra faire demande.getListBarge().get(0).setOccupe(true) connerie du genre
