package bashpound.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bashpound.marketplace.domain.model.Mbtemp;
import bashpound.marketplace.infra.mapper.TempMapper;

@Service
@Transactional
public class MbtempService implements TempMapper{
    @Autowired
    TempMapper mapper;

	@Override
	public Mbtemp selectById(Long id) {
		mapper.selectById(id);
		return null;
	}

	@Override
	public List<Mbtemp> selectAll() {
		mapper.selectAll();
		return null;
	}

	@Override
	public void insert(Mbtemp mbTemp) {
		mapper.insert(mbTemp);
		
	}
	
	

}
