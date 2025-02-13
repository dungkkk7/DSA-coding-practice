import java.util.*;

public class TournamentProbabilities {
    
    // Function to find the largest k such that n - k / 2 is a power of 2
    private static int findK(int n) {
        for (int k = 2; k <= n; k += 2) {
            if ((n - k / 2) > 0 && ((n - k / 2) & (n - k / 2 - 1)) == 0) {
                return k;
            }
        }
        return n;
    }

    // Main function to calculate the tournament probabilities
    public static double[] tournamentProbabilities(int n, int[] luckiness) {
        int k = findK(n);
        
        // Initialize probabilities for participants 1 to k
        double[] probabilities = new double[n];
        for (int i = 0; i < k; i++) {
            probabilities[i] = 1.0;  // Initial probability of first k participants is 1
        }
        
        List<Integer> currentParticipants = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            currentParticipants.add(i); // Store indices of current participants
        }
        
        while (currentParticipants.size() > 1) {
            List<Integer> nextParticipants = new ArrayList<>();
            
            // Pair participants and calculate winning probabilities
            for (int i = 0; i < currentParticipants.size(); i += 2) {
                int p1 = currentParticipants.get(i);
                int p2 = currentParticipants.get(i + 1);
                
                // Calculate win probabilities
                double totalLuckiness = luckiness[p1] + luckiness[p2];
                double probP1Wins = luckiness[p1] / totalLuckiness;
                
                // Update probabilities of the winner
                nextParticipants.add(probP1Wins > 0.5 ? p1 : p2);
                probabilities[p1] *= probP1Wins;
                probabilities[p2] *= (1 - probP1Wins);
            }
            
            // Update the current participants to the winners
            currentParticipants = nextParticipants;
        }
        
        // The last remaining participant is the winner
        int finalWinner = currentParticipants.get(0);
        probabilities[finalWinner] = 1.0;
        
        return probabilities;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of participants
        int n = scanner.nextInt();
        int[] luckiness = new int[n];
        
        // Read luckiness values
        for (int i = 0; i < n; i++) {
            luckiness[i] = scanner.nextInt();
        }
        
        // Calculate probabilities
        double[] probabilities = tournamentProbabilities(n, luckiness);
        
        // Output result with specified precision
        for (double p : probabilities) {
            System.out.printf("%.9f ", p);
        }
    }
}
