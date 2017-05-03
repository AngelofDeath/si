/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jarek
 */
public class Node
{
    //TODO: add probability
    private Map <Node,Integer> neighbors;
    private List <Node> parents;
    private String syllable;
    private int sum;
    public Node(String syllable)
    {
        this.syllable = syllable;
        this.neighbors = new HashMap<Node,Integer>();
        this.parents = new ArrayList<Node>();
        this.sum = 0;
    }
    
    public void add(Node node)
    {
        for (Map.Entry<Node, Integer> entry : this.neighbors.entrySet()) 
        {
            Node key = entry.getKey();
            if(key.getSyllable().equals(node.getSyllable()))
            {
                entry.setValue(entry.getValue()+1);
                this.sum += 1;
                return;
            }
        }
        node.addParent(this);
        this.sum += 1;
        this.neighbors.put(node, new Integer(1));
    }
    
    public String getSyllable()
    {
        return this.syllable;
    }
    
    public void addParent(Node node)
    {
        for(Node parent: this.parents)
        {
            if(parent.getSyllable().equals(node.getSyllable()))
            {
                return;
            }
        }
        this.parents.add(node);
    }
}
