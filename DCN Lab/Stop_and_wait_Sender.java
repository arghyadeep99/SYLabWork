import java.net.*;
import java.io.*;
import java.util.*;
public class Stop_and_wait_Sender
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
try
{
Socket socket = new Socket("LocalHost",6666);
ServerSocket ss=new ServerSocket(7777);
Socket s=ss.accept();
DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
DataInputStream din = new DataInputStream(s.getInputStream());
int i=0;
String am;
int count = 100;
int type = 0;
int r=0;
for(i=0;i<5;i++)
{
Thread.sleep(2500);
System.out.println("1. Normal Communication");
System.out.println("2. Error in sending frame");
type = sc.nextInt();
if(type == 2)
{
System.out.println("Frame "+i%2+" sent\n Timer started.");
Thread.currentThread().sleep(5000);
System.out.println("Timer expired! Retransmitting.");
i--;
continue;
}
else
Thread.currentThread().sleep(2500);
dout.writeUTF(""+i);
System.out.println("Frame "+i%2+" sent\nTimer started.");
r = Integer.parseInt((String)din.readUTF());
if(r!=-1)
{
System.out.println("ack "+(r+1)%2+" received");
}
else
{
Thread.currentThread().sleep(5000);
System.out.println("Ack "+(i+1)%2+" not received");
System.out.println("Timer expired! Retransmitting.");
i--;
}
count--;
if(count == 0)
{
System.out.println("Number of trials expired");
break;
}
}
dout.close();
socket.close();
}
catch(Exception e){
System.out.println(e);
}
}
}
