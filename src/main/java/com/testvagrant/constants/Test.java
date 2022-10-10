package com.testvagrant.constants;

public class Test {

	public static void main(String[] args) {
		
		//arrival_list         = {1300, 1400, 1530, 1700}
	    // deparature_list = {1330, 1410, 1800, 1830}
		
		int[] arrival =  {1300,1400,1530,1700,1730};
		int[] departure= {1330,1410,1800,1830,1900};
		int numOfPlatform=1;
		int size = arrival.length;
		
		for(int i=0,j=0; i<size&&j<size;i++) {
			
			while(departure[j]<arrival[i+1]) {
				numOfPlatform++;
				i++;
			}
			
		}
		System.out.println("Platform :"+ numOfPlatform);
		
		

	}

}
