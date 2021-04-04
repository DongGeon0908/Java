package example12_2_bank;

public class Trace {
	static boolean DEBUG = true;
	
	static void out(String title, Object ... os) {
		if (DEBUG == false)
			return;
		
		int n = 0;
		
		System.out.print("\n  * " + title +": ");
		
		for (Object o : os) {
			if (n% 2 == 0)
				System.out.print(o +"=");
			else
				System.out.print(o +"   ");
			
			n++;
		}
		
		System.out.print(" done!");
	}


	static void outPair(String title, Object ... os) {
		if (DEBUG == false)
			return;

		int n = 0;

		System.out.print("\n  * " + title +": (");

		for (Object o : os) {
			if (n% 4 == 0)
				System.out.print(o +", ");
			else if (n% 4 == 1)
				System.out.print(o +")=(");
			else if (n% 4 == 2)
				System.out.print(o +", ");
			else if (n% 4 == 3)
				System.out.print(o +")   ");
			
			n++;
		}

		System.out.print(" done!");
	}
}
