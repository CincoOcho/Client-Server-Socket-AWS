package finalsd;
import java.io.*;  
import java.net.*; 

/**
 *
 * @author CincoOcho <///7>
 */
public class ServerTest {
        public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(6666); //PORT TO LISTEN SOCKET CLIENT
			Socket s=ss.accept();//establishes connection
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String  str=(String)dis.readUTF();
			System.out.println("message= "+str);
			ss.close();
		}catch(Exception e){System.out.println(e);}
	}
    
}
