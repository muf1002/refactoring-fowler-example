package main.java.ubu.gii;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {

			Rental each = rentals.next();


			frequentRenterPoints += each.getFrequentRenterPoints();
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
	private double getTotalCharge() {
		double result = 0;

		Iterator<Rental> rentals = _rentals.iterator();
		while (rentals.hasNext()) {

			Rental each = rentals.next();
			result += each.getCharge();
		}

		return result;
	}
}
