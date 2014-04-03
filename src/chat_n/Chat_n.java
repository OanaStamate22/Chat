
package chat_n;
import java.net.*;
import java.util.*;
import java.io.*;

class Client_n {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.print("Adresa serverului si portul : ");
    Socket cs = new Socket( sc.next(), sc.nextInt() );
    DataOutputStream os = new DataOutputStream(cs.getOutputStream());
    /*int cifra = (int) (10 * Math.random());
    os.write(cifra); os.write(200);
    // cere serverului sa afiseze de 200 de ori cifra b*/
    String mesaj;
    while(true)
    {
        mesaj=sc.next();
        os.writeUTF(mesaj); 
    }
  }
}
class Server_n {
  static int i=0;
  public static void main(String[] arg) throws IOException {
    ArrayList <DataOutputStream> sockete;
    ServerSocket ss = null; Socket cs = null;
    Scanner sc = new Scanner(System.in);
    System.out.print("Portul : ");
    ss = new ServerSocket( sc.nextInt() ); 
    System.out.println("Serverul a pornit");

    while (true) {
      cs = ss.accept(); 
      System.out.println("\nClient nou. ");
      new Conexiune(cs,++i,sockete);
      Thread t=new Thread(new Runnable(){
          public void run(){
              
          }
      });
      t.start();
    }
  }
}

class Conexiune extends Thread {
  int identitate; Socket cs = null; DataInputStream is = null;
  ArrayList <DataOutputStream> sockete;
  public Conexiune(Socket client, int i, ArrayList <DataOutputStream> sockete) 
      throws IOException {
      this.sockete=sockere;
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
   // System.out.print(e);}
  }
}

