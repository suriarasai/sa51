package sg.edu.iss.club.service;

import java.util.ArrayList;

import sg.edu.iss.club.domain.Member;

public interface MemberService {
	 public boolean saveMember(Member member);
	 public ArrayList<Member> findAllMembers();
	 public Member findMemberById(Integer id);
	 public void deleteMember(Member member);
	 public ArrayList<String> findAllMemberNames();
	 public Member findMemberByFirstName(String firstName);
}
