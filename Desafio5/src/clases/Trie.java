package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Trie
{
	private TrieNode root;
	 
	 //CONSTRUCTOR
	 public Trie() 
	 {
		 setRoot(new TrieNode(' ')); 
	 }
	 //SETTERS Y GETTERS
	 public TrieNode getRoot() {
		return root;
	 }

	 public void setRoot(TrieNode root) {
		 this.root = root;
	 }
	 
	 //FUNCIONES
	 
	 public void insert(String s) 
	 {
		 //SI EXISTE NO HAY NECESIDAD DE INGRESARLO DENUEVO
		 if (search(s) == true)
		 {
			 return;
		 }
	                
		 TrieNode temp = root; 
		 TrieNode aux ;
		 for (char ch : s.toCharArray())
		 {
			 aux = temp;
			 TrieNode hijo = temp.getHijo(ch);
			 if (hijo != null)
			 {
				 temp = hijo;
				 hijo.setPadre(aux);
			 } 
			 else 
			 {
				 temp.getHijo().add(new TrieNode(ch));
				 temp = temp.getHijo(ch);
				 temp.setPadre(aux);
			 }
			 
		 }
		 	temp.setEnd(true);
	 }
	    
	 public boolean search(String s) 
	 {
		 TrieNode temp = root;      
		 for (char ch : s.toCharArray())
		 {
			 if (temp.getHijo(ch) == null)
			 {
				   return false;
			 }
			 else 
			 {
				 temp = temp.getHijo(ch);    
			 }
		 }      
		 if (temp.isEnd()) 
		 {       
			 return true;
		 }
		 return false;
	 }
	    
	 public List autocompletar(String input) 
	 {     
		 TrieNode temp = root;
		 for (int i = 0; i< input.length(); i++) 
		 {
			 temp = temp.getHijo(input.charAt(i));	     
			 if (temp == null)
			 {
				 return new ArrayList();
			 }
		 }
		 return temp.getWords();
	  }
	 
	 public void mostrarPredicciones(ArrayList predicciones, String full, String aux)
	 {
		 int largo = predicciones.size();
		 int prediccion, mostrar,max;
		 if(largo > 10)
		 {
			 mostrar = largo/10;
			 max = mostrar;
		 }
		 else
		 {
			 mostrar = 1;
			 max = 1;
		 }
		 Random r = new Random();
		 String oracion_previa=eliminarPalabra(full,aux);
		 for (int min = 0 ; min < largo ; min+=mostrar)
		 {
			 prediccion = r.nextInt(max-min) + min;
			 System.out.println(oracion_previa+predicciones.get(prediccion));
			 max+=mostrar;
			 if(max > largo-1)
			 {
				 break;
			 }
		 }
	 }
	 
	 public static String  eliminarPalabra(String oracion,String palabra) 
	 {
		    if(oracion.contains(palabra))
		    {
		        return oracion.replaceAll(palabra, "");
		    }
		    return oracion;
	}
	 
}
