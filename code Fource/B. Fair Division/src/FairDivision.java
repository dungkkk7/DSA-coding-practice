import java.util.Scanner;

public class FairDivision {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // số lượng test case

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // số lượng kẹo
            int count1 = 0; // số kẹo 1 gram
            int count2 = 0; // số kẹo 2 gram

            // Đếm số kẹo 1 và 2
            for (int j = 0; j < n; j++) {
                int candy = sc.nextInt();
                if (candy == 1) {
                    count1++;
                } else {
                    count2++;
                }
            }

            // Tính tổng trọng lượng
            int totalWeight = count1 + 2 * count2;

            // Kiểm tra điều kiện
            if (totalWeight % 2 != 0) {
                System.out.println("NO"); // Tổng trọng lượng lẻ
            } else {
                int halfWeight = totalWeight / 2;
                // Kiểm tra nếu có thể chia được
                if (halfWeight % 2 == 0 || (halfWeight % 2 == 1 && count1 > 0)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

        sc.close();
    }
}
