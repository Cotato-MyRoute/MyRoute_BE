package BE.MyRoute.member.repository;

import BE.MyRoute.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    public Member findByEmail(String email);
}
