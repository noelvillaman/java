package org.villaman.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ArrayList1 {
	private static int[] num1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		ArrayList<String> arraylist1 = new ArrayList<String>();
		arraylist1.add("Today");
		arraylist1.add("Monday");

//		for (String strings : arraylist1)
//			System.out.println(strings);

		Random rd = new Random();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			int p = rd.nextInt(100);
			// for(int j = 0; j < 10; j++){
			// //System.out.println(num1[j]);
			// if(p == num1[j]){
			// System.out.println(p);
			nums.add(p);
			// continue;
			// }
			//System.out.println(nums.get(i));
		}
		
		ArrayList1 list5 = new ArrayList1();
		//list5.myLinkl();
		list5.fila();
		
	}
	
	public void myLinkl(){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(4);
		for(int i = 0; i<12; i++){
			list.add(i);
		}
		
		list.add(9, 100);
		
		System.out.println(list.removeFirst());
		for(int p : list){
			System.out.println(p);
		}
	}
	

	public void fila(){
		Queue<Integer> que = (Queue<Integer>) new LinkedList<Integer>();
		que.add(1);
		for(int i = 1; i <13; i++){
			que.add(i);
		}
		
		System.out.println(que.peek());
		System.out.println(que.contains(5));
		que.remove();
		//que.clear();
		System.out.println("idk " +que.element());
		for(int uno : que){
			System.out.println(uno);
		}
	}

}
