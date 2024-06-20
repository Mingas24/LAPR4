import eapli.base.machinemanagement.domain.ProtocolId;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Map;

class BroadcastRequest {
    private static InetAddress targetIP;
    private static Map<ProtocolId, InetAddress> map;

    public BroadcastRequest(Map<ProtocolId, InetAddress> mapa) {
        this.map = mapa;
    }

    public static Map<ProtocolId, InetAddress> broadcast() throws Exception {
        byte[] data = new byte[512];
        byte convert[] = new byte[2];
        ByteBuffer wrapped;
        Short conversion;
        short idProtMac;
        int id;
        targetIP = InetAddress.getByName("255.255.255.255");

        DatagramSocket sock = new DatagramSocket();
        sock.setBroadcast(true);
        DatagramPacket udpPacket = new DatagramPacket(data, data.length, targetIP, 30803);

        sock.setSoTimeout(1000 * 3);

        for (int i = 0; i < 6; i++) {
            data[i] = 0;
        }
        udpPacket.setData(data);
        udpPacket.setLength(data.length);
        sock.send(udpPacket);

        while (true) {
            udpPacket.setData(data);
            udpPacket.setLength(data.length);
            try {
                sock.receive(udpPacket);
                //ID do protocolo esta nas pos 2 e 3 da data para construir ProtocolID
                convert[0] = data[3];
                convert[1] = data[2];
                wrapped = ByteBuffer.wrap(convert);
                idProtMac = wrapped.getShort();
                conversion = new Short(idProtMac);
                id = conversion.intValue();

                System.out.println("ProtID:"+ id);
                System.out.println("Map Size:"+map.size());

                //se for true adiciona no mapa, caso contrario nao adiciona
                if (checkMachineProtOnPL(id)) {
                    map.put(new ProtocolId(id), udpPacket.getAddress());
                }
            } catch (SocketTimeoutException e) {
                sock.close();
                return map;
            }
        }
    }

    //confirma se o id por param esta no mapa
    public static boolean checkMachineProtOnPL(int id) {
        return map.containsKey(new ProtocolId(id));
    }
}