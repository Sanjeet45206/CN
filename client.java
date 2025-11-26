// UDP Client
import java.io.*;
import java.net.*;

class client {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        
        System.out.print("Enter string: ");
        String msg = br.readLine();
        byte[] send = msg.getBytes();
        
        DatagramPacket sp = new DatagramPacket(send, send.length, ip, 9876);
        ds.send(sp);
        
        byte[] recv = new byte[1024];
        DatagramPacket rp = new DatagramPacket(recv, recv.length);
        ds.receive(rp);
        
        System.out.println("From server: " + new String(rp.getData()).trim());
        ds.close();
    }
}
