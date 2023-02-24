package unit_testing.First_one.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import unit_testing.First_one.controllers.beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> 

{
	
}
