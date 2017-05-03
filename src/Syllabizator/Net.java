/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jarek
 */
public class Net
{
    private Map <String,Node> occuredSyllables;
    
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
            this.occuredSyllables.put(s, newNode);
        }
        else
        {
            //TODO: add counter incremet?
        }
    }
}
