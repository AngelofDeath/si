/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

/**
 *
 *
 * 
 */
public class SylabizatorEN {
    
    public boolean czySamogloska(String znak)
    {
    if ((znak=="a")||(znak=="ai")||(znak=="e")||(znak=="oo")||(znak=="ę")||(znak=="o")||(znak=="ó")||(znak=="u")||(znak=="i")||(znak=="oy")||(znak=="eu")||(znak=="uy")|| (znak=="ey")|| (znak=="y")||(znak=="ack")||(znak=="eo")||(znak=="au")||(znak=="ie")||(znak=="iu")||(znak=="ia")||(znak=="ou")||(znak=="you")||(znak=="uo")||(znak=="tion")||(znak=="sion")||znak=="ing") return true;
    else return false;
    }
    
    public int zwrocWartosc (String symbol)
    {
        switch (symbol)
         {
            case "a": return 0; 
            case " ": return 1;
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
            case "inch": return 35;
            case "sh": return 36;
            case "th": return 37;
            case "eo": return 38;
            case "ie": return 39;
            case "ia": return 40;
            case "iu": return 41;
            case "io": return 42;
            case "ou": return 43;
            case "uo": return 44;
            case "gh": return 45;
            case "ct": return 46; 
            case "oy": return 47;
            case "uy": return 48;
            case "ey": return 49;
            case "ph": return 50;    
            case "ck": return 51;
            case "nn": return 52; 
            case "ss": return 53; 
            case "ll": return 54;
            case "sion": return 55; 
            case "tion": return 56;
            case "ing": return 57; 
            case "au" : return 58; 
            case "ai" : return 59;
            case "ea": return 60;    
            case "ee": return 61;    
            case "you": return 62;    
            case "eu": return 63;
            case "ch": return 64;
            case "oo": return 65;
            case "wav": return 66; 
            case "scr": return 67;  
            case "oa": return 68;
                 //case "str": return 47;    
            default: return 100;          
         }
    }
    
    public String zwrocSymbol (int wartosc)
    {
        switch (wartosc)
         {
            case 0: return "a"; 
            case 1: return " ";
            case 2: return "b";
            case 3: return "ck";
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
            case 35: return "inch";    
            case 36: return "sh";
            case 37: return "th";
            case 38: return "eo";
            case 39: return "ie";
            case 40: return "ia";
            case 41: return "iu";
            case 42: return "io";
            case 43: return "ou";
            case 44: return "uo";
            case 45: return "gh";
            case 46: return "ct";
            case 47: return "oy"; 
            case 48: return "uy";
            case 49: return "ey";
            case 50: return "ph";
            case 51: return "ck"; 
            case 52: return "nn"; 
            case 53: return "ss"; 
            case 54: return "ll"; 
            case 55: return "sion";     
            case 56: return "tion"; 
            case 57: return "ing"; 
            case 58: return "au"; 
            case 59: return "ai";    
            case 60: return "ea";    
            case 61: return "ee";
            case 62: return "you";
            case 63: return "eu";
            case 64: return "ch";
            case 65: return "oo";
            case 66: return "wav";
            case 67: return "scr";
            case 68: return "oa";  
            default: return "BLAD!";          
                    
                
         }
    }
    
    public String syllabizeEN(String wyraz)
    {
        String output ="";
        String AdditionalSign = "";
        if (wyraz.length()>=3){
        if  ((wyraz.endsWith("e")==true)) 
        {
            System.out.println(""+czySamogloska(wyraz.toCharArray()[wyraz.length()-2]+"".toString())+"");
            System.out.println(""+ wyraz.toCharArray()[wyraz.length()-2]);
            wyraz=wyraz.substring(0,wyraz.length()-1);
            AdditionalSign = "e";
        }
    }
        {
        String[] sylaba = new String[15]; 
        
      
            int k=0;
            int j=0;
            wyraz=wyraz.trim();
            wyraz=wyraz.toLowerCase();
            for (int s=69;s>-1;s--)
                {
                for (int d=0; d<wyraz.length()-zwrocSymbol(s).length(); d++)
                    {
                     if (wyraz.startsWith(zwrocSymbol(s), d)==true) 
                     wyraz.replace(zwrocSymbol(s),"-"+Integer.toString(s)+"-");
                     wyraz = wyraz.replace(zwrocSymbol(s),Integer.toString(s)+"-");
                    }
                }
            wyraz=wyraz.replace("﻿", "");
            System.out.println(wyraz);
            String[] temp = wyraz.split("\\-");
            Integer[] symbol = new Integer[temp.length];
            
            for(int o=0;o<temp.length;o++)
                {
                symbol[o] = Integer.parseInt(temp[o]);
                System.out.println(czySamogloska(zwrocSymbol(symbol[o])));
                }
            
            j=0;
            
            while (j<symbol.length)
                {
                System.out.println(Integer.toString(j));
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
                                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]); //- czy "przyklejamy" samogloske do poprzedniej sylaby (angielski) czy do nastepnej (polski) 
                                            k++; 
                                            //j--;
                                            
                                            }
                                        else 
                                            {
                                            sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]); //pierwsza spolgloska - druga samogloska - trzecia spolgloska - czwarta spolgloska
                                            //if (j+1<symbol.length) sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                            j++;
                                            if (j<symbol.length) 
                                                {
                                                if (czySamogloska(zwrocSymbol(symbol[j]))==true) j--;
                                                else j--;
                                                }
                                            else { sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j-1]);};
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
                                                else sylaba[k]=sylaba[k]+zwrocSymbol(symbol[j]);
                                            }
                                        else
                                        {} // // pierwsza spolgloska - druga spolgloska - trzecia spolgloska - czwarta spolgloska raczej nie wystepuje
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
               // else if ((AdditionalSign!="")&&(output.toCharArray()[output.length()-2]=='-')) output=output.substring(0,output.length()-1)+AdditionalSign;
            }
            if (output.toCharArray()[output.length()-1]=='-') output=output.substring(0,output.length()-1);
            output=output+AdditionalSign;
 
            
            //output.append("\n");
            for (int l=0; l<k+1; l++) sylaba[l]=null;
            
        
      }
 
    return output;
    }
    
}
