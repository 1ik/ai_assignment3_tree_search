/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.TreeSearching.utils;

import java.util.Scanner;
import java.util.Vector;



/**
 *
 * @author Insane
 */
public class SearchTree {
    private CityNode root;
    private Vector<CityNode> adjacent_cities;
    private Vector<CityNode> added;
    
    public SearchTree(){
        root = null;
        adjacent_cities = new Vector<CityNode>();
        added = new Vector<CityNode>();
    }
    
    public CityNode getRoot(){
        return root;
    }
    
    
    
    public void make_serach_tree(CityNode city_node){
        if(!added.contains(city_node)){
            if(root==null)
                root=city_node;
            Vector<CityNode> adjcent_nodes = adjacent_nodes_of(city_node);
            this.adjacent_cities.addAll(adjcent_nodes);
            
            
            for(int i=0; i<adjcent_nodes.size(); i++){
                adjcent_nodes.get(i).parent = city_node;
            }
            
            city_node.add_adjacent_cities(adjcent_nodes);
            added.add(city_node);
        }
        
        if(adjacent_cities.size()!=0){
            make_serach_tree(adjacent_cities.remove(0));
        }
    }
        
    
    
    
    
    public Vector<CityNode> adjacent_nodes_of(CityNode cityNode){
        Vector<CityNode> adjacentNodes = new Vector<CityNode>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("number of adjacent cities for "+ cityNode.getCityName());
        int i = sc.nextInt();
        sc.nextLine();
        int j=1;
        while(j<=i){
            System.out.println("Enter the name of city "+j);
            String cityname = sc.nextLine();
            adjacentNodes.add(new CityNode(cityname));
            ++j;
        }
        return adjacentNodes;
    }
    
    
}
