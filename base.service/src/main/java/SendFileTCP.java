import eapli.base.machinemanagement.domain.ConfigurationSheet;
import eapli.base.machinemanagement.domain.ProtocolId;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SendFileTCP extends Thread {
    private ConfigurationSheet file;
    private ProtocolId protocolId;
    private InetAddress socket;
    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "lapr2020";
    private SSLSocket sock;

    public SendFileTCP(ConfigurationSheet file, ProtocolId protocolId, InetAddress socket) {
        this.file = file;
        this.protocolId = protocolId;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Trust these certificates provided by authorized clients
            System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key as server certificate
            System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            SSLSocketFactory sslF = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try {
                sock = (SSLSocket) sslF.createSocket(socket, 30803);
            } catch (IOException e) {
                System.out.println("Failed to open server socket");
                System.exit(1);
            }

            System.out.println("New client connection from " + socket.getHostAddress() + ", port number " + 30803);

            sock.startHandshake();

            DataInputStream sIn = new DataInputStream(sock.getInputStream());
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            System.out.println("Connected");
            int i = protocolId.protocolId();
            char cId = (char) i;
            byte[] aux = file.config().getBytes();
            byte[] message = build(cId, aux);
            sOut.write(message);
            byte version = sIn.readByte();
            byte code = sIn.readByte();
            char readId = sIn.readChar();
            int intId = (int) i;
            char charLength = sIn.readChar();
            System.out.println("Waiting for connections!");
            int length = (int) charLength;
            byte[] messageArray = new byte[length];
            sIn.read(messageArray, 0, length);
            String messageRead = new String(messageArray);
            System.out.println("The message is: " + messageRead);
            sock.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Error");
        }
    }

    private byte[] build(char identifier, byte[] rawData) {
        int counter = 0;
        byte version = 0;
        byte code = (byte) 2;
        byte msb = (byte) ((identifier >> 8) & 0xFF);
        byte lsb = (byte) (identifier & 0xFF);
        int length = rawData.length;
        byte fdl = (byte) ((length >> 8) & 0xFF);
        byte sdl = (byte) (length & 0xFF);
        byte[] message = new byte[length + 6];
        message[0] = version;
        message[1] = code;
        message[2] = msb;
        message[3] = lsb;
        message[4] = fdl;
        message[5] = sdl;
        for (int i = 6; i < message.length; i++) {
            message[i] = rawData[counter];
            counter++;
        }
        return message;
    }

}
