import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BMultiplyBy2DivideBy6 {

    public static void main(String[] args) {
        FastReader br = new FastReader();

        int n = br.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(calculate(input[i]));
        }
    }


    static int calculate(int x) {
        if (x <= 0) {
            return -1;
        }
            if (x == 1) {
                return 0;
            } else {
                int moves = 0;
                while (x != 1) {
                    if (x % 6 == 0) {
                        x = x / 6;
                    } else if (x % 3 == 0) {
                        x *= 2;
                    } else {
                        return -1;
                    }
                    moves++;
                }
                return moves;
            }
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
