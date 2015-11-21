
import java.util.*;

/*
----------------------------
|	Reservierung			|
----------------------------
|sitze[] 					|
|anzahlreserviertesitze		|
----------------------------
|initialisieren()			|
|istFrei()					|	
|reservieren()				|
|drucken() 					|
|getAnzahlReservierteSitze()|
|getAnzahlFreieSitze()		|
----------------------------
*/

class ReservierungMain
{

	public static void main(String... args)
	{
		Scanner tastatur = new Scanner(System.in);
		Reservierung reservierung = new Reservierung(10);
		while (reservierung.getAnzahlFreieSitze() > 0){
		//...
			System.out.print("Befehl eingeben: ");
			String befehl = tastatur.next();

			if (befehl.equalsIgnoreCase("R")){
				
				System.out.println("Bitte geben Sie Ihren Namen ein:");
				String name = tastatur.next();
				System.out.println(name + ", wo möchten Sie sitzen? ");
				int platzNummer = tastatur.nextInt();
				
				if (reservierung.reservieren(platzNummer, name) == true){
					System.out.println(name + ", Ihr Platz ist gebucht!");
				}
				else {
					System.out.println("der Platz ist leider vergeben");
				}
			}
			else if (befehl.equalsIgnoreCase("D")){
				reservierung.drucken();
			}
			else if (befehl.equalsIgnoreCase("E"))
			{
				System.out.println("------- abgebrochen -------");	
				break;
			}
		//...
		}
		//...
		if (reservierung.getAnzahlFreieSitze() == 0) {
			System.out.println("Das Flugzeug ist voll. Es geht los!");
		}
	}
}

class Reservierung
{
	String[] sitze;

	public Reservierung(int anzahlSitze)
	{
		sitze = new String[anzahlSitze];
		initialisieren();
	}

	public boolean istFrei(int platz)
	{
		return platz >= 0 && sitze.length > platz && sitze[platz].equals("frei");
	}

	public boolean reservieren(int platz, String name)
	{
		if(!istFrei(platz))
			return false;
		sitze[platz] = name;
		return true;
	} 

	public int getAnzahlFreieSitze()
	{
		int i = 0;
		for(String str : sitze)
			i+= str.equals("frei")?1:0;
		return i;
	}

	public int getAnzahlReservierteSitze()
	{
		return sitze.length - getAnzahlFreieSitze();
	}

	private void initialisieren()
	{
		for(int i = 0; i<sitze.length; i++)
			sitze[i] = "frei";
	}

	public void drucken()
	{
		System.out.println("-----------------------------");
		for(int i = 0; i < sitze.length; i++)
		{
			System.out.println("["+i+", "+sitze[i]+"]");
		}
		System.out.println("\r\n-----------------------------");
	}
}
