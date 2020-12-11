package sg.edu.iss.club.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
   @Query("Select b from Booking b where :date between b.startDate AND b.endDate AND b.facility.facilityId = :fid")
   public List<Booking> findBooking(@Param("date") LocalDate date, @Param("fid") Integer fid);
  
}
