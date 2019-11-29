package finalsd;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 29-Nov-2019
 *
 * @author CincoOcho <///7>
 * Del toro Gómez José Luis 211027474UDGCUT
 */
public class Client {

    public static String user, msg, dateSend = "";
    public static Scanner scan = new Scanner(System.in);
    public static Scanner scan2 = new Scanner(System.in);
    public static String in, status;
    public static int limit, randomInt;
    //public static String HOST[] = new String[4];
    public static String IpsHosts[] = new String[4];

    public static void main(String[] args) throws IOException {
        inputHOST();
        //inputUser();
        //socket();
    }

    static void randomNumElection() {
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(limit) + 1;
    }

    public static void inputHOST() throws IOException {
        boolean flag = true;
        System.out.println("- - - - - SISTEMAS DISTRIBUIDOS, PROYECTO FINAL - - - - -");

        do {
            System.out.println("Cuantos HOST's desea verificar?");
            System.out.print("->");
            limit = scan2.nextInt();
            
            for (int i = 0; i < limit; i++) {
                i++;
                System.out.println("Introduce el HOST #" + i);
                i--;
                IpsHosts[i] = scan.nextLine();
            }
            System.out.println(" - - - - - - - Lista de Host y estado - - - - - - -");
            for (int i = 0; i < limit; i++) {
                sendPingRequest(IpsHosts[i]);
            }
            System.out.println("\n - - - - - - - Lista de Host y estado - - - - - - -\n\n");
            //------------------------------------------------------------------------------ASIGNED ARRAY GLOBAL TO LOCAL
            for (int i = 0; i < limit; i++) {
                //HOST[i] = IpsHosts[i];
                System.out.println("HOST - >" + IpsHosts[i]);
            }
            System.out.println("Desea conectar a alguno de ellos en forma aletoria?");
            System.out.println("(solo se conectará a aquellos antes comprobados como "
                    + "'reachble o OK')");
            System.out.println("SI (s) / NO (n)");
            String status = "";
            status = scan.nextLine();
            if ("s".equals(status)) {
                flag = false; //--------------------------------------------------CONECCTION TO SERVER------EXIT DO WHILE--->
                System.out.println("Se conectará a un servidor aleatoriamente !");
                System.out.println("Conectando a Servidor...");
                //----------------RANDOM------------------------------------------------CONECTION---SOCKET 
                randomNumElection();
                socket();

            } else if ("n".equals(status)) {
                System.out.println("Se eliminará todo el progreso anterior !");
                System.out.println("Desea continuar? - - - > SI (s) / NO (n)");
                status = scan.nextLine();
                if ("s".equals(status)) {
                    flag = true;
                    System.out.println("SALIENDO !!");

                } else if ("n".equals(status)) {
                    System.out.println("Reintentando !!");
                    flag = false;
                } else {
                    flag = true;
                    System.out.println("ERROR!!");
                }

            }

        } while (flag != true);

    }

    public static void socket() {
        inputUser();
          System.out.print("CLIENT SEND DATA TO - - - - >");
                System.out.println("HOST: " + IpsHosts[randomInt]);
        try {
            try (Socket s = new Socket(IpsHosts[randomInt], 6666) //IP , PORT CONFIG
            ; DataOutputStream dout = new DataOutputStream(s.getOutputStream())) {
                dout.writeUTF(user);
                dout.writeUTF(msg);
                dout.writeUTF(dateSend);
                dout.flush();
                s.close();
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("SEND MSG FINISHED");
    }

    public static void inputUser() {
        boolean msgOk = false;
        String passOk = "";
//        Scanner scan = new Scanner(System.in);

        do {

            SimpleDateFormat sdfDATE = new SimpleDateFormat("dd-M-yyyy");
            SimpleDateFormat sdfTIME = new SimpleDateFormat("HH-mm-ss");
            String date1 = sdfDATE.format(new Date());
            String date2 = sdfTIME.format(new Date());
            dateSend = "DATE " + date1 + " - - - TIME " + date2;
            System.out.print("Introduzca su nombre de usuario : ");
            user = scan.nextLine();
            System.out.print("Introduzca su mensaje a continuación: ");
            msg = scan.nextLine();
            System.out.println("Desea enviar el mensaje ?");
            System.out.print("Si(s) / No(n) ? -> ");
            passOk = scan.nextLine();
            if ("s".equals(passOk)) {
                System.out.println("Enviando mensaje..");
                msgOk = true;

            } else if ("n".equals(passOk)) {
                System.out.println("No se envió nada al servidor !");
                System.out.println("-----------------------------NEW LINE CLIENT------------------"
                        + "--------------");
                msgOk = false;
            }
        } while (msgOk != true);

    }

    public static void sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException {
        InetAddress geek = InetAddress.getByName(ipAddress);
        //System.out.println("Sending Ping Request to " + ipAddress);
        if (geek.isReachable(5000)) {
            System.out.println("\n< - - - - - - - - - - O-K - - - - - - - - - - >");
            System.out.println("Host : " + ipAddress + " is reachable !!");
            System.out.println("< - - - - - - - - - - O-K - - - - - - - - - - >");

        } else {
            System.out.println("< X- - - - - - - - - - - * - - - - - - - - - - -X >");
            System.out.println("Sorry !Host:" + ipAddress + " We can't reach to this host !");
            System.out.println("< X- - - - - - - - - - - * - - - - - - - - - - -X >");

        }

    }

}
