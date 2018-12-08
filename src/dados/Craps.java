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
public class Craps {

    public  Craps(){  
     
    }
   
  public int Gana(int num){// Regresa 1 si el usuario gano de lo contrario regresa 0
   if(num==7 || num==11){
       int i=123;
       return 1;
       
   }
   else {   
  }return 0;
  
  }
  public int Crapso(int num2){//Regresa 1 si el usuario perdio de lo contrario regresa 0
 
  if(num2==2 || num2==3 || num2==12){
       return 1;
   }
   else {   
  }return 0;
  }
  public int Tirada(int num3){//Si el usuario no gana ni pierde regresa 1 de lo contrario regresa 0
     if(num3==4 || num3==5 || num3==6 || num3==8 || num3==9 || num3==10){
       return 1;
   }
   else {   
  }return 0; 
  }
}
