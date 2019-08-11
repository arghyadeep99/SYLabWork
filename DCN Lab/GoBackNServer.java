import java.io.*;
import java.util.*;
import java.net.*;

public class GoBackNServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(5000);
			Socket s=ss.accept();//establishes connection 
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			Thread t=new Thread();
			
            int m = Integer.parseInt((String)dis.readUTF());
            int data[] = new int[(int)(Math.pow(2,m))];
            for(int i = 0;i < (int)(Math.pow(2,m)); i++)
            {
                data[i] = i;
                System.out.print(data[i]+" ");
            }
            System.out.println();

            //Data received and acknowledgement sent
            String str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");

            dout.writeUTF("Acknowledgement 1");
            t.sleep(2000);
            System.out.println("Acknowledgement 1 sent.");
            t.sleep(2000);

            //Data received but acknowledgement lost.
            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
            dout.writeUTF("Acknowledgement 2");
            t.sleep(2000);
            System.out.println("Acknowledgement 2 sent.");
            t.sleep(2000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(4000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
            dout.writeUTF("Acknowledgement 4");
            t.sleep(2000);
            System.out.println("Acknowledgement 4 sent.");
            t.sleep(2000);

            //Data lost
            str = (String)dis.readUTF();
            t.sleep(2000);
            t.sleep(4000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received. Discarded");
            t.sleep(2000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received. Discarded");
            t.sleep(2000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
            dout.writeUTF("Acknowledgement 5");
            t.sleep(2000);
            System.out.println("Acknowledgement 5 sent.");
            t.sleep(2000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
            dout.writeUTF("Acknowledgement 6");
            t.sleep(2000);
            System.out.println("Acknowledgement 6 sent.");
            t.sleep(2000);

            str = (String)dis.readUTF();
            t.sleep(2000);
            System.out.println(str+" received.");
            t.sleep(2000);
            dout.writeUTF("Acknowledgement 7");
            t.sleep(2000);
            System.out.println("Acknowledgement 7 sent.");
            t.sleep(2000);
			//TimerTask tasknew = new TimerTask();
   			// scheduling the task at interval
			dout.close();

			ss.close();

		}
		catch(Exception e){System.out.println(e);}
	}
}
