import java.net.*;
import java.io.*;
import java.util.*;
class Stop_and_wait_Receiver
{
	public static void main(String args[])
	{
		try{
			Scanner sc =new Scanner(System.in);
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			Socket socket1 = new Socket("LocalHost",7777);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket1.getOutputStream());
			int frameNo = 0;
			int f = 0;
			int type = 0;
			for(int i=0;i<6;i++) {
				f = Integer.parseInt(dis.readUTF());
				System.out.println("Frame "+f%2+" received");
				System.out.println("1. Normal Communication");
				System.out.println("2. Ack failure");
				type = sc.nextInt();
				if(type == 2)
				{
					dout.writeUTF("-1");
					continue;
				}
				if(f == frameNo + 1)
				{
					frameNo = f;
					dout.writeUTF(""+frameNo);
				}
				else
				dout.writeUTF(""+frameNo);
				System.out.println("ack "+(frameNo+1)%2+" sent");
			}
			ss.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}
