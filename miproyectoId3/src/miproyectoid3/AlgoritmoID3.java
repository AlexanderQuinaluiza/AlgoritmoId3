/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miproyectoid3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author IVAN
 */
public class AlgoritmoID3 {
	
	List<Object> resultados=new ArrayList<>();
	List<Object> respuesta=new ArrayList<>();
	List<Integer> items=new ArrayList<>();
	Object datos[][];
	
	
	public void id3(Object datos[][],int condicion) {
		 if (condicion<2)
			this.datos=datos; 
		// Variables
		String resArbol="";
		Object[] arbolMenorDP=new Object[datos[0].length-2];
		int nt=datos.length,dpMenor = 0,porc=0;
		double porcMenor=0;
		Object arbol1[][],arbol2[][];
		List<Object> elementos=new ArrayList<>();
		
		// Inicializa las matrices auxiliar
		arbol1=new Object[datos[0].length-1][noElementos(datos)];
		arbol2=new Object[datos[0].length-1][noElementos(datos)];
		          
		          System.out.println("Filas "+arbol1.length+" columnas "+arbol1[0].length);
		
		for (int i = 0; i < datos[0].length-1; i++) {
			for (int j = 0; j < datos.length; j++) {
				elementos.add(datos[j][i]);
			}
			// Remueve los elementos repetidos de la listas
			elementos=removerRepetidos(elementos);
			
			// Anade la parte 1 del arbol
			arbol1[i]=elementos.toArray();
			// Forma la parte 2 del arbol
			for (int k=0; k<elementos.size(); k++) {
				for (int j = 0; j < datos.length; j++) {
					if (elementos.get(k).equals(datos[j][i]))
						// Agrega cada resultado con su identificador respectivo
						resArbol=resArbol.concat(j+identificador(resultados.get(resultados.indexOf(datos[j][datos[0].length-1])).toString())+",");
					}
				elementos.remove(k);
				elementos.add(k,resArbol);
				resArbol="";
			}
			// Anade la parte 2 del arbol
			arbol2[i]=elementos.toArray();
			elementos.clear();
	}
		
	//System.err.println("2 Filas "+arbol1.length+" columnas "+arbol1[0].length);
		System.out.println("\n\nArbol 1 ");
		
		for (int i = 0; i < arbol1.length; i++) {
			for (int k = 0; k < arbol1[i].length; k++) {
				System.out.print(arbol1[i][k]+" ");
				
			}System.out.println();
		}
		System.out.println("\n\n Arbol 2");
		for (int i = 0; i < arbol2.length; i++) {
			for (int k = 0; k < arbol2[i].length; k++) {
				
				System.out.print(arbol2[i][k]+"  ");
			}System.out.println();
		}
		// Busca el menor valor
		List<Double> dps=dp(arbol2, nt);
		
		
			System.out.println("DP= "+dps);
			dpMenor=numeroMenor(dps);
			// Forma la variable respuesta
			Object m[]=arbol1[dpMenor];
			String ramaResp="";
			for (int i = 0; i < m.length; i++) {
			ramaResp=ramaResp.concat(m[i]+"-");	
			}
			respuesta.add(ramaResp);
			// Arbol de menor dp
			arbolMenorDP=arbol2[dpMenor];
			System.out.println("Ramas dp menor "+dpMenor);
			for (int i = 0; i < arbolMenorDP.length; i++) {
				System.out.print(arbolMenorDP[i]+"  ");
			}
			
			
			List<Double> porcentajes=new ArrayList<Double>();
			
			
			for (Object rama : arbolMenorDP) {
				String v[]=rama.toString().split(",");

				for (Object resul : resultados) {
					
					for (int k = 0; k < v.length; k++){
						// Cuenta los elementos correspondientes a cada resultado
						if (v[k].contains(resul.toString())) {
							porc++;
						}
					}
					
					//System.out.println("Porc "+porc+" v length "+v.length);
					// Calcula valores con log
					porcMenor=((porc*100.0)/v.length)-porcMenor;
					porc=0;
				}
				porcentajes.add(Math.abs(porcMenor));
				porcMenor=0;
				
			}
			
			String ramaMenor=arbolMenorDP[numeroMenor(porcentajes)].toString();
			System.err.println("\n\nRAMA MENOR "+ramaMenor);
			String items="";
			String itemsrestantes[]=ramaMenor.split(",");
			for (int i = 0; i < itemsrestantes.length; i++) {
				String v[]=itemsrestantes[i].split("_");
				if(condicion<2)
					this.items.add(Integer.valueOf(v[0]));
				items=items.concat(v[0]+" ");
			}
			
			Object [][] aux=new Object [itemsrestantes.length][datos[0].length-1];
			
			System.err.println("Filas "+aux.length+" Columnas "+aux[0].length+" DP Menor "+dpMenor);
			
			int fila=0;
		for (int i = 0; i < datos.length; i++) {
				//System.out.println("IIIBB "+datos[j][i]);
				if (items.contains(String.valueOf(i))) {
					for (int j = 0; j < datos[0].length; j++) {
						if(j<dpMenor){
							aux[fila][j]=datos[i][j];
						}
						else 
							//System.out.println("jjj  "+j);
							if(j>dpMenor){
								//System.out.println("hhh "+datos[i][j]);
							aux[fila][j-1]=datos[i][j];
						}
							//System.out.println("jjj455  "+j);
					}
					fila++;
				}
		
		}
		
		/*System.out.println("ITEMSV RWEZS   ");
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[0].length; j++) {
			System.out.print(aux[i][j]+"  ");	
			}System.out.println();
		}*/
		// if condicional
		if (condicion<2) {
			
		id3(aux, 2);
		} else{
			formarReglas();
		}
		
	}
	
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/
	// Forma una nueva regla
	//en caso de usar una base de datos
	private void guardarReglas() {
	          
	    	/*
	    	          String sql = "insert into clientes (cli_cedula, cli_nombre, cli_apellido,"
	    	                  + "cli_telefono) values(?,?,?,?)";
	    	          try {
	    	              PreparedStatement psd=cn.prepareStatement(sql);
	    	              psd.setString(1, txtCedula.getText().trim());
	    	              psd.setString(2, txtNombre.getText().trim());
	    	              psd.setString(3, txtApellido.getText().trim());
	    	              psd.setString(4, txtTelefono.getText().trim());
	    	             
	    	              
	    	              int n=psd.executeUpdate();
	    	              
	    	              if(n>0){
	    	                  JOptionPane.showMessageDialog(null, "Registro Correcto");
	    	                  cargarTabla("");
	    	                  btnCancelar.doClick();
	    	              }
	    	                  
	    	              
	    	          } catch (SQLException ex) {
	    	              JOptionPane.showMessageDialog(null, ex);
	    	          }*/
	    	          
	    	  
	}
	
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/
	// Forma una nueva regla
	
	
	public String[][] formarReglas(){
		List<Object> respuestas=new ArrayList<>();
		String[][] resultados;
		
		int si1=-1,si2=-1;
		String cond1 = "",cond2="",sol1="";
		for (Object resp : respuesta) {
			for (int i = 0; i < datos[0].length; i++) {
				boolean ver=true;
				for (int j = 0; j < datos.length; j++) {
					if (!resp.toString().contains(datos[j][i].toString())) {
						ver=false;
					}
				}
				//
				if(ver){
				if (si1==-1) 
					si1=i;
				else
					si2=i;
				}
			}
		}
		
		for (int indice : items) {
			for (int j = 0; j < datos.length; j++) {
					if(j==indice){
						cond1=datos[j][si1].toString();
						cond2=datos[j][si2].toString();
						sol1=datos[j][datos[0].length-1].toString();
						respuestas.add(si1+"if"+cond1+" "+si2+" "+cond2+" "+sol1);
					}
					
					
				}
		}
		
		respuestas=removerRepetidos(respuestas);
		resultados=new String[respuestas.size()][5];
		for (int j = 0; j < respuestas.size(); j++) 
		resultados[j]=respuestas.get(j).toString().split(" ");	
	
		return resultados;
		
	}
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/
	// Devuelve el número menor de una serie
	
