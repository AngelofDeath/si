/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;
/**
 *
 * @author Łukasz Gutowski
 * //TO DO
 * 
 * 
 */

public class SylabizatorPL {
    
     public boolean czySamogloska(String znak)
    {
    if ((znak=="a")||(znak=="ą")||(znak=="e")||(znak=="ę")||(znak=="o")||(znak=="ó")||(znak=="u")||(znak=="i")||(znak=="y")||(znak=="ie")||(znak=="iu")||(znak=="ia")||(znak=="ię")||(znak=="ią")||(znak=="io")) return true;
    else return false;
    }
    
    public int zwrocWartosc (String symbol)
    {
        switch (symbol)
         {
            case "a": return 0; 
            case "ą": return 1;
            case "b": return 2;
            case "c": return 3;
            case "ć": return 4;
            case "d": return 5;
            case "e": return 6;
            case "ę": return 7;
            case "f": return 8;
            case "g": return 9;
            case "h": return 10;
            case "i": return 11;    
            case "j": return 12;
            case "k": return 13;
            case "l": return 14;
            case "ł": return 15;
            case "m": return 16;
            case "n": return 17;
            case "ń": return 18;
            case "o": return 19;
            case "ó": return 20;
            case "p": return 21;
            case "q": return 22;    
            case "r": return 23;
            case "s": return 24;
            case "ś": return 25;
            case "t": return 26;
            case "u": return 27;
            case "v": return 28;
            case "w": return 29;
            case "x": return 30;
            case "y": return 31;
            case "z": return 32;
            case "ż": return 33;
            case "ź": return 34;
            case "ch": return 35;
            case "cz": return 36;
            case "dz": return 37;
            case "dź": return 38;
            case "dż": return 39;
            case "rz": return 40;
            case "sz": return 41;
            case "ie": return 42;
            case "ia": return 43;
            case "iu": return 44;
            case "io": return 45;
            case "ię": return 47;
            case "ią": return 46;
            case "trw": return 48;
            case "tr": return 49;
                //case "str": return 47;    
            default: return 100;          
         }
    }
    
    public String zwrocSymbol (int wartosc)
    {
        switch (wartosc)
         {
            case 0: return "a"; 
            case 1: return "ą";
            case 2: return "b";
            case 3: return "c";
            case 4: return "ć";
            case 5: return "d";
            case 6: return "e";
            case 7: return "ę";
            case 8: return "f";
            case 9: return "g";
            case 10: return "h";
            case 11: return "i";    
            case 12: return "j";
            case 13: return "k";
            case 14: return "l";
            case 15: return "ł";
            case 16: return "m";
            case 17: return "n";
            case 18: return "ń";
            case 19: return "o";
            case 20: return "ó";
            case 21: return "p";
            case 22: return "q";    
            case 23: return "r";
            case 24: return "s";
            case 25: return "ś";
            case 26: return "t";
            case 27: return "u";
            case 28: return "v";
            case 29: return "w";
            case 30: return "x";
            case 31: return "y";
            case 32: return "z";
            case 33: return "ż";
            case 34: return "ź";
            case 35: return "ch";
            case 36: return "cz";
            case 37: return "dz";
            case 38: return "dź";
            case 39: return "dż";
            case 40: return "rz";
            case 41: return "sz";
            case 42: return "ie";
            case 43: return "ia";
            case 44: return "iu";
            case 45: return "io";
            case 47: return "ię";
            case 46: return "ią";
            case 48: return "trw";
            case 49: return "tr";
                
            //case 47: return "str";    
            default: return "BLAD!";          
         }
    }
    
