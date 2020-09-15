package bashpound.marketplace.infra.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bashpound.marketplace.domain.model.Mbtemp;

@Mapper
public interface TempMapper {
    Mbtemp selectById(Long id);
    
    List<Mbtemp> selectAll();
    
    void insert(Mbtemp mbTemp);
}
