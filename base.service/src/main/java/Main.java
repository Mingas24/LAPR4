import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ConfigurationSheet;
import eapli.base.machinemanagement.domain.ProtocolId;
import eapli.base.machinemanagement.domain.RequestConfigurationFile;
import eapli.base.machinemanagement.repositories.RequestFileRepository;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<ProtocolId, InetAddress> connections = new HashMap<>();
    public static RequestFileRepository requestFileRepository = PersistenceContext.repositories().requestFiles();

    public static void main(String args[]) {
        runServer();
        runClient();
    }

    private static void runServer() {
        Thread thread = new TcpSrvSum();
        thread.start();
    }

    private static void runClient() {
        while (true) {
            Iterable<RequestConfigurationFile> requests = requestFileRepository.findAll();
            for (RequestConfigurationFile req : requests) {
                ProtocolId protocolId = req.identity();
                ConfigurationSheet configurationSheet = req.sheet();
                InetAddress ipServer = connections.get(protocolId);
                if (ipServer != null) {
                    Thread clientThread = new SendFileTCP(configurationSheet, protocolId, ipServer);
                    clientThread.start();
                    requestFileRepository.remove(req);
                } else {
                    System.out.println();
                }
            }
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("NONONO");
            }
        }
    }

    public static synchronized void addToMap(InetAddress inetAddress, ProtocolId protocolId) {
        connections.put(protocolId, inetAddress);
    }
}
