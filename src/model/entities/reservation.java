package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public reservation(Integer roomNumber, Date checkIn, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDate(Date checkin, Date checkout) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkout.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		this.checkIn = checkin;
		this.checkout = checkout;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " +
				roomNumber +
				"Check in" +
				sdf.format(checkIn) +
				"Check out " +
				sdf.format(checkout) +
				", " +
				duration() +
				"nights";
				
	}
}
