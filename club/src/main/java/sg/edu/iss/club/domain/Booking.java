package sg.edu.iss.club.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@OneToOne
    private Member member;
	@OneToOne
    private Facility facility;
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
    private LocalDate  startDate;
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
    private LocalDate  endDate;
	
    private String comments;
    private BookingStatus status;
	public Booking(int bookingId, @NotEmpty Member member, @NotEmpty Facility facility, @FutureOrPresent LocalDate startDate,
			@FutureOrPresent LocalDate endDate, String comments, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.member = member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.status = status;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(@FutureOrPresent LocalDate startDate, @FutureOrPresent LocalDate endDate, String comments,
			BookingStatus status) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.status = status;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", member=" + member + ", startDate=" + startDate + ", endDate="
				+ endDate + ", comments=" + comments + ", status=" + status + "]";
	}
    
    

}
