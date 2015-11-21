
import java.util.*;

/*
-------------------------
|	Account		|
-------------------------
|balance 		|
|owner	 		|
-------------------------
|drawOut()		|
|deposit()		|	
|getBalance()		|
|print() 		|
-------------------------
*/

class AccountApp
{

	public static void main(String... args)
	{
		// Initialisiere mit einem Kontostand von 5 Euro (5*100 Cents)
		Account account = new Account(5.0, "Hans");
		
		// Kontostand anzeigen
		System.out.println(account.getBalance());
		
		// 100 Euro einzahlen
		account.deposit(100.0);
		
		// Kontostand anzeigen
		System.out.println(account);

		// 50 Euro abheben und Rückgabewert auswerten
		if (account.drawOut(50.0) == true){
			System.out.println(account.getBalance());
		}

		else {
			System.out.println("FEHLER: das Guthaben ist nicht ausreichend");
		}
	}
}

class Account
{
	double balance;
	String owner;

	public Account(double balance, String owner)
	{
		this.owner = owner;
		this.balance = balance;
	}

	public void deposit(double d)
	{
		balance += d;
	}

	public boolean drawOut(double d)
	{
		if(balance >= d)
		{
			balance -= d;
			return true;
		}
		else
		{
			return false;
		}
	}

	public double getBalance()
	{
		return balance;	
	}

	public void print()
	{
		System.out.println("Kontostand ("+owner+"): "+balance+" Euro");
	}
}
