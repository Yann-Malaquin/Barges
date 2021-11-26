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

        // Liste des demandes
        List<Demande> demandeList = new ArrayList<>();
        // Liste des services
        List<Service> serviceList = new ArrayList<>();
        // Lecture des demandes
        LectureDemande ld = new LectureDemande();
        // Lecture des services
        LectureService ls = new LectureService();
        // Affectation des demandes lues à la liste
        demandeList = ld.getListDemande();
        // Affectation des services lus à la liste
        serviceList = ls.getListService();

        System.out.println(serviceList);

        // Correspond à 1/2 journée
        int i = 0;
        // Permet de délimiter une semaine (0 premiere 1/2 journee; 15 permet de revenir à 0
        int j = 0;
        // Correspond au nombre total de 1/2 journée
        int time = 0;

        // Boucle pour la simulation
        while (time < 42) {
            // Si permettant de remettre à 0
            if (j == 15 || j == 0) {
                System.out.println("\u001B[33m ----------------------Début de semaine " + (time / 14 + 1) + "----------------------");
                i = 0;
                j = 0;
            }
            // Boucle pour parcourant les demandes
            for (int w = 0; w < demandeList.size(); w++) {
                // Affectation de la demande en cours
                Demande demande = demandeList.get(w);
                // Boucle parcourant les services
                for (Service service : serviceList) {
                    // Si le service peut correspondre à la demande en terme d'horaires
                    if ((demande.getOrigin().equals(service.getOrigin()))
                            && (demande.getDestination().equals(service.getDestination()))
                            && (service.getInitialLoading() >= demande.getDepartureTime())
                    ) {
                        // Si la demande n'est pas géré, cad pas de barges allouées et que le chargement correspond à la 1/2 journée alors
                        if (demande.getBargeAllouee().isEmpty() && service.getInitialLoading() == i) {
                            // On stock le poids de la demande
                            int poidsDemande = demande.getVolume();
                            int k = 0;

                            // Tant que l'on a pas atteint le poids cible ou que la liste de barges n'est pas entièrement parcourue
                            while (poidsDemande > 0 && k < service.getBargeList().size()) {
                                Barge b = service.getBargeList().get(k);
                                // Si la barge correspond aux critères on l'ajoute
                                if (b.isDisponible()) {
                                    b.setDisponible(false);
                                    demande.setBargeAllouee(b);
                                    poidsDemande -= b.getPoids();
                                }
                                k++;
                            }

                            // Si on a pas atteint le poids cible
                            if (poidsDemande > 0) {
                                // On rend les barges ajoutées à disponible
                                for (Barge b : demande.getBargeAllouee()) {
                                    b.setDisponible(true);
                                }
                                // On remet à 0 la liste
                                demande.getBargeAllouee().clear();
                            }

                            // Si la liste est vide
                            if (demande.getBargeAllouee().isEmpty()) {
                                System.out.println("\u001B[31m /!\\ Pas de barges disponibles pour " + demande.getDemandeId());
                            }
                            // Sinon on charge
                            else {
                                System.out.println("\u001B[34m -Service : " + service.getServiceID() + ", Chargement de la demande "
                                        + demande.getDemandeId() + " a 1/2 journee " + i + " avec la barge " + demande.getBargeAllouee());
                            }
                        }
                        // Sinon la demande a déjà eu ses barges allouées ou n'est pas sur l'initial loading
                        else {
                            // Vérification si la liste des barges n'est pas vide
                            if (!demande.getBargeAllouee().isEmpty()) {
                                // Vérification pour ne pas sortir de la liste
                                if (demande.getIndex_depart() + 1 < service.getDepartureTime().size()) {
                                    // Dans le cas où il n'y a pas d'arrête
                                    if (service.getDepartureTime().get(0).equals("-")) {
                                        if (service.getDeparture() == i) {
                                            int id = service.getServiceID();
                                            String s = service.getPathOfEachLeg().get(0);
                                            System.out.println("\u001B[0m --Service " + id + " départ du point " + s + " a 1/2 journee " + i);
                                        }
                                    }
                                    // Dans le cas où il y a des départs/arrêts ( + 1 pour retrouver la valeur du temps car initialisé à 0)
                                    else if (service.getDeparture() == i || service.getDepartureTime().get(demande.getIndex_depart() + 1).equals(Integer.toString(i))) {
                                        int id = service.getServiceID();
                                        if (service.getDepartureTime().get(demande.getIndex_depart() + 1).equals(Integer.toString(i))) {
                                            demande.setIndex_depart();
                                        }
                                        String s = service.getPathOfEachLeg().get(demande.getIndex_depart());
                                        System.out.println("\u001B[0m --Service " + id + " départ du point " + s + " a 1/2 journee " + i);

                                    }
                                }
                                // Vérification pour ne pas sortir de la liste
                                if (demande.getIndex_arrive() < service.getStoppingTime().size()) {
                                    // Dans le cas où il y a des arrêts  ( + 1 pour retrouver la valeur du temps car initialisé à 0)
                                    if (!service.getStoppingTime().get(0).equals("-") && service.getStoppingTime().get(demande.getIndex_arrive() + 1).equals(Integer.toString(i))) {
                                        int id = service.getServiceID();
                                        String s = service.getStoppingTime().get(demande.getIndex_arrive());
                                        System.out.println("\u001B[30m---Service " + id + " arrive en " + s + " a 1/2 journee " + i);
                                        demande.setIndex_arrive();
                                    }
                                }

                                // Vérification permettant de savoir si on est arrivée
                                if (service.getArrival() == i) {
                                    int id = service.getServiceID();
                                    String s = service.getDestination();
                                    System.out.println("\u001B[31m ----Service " + id + " arrive en " + s + " a 1/2 journee " + i + " et a termine");
                                    // On rend les barges ajoutées à disponible
                                    for (Barge b : demande.getBargeAllouee()) {
                                        b.setDisponible(true);
                                    }
                                    // On remet à 0 la liste
                                    demande.getBargeAllouee().clear();

                                    // On supprime la demande qui a été géré
                                    demandeList.remove(demande);
                                }
                            }
                        }
                    }
                }
            }
            // Incrémentation pour faire passer la 1/2 journée
            j++;
            i++;
            time++;
        }
        // Affichage permettant de voir si toutes les demandes ont été traité ou non
        if (demandeList.isEmpty()) {
            System.out.println("\u001B[32m /!\\ Il n'y a plus de demande.");
        } else {
            System.out.println("\u001B[32m /!\\ Il reste " + demandeList.size() + " demande(s) non traitée(s)");
        }


    }


}
