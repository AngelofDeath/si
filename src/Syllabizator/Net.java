/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Jarek
 */
public class Net
{
    private Map <String,Node> occuredSyllables;
    private int nWords = 0;
    
    public Net()
    {
        this.occuredSyllables = new HashMap<String,Node>();
    }
    
    public void add(String s,String pre)
    {
        Node n = this.occuredSyllables.get(s);
        if(n != null && pre != null)
        {
            this.occuredSyllables.get(pre).add(n);
        }
        else if(n == null && pre != null)
        {
            Node newNode = new Node(s);
            this.occuredSyllables.put(s, newNode);
            this.occuredSyllables.get(pre).add(newNode);
        }
        else if(n == null && pre == null)
        {
            Node newNode = new Node(s);
            newNode.incrementCounter();
            this.occuredSyllables.put(s, newNode);
            nWords++;
        }
        else if(n != null && pre == null)
        {
            n.incrementCounter();
            nWords++;
        }
    }
    
    public void setUnconditionalProbs(){
        double distribution = 0, tmp;
        for (Node sylNode : occuredSyllables.values()) {
            tmp = (double)sylNode.getNStartingNodes() / nWords;
            distribution += tmp;
            sylNode.setStartingNodeCDF(distribution);
        }
    }
    
    public void setConditionalProbs(){
        for (Node sylNode : occuredSyllables.values()){
               sylNode.setConditionalProbs();
        }   
    }
    
    public Node getFirstSyllable(){
        Random gen = new Random();
        double rand = gen.nextDouble();
        Node last = null;
        for (Node sylNode : occuredSyllables.values()){
            if (rand <= sylNode.getStartingNodeCDF())
                return sylNode;
            last = sylNode;
        }
        
        return last;
    }
}