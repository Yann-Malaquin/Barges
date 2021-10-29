package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Class permettant la lecture d'un ou des services
public class LectureService {

    // La liste des services à lire
    private List<Service> listService;

    public LectureService() {
        listService = new ArrayList<>();
        try {
            // Le fichier d'entrée
            File file = new File("src/services.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            int x = 0;
            int j;
            String[] tab = new String[14];
            String temp;
            String[] lines = new String[7];
            while ((temp = br.readLine()) != null) {
                j = 0;
                if (x > 0) {
                    lines = temp.split("\\s+");
                    for (String word : lines) {
                        tab[j] = word;
                        j++;
                    }
                    int serviceID = Integer.parseInt(tab[0]);
                    String origin = tab[1];
                    String destination = tab[2];
                    List<String> setOfLegs = new ArrayList<>();
                    String[] sOL = tab[3].split(";");
                    setOfLegs.addAll(Arrays.asList(sOL));
                    List<String> pathOfEachLeg = new ArrayList<>();
                    String[] pOEL = tab[4].split(";");
                    pathOfEachLeg.addAll(Arrays.asList(pOEL));
                    List<Integer> travelTime = new ArrayList<>();
                    String[] tT = tab[5].split(";");

                    for (String s : tT){
                        travelTime.add(Integer.parseInt(s));
                    }

                    int initialLoading = Integer.parseInt(tab[6]);
                    int finalUnloading = Integer.parseInt(tab[7]);
                    int departure = Integer.parseInt(tab[8]);
                    int arrival = Integer.parseInt(tab[9]);
                    List<String> stoppingTime;
                    List<String> departureTime;
                    int capacity = Integer.parseInt(tab[12]);
                    List<Map<Integer, String>> vesselType;
                    //Service s = new Service();
                }
                else {
                    x++;
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
