/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.io.Serializable;

/**
 *
 * @author rick
 */
public class MsReq implements Serializable {
    private char oper;
    private double value1;
    private double value2;
    
    public MsReq(char oper, double value1, double value2) {
        this.oper = oper;
        this.value1 = value1;
        this.value2 = value2;
    }

    public char getOper() {
        return oper;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }
}
