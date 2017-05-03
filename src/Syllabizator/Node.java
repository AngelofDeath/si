/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jarek
 */
public class Node
{
    //TODO: add probability
    private List <Node> neighbors;
    private String syllable;
    
    public Node(String syllable)
    {
        this.syllable = syllable;
        this.neighbors = new ArrayList<Node>();
    }
    
    public void add(Node node)
    {
        for(int i=0;i<this.neighbors.size();i++)
        {
            if(this.neighbors.get(i).getSyllable().equals(node.getSyllable()))
            {
                //add new link/increment counter?
                return;
            }
        }
        this.neighbors.add(node);
    }
    
    public String getSyllable()
    {
        return this.syllable;
    }
}
