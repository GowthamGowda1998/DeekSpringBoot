package unit_testing.First_one;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import unit_testing.First_one.controllers.Country_controller;
import unit_testing.First_one.controllers.beans.Country;
import unit_testing.First_one.controllers.servives.Country_service;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {ControllerMocito.class})
public class ControllerMocito {
	
	@Mock
	Country_service countryservice;
	
	@InjectMocks
	Country_controller countryController;
	
	List<Country>mycountries;
	Country country;
	
	@Test
	@Order(1)
	
	public void test_getAllCountries()
	{
		
		mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1, "India","Delhi"));
		mycountries.add(new Country(1, "USA","Washington"));
		
		when(countryservice.getAllCountries()).thenReturn(mycountries);
		ResponseEntity<List<Country>> res=countryController.getCountries();
		asssertEquals(HttpStatus.FOUND,res.getStatusCode());
		assertEquals(2,countryservice.getAllCountries().size());
	}
	@Test
	@Order(2)
	
	public void test_getCountrybyId()
	{
		
		country=new Country(2,"USA","WashingTon");
		int countryID=2;
		when(countryservice.getCountrybyId(countryID)).thenReturn(country);
		ResponseEntity<Country>res=countryController.getCountrybyId(countryID);
		asssertEquals(HttpStatus.FOUND,res.getStatusCode());
		asssertEquals(countryID,res.getBody().getId());
			
	}
	
	@Test
	@Order(3)
	
	public void test_getCountrybyName()
	{
		country=new Country(2,"USA","WashingTon");
		String countryName="USA";
		when(countryservice.getCountrybyName(countryName)).thenReturn(countryName);
		ResponseEntity<Country> res=countryController.getCountrybyName(countryName);
		asssertEquals(HttpStatus.FOUND,res.getStatusCode());
		asssertEquals(countryName,res.getBody().getCountryName());
	}
	
	
}
	

