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
	Mbtemp mbTemp;

	@Override
	public Mbtemp selectCityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mbtemp> selectAllCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCity(Mbtemp mbTemp) {
		// TODO Auto-generated method stub
		
	}
	
	

}