	private int numeroMenor(List<Double> lista) {
		int menor = 0;
		for (int i = 0; i < lista.size()-1; i++) {
			if (lista.get(i)<lista.get(i+1))
				menor=i;
			else
				menor=i+1;
		}
		return menor;
	}
	
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/
	// Devuelve el número máximo de elementos
	private int noElementos(Object datos[][]) {
		int total=0;
		List<Object> elementos=new ArrayList<>();
		resultados.clear();
		for (int i = 0; i < datos[0].length; i++) {
			for (int j = 0; j < datos.length; j++) {
				elementos.add(datos[j][i]);
			}
			
			// Remueve los elementos repetidos de la listas
			elementos=removerRepetidos(elementos);
			// Encuentra la lista con mas elementos
			if (elementos.size()>total && i<datos.length-1) 
				total=elementos.size();
			else{
				if (i==datos[0].length-1) {
					resultados.addAll(elementos);
				}
			}
			elementos.clear();
			}
			return total;
		}
        public void interpretacion_id3(){
            String resul= "if then entonces";
        } 
        

	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/
	
	// Devuelve un identificador para cada elemento
	private String identificador(String item){
		return "_"+item;
	}
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/

//Remueve elementos repetidos en una lista
	public List<Object> removerRepetidos(List<Object> var){
		for (int i = 0; i < var.size(); i++) {
			for (int j = 0; j < var.size(); j++) {
				if (i!=j && var.get(i).equals(var.get(j))) {
					var.remove(j);
					removerRepetidos(var);
				}
			}
		}
		return var;
		
	}
	
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/

// Calcula el desorden promedio
	private List<Double> dp(Object datos[][],int nt) {
		List<Double> result=new ArrayList<>();
		
		double nb=0,nbc=0,calcLog=0,calculoTotal=0;
		for (int i = 0; i < datos.length; i++) {
			for (int j = 0; j < datos[i].length; j++) {
				// Separa los elementos de cada rama
				String v[]=String.valueOf(datos[i][j]).split(",");
				nb=v.length;
				
				for (Object resul : resultados) {
					
					for (int k = 0; k < v.length; k++){
						// Cuenta los elementos correspondientes a cada resultado
						if (v[k].contains(resul.toString())) {
							nbc++;
						}
					}
					// Calcula valores con log
					if (nbc!=0) 
						calcLog+=(-(nbc/nb)*logn((nbc/nb), 2));
					
					//System.out.println(datos[i][j]+" NB "+nb+" NBC "+nbc+" calc "+calcLog);
					nbc=0;
				}
				// Calcula DP de cada rama
				calculoTotal+=(nb/nt)*calcLog;
				// Reinicializacion de variables
				calcLog=0;
				nb=0;
				nbc=0;
			}
			//Añade los resultados a la lista
			result.add(calculoTotal);
			//System.out.println("Total "+calculoTotal);
			calculoTotal=0;
		}
		
		
		return result;
		
	}
	
	/*###########################################################################################################################
	 * #																														#
	 * ##########################################################################################################################*/

// Calcula el logaritmo de un número en base n
	public double logn(double numero,double base) {
		return Math.log(numero)/Math.log(base);
		
	}
}
