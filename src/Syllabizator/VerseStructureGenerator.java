/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Tomek
 */
public class VerseStructureGenerator {
    private final int syllables;
    private ArrayList<int[]> distributions = new ArrayList<>();
    
    public VerseStructureGenerator(int syllables){
        this.syllables = syllables;
        generateDistributions();
    }
    
    private void generateDistributions(){
        int tmpDistribution[];
        for(int i = 2; i <= syllables / 2; i++){
            int maxComponents = syllables / i;
            for(int j=2; j<=maxComponents; j++){
                tmpDistribution = new int[j];
                int sum = 0;
                for(int k = 0; k < j; k++){
                    tmpDistribution[k] = i;
                    sum += i;
                }
                generateDistribution(tmpDistribution, j-1, sum);
            }
        }
    }
    
    private void generateDistribution(int tmpDistribution[], int index, int sum){
        if(sum == syllables)
            distributions.add(tmpDistribution);
        else{
            if(index == 0)
                return;
            while(sum != syllables && tmpDistribution[index] < 5){
                if(index < tmpDistribution.length - 1 && tmpDistribution[index] == tmpDistribution[index+1])
                    break;
                tmpDistribution[index]++;
                sum++;
                int newtmp[] = tmpDistribution.clone();
                generateDistribution(newtmp, index-1, sum);
            }
        }
    }
    
    public int[] getRandomDistribution(){
        Random gen = new Random();
        int index = gen.nextInt(distributions.size());
        int set[] = getRandomPermutation(index);
        return set;
    }
    
    private int[] getRandomPermutation(int index){
        int set[] = distributions.get(index).clone();
        int length = set.length;
        for(int i=0; i<100; i++){
            Random gen = new Random();
            int index1 = gen.nextInt(length);
            int index2 = gen.nextInt(length);
            int tmp = set[index1];
            set[index1] = set[index2];
            set[index2] = tmp;
        }
        return set;
    }
}
