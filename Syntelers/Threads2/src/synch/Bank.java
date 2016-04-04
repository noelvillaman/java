package synch;

import java.util.concurrent.locks.*;

public class Bank {
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	
	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	public void transfer(int from, int to, double amount) throws InterruptedException
	{
		bankLock.lock();
		try
		{
			while(accounts[from] < amount)
				System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("%10.2f from %d to %d", amount, from, to);
			
		}
		finally
		{
			bankLock.unlock();
		}
	}
	
	public double getTotalBalance()
	{
		bankLock.lock();
		try
		{
			double sum = 0;
			
			for (double a : accounts)
				sum += a;
			
			return sum;
		}
		finally
		{
			bankLock.unlock();
		}
	}
	public int size()
	{
		return accounts.length;
	}

}
