package unit_testing.First_one.controllers.servives;
import java.util.List;
import unit_testing.First_one.controllers.AddResponse;
import unit_testing.First_one.controllers.beans.Country;
import unit_testing.First_one.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component

public class Country_service {
	@Autowired
	CountryRepository countryrep;
	
	
	

	 public List<Country> getAllCountries()
	 {
		
		 
		List<Country>countries=countryrep.findAll();
		return countries;
	 }
   
	 
	 public Country getCountrybyId(int id)
	 {
		 List<Country>countries=countryrep.findAll();
			Country country=null;
			for(Country con:countries)
			{
				if(con.getId()==id)
					country=con;
			}
			return country;
		
		
		
	 }
	 public Country getCountrybyName(String countryName)
	 {
		List<Country> countries=countryrep.findAll();
		Country country=null;
		for(Country con:countries)
		{
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		return country;
	 }
	 public Country addCountry(Country country)
	 {
		 country.setId(getMaxId());
		 countryrep.save(country);
		 return country;
	 }
	
	 
	 public Country updateCountry(Country country) 
	 {
		countryrep.save(country);
		return country;
	 }
	 public AddResponse  deleteCountry(int id) 
	 {
		countryrep.deleteById(id);
		AddResponse res=new AddResponse();
		res.setMsg("country deleted");
		res.setId(id);
		return res;
	 }
	 public int getMaxId()
	 {
		 return countryrep.findAll().size()+1;
	 }
}

