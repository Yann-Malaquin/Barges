package flotte;

import java.util.List;
import java.util.Map;

/**
 * @author Yann
 * @version 1.0
 * @name : Flotte
 * @created 16/11/2021 - 21:41
 * @project Barges
 * @copyright Yann
 **/
public class Flotte {

    private int small;
    private int medium;
    private int large;

    public Flotte(){}

    public int getSmall() {
        return small;
    }

    public int getMedium() {
        return medium;
    }

    public int getLarge() {
        return large;
    }

    public void setSmall(int small) {
        this.small = small;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "Flotte{" +
                "small=" + small +
                ", medium=" + medium +
                ", large=" + large +
                '}';
    }
}
