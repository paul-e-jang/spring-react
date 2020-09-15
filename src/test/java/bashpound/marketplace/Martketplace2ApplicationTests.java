package bashpound.marketplace;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import bashpound.marketplace.domain.model.Mbtemp;
import bashpound.marketplace.services.MbtempService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class Martketplace2ApplicationTests {

	@Autowired
	MbtempService service;

    @Test
    public void getCityById() {
    	Mbtemp mbTemp = service.selectById(1L);
    }

    @Test
    public void getAllCity() {
        List<Mbtemp> Mbtemps = service.selectAll();
    }

}
