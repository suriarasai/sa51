package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Member;
import sg.edu.iss.club.repo.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository mrepo;

	@Transactional
	public boolean saveMember(Member member) {
		if(mrepo.save(member)!=null) return true; else return false;
	}

	@Transactional
	public ArrayList<Member> findAllMembers() {
		return (ArrayList<Member>) mrepo.findAll();
	}

	@Transactional
	public Member findMemberById(Integer id) {
		return mrepo.findById(id).get();
	}

	@Transactional
	public void deleteMember(Member member) {
		 mrepo.delete(member);
	}

	@Transactional
	public ArrayList<String> findAllMemberNames() {
		List<Member> members = mrepo.findAll();
		ArrayList<String> names = new ArrayList<String>();
		for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
			Member member = (Member) iterator.next();
			names.add(member.getFirstName());
		}
		return names;
	}
	
	@Transactional
	public Member findMemberByFirstName(String firstName) {
		return mrepo.findMemberByFirstName(firstName.trim()).get(0);
	}

}
