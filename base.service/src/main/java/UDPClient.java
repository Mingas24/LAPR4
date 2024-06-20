import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.ProtocolId;
import eapli.base.machinemanagement.repositories.MachineRepository;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UDPClient {

    private static final MachineRepository mr = PersistenceContext.repositories().machines();

    static Map<ProtocolId, InetAddress> ipMachines = new HashMap<>();
    static Map<ProtocolId, List<String>> machStatus = new HashMap<>();

    public static void main(String[] args) throws Exception {
        machinesByProductionLine("Line 1");
        System.out.println("*Started Broadcast*");
        BroadcastRequest br = new BroadcastRequest(ipMachines);
        ipMachines = br.broadcast();
        System.out.println("*Finished Broadcast*");

        ipMachines.forEach((key, value) -> System.out.println(key + ":" + value));

        for (ProtocolId protID : ipMachines.keySet()) {
            if (ipMachines.get(protID) != null) {
                System.out.println("3");
                InetAddress ip = ipMachines.get(protID);
                Thread udp = (new UDPClientThread(machStatus, protID, ipMachines.get(protID)));
                Thread reset = (new ResetRequest(ip));
                udp.start();
                reset.start();
                while (!((UDPClientThread) udp).hasMap()) {
                    Thread.sleep(1000);
                }
                machStatus = ((UDPClientThread) udp).getMap();
                Thread.sleep(1000 * 30);
            }
        }
        System.out.println("Finished building status map");
        machStatus.forEach((key, value) -> System.out.println(key + ":" + value.toString()));
    }

    public static void machinesByProductionLine(String plID) {
        Iterable<Machine> machinesPL = mr.findMachinesByPLID(plID);
        for (Machine mach : machinesPL) {
            ipMachines.put(mach.protocolId(), null);
            machStatus.put(mach.protocolId(), new LinkedList<>());
        }
    }
}
