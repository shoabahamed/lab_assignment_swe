package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Delete a city from city list
     * @param city
     *      The city to delete
     */
    public void delete(City city){
        if(cities.contains(city)){
            cities.remove(city);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gives total number of cities
     * @return the total number of cities
     */
    public int Count(){
        return cities.size();
    }


    /**
     * Sort the cities
     * @param sortBy
     *      Takes city/province string
     * @return
     *      Given sortBy return cityList
     */
    public List<City> getCities(String sortBy) {
        List<City> cityList = cities;
        if(sortBy.equalsIgnoreCase("city")){
            Collections.sort(cityList);
        } else if (sortBy.equalsIgnoreCase("province")) {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City o1, City o2) {
                    return o1.getProvinceName().compareTo(o2.getCityName());
                }
            });
        }

        return cityList;
    }
}