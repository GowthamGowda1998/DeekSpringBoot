package unit_testing.First_one;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import unit_testing.First_one.controllers.beans.Country;
import unit_testing.First_one.controllers.servives.Country_service;
import unit_testing.First_one.repositories.CountryRepository;
import static org.junit.Assert.assertArrayEquals;


@SpringBootTest(classes= {Service_mockito_Test.class})



public class Service_mockito_Test {
	
	
	@Mock
	CountryRepository countryrep;
	
	@InjectMocks
	Country_service countryservice;
	
	public List<Country>mycountries;
	@Test
	@Order(1)
	public void  test_getAllcountries()
	{
		
		List<Country>mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"India","Delhi"));
		mycountries.add(new Country(2,"USA","Washington"));
		when(countryrep.findAll()).thenReturn(mycountries);
		countryservice.getAllCountries().size();
		assertEquals(2,countryservice.getAllCountries().size());
		
	}
	@Test
	@Order(2)
 public void test_getCountryById()
 
 {
	 List<Country>mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"India","Delhi"));
		mycountries.add(new Country(2,"USA","Washington"));
		int countryId=1;
		when(countryrep.findAll()).thenReturn(mycountries); 
		countryservice.getCountrybyId(countryId);
		 assertEquals(countryId,countryservice.getCountrybyId(countryId).getId());
 }
	
	@Test
	@Order(3)
 public void test_getCountryByName()
 
 {
	 List<Country>mycountries=new ArrayList<Country>();
		mycountries.add(new Country(1,"India","Delhi"));
		mycountries.add(new Country(2,"USA","Washington"));
	String countryname="India";
		when(countryrep.findAll()).thenReturn(mycountries); 
		countryservice.getCountrybyName(countryname);
		 assertEquals(countryname,countryservice.getCountrybyName(countryname).getCountryName());
 }
	
	@Test
	@Order(4)
	public void test_addCountry()
	{
		Country country =new Country(3,"Germany","Berlin");
		when(countryrep.save(country)).thenReturn(country);
		assertEquals(country,countryservice.addCountry(country));
	}
	
	
	@Test
	@Order(5)
	public void test_updateCountry()
	{
		Country country =new Country(3,"Germany","Berlin");
		when(countryrep.save(country)).thenReturn(country);
		assertEquals(country,countryservice.updateCountry(country));
	}
	
	@Test
	@Order(6)
	public void test_deletecountry()
	{
		Country country =new Country(3,"Germany","Berlin");
		countryservice.deleteCountry(country);
	}
}














