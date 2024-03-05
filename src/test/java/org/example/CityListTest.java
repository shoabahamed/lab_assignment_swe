package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    @Test
    void delete() {
        City city1 = new City("dhaka", "dhaka");
        City city2 = new City("comilla", "cittagong");
        CityList cityList = new CityList();

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertEquals(1, cityList.Count());

        cityList.delete(city2);
        assertEquals(0, cityList.Count());
    }

    @Test
    void deleteException() {
        City city1 = new City("dhaka", "dhaka");
        City city2 = new City("comilla", "cittagong");
        CityList cityList = new CityList();

        cityList.add(city1);


        assertThrows(IllegalArgumentException.class, ()->cityList.delete(city2));
    }




    @Test
    void count() {
        City city1 = new City("dhaka", "dhaka");
        City city2 = new City("coxbazar", "cittagong");
        CityList cityList = new CityList();

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2, cityList.Count());
    }

    @Test
    void getCities() {
        City city1 = new City("dhaka", "dhaka");
        City city2 = new City("khagrachori", "cittagong");
        CityList cityList = new CityList();
        cityList.add(city1);
        cityList.add(city2);

        List<City> sortByCity = cityList.getCities("city");

        assertEquals("dhaka", sortByCity.get(0).getCityName());


        List<City> sortByProvince= cityList.getCities("province");
        assertEquals("khagrachori", sortByCity.get(0).getCityName());
    }
}