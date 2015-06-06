/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyectoid3;

import id3aq.AlgoritmoID3;
import id3aq.AlgoritmoID3;

/**
 *
 * @author IVAN
 */
public class AlgoritmoID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      AlgoritmoID3 id =new AlgoritmoID3();
		Object datos[][]=new Object[][]{{"c","Joe","No","Sally","Alto"},{ "c","Samantha","No","Thomas","Bajo"},{ "a","Jim","Si","Patrick","Bajo"},
				{ "c","Joe","No","Thomas","Bajo"},{ "b","Jim","No","Patrick","Alto"},{ "b","Jim","Si","Thomas","Bajo"}
				,{ "a","Joe","No","Patrick","Alto"},{ "b","Samantha","Si","Patrick","Bajo"}};
		
		id.id3(datos,0);
		//System.out.println(id.logn(0, 2));
		String v[][]=id.formarReglas();
		
		for (String[] strings : v) {
			for (String string : strings) {
				System.out.print(string+" ");
			}System.out.println();  // TODO code application logic here
    }
    
}
    }
