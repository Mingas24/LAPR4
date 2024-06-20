import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.domain.ProtocolId;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.messagemanagement.application.Interperter;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class TcpSrvSum extends Thread{

    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "lapr2020";
    private SSLServerSocket sock;
    private Socket cliSock;

    @Override
    public void run() {


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(30803);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }
        while (true) {
            System.out.println("Servidor pronto para receber conexoes!");
            try {
                cliSock = sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(new TcpSrvSumThread(cliSock)).start();
        }
    }
}

class TcpSrvSumThread extends Thread implements Runnable {

    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    byte version, code;
    short idProtMac, dataLength;
    byte convert[] = new byte[2];
    byte[] message = new byte[512];
    byte[] response = new byte[6];
    ByteBuffer wrapped;
    String rawData;
    Short conversion;
    int id;
    Logger logger = Logger.getLogger("Messages:");
    FileHandler fh;
    Interperter interperter = new Interperter();

    public TcpSrvSumThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;
        clientIP = s.getInetAddress();
        final MachineRepository repo = PersistenceContext.repositories().machines();

        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + s.getPort());

        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());

            for (; ; ) {
                try {
                    sIn.read(message);
                } catch (SocketException se) {
                    System.out.println("The Process has been interrupted");
                    break;
                }
                convert[0] = message[2];
                convert[1] = message[3];
                wrapped = ByteBuffer.wrap(convert);
                idProtMac = wrapped.getShort();
                conversion = new Short(idProtMac);
                id = conversion.intValue();
                try {
                    repo.findMachineByProtocol(id).get();
                    Main.addToMap(clientIP, new ProtocolId(idProtMac));
                } catch (NoSuchElementException nsee) {
                    response[0] = message[0];
                    response[1] = (byte) 151;
                    response[2] = message[2];
                    response[3] = message[3];
                    response[4] = message[4];
                    response[5] = message[5];
                    System.out.println("Machine not found");
                    sOut.write(response);
                    break;
                }
                version = message[0];
                code = message[1];
                convert[0] = message[4];
                convert[1] = message[5];

                wrapped = ByteBuffer.wrap(convert);
                dataLength = wrapped.getShort();
                rawData = new String(message, 6, dataLength).trim();
                System.out.println("Mensagem: " + rawData);
                if (rawData.length() != 7) {
                    interperter.checkType(rawData);
                }
                try {
                    fh = new FileHandler("./LOGS/logFile.log");
                    logger.addHandler(fh);
                    SimpleFormatter formatter = new SimpleFormatter();
                    fh.setFormatter(formatter);
                    logger.info(rawData);
                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
                response[0] = message[0];
                response[2] = message[2];
                response[3] = message[3];
                response[4] = message[4];
                response[5] = message[5];
                if (sIn.available() == 0) {
                    response[1] = (byte) 150;
                    try {
                        sOut.write(response);
                    } catch (SocketException se) {
                        System.out.println("The Process has been interrupted");
                        break;
                    }
                } else {
                    response[1] = (byte) 151;
                    try {
                        sOut.write(response);
                    } catch (SocketException se) {
                        System.out.println("The Process has been interrupted");
                        break;
                    }
                    break;
                }
            }
            for (Handler a : logger.getHandlers()) {
                a.close();
            }
            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() + " disconnected");
            s.close();
        } catch (IOException | ParseException ex) {
            System.out.println("Isto rebentou -> BOOM <-");
            ex.printStackTrace();
        }
    }
}