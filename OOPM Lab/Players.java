import java.util.*;
import java.text.DecimalFormat;
class Operations{
	int add(int arr[]){
		int total_runs=0;
		for(int i=0;i<arr.length;i++){
				total_runs+=arr[i];
		}
		return total_runs;
	}
	double avg(int arr[]){
		double avg=0.0;
		int total_runs=0;
		for(int i=0;i<arr.length;i++){
				total_runs+=arr[i];
			}
			return (float)total_runs/(float)arr.length;
	}
}
public class Playersr {
  public static void main(String[] args) {
    int count_matches=1;
    System.out.print("Enter number of players: ");
    Scanner sc=new Scanner(System.in);
    DecimalFormat df=new DecimalFormat("#.00");
    int n=sc.nextInt();
    Operations op=new Operations();
    int[][] arr= new int[n][];
    int[] total_runs=new int[n];
    double[] avg=new double[n];
    for(int i=0;i<n;i++){
    System.out.print("Enter number of matches of player "+(i+1)+": ");
    int j=sc.nextInt();
    arr[i]=new int[j];
    System.out.println("Enter runs scored in each match: ");
    for(int k=0;k<arr[i].length;k++){
        arr[i][k]=sc.nextInt();
       }
    }
	System.out.println("Player\t\tTotal Runs\t\tAverage");
    for(int i=0;i<n;i++){
	total_runs[i]=op.add(arr[i]);
	avg[i]=op.avg(arr[i]);
        System.out.println("Player "+(i+1)+"\t"+total_runs[i]+"\t\t\t"+df.format(avg[i]));
	}
  }
}
