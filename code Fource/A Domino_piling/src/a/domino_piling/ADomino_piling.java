


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author dungvnzx1
 */
public class ADomino_piling {
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FastReader rd = new FastReader(System.in); 
        int n = rd.nextInt();
        int k = rd.nextInt(); 
       
       
        System.out.println(n*k/2);
        
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
            }
            return line;
        }
    }
    
}
