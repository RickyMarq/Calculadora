/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Util.MsReq;
import Util.MsResp;


/**
 *
 * @author rick
 */
public class threadCalc extends Thread {
    private Socket client;
    ObjectInputStream in;
    ObjectOutputStream out;
    MsResp response;

    public threadCalc(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() { 
        try {
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());

            // Obtendo o objeto

            MsReq request = (MsReq) in.readObject(); // casting


            System.out.println("Recebido com sucesso " + request.getOper() + " " + request.getValue1() + " " + request.getValue2());
            char oper = request.getOper();
            double value1 = request.getValue1();
            double value2 = request.getValue2();
            double resp;


            switch (oper) {
                case '+':
                    resp = value1 + value2;
                    response = new MsResp(status.Sucesso, resp);
                    break;
                case '-':
                    resp = value1 - value2;
                    response = new MsResp(status.Sucesso, resp);
                    break;
                case '*':
                    resp = value1 * value2;
                    response = new MsResp(status.Sucesso, resp);
                    break;
                case '/':
                    if(request.getValue2() == 0) {
                        response = new MsResp(status.DivisaoZero, 0);
                    } else {
                        resp = value1 / value2;
                        response = new MsResp(status.Sucesso, resp);
                    }
                    break;
            
                default:
                    response = new MsResp(status.OperadorInvalido, 0);
                    break;
            }

            out.writeObject(response);
            
        } catch (Exception e) {
            System.out.println("Erro na Thread " + e.getMessage());
        }
    }
}
