package prGuiAccount;
/*******************************************************************************
 * Model
 ******************************************************************************/

public class Account 
{
	private double balance;

	public Account(double amount) 
	{
		balance = Math.max(0, amount);
	}

	public void deposit(double amount) 
	{
		balance += amount;
	}

	public double withdraw(double amount) 
	{
		double realAmount = amount;
		if (balance < amount) 
		{
			realAmount = balance;
		}
		balance -= realAmount;
		return realAmount;
	}

	public double getBalance() 
	{
		return balance;
	}
}
