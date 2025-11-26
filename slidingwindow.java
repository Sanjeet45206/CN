import java.util.Scanner;

public class SlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter window size: ");
        int w = sc.nextInt();
        System.out.print("Enter number of frames: ");
        int f = sc.nextInt();
        
        int[] frames = new int[f];
        System.out.print("Enter " + f + " frames: ");
        for(int i = 0; i < f; i++) frames[i] = sc.nextInt();
        
        System.out.println("\nSliding window protocol simulation:");
        System.out.println("Sender waits for ACK after " + w + " frames\n");
        
        for(int i = 0; i < f; i++) {
            System.out.println("Sent frame: " + frames[i] + " - ACK received");
            if((i + 1) % w == 0 || (i + 1) == f)
                System.out.println("ACK for frames up to " + (i + 1) + " received.\n");
        }
    }
}
