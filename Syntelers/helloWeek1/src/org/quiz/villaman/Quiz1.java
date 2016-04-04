package org.quiz.villaman;

public class Quiz1 {

	public static void main(String args[]){
    int[] a = {1,2,053,4};
    int k[][] = new int[3][];
    k[1] = new int[]{1,2,3};
    k[2] = new int[]{4,5};
    System.out.print(k[1][1]);
    int b[][] = { {1,2,4} , {2,2,1},{0,43,2}};
    for(int i = 0; i <b.length; i++){
    	for(int j =0; j < b.length; j++){
    		System.out.print(k[i][j]);
    	}
    	System.out.println();
    }
	}
}
