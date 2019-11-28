package finalsd;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author CincoOcho <///7>
 */
public class Client {

    public static String user, msg, dataSend = "";

    public static void main(String[] args) {
        inputUser();
        socket();

    }

    public static void socket() {
        //dataSend = "\t\n- - -DATA CLIENT- - -\nUsuario: " + user + "." + "\nMe
        //nsaje: " + msg + ".";

        try {
            Socket s = new Socket("localhost", 6666);  //IP , PORT CONFIG
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            //dout.writeUTF(dataSend);
            dout.writeUTF(user);
            dout.writeUTF(msg);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void inputUser() {
        int randomServer = 0;
        boolean msgOk = false;
        String passOk = "";
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Introduzca su nombre de usuario : ");
            user = scan.nextLine();
            System.out.print("Introduzca su mensaje a continuación: ");
            msg = scan.nextLine();
            System.out.println("Desea enviar el mensaje ?");
            System.out.print("Si(s) / No(n) ? -> ");
            passOk = scan.nextLine();
            if ("s".equals(passOk)) {
                System.out.println("Se envió el mensaje al servidor número " + randomServer + "");
                msgOk = true;

            } else {
                System.out.println("No se envió nada al servidor !");
                System.out.println("-----------------------------NEW LINE CLIENT------------------"
                        + "--------------");
                msgOk = false;
            }
        } while (msgOk != true);

    }

}
