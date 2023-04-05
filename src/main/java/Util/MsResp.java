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
public class MsResp implements Serializable {
    private status status;
    private double valor;

    public MsResp(Util.status status, double valor) {
        this.status = status;
        this.valor = valor;
    }

    public status getStatus() {
        return status;
    }

    public double getValor() {
        return valor;
    }

}
