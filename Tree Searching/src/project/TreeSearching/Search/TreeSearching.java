/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.TreeSearching.Search;

import java.util.LinkedList;
import java.util.Vector;
import project.TreeSearching.utils.CityNode;
import project.TreeSearching.utils.SearchTree;

/**
 *
 * @author Insane
 */
public class TreeSearching {

    static Vector<CityNode> bfsqueue;
    public static void main(String args[]){
        bfsqueue = new Vector<CityNode> ();
        SearchTree tree = new SearchTree();
        tree.make_serach_tree(new CityNode("D"));
        bfsqueue.add(tree.getRoot());
        
        CityNode solution = BFS_search("L");
        while(solution.parent!=null){
            System.out.println(solution.parent.getCityName());
            solution = solution.parent;
        }

    }
    
    
    
    public static CityNode BFS_search(String destination){
        if(bfsqueue.size()==0)
            return null;
        CityNode node = bfsqueue.remove(0);
        if(node.getCityName().equals(destination)){
            return node;
        }
        bfsqueue.addAll(node.get_adjacent_cities());
        return BFS_search(destination);
    }
    
    
}



