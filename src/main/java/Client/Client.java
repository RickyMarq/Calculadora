/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Util.MsReq;
import Util.MsResp;
import Util.status;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rick
 */
public class Client  {
    
     public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Socket socket;
        int porta = 54321;
        String ip = "127.0.0.1";
        ObjectOutputStream out;
        ObjectInputStream in;
        double value1, value2; 
        char oper;



        

        try {
            // o cliente está pedindo conexão com o servidor que está no IP e Porta informados
            socket = new Socket(ip, porta);
            System.out.println("Conectado com o servidor.");
            Home tela = new Home();
            tela.setVisible(true);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

 
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

 //           System.out.println("Digite a operação (+, -, /, *): ");
 //           oper = entrada.nextLine().charAt(0); // pega apenas o primeiro caracter
 //           System.out.println("Digite o primeiro valor:");
 //           value1 = Double.parseDouble(entrada.nextLine());
 //           System.out.println("Digite o segundo valor:");
 //           value2 = Double.parseDouble(entrada.nextLine());

//            MsReq request = new MsReq(oper, value1, value2);

 //           out.writeObject(request);

  //          MsResp response = (MsResp) in.readObject();

  //          if(response.getStatus() == status.Sucesso) {
  ///              System.out.println("Resposta: " + response.getValor());
  //         } else {
   //             if(response.getStatus() == status.DivisaoZero) {
  //                  System.out.println("Erro. Divisão por zero");
  //              } else {
  //                  System.out.println("Operador inválido");
  //              }
  //          }

        } catch (Exception e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
        }

        try {
            System.out.println("Encerrando o cliente");
            entrada.close();
            socket.close();
        } catch (Exception e) {
            
        }
    }

}
