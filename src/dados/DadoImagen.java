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
import javax.swing.*;
public class DadoImagen {
   public ImageIcon caradado; 
   public ImageIcon dadosgif; 
    public ImageIcon dadogif(int o){// Reinicia el label a una imagen .Gif o a un dado estatico
       switch(o){
           case 1:dadosgif = new ImageIcon("src/imagenes/daIN1.png");
               break;
           case 2:dadosgif = new ImageIcon("src/imagenes/daIN2.png");
               break;
           case 3:dadosgif = new ImageIcon("src/imagenes/daIN1.png");
               break;
           case 4:dadosgif = new ImageIcon("src/imagenes/daIN2.png");
               break;
       }
   return dadosgif;
   }
   public ImageIcon Cara(int cara){// Regresa la cara del dado segun el numero aleatorio
   switch(cara){
       case 1:
         caradado = new ImageIcon("src/imagenes/da1.png");//Asigna la  imagen al objeto
       break;
       case 2:
           caradado = new ImageIcon("src/imagenes/da2.png");
       break;
       case 3:
           caradado = new ImageIcon("src/imagenes/da3.png");
       break;
       case 4:
           caradado = new ImageIcon("src/imagenes/d4.png");
       break;
       case 5:
           caradado = new ImageIcon("src/imagenes/d5.png");
       break;
       case 6:
           caradado = new ImageIcon("src/imagenes/d6.png");
       break;
   }
    return caradado;    
   }
}
