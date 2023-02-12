package tacos;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="taco.orders")
public class OrderProps {
	
	private int pageSize = 20;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
