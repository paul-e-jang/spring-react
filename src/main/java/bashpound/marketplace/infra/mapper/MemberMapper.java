package bashpound.marketplace.infra.mapper;



import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Member;

public interface MemberMapper {
	
	public bashpound.marketplace.domain.model.mybatis.Member selectByUsername(@Param("username")String username);

}
