package bashpound.marketplace.domain.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("city")
public class Mbtemp {
	private Long id;
    private String name;

	public Mbtemp() {
		
	}
	
	public Mbtemp(String name) {
	    this.name = name;
	}

}