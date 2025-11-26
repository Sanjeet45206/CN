import java.util.Scanner;

public class lab12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buck = 0, cap = 4, rate = 3, recv, sent;
        
        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();
        int[] a = new int[n+1];
        
        System.out.print("Enter packets: ");
        for(int i = 1; i <= n; i++) 
            a[i] = sc.nextInt();
        
        System.out.println("Clock\tSize\tAccept\tSent\tRemaining");
        for(int i = 1; i <= n; i++) {
            recv = (a[i] != 0 && buck + a[i] <= cap) ? a[i] :
                   (a[i] != 0 ? -1 : 0);
            if(recv > 0) 
               buck += recv;
            
            sent = (buck > 0) ? Math.min(buck, rate) : 0;
            buck -= sent;
            
            System.out.println(i + "\t" + a[i] + "\t" + 
                (recv == -1 ? "dropped" : recv) + "\t" + sent + "\t" + buck);
        }
    }
}
