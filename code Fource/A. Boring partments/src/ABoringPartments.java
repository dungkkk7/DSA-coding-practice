

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class ABoringPartments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FastReader br = new FastReader();

        int n = br.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.nextInt();
        }
        int[] data = new int[(9 * 4) + 1];
        int index = 1; 
        for (int i = 1; i <= 9; i++) {
            int capsocong = i; 
            for (int j = 1; j <= 4; j++) {
                  data[index] = capsocong; 
                  capsocong = (capsocong*10) +i; 
                  index++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(caculate(input[i], data));
        }

    }

    static int caculate(int a , int[] data ) {
        int sum = 0; 
        for (int i = 1; i <= 36; i++){
            String x = data[i] +""; 
            sum += x.trim().length(); 
            if(a == data[i]){
                
                break; 
            }
        }
        return sum ;

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
