package main;

import java.util.Iterator;
import java.util.TreeSet;

class Pokladna {
	
	TreeSet<Priehradka> priehradky;
	
	Pokladna() {
		priehradky = new TreeSet<Priehradka>();
	}

	public void vydaj(float value) {
		
		Iterator<Priehradka> iterator = priehradky.descendingIterator();

		float remaining = value;
		while (iterator.hasNext() && remaining > 0) {
			Priehradka current = iterator.next();
			float returns = current.getCash(remaining);
			remaining -= returns;
			System.out.println("Returning: " + returns + " in " + current.getValue());
		}
		if (remaining >= 0) {
			System.out.println("Cant return " + remaining);
		} else {
			System.out.println("Returned all");
		}
	}
	
	public void addCash(float value, int count) {
		boolean found = false;
		for (Priehradka current: priehradky) {
			if (current.getValue() == value) {
				found = true;
				current.addCash(count);
			}
		}
		if (!found) {
			priehradky.add(new Priehradka(value, count));
		}
	}
	
	public static void main(String[] args) {

		Pokladna pokladna = new Pokladna();
		
		pokladna.addCash(5000, 2);
		pokladna.addCash(2000, 2);
		pokladna.addCash(1000, 4);
		pokladna.addCash(500, 5);
		pokladna.addCash(200, 4);
		pokladna.addCash(100, 10);
		pokladna.addCash(50, 9);
		pokladna.addCash(20, 20);
		pokladna.addCash(10, 5);
		pokladna.addCash(2, 10);
		pokladna.addCash(1, 50);
		
		pokladna.vydaj(22043.50f);


	}
}
