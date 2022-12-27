package tacos;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	
	private long id;
	
	private Date createAt;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 character long")
	private String name;
	
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<String> ingredients;
	  
}


