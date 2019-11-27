package finalsd;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author CincoOcho <///7>
 */
public class Client {

    public static String user, msg = "";

    public static void main(String[] args) {
        inputUser();
        server();

    }

    public static void server() {

        try {
            Socket s = new Socket("localhost", 6666);  //IP , PORT CONFIG
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void inputUser() {
        int randomServer=0;
        boolean msgOk = false;
        String passOk="";
        Scanner scan = new Scanner(System.in);
        while (msgOk != true) {
            System.out.print("Introduzca su nombre de usuario : ");
            user = scan.nextLine();
            System.out.print("Introduzca su mensaje a continuación: ");
            msg = scan.nextLine();
            System.out.println("Desea enviar el mensaje ?");
            System.out.print("Si(s) / No(n) ? -> ");
            passOk = scan.nextLine();
            if ("S".equals(passOk)) {
                System.out.println("Se enviará el mensaje al servidor numero"+randomServer+"");
                msgOk=true;
                
            }
            else{
                System.out.println("No se enviará nada al servidor !");
                msgOk=false;
            }
        }

    }

}
