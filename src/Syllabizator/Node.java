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
import java.util.Random;

/**
 *
 * @author Jarek
 */
public class Node
{
    private Map <List<Node>,Double> neighbors;
    private List <Node> parents;
    private String syllable;
    private int sum, nStartingNodes;
    private double startingNodeCDF; //unconditional probability
    public Node(String syllable)
    {
        this.syllable = syllable;
        this.neighbors = new HashMap<List<Node>,Double>();
        this.parents = new ArrayList<Node>();
        this.sum = 0;
        this.nStartingNodes = 0; 
    }
    
    public void add(Node node, Node pre)
    {
        for (Map.Entry<List<Node>, Double> entry : this.neighbors.entrySet()) 
        {
            List<Node> key = entry.getKey();
            if(pre == null)
            {
                if(key.get(1).getSyllable().equals(node.getSyllable()))
                {
                    entry.setValue(entry.getValue()+1);
                    this.sum += 1;
                    return;
                }
            }
            else
            {
                if(key.get(0) != null)
                    if(key.get(0).getSyllable().equals(pre.getSyllable()) && key.get(1).getSyllable().equals(node.getSyllable()))
                    {
                        entry.setValue(entry.getValue()+1);
                        this.sum += 1;
                        return;
                    }
            }
        }
        node.addParent(this);
        this.sum += 1;
        ArrayList<Node> arr =  new ArrayList<Node>();
        arr.add(0, pre);
        arr.add(1, node);
        this.neighbors.put(arr, 1.0);
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
    
    public void incrementCounter(){
        this.nStartingNodes++;
    }
    
    public double getStartingNodeCDF(){
        return startingNodeCDF;
    }
    
    public void setStartingNodeCDF(double prob){
        startingNodeCDF = prob;
    }
    
    public int getNStartingNodes(){
        return nStartingNodes;
    }
    
    public void setConditionalProbs(){ // changes value in neighbours map from neighbour counter to cdf value
        double distribution = 0, tmp;
        for (Map.Entry<List<Node>, Double> entry : this.neighbors.entrySet()) {
            tmp = entry.getValue() / sum;
            distribution += tmp;
            entry.setValue(distribution);
        }
    }
    
    public Node nextNode(){ // can only be run after setConditionalProbs!
        Random gen = new Random();
        double rand = gen.nextDouble();
        Node last = null;
        for (Map.Entry<List<Node>, Double> entry : this.neighbors.entrySet()) {
            if(rand <= entry.getValue())
                return entry.getKey().get(1);
            last = entry.getKey().get(1);
        }
        if(last == null)
            last = new Node("nie");
        return last;
    }
}