    public String syllabizePL(String wyraz)
    {
        String output ="";
        String[] sylaba = new String[15]; 
        {
        
      
            int k=0;
            int j=0;
            wyraz=wyraz.trim();
            wyraz=wyraz.toLowerCase();
            for (int s=60;s>-1;s--){
                for (int d=0; d<wyraz.length()-zwrocSymbol(s).length(); d++){
                    wyraz = wyraz.replace(zwrocSymbol(s),Integer.toString(s)+"-");
                }
            }
            wyraz=wyraz.replace("﻿", "");
            String[] temp = wyraz.split("\\-");
            Integer[] symbol = new Integer[temp.length];
            
            for(int o=0;o<temp.length;o++)
                {
                symbol[o] = Integer.parseInt(temp[o]);
                }
            
            j=0;
            
           while (j<symbol.length)
                {
                if (czySamogloska(zwrocSymbol(symbol[j]))==true) 
                    {
                    sylaba[k]=zwrocSymbol(symbol[j]);  
                    j++;                               
                    if (j<symbol.length)
                        {
                        if (czySamogloska(zwrocSymbol(symbol[j]))==true) // pierwsza samogloska - druga samogloska
                            {
                            k++;                       
                            }
                        else                                              // pierwsza samogloska - druga spolgloska  
                            {
                            j++;
                            if (j<symbol.length)
                                {
                                if (czySamogloska(zwrocSymbol(symbol[j]))==true)   // pierwsza samogloska - druga spolgloska - trzecia samogloska
                                    {
                                    k++;
                                    j--;
                                    }
                                 else                                               // pierwsza samogloska - druga spolgloska - trzecia spolgloska
                                    {
                                    sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]);  
                                    k++; 
                                    }
                                } else sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]);
                           
                            }
                        } 
                    }
                else
                    {
                    sylaba[k]=zwrocSymbol(symbol[j]);  
                    j++;
                    if (j<symbol.length)
                        {
                        if (czySamogloska(zwrocSymbol(symbol[j]))==true) // pierwsza spolgloska - druga samogloska
                            {   
                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                            j++;
                            if (j<symbol.length)
                                {
                                if (czySamogloska(zwrocSymbol(symbol[j]))==true)  // pierwsza spolgloska - druga samogloska - trzecia samogloska
                                    {
                                    k++;
                                    }
                                else                                             // pierwsza spolgloska - druga samogloska - trzecia spolgloska
                                    {
                                    j++;
                                    
                                    if (j<symbol.length)
                                        {
                                        if (czySamogloska(zwrocSymbol(symbol[j]))==true)  // pierwsza spolgloska - druga samogloska - trzecia spolgloska - czwarta samogloska
                                            {
                                            k++; 
                                            j--;
                                            
                                            }
                                        else 
                                            {
                                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]); //pierwsza spolgloska - druga samogloska - trzecia spolgloska - czwarta spolgloska
                                            k++;
                                            }
                                        }
                                        else{sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]);}
                                    
                                    }
                                }
                        }
                    else                 // pierwsza spolgloska - druga spolgloska                             
                        {
                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);  
                            j++;
                            if (j<symbol.length)
                                {
                                if (czySamogloska(zwrocSymbol(symbol[j]))==true) // pierwsza spolgloska - druga spolgloska - trzecia samogloska
                                    {
                                    sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                    j++;
                                    //k++;
                                      if (j<symbol.length)
                                         {
                                         if (czySamogloska(zwrocSymbol(symbol[j]))==true)  // pierwsza spolgloska - druga spolgloska - trzecia samogloska - czwarta samogloska - bardzo rzadko
                                            {k++;}          
                                         else 
                                         {
                                         sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);    //pierwsza spolgloska - druga spolgloska - trzecia samogloska - czwarta spolgloska
                                         j++; 
                                         k++;
                                         }                                              
                                         }  
                                    }
                                else                                             // pierwsza spolgloska - druga spolgloska - trzecia spolgloska
                                    {
                                    sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                    j++;
                                    if (j<symbol.length)
                                        {
                                        if (czySamogloska(zwrocSymbol(symbol[j]))==true) // pierwsza spolgloska - druga spolgloska - trzecia spolgloska - czwarta samogloska
                                            {
                                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                            j++;
                                            //k++;
                                                if (j<symbol.length)
                                                {
                                                    if (czySamogloska(zwrocSymbol(symbol[j]))==true) // pierwsza spolgloska - druga spolgloska - trzecia spolgloska - czwarta samogloska - piata samogloska // raczej nie zajdzie
                                                    {k++;} 
                                                    else
                                                    {

                                                      sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                                      //System.out.println(sylaba[k]);
                                                      j++;
                                                      k++;  
                                                    }
                                                
                                                }
                                                else {}
                                            }
                                        else {} // // pierwsza spolgloska - druga spolgloska - trzecia spolgloska - czwarta spolgloska raczej nie wystepuje
                                        }
                                    }
                                }
                        }
                  
                    }
                }
            }
           
            for (int l=0; l<k+1; l++) 
            {
                if (sylaba[l]!=null) output = output + sylaba[l];
                if (l!=k) output = output + "-";
            }
            for (int l=0; l<k+1; l++) sylaba[l]=null;
            
        
      }
 
    return output;
    }
    
}
