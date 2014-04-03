package client_n;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class Conexiune extends Thread {
  int identitate; Socket cs = null; DataInputStream is = null;
  ArrayList <DataOutputStream> sockete;
  public Conexiune(Socket client, int i, ArrayList <DataOutputStream> sockete) 
      throws IOException {
      this.sockete=sockete;
    cs = client; identitate = i; 
    is = new DataInputStream(cs.getInputStream());
    start();
  }

  public void run() {
     try {
      String mesaj="";
     while(true){
         mesaj=is.readUTF();
         System.out.println(mesaj);
         for(int i=0; i<sockete.size();i++)
             sockete.get(i).writeUTF(mesaj);
         }
     }
  }
      
    catch(Exception e) {
    System.out.print(e);}
  }
}