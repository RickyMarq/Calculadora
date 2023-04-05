/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Util.threadCalc;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rick
 */
public class Server {
    
      public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socketClient = null;
        int porta = 54321;
        boolean continuar = true;


        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Sucesso" +  porta);
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
            return; 
        }
        
        while(continuar) {
            try {
                System.out.println("Aguardando o cliente...");
                socketClient = serverSocket.accept();
                System.out.println("Conectado com " + socketClient.getInetAddress().getHostAddress());

                threadCalc calc = new threadCalc(socketClient);
                calc.start();

            } catch (Exception e) {
                
            }
        }

      


        try {
            socketClient.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }    
}
