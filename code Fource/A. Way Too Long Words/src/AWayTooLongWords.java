


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AWayTooLongWords {

    // 
    public static void main(String[] args) {
        // TODO code application logic here
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = rd.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if (str[i].length() <= 10) {
                System.out.println(str[i]);
            } else {
                StringBuilder str1 = new StringBuilder();
                str1.append(str[i].charAt(0)); 
                str1.append(str[i].length()-2); 
                str1.append(str[i].charAt(str[i].length()-1)); 
                System.out.println(str1.toString());
            }
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
