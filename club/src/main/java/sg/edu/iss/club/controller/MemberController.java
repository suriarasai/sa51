package sg.edu.iss.club.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.service.MemberService;
import sg.edu.iss.club.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService mservice;
	
	@Autowired
	public void setMemberService(MemberServiceImpl mserviceImpl) {
		this.mservice = mserviceImpl;
	}
    
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("members", mservice.findAllMembers());
		return "members";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("member", new Member());
		return "member-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("member", mservice.findMemberById(id));
		return "member-form";
	}
	@RequestMapping(value = "/save")
	public String saveMember(@ModelAttribute("member") @Valid Member member, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "member-form";
		}
		mservice.saveMember(member);
		return "forward:/member/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteMember(@PathVariable("id") Integer id) {
		mservice.deleteMember(mservice.findMemberById(id));
		return "forward:/member/list";
	}

}
