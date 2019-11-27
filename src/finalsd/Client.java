package finalsd;
import java.io.*;  
import java.net.*; 

/**
 *
 * @author CincoOcho <///7>
 */
public class Client {
        public static void main(String[] args) {  
		try{      
			Socket s=new Socket("localhost",6666);  //IP , PORT CONFIG
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
			dout.writeUTF("Hello Server");  
			dout.flush();  
			dout.close();  
			s.close();  
		}catch(Exception e){System.out.println(e);}  
	} 
    
}
