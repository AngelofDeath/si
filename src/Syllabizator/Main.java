/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syllabizator;

import static Syllabizator.Syllabizator.syllabize;

/**
 *
 * @author Jarek
 */
public class Main
{
    public static void main(String[] args)
    {
        Net net = new Net();
        String[] tmp = syllabize("jarosław","PL").split("-");
        net.add(tmp[0], null);
        net.add(tmp[1], tmp[0]);
        net.add(tmp[1], tmp[0]);
        net.add(tmp[1], tmp[0]);
        net.add(tmp[1], tmp[0]);
        net.add(tmp[2], tmp[0]);
        net.add(tmp[2], tmp[0]);
        net.add(tmp[2], tmp[0]);
        net.add(tmp[2], tmp[1]);
        return;
    }
}
