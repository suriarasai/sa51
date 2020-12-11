package sg.edu.iss.club.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.club.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	 @Query("Select m from Member m where m.firstName LIKE :name")
	 List<Member> findMemberByFirstName(@Param("name") String name);

}
