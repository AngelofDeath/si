/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import static Syllabizator.Syllabizator.syllabize;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jarek
 */
public class Main
{
    public static void main(String[] args)
    {
        Net net = new Net();
        String[] tmp;
        try {
            BufferedReader br = new BufferedReader(new FileReader("slowa.txt"));
            String word = br.readLine();
            while(word != null){
                tmp = syllabize(word, "PL").split("-");
                for (int i=0; i<tmp.length; i++){
                    if(i == 0)
                        net.add(tmp[0], null);
                    else
                        net.add(tmp[i], tmp[i-1]);
                }
                word = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        net.setUnconditionalProbs();
        net.setConditionalProbs();
        for(int i=0; i<100; i++){
            Node tmp2 = net.getFirstSyllable();
            System.out.print(tmp2.getSyllable());
            tmp2 = tmp2.nextNode();
            System.out.print(tmp2.getSyllable());
            tmp2 = tmp2.nextNode();
            System.out.print(tmp2.getSyllable());
            System.out.println();
        }
    }
}
