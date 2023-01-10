package com.github.marcospmelo.citiesapi.countries.repository;

import com.github.marcospmelo.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
