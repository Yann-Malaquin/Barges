package demande;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette class permet la lecture d'une ou des demandes
 *
 * @author Yann Malaquin Billy Mortreux
 * @version 1.0
 * @name : LectureDemande
 * @created 15/11/2021 - 14:15
 * @project Barges
 * @copyright Yann
 **/
public class LectureDemande {

    // Stockage des services lus
    private List<Demande> listDemande;

    public LectureDemande() {
        listDemande = new ArrayList<>();

        try {
            // Le fichier d'entrée
            File file = new File("src/demandes.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            // Correspond à la ligne lu
            int x = 0;
            // Correspond au mot
            int j;
            // Tableau de 6 mots lu
            String[] tab = new String[6];
            String temp;
            String[] lines = new String[7];

            // Tant que l'on peut lire dans le fichier
            while ((temp = br.readLine()) != null) {
                // On est au 1er mot
                j = 0;
                // Pour éviter de lire la 1ère ligne
                if (x > 0) {
                    // On "éclate" la chaine de caractère en mot ( utilisation du tab pour faire les séparations )
                    lines = temp.split("\\s+");

                    // On ajoute les mots dans le tableau tab
                    for (String word : lines) {
                        tab[j] = word;
                        j++;
                    }

                    // On affecte les valeurs aux différentes variables pour ensuite créer la demande
                    // Récupération de l'ID de la demande
                    String demandeId = tab[0];
                    // Récupération de l'origin de la demande
                    String origin = tab[1];
                    // Récupération de la destination de la demande
                    String destination = tab[2];
                    // Récupération de l'heure de départ
                    int departureTime = Integer.parseInt(tab[3]);
                    // Récupération de l'heure d'arrivée
                    int arrivalTime = Integer.parseInt(tab[4]);
                    // Récupération du volume à transiter
                    int volume = Integer.parseInt(tab[5]);

                    // Ajout d'une nouvelle demande dans la liste de demandes
                    listDemande.add(new Demande(demandeId, origin, destination, departureTime, arrivalTime, volume));
                } else {
                    x++;
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Demande> getListDemande() {
        return listDemande;
    }

    @Override
    public String toString() {
        return "LectureDemande { \n" +
                "listDemande = \n" + listDemande +
                "}\n";
    }
}
