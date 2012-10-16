/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.TreeSearching.utils;

import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author Insane
 */
public class CityNode {
    private String cityname;
    private Vector<CityNode> cityLists;
    public CityNode parent;
    public boolean visited;
    
    public CityNode(String cityName){
        this.cityname=cityName;
        cityLists = new Vector<CityNode>();
        visited = false;
    }
    
    public CityNode(String cityName, String adjacentCities[]){
        this(cityName);
        for (String adjCity : adjacentCities) {
            addCity(adjCity);
        }
    }
    
    
    public String getCityName(){
        return this.cityname;
    }
    
    
    public Vector<CityNode> get_adjacent_cities(){
        return cityLists;
    }
    
    
    public void addCity(String cityName){    
        cityLists.add(new CityNode(cityName));
    }
    
    
    public void add_adjacent_cities(Vector<CityNode> cities){
        for(int i=0; i<cities.size(); i++){
            cityLists.add((CityNode)cities.get(i));
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(! (obj instanceof CityNode))
            return false;
        
        CityNode other_cityNode = (CityNode)obj;
        return other_cityNode.cityname.equals(this.cityname);
    }
}
