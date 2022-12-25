import java.net.DatagramSocket;
import java.net.InetAddress;

public class IP {

    public static void main(String[] args){

        try (final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ip = socket.getLocalAddress().getHostAddress();
            System.out.println(ip);
        
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}