/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import listaGenericaLLS.Lista;

//import listaGenericaArrayList.Lista;


/**
 *
 * @author ninavaldivia
 */
public class AppColecciones {
    public static void main(String[] args){
        Lista<String> nombres= new Lista();
        
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Luis");
        nombres.add("Javiera");
        
        System.out.println("Lista:\n" + nombres.toString());
    }
}
