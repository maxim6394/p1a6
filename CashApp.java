import java.util.*;

class CashApp
{

	public static void main(String... args)
	{
		Scanner scanner = new Scanner(System.in);
		
		float eingabe; 
		Cash cash = new Cash(); 


		System.out.println("Preis oder neuer Kunde [0] oder fertig [-1]: ");

		while((eingabe = scanner.nextFloat() ) != -1f)
		{
			if(eingabe == 0f)
				cash.reset();
			else 
				cash.add(eingabe);

			System.out.println("Zwischensumme: "+cash.getSum());
			System.out.println("Preis oder neuer Kunde [0] oder fertig [-1]: ");
		}
	}
}

class Cash
{
	float sum;

	public void add(float f)
	{
		sum += f;
	}

	float getSum()
	{
		return sum;
	}

	void reset()
	{
		sum = 0f;
	}
}


/*
----------------------------
|	Cash					|
----------------------------
|sum 						|
----------------------------
|setSum()					|
|getSum()					|	
|reset()					|
----------------------------

*/