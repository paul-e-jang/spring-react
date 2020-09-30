package bashpound.marketplace.infra.mapper;


import org.springframework.data.jpa.repository.JpaRepository;

import bashpound.marketplace.domain.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Member findByUsername(String username);

}
