import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] arr, int target) {
        // Khởi tạo biến lưu tổng gần nhất
        int closestSum = arr[0] + arr[1] + arr[2];
        Arrays.sort(arr);
        int n = arr.length;

        // Duyệt qua từng phần tử trong mảng
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Sử dụng hai con trỏ left và right
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                // Nếu tổng bằng target, trả về ngay lập tức
                if (sum == target) {
                    return sum;
                }

                // Cập nhật closestSum nếu tổng hiện tại gần hơn
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Điều chỉnh left và right
                if (sum < target) {
                    left++; // Tổng nhỏ hơn target, cần tăng tổng
                } else {
                    right--; // Tổng lớn hơn target, cần giảm tổng
                }
            }
        }

        // Trả về tổng gần nhất
        return closestSum;
    }
}
