import java.util.*;
import java.io.*;
import java.net.*;

public class GoBackNClient
{
	public static void main(String[] args)
	{
		try
		{	
			Socket s=new Socket("localhost",5000);
			Scanner sc = new Scanner(System.in);
            /*DataInputStream dis=new DataInputStream(s.getInputStream());

			String	str=(String)dis.readUTF();
			System.out.println("message= "+str);*/
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			Thread t=new Thread();
            System.out.print("Enter the value of m: ");
            int m = sc.nextInt();
            
            int w = (int)(Math.pow(2,m) - 1);
            int data[] = new int[w+1];
            for(int i = 0;i <= w;i++)
            {
                data[i] = i;
                System.out.print(data[i]+" ");
            }
			
            System.out.println("\nWindow Size: "+w);

            dout.writeUTF(Integer.toString(m));
            //Data sent and acknowledgement received
            dout.writeUTF("Frame 0");
            t.sleep(2000);
            System.out.println("Frame 0 sent.");
            String str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+ " received.");
            t.sleep(2000);
            
            //Data sent but acknowledgement not received
            dout.writeUTF("Frame 1");
            t.sleep(2000);
            System.out.println("Frame 1 sent.");
            t.sleep(2000);
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
	    
            dout.writeUTF("Frame 2");
            t.sleep(2000);
            System.out.println("Frame 2 sent.");
            t.sleep(4000);

            dout.writeUTF("Frame 3");
            t.sleep(2000);
            System.out.println("Frame 3 sent.");
            t.sleep(2000);
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);

            //Frame sent but lost
            dout.writeUTF("Frame 4");
            t.sleep(2000);
            System.out.println("Frame 4 sent.");
            t.sleep(4000);

            dout.writeUTF("Frame 5");
            t.sleep(2000);
            System.out.println("Frame 5 sent.");
            t.sleep(4000);

            dout.writeUTF("Frame 6");
            t.sleep(2000);
            System.out.println("Frame 6 sent.");
            t.sleep(4000);

            System.out.println("Timer stopped.");
            t.sleep(2000);
            System.out.println("Acknowledgement 5 not received.");
            t.sleep(2000);
            System.out.println("Timer restarted.");
            dout.writeUTF("Frame 4");
            t.sleep(2000);
            System.out.println("Frame 4 resent.");
            t.sleep(2000);
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);

            dout.writeUTF("Frame 5");
            t.sleep(2000);
            System.out.println("Frame 5 sent.");
            t.sleep(2000);
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+ " received.");
            t.sleep(2000);

            dout.writeUTF("Frame 6");
            t.sleep(2000);
            System.out.println("Frame 6 sent.");
            t.sleep(2000);
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+ " received.");
            t.sleep(2000);

			dout.close();
			s.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}
