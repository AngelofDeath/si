/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

/**
 *
 * @author Łukasz
 */
public class Syllabizator {
    static SylabizatorEN sylabizatorEN = new SylabizatorEN();
    static SylabizatorPL sylabizatorPL = new SylabizatorPL();

    public static String syllabize(String wyraz, String jezyk)
    {
        switch (jezyk) {
            case "PL":
                return sylabizatorPL.syllabizePL(wyraz);
            case "EN":
                return sylabizatorEN.syllabizeEN(wyraz);
            default:
                return "ERROR! Language not recognized!";
        }
    }
    

    
}
