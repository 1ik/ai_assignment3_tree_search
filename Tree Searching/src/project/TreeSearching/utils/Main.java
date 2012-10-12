/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.TreeSearching.utils;

import java.util.Vector;
import project.TreeSearching.utils.CityNode;

/**
 *
 * @author Insane
 */
public class Main {
    public static void main(String ars[]){
        SearchTree tree = new SearchTree();
        tree.make_serach_tree(new CityNode("D"));
        
        CityNode root = tree.getRoot();
        Vector<CityNode> cities = new Vector<CityNode>();
        
        cities.add(root);
        while(!cities.isEmpty()){
            CityNode city = cities.remove(0);
            Vector adjcent_cities = city.get_adjacent_cities();
            System.out.print(city.getCityName()+" : [ ");
            for(int i=0; i<adjcent_cities.size(); i++){
                
                System.out.print(((CityNode)adjcent_cities.get(i)).getCityName()+" ");
            }
            System.out.println("]");
            cities.addAll(adjcent_cities);
        }   
    }
}
