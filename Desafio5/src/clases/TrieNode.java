package clases;

import java.util.ArrayList;
import java.util.List;

public class TrieNode
{
	 private char data;     
	 private ArrayList hijo; 
	 private TrieNode padre;
	 private boolean isEnd;
	 
	 //CONSTRUCTOR
	 public TrieNode(char c) 
	 {
		 setData(c);
		 setHijo(new ArrayList());
		 setEnd(false);        
	 }

	//SETS Y GETS
	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public ArrayList getHijo() {
		return hijo;
	}

	public void setHijo(ArrayList hijo) {
		this.hijo = hijo;
	}

	public TrieNode getPadre() {
		return padre;
	}

	public void setPadre(TrieNode padre) {
		this.padre = padre;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}  
	//FUNCIONES
	
	
	 public TrieNode getHijo(char c) 
	 {
		 //MIENTRAS NO SEA NULL
		 if (hijo != null)
		 {
			 //RECORRE CON TEMP
			 for (int i=0;i<hijo.size();i++)
			 {
				 TrieNode temp=(TrieNode) hijo.get(i);
				 if (temp.data == c)
				 {
					 return temp;
				 }
	            
			 }
		 }
		 return null;
	 }
	 
	 public ArrayList getWords() 
	 {
		 ArrayList list = new ArrayList();
		 
		 //VE SI ES EL FINAL 
		 if (isEnd) 
		 {
			 list.add(InputToString());
		 }
	       
		 //MIENTRAS NO SEA NULL
		 if (hijo != null) 
		 {
			 for (int i=0; i< hijo.size(); i++) 
			 {
				 if (hijo.get(i) != null) 
				 {
					 list.addAll(((TrieNode) hijo.get(i)).getWords());
				 }
			 }
		 }       
		 return list; 
	 }
	 
	 //VA CREANDO EL STRING
	 public String InputToString() 
	 {
		 if (padre == null) 
		 {
			 return "";
		 } 
		 else 
		 {
			 return padre.InputToString() + new String(new char[] {data});
		 }
	 }
}
