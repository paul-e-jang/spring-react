package bashpound.marketplace.infra.repository;

import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Member;

public interface MemberMapper {
	public Member selectByUsername(@Param("username")String username);
	
	public String getNow();
	
	public int insert();
}
