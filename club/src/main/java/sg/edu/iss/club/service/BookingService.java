package sg.edu.iss.club.service;

import java.util.List;

import sg.edu.iss.club.domain.Booking;

public interface BookingService {
	
	public void addBooking(Booking booking);
	public boolean checkAvailability(Booking booking);
	public void cancelBooking(Booking booking);
	public List<Booking> listBooking();
	public Booking findBookingById(Integer id);

}
