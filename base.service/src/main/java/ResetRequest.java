import java.io.IOException;
import java.net.*;
import java.util.Arrays;


/*6002*/
public class ResetRequest extends Thread {

    private static InetAddress serverIP;

    private static final byte RESET = (byte) 3;
    private static final byte ACK = (byte) 150;
    private static final byte NACK = (byte) 151;


    public ResetRequest(InetAddress enderecoIP) {
        this.serverIP = enderecoIP;
    }

    @Override
    public void run() {
        try {
            byte[] data = new byte[512];
            byte[] emptyData = new byte[512];

            DatagramSocket s = new DatagramSocket();
            s.setBroadcast(false);
            DatagramPacket packet = new DatagramPacket(data, data.length, serverIP, 30803);

            try {
                s.setSoTimeout(20 * 1000);
                data[0] = (byte) 0;
                data[1] = RESET;
                data[2] = (byte) 0;
                data[3] = (byte) 0;
                data[4] = (byte) 0;

                defineData(data, packet);
                System.out.println("Requested Info" + Arrays.toString(data));

                System.out.println("Server IP: " + serverIP);
                packet.setAddress(serverIP);
                s.send(packet);
                System.out.println("Send!");
                defineData(emptyData, packet);
                s.receive(packet);
                System.out.println("Receive!");

                data = packet.getData();
                byte code = data[0];
                if (code == NACK) {
                    System.out.println("Reset with successful!");

                } else if (code == ACK) {
                    System.out.println("Failed Reset!");
                }
            } catch (SocketTimeoutException e) {
                System.out.println("TIMEOUT");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean defineData(byte[] info, DatagramPacket packet) {
        packet.setData(info);
        packet.setLength(info.length);
        return true;
    }
}
