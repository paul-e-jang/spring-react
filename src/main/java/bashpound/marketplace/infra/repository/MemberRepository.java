package bashpound.marketplace.infra.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bashpound.marketplace.domain.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Optional<Member> findByUsername(String username);

}
