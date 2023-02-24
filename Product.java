package unit_testing.First_one;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.domain.EntityScan;

//public class Product {
	@EntityScan
	public class Product {
	  
	  private Long id;
	  private String name;
	  private String description;
	  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	private BigDecimal price;
	  
	}


