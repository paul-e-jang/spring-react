package bashpound.marketplace.infra.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bashpound.marketplace.domain.model.Mbtemp;

@Mapper
public interface TempMapper {
    Mbtemp selectCityById(Long id);
    
    List<Mbtemp> selectAllCity();
    
    void insertCity(Mbtemp mbTemp);
}
