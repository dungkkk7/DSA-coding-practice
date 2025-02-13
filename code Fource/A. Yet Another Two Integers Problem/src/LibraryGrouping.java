import java.util.Scanner;

public class LibraryGrouping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n and k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        // Read the book counts for each student
        int[] bookCounts = new int[n];
        for (int i = 0; i < n; i++) {
            bookCounts[i] = scanner.nextInt();
        }
        
        // Count the occurrences of 1, 2, and 3
        int count1 = 0, count2 = 0, count3 = 0;
        for (int count : bookCounts) {
            if (count == 1) count1++;
            else if (count == 2) count2++;
            else count3++;
        }
        
        // Calculate total arrangements
        long totalWays = calculateWays(count1, k) * calculateWays(count2, k) * calculateWays(count3, k);
        
        // Output the result
        System.out.println(totalWays);
    }
    
    private static long calculateWays(int count, int k) {
        if (count == 0) return 1; // No students to group
        
        // Number of groups needed
        int groups = (count + k - 1) / k; // This is equivalent to Math.ceil(count / k)
        
        // Factorial for total students
        long totalArrangements = factorial(count);
        
        // Calculate factorial of the groups (since order of groups matters)
        long groupArrangements = factorial(groups);
        
        // Calculate ways to arrange students within groups
        long waysWithinGroups = 1;
        for (int i = 0; i < groups; i++) {
            int sizeOfGroup = Math.min(k, count - i * k);
            waysWithinGroups *= factorial(sizeOfGroup);
        }
        
        // The total ways are the total arrangements divided by the group arrangements
        return totalArrangements / (groupArrangements * waysWithinGroups);
    }
    
    private static long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
