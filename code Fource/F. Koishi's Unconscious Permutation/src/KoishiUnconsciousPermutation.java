import java.util.ArrayList;
import java.util.Scanner;

public class KoishiUnconsciousPermutation {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n;
        int s;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            s = scanner.nextInt();
        }

        ArrayList<int[]> hoanvis = tinhHoanVi(n, s);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(Fx(hoanvis, i) % MOD).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    private static ArrayList<int[]> tinhHoanVi(int n, int s) {
        ArrayList<int[]> result = new ArrayList<>();
        permute(n, new int[n], new boolean[n], 0, result, s);
        return result;
    }

    private static int Fx(ArrayList<int[]> hoanvis, int k) {
        int count = 0;
        for (int[] x : hoanvis) {
            int pair = 0;
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i + 1] > x[i]) {
                    pair++;
                }
            }
            if (pair == k) {
                count++;
            }
        }
        return count;
    }

    private static void permute(int n, int[] current, boolean[] used, int index, ArrayList<int[]> result, int s) {
        if (index == n) {
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                if (current[i + 1] - current[i] == 1) {
                    count++;
                }
            }
            if (count == s) {
                result.add(current.clone());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                current[index] = i + 1;
                permute(n, current, used, index + 1, result, s);
                used[i] = false;
            }
        }
    }
}