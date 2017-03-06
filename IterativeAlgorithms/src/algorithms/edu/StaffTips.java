package algorithms.edu;

import java.util.Scanner;

public class StaffTips {
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int a = 0;
		
		String names[] = {"Ben", "Mark", "Josh", "Kyle", "Julie", "Emily", "Abby", "Liam", "John", "Alex"};
		double tips[] = {21.10, 39.52, 43.12, 56.15, 63.45, 66.78, 72.83, 87.99, 91.37, 102.49};
		
		System.out.println("Please enter a tip amount:");
		double input = in.nextDouble();
		
		a = binarySearch(tips, input);
		
		if(a == -1)
			System.out.println("Sorry, this number is not on the list.");
		
		else
			System.out.format("%n%s - You owe $%.2f to the staff kitty.", names[a], (tips[a] * .25));
		
		in.close();
		
	}
	
	private static int binarySearch(double a[], double srchVal){
		
		int lv = 0;
		int hv = a.length-1;
		
		while(hv >= lv){
			
			int mid = (lv + hv) / 2;
			
			if(srchVal == a[mid]){
				
				return(mid);
				
			} else if(srchVal > a[mid]){
				
				lv = mid+1;
				
			} else{
				
				hv = mid - 1;
				
			}
			
		}
		
		return(-1);
	
	}
	
}
