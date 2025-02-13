
import java.util.Scanner;

public class A_Petya_and_Strings {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int compareTo = sc.nextLine().toLowerCase().compareTo(sc.nextLine().toLowerCase());
        if(compareTo > 0){
            System.out.println(1);
        }else if(compareTo < 0){
            System.out.println(-1);
        }else{
            System.out.println(0);
        }

    }

}
