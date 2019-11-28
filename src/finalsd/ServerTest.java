package finalsd;

import java.io.*;
import java.net.*;

/**
 *
 * @author CincoOcho <///7>
 */
public class ServerTest {

    public static String strData, nameClientRec, msgClientRec, timeSetRec;

    public static void main(String[] args) {
        System.out.println("Server say ---> Server running...");
        Ssocket();
        MakeTXTLogFile();

    }

    public static void Ssocket() {

        try {
            ServerSocket ss = new ServerSocket(6666); //PORT TO LISTEN SOCKET CLIENT
            Socket s = ss.accept();//establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            //str = (String) dis.readUTF();
            nameClientRec = (String) dis.readUTF();
            msgClientRec = (String) dis.readUTF();
            System.out.println("<- - -RECEIVED-AND-SAVED-DATA- - ->");
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void MakeTXTLogFile() {
        timeSetRec=" ";

        strData = nameClientRec + "_" + timeSetRec + "_";
        try {
            PrintWriter writer = new PrintWriter(strData+" .txt", "UTF-8");
            writer.println(msgClientRec);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
