import eapli.base.machinemanagement.domain.ProtocolId;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

public class UDPClientThread extends Thread {

    private static Map<ProtocolId, List<String>> map;
    private static ProtocolId protID;
    private static InetAddress machineIP;
    private static boolean flagMap = false;

    public Map<ProtocolId, List<String>> getMap() {
        return this.map;
    }

    public UDPClientThread(Map<ProtocolId, List<String>> map, ProtocolId protID, InetAddress machineIP) {
        this.map = map;
        this.protID = protID;
        this.machineIP = machineIP;
    }

    @Override
    public void run() {
        byte[] data = new byte[512];
        byte[] clean = new byte[512];

        try {
            DatagramSocket sock = new DatagramSocket();
            sock.setBroadcast(true);
            sock.setSoTimeout(1000 * 20);
            DatagramPacket udpPacket = new DatagramPacket(data, data.length, machineIP, 30803);

            System.out.println(machineIP);
            for (int i = 0; i < 6; i++) {
                data[i] = 0;
            }
            udpPacket.setData(data);
            udpPacket.setLength(data.length);
            sock.send(udpPacket);
            udpPacket.setData(clean);
            udpPacket.setLength(clean.length);
            try {
                sock.receive(udpPacket);
                String message = new String(data, 6, 506).trim();
                map.get(protID).add(message);
                System.out.println("Got it!");
            }catch (SocketTimeoutException e){
                map.get(protID).add("UNAVAILABLE");
            }
            flagMap = true;
            Thread.sleep(1000 * 2);
            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasMap(){
        return this.flagMap;
    }
}
