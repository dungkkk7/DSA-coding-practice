import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class SpaceExploration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc n và k
        int n = scanner.nextInt();
        BigInteger k = scanner.nextBigInteger();
        
        // Đọc trọng lượng tiêu chuẩn s và trọng lượng hiện tại a
        BigInteger[] s = new BigInteger[n];
        BigInteger[] a = new BigInteger[n];
        
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextBigInteger();
        }
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextBigInteger();
        }

        // Tính độ lệch chuẩn hiện tại và thêm vào danh sách
        BigInteger[] deviations = new BigInteger[n];
        BigInteger totalDeviation = BigInteger.ZERO;
        
        for (int i = 0; i < n; i++) {
            if (s[i].equals(BigInteger.ZERO)) {
                deviations[i] = BigInteger.ZERO; // Không tính độ lệch nếu trọng lượng chuẩn bằng 0
            } else {
                deviations[i] = a[i].subtract(s[i]).abs().divide(s[i]); // Độ lệch chuẩn
            }
            totalDeviation = totalDeviation.add(deviations[i]); // Cập nhật tổng độ lệch chuẩn
        }

        // Nếu tổng độ lệch chuẩn đã nhỏ hơn hoặc bằng k, không cần điều chỉnh
        if (totalDeviation.compareTo(k) <= 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(deviations, (x, y) -> y.compareTo(x)); // Sắp xếp giảm dần độ lệch chuẩn
        BigInteger time = BigInteger.ZERO;
        
        for (int i = 0; i < n; i++) {
            if (totalDeviation.compareTo(k) <= 0) {
                break;
            }
            BigInteger currentDeviation = deviations[i];
            BigInteger decreaseAmount = currentDeviation.min(totalDeviation.subtract(k));
            time = time.add(decreaseAmount);  // Thời gian điều chỉnh
            totalDeviation = totalDeviation.subtract(decreaseAmount);  // Cập nhật tổng độ lệch chuẩn
        }
        
        System.out.println(time);
        scanner.close();
    }
}
