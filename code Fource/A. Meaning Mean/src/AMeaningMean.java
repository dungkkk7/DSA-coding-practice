
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dungvnzx1
 */
public class AMeaningMean {

    static int size;
    static int length;
    static ArrayList<Integer> arr;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FastReader rd = new FastReader(System.in);
        size = rd.nextInt();
        for (int i = 0; i < size; i++) {
            length = rd.nextInt();
            arr = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                arr.add(rd.nextInt());
            }
            operation();

        }
    }

    static void operation() {

        while (arr.size() != 1) {
            Collections.sort(arr);
            int i = 0;
            int j;
            
            if (arr.size() > 2) {
                j = arr.size() - 2;
            } else {
                j = arr.size() - 1;
            }

            double newValue = Math.floor((arr.get(i) + arr.get(j)) / 2);
            arr.add((int) newValue);
            arr.remove(j);
            arr.remove(i);

        }

        System.out.println(arr.get(0));
    }

    static class FastReader {

        private BufferedReader br;
        private String[] tokens;
        private int currentTokenIndex;

        public FastReader(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
            tokens = new String[0];
            currentTokenIndex = 0;
        }

        // Đọc dữ liệu từ đầu vào và phân tách thành token
        private void readNextLine() {
            try {
                String line = br.readLine();
                if (line != null) {
                    tokens = line.split(" "); // Phân tách bằng khoảng trắng
                    currentTokenIndex = 0;
                } else {
                    tokens = new String[0]; // Đầu vào kết thúc
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            if (currentTokenIndex >= tokens.length) {
                readNextLine(); // Đọc dòng tiếp theo nếu không còn token
            }
            return tokens[currentTokenIndex++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }

}
