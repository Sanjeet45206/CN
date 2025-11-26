import java.net.*;

class server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9876);
        byte[] recv = new byte[1024], send;
        
        while(true) {
            System.out.println("Server Up");
            DatagramPacket rp = new DatagramPacket(recv, recv.length);
            ds.receive(rp);
            
            String msg = new String(rp.getData()).trim();
            System.out.println("Received: " + msg);
            
            send = msg.toUpperCase().getBytes();
            DatagramPacket sp = new DatagramPacket(send, send.length, rp.getAddress(), rp.getPort());
            ds.send(sp);
        }
    }
}
