package finalsd;

import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CincoOcho <///7>
 */
public class Client {

    public static String user, msg, dateSend = "";

    public static void main(String[] args) {

        inputUser();
        socket();

    }

    public static void socket() {

        try {
            Socket s = new Socket("localhost", 6666);  //IP , PORT CONFIG
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            //dout.writeUTF(dataSend);
            dout.writeUTF(user);
            dout.writeUTF(msg);
            dout.writeUTF(dateSend);
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
           
                SimpleDateFormat sdfDATE = new SimpleDateFormat("dd-M-yyyy");                
                SimpleDateFormat sdfTIME = new SimpleDateFormat("HH-mm-ss");                
                String date1 = sdfDATE.format(new Date());
                String date2 = sdfTIME.format(new Date());
                dateSend ="DATE "+date1+" - - - TIME "+date2;
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
            } 
         while (msgOk != true);

    }

}
