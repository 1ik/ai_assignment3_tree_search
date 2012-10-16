/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project.TreeSearching.Search;

import java.util.LinkedList;
import java.util.Scanner;
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
        SearchTree tree = new SearchTree();
        tree.make_serach_tree(new CityNode("D"));
        CityNode root = tree.getRoot();
        while(true){
            System.out.println("Enter Destination : ");
            String dest = new Scanner(System.in).nextLine();
//            int limit = new Scanner(System.in).nextInt();
//            CityNode solution = DFS_search(dest, root);
//            CityNode solution = DFS_Limited_Search(root, dest, limit, 0);
//            CityNode solution = BFS_search(dest, root);
            CityNode solution = ID_DFS(root, dest, 5);
            if(solution==null){
                System.out.println("no solution found");
            }else{
                System.out.println("solution : ");
                printSolution(solution);
                System.out.println();
                System.out.println("==================");
            }
        }
    }
    
    
    public static void printSolution(CityNode solution){
        if(solution.parent!=null){
            printSolution(solution.parent);
            System.out.print(" -> "); 
        }
        System.out.print(solution.getCityName());
    }
    
    
    
    public static CityNode BFS_search(String destination , CityNode root){
        Vector<CityNode> queue = new Vector<CityNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            CityNode node = queue.remove(0);
            if(node.getCityName().equals(destination)){
                return node;
            }
            queue.addAll(node.get_adjacent_cities());
        }
        return null;
    }
    
    
    
    public static CityNode uniform_cost_search(CityNode root, String dest){
        return null;
    }
    
    
    
    
    
    public static CityNode DFS_search(String destination , CityNode root){
        Vector<CityNode> stack;
        stack = new Vector<CityNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            CityNode node = stack.remove(stack.size()-1);
            if(node.getCityName().equals(destination)){
                return node;
            }
            stack.addAll(node.get_adjacent_cities());
        }
        return null;
    }
    
    
    
    public static CityNode DFS_Limited_Search(CityNode source, String dest, int limit, int depth){
//        System.out.println("checking for  : " + source.getCityName());
        if(depth>limit)
            return null;
        if(source==null)
            return null;
        
        if(source.getCityName().equals(dest))
            return source;

        Vector<CityNode> children = source.get_adjacent_cities();
        for(int i=0; i<children.size(); i++){
            CityNode sol = DFS_Limited_Search(children.get(i), dest, limit, depth+1);
            if(sol!=null){
                return sol;
            }
        }
        return null;
    }
    
    
    
    public static CityNode ID_DFS(CityNode source, String dest,int depth){
        CityNode solution = null;
        int limit = 0;
        while(solution == null && limit<=depth){
            solution = DFS_Limited_Search(source, dest, limit, 0);
            limit+=1;
        }
        return solution;
    }
        
}



