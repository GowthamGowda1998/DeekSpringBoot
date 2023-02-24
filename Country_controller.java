package unit_testing.First_one.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unit_testing.First_one.controllers.beans.Country;
import unit_testing.First_one.controllers.servives.Country_service;

@RestController


public class Country_controller {
	@Autowired
	Country_service countryservice;
	
	@GetMapping("/getcountries")
	public ResponseEntity<List<Country>> getCountries(){
	
	try{
		List<Country> countries=countryservice.getAllCountries();
		return new ResponseEntity<List<Country>>(countries,HttpStatus.FOUND);
	}
	
		catch(Exception e)
	{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	}
		
	
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountrybyId(@PathVariable(value="id" )int id)
	{
		try 
		{
		Country country= countryservice.getCountrybyId(id);
		return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountrybyName(@RequestParam(value="name" )String  countryName)
	{
		try 
		{
		Country country= countryservice.getCountrybyName(countryName);
		return new ResponseEntity<>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}
	@PostMapping("/Addcountry")
	public Country addCountry(@RequestBody Country country )
	{
		return countryservice.addCountry(country);
	}
	
	
	
	@PutMapping("/UpdateCountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id")int id,@RequestBody Country country )
	{
		try {
		Country existCountry =countryservice.getCountrybyId(id);
		existCountry.setCountryName(country.getCountryName());
		existCountry.setCountryCapital(country.getCountryCapital());
		Country update_country=countryservice.updateCountry(existCountry);
		return new ResponseEntity<Country>(update_country,HttpStatus.NOT_FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/deleteCountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id")int id)
	{
		return countryservice.deleteCountry(id);
	}
}
