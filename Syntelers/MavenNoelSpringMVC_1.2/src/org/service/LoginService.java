package org.service;

public class LoginService {
	
	public int[][] getMultiplicationTable(int num, int[][] table) throws ArrayIndexOutOfBoundsException
	{
		
		for(int iRow = num; iRow < (num+1); iRow++)
		{
			for(int iCol = 1; iCol < table.length; iCol++)
			{
				table[iRow][iCol] = iRow * iCol;
				System.out.print(table[iRow][iCol]);
			}
			//System.out.println();
		}
		
		return table;
	}
	public int[][] getMultiplicationTable(int[][] table)
	{
		for(int iRow = 1; iRow < table.length; iRow++)
		{
			for(int iCol = 1; iCol < table.length; iCol++)
			{
				table[iRow][iCol] = iRow*iCol;
			}
		}
		
		return table;
	}

}
