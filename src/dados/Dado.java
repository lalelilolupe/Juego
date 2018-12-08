/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author PONKCHO
 */
import com.itver.project.resources.NetConnection;
import com.itver.project.resources.PacketNet;
import com.itver.project.resources.Protocol;
import java.util.Random;



public class Dado {
    public Dado(){
     //GenerarDado();
    
 }
    
    public int GenerarDado(final NetConnection connection){// Regresa el numero aleatorio del dado
     int dado=0;
     //Random girar= new Random();
     //dado= girar.nextInt(6)+1;
     
    PacketNet requestPacket = new PacketNet("Lanzando Dados", Protocol.TIRO );
    connection.sendPacket(requestPacket);
    PacketNet receivedPacket = connection.readPacket();
    
    dado = receivedPacket.getTiro();
    return dado;  
    }
 
}
