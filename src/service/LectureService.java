package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Cette class permet la lecture un ou des services
 */
public class LectureService {

    // Stockage des services lus
    private List<Service> listService;

    public LectureService() {
        // Initialisation de la liste des services
        listService = new ArrayList<>();
        try {
            // Le fichier d'entrée
            File file = new File("src/services.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            // Correspond à la ligne lu
            int x = 0;
            // Correspond au mot
            int j;
            // Tableau de 14 mots lu
            String[] tab = new String[14];
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

                    // On affecte les valeurs aux différentes variables pour ensuite créer le Service
                    // Récupération de l'ID du service
                    int serviceId = Integer.parseInt(tab[0]);
                    // Récupération de l'origin du service
                    String origin = tab[1];
                    // Récupération de la destination du service
                    String destination = tab[2];
                    // Récupération du set of legs du service
                    List<String> setOfLegs = new ArrayList<>();
                    // On "éclate" la chaîne de caractères grâce au séparateur ";" et on ajoute dans la liste
                    setOfLegs.addAll(Arrays.asList(tab[3].split(";")));
                    //Récupération du path of each leg du service
                    List<Map<String, String>> pathOfEachLeg = new ArrayList<>();
                    // On "éclate" la chaîne de caractères grâce au séparateur ";" et on ajoute dans la liste
                    String[] paths = tab[4].split(";");
                    String[] pathSplit = new String[2];
                    Map<String, String> path;
                    /*
                     * On obtient donc par exemple "A-B"
                     * On "éclate" la chaîne de caractères grâce au séparateur "-" et on crée un Map que l'on ajoute dans
                     * la liste
                     */
                    for (int i = 0; i < paths.length; i++) {
                        pathSplit = paths[i].split("-");
                        path = new HashMap<>();
                        path.put(pathSplit[0], pathSplit[1]);
                        pathOfEachLeg.add(path);
                    }
                    // Récupération du travel time pour chaque leg
                    List<Integer> travelTime = new ArrayList<>();
                    String[] tT = tab[5].split(";");
                    // Conversion des valeurs String en Integer
                    for (String s : tT) {
                        travelTime.add(Integer.parseInt(s));
                    }

                    // Récupération du début de chargement
                    int initialLoading = Integer.parseInt(tab[6]);
                    // Récupération du fin de chargement
                    int finalUnloading = Integer.parseInt(tab[7]);
                    // Récupération du pas de temps pour le premier leg emprunté
                    int departure = Integer.parseInt(tab[8]);
                    // Récupération du pas de temps lors de l'arrivée
                    int arrival = Integer.parseInt(tab[9]);

                    // Récupération du stoppingTime
                    String[] sT = tab[10].split(";");
                    String[] sTSplit = new String[2];
                    Map<String, Integer> sTMap;
                    List<Map<String, Integer>> stoppingTime = new ArrayList<>();
                    /*
                     * On obtient donc par exemple "A-2"
                     * On "éclate" la chaîne de caractères grâce au séparateur "," et on crée un Map que l'on ajoute dans
                     * la liste
                     */
                    for (int i = 0; i < sT.length; i++) {
                        sTSplit = sT[i].split(",");
                        sTMap = new HashMap<>();
                        if (sTSplit.length == 2) {
                            sTMap.put(sTSplit[0], Integer.parseInt(sTSplit[1]));
                        } else {
                            sTMap.put("-", 0);
                        }
                        stoppingTime.add(sTMap);
                    }

                    // Récupération du departureTime
                    String[] dT = tab[11].split(";");
                    String[] dTSplit = new String[2];
                    Map<String, Integer> dTMap;
                    List<Map<String, Integer>> departureTime = new ArrayList<>();
                    /*
                     * On obtient donc par exemple "A-2"
                     * On "éclate" la chaîne de caractères grâce au séparateur "," et on crée un Map que l'on ajoute dans
                     * la liste
                     */
                    for (int i = 0; i < dT.length; i++) {
                        dTSplit = dT[i].split(",");
                        dTMap = new HashMap<>();
                        if (dTSplit.length == 2) {
                            dTMap.put(dTSplit[0], Integer.parseInt(dTSplit[1]));
                        } else {
                            dTMap.put("-", 0);
                        }

                        departureTime.add(dTMap);
                    }


                    // Récupération de la capacité max
                    int capacity = Integer.parseInt(tab[12]);
                    // Récupération du vesselType
                    String[] vesselTypes = tab[13].split(";");
                    String[] vesselTypesSplit = new String[2];
                    Map<Integer, String> vessel;
                    List<Map<Integer, String>> vesselType = new ArrayList<>();
                    /*
                     * On obtient donc par exemple "1-Small"
                     * On "éclate" la chaîne de caractères grâce au séparateur "-" et on crée un Map que l'on ajoute dans
                     * la liste
                     */
                    for (int i = 0; i < vesselTypes.length; i++) {
                        vesselTypesSplit = vesselTypes[i].split("-");
                        vessel = new HashMap<>();
                        vessel.put(Integer.parseInt(vesselTypesSplit[0]), vesselTypesSplit[1]);
                        vesselType.add(vessel);
                    }

                    // Ajout d'un nouveau service dans la liste de services
                    listService.add(new Service(serviceId, origin, destination, setOfLegs, pathOfEachLeg, travelTime,
                            initialLoading, finalUnloading, departure, arrival, stoppingTime,
                            departureTime,
                            capacity, vesselType));

                } else {
                    x++;
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "LectureService { \n" +
                "listService = " + listService +
                "}\n";
    }
}
