import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import com.main.lib.Logger;
import com.main.lib.Village;

public class App {

    public static void main(String[] args) {

        ArrayList<Village> villages = new ArrayList<Village>();

        for (int i = 0; i < 100; i++) {
            Village v = new Village(i > 50);
            do {
                v.dayPassesAll();
            } while (v.countSick() > 0);

            Logger.log("V(" + (i > 50 ? "vacc)" : "nova)") + " sick: " + v.countSick() + ", dead: " + v.countDead());
        }

    }

}
