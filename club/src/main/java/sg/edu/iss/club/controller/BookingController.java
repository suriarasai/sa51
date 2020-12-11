package sg.edu.iss.club.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Booking;
import sg.edu.iss.club.domain.BookingStatus;
import sg.edu.iss.club.domain.Facility;
import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.service.BookingService;
import sg.edu.iss.club.service.BookingServiceImpl;
import sg.edu.iss.club.service.FacilityService;
import sg.edu.iss.club.service.MemberService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bservice;
	
	@Autowired
	private FacilityService fservice;
	
	@Autowired
	private MemberService mservice;
	
	@Autowired
	public void setBookingService(BookingServiceImpl bserviceImpl) {
		this.bservice = bserviceImpl;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("bookings", bservice.listBooking());
		return "bookings";
	}
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("booking", new Booking());
		ArrayList<String> flist = fservice.findAllFacilityNames();
		ArrayList<String> mlist = mservice.findAllMemberNames();
		model.addAttribute("mnames", mlist);
		model.addAttribute("fnames", flist);
		return "booking-form";
	}
	
	@RequestMapping(value = "/save")
	public String saveMember(@ModelAttribute("booking") @Valid Booking booking, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) {
			return "booking-form";
		}
		Member member = mservice.findMemberByFirstName(booking.getMember().getFirstName());
		member = mservice.findMemberById(member.getMemberId());
		booking.setMember(member);
		Facility facility = fservice.findFacilityByName(booking.getFacility().getName());
		facility = fservice.findFacilityById(facility.getFacilityId());
		booking.setFacility(facility);
		booking.setStatus(BookingStatus.BOOKED);
		if (bservice.checkAvailability(booking)) {
			bservice.addBooking(booking);
			return "forward:/booking/list";
		} else
			return "error";
		
		
	}
	@RequestMapping(value = "/cancel/{id}")
	public String cancelBooking(@PathVariable("id") Integer id) {
		bservice.cancelBooking(bservice.findBookingById(id));
		return "forward:/booking/list";
	}

}
