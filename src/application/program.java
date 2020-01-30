package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.reservation;

public class program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check out (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		
		else {
			reservation reservation = new reservation(roomNumber, checkIn, checkout);
			System.out.print("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check out (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			String error = reservation.updateDate(checkin, checkout);
			if (error != null) {
				
			System.out.print("Error in reservation: " + error);
			
			}
			
			else {
			
			System.out.println("Reservation: " + reservation);
			
			}
		}
		
		sc.close();

	}

}
