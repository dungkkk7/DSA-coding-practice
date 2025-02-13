import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author dungvnzx1
 */
public class GVariableDamage {

    /**
     * @param args the command line arguments
     */
    static class heroes {

        double health;
        int round = 0;
        artifact x;

        public heroes(double health) {
            this.health = health;
        }

    }

    static class artifact {

        double x = 0;

        public artifact(double x) {
            this.x = x;
        }

    }
    static ArrayList<heroes> hero = new ArrayList<>();
    static ArrayList<artifact> wepon = new ArrayList<>();

    public static void main(String[] args) {
        // Simulate the scenario
        wepon.add(new artifact(5)); // Add artifact with durability 5
        hero.add(new heroes(4)); // Add hero with health 4
        attack(hero, wepon); // Perform attack

        hero.add(new heroes(10)); // Add hero with health 10
        attack(hero, wepon); // Perform attack
    }

    public static void attack(ArrayList<heroes> hero, ArrayList<artifact> wepon) {
        if (hero.isEmpty()) {
            System.out.println("0");
            return;
        }

        int numberOfHeroes = hero.size();
        int numberOfActiveWepon = wepon.size();
        numberOfActiveWepon = Math.min(numberOfHeroes, numberOfActiveWepon);

        for (int i = 0; i < numberOfActiveWepon; i++) {
            hero.get(i).x = wepon.get(i);
        }
        for (int i = numberOfActiveWepon; i < numberOfHeroes; i++) {
            hero.get(i).x = new artifact(0);
        }

        ArrayList<heroes> deadHeroes = new ArrayList<>();
        int total = 0;
        for (heroes h : hero) {
            boolean datru = false;
            double dam = 1.0 / (numberOfHeroes + numberOfActiveWepon);
            if (dam == h.x.x) {
                numberOfActiveWepon -= 1;
                datru = true;
            }
            System.err.println(dam);
            total += h.round = (int) (h.health / dam);

            h.health = 0;

            deadHeroes.add(h);

            numberOfHeroes--;
            numberOfActiveWepon -= datru ? 0 : 1;
        }
        System.out.println(total + "x");
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}