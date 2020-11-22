package clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main 
{
	private static String input;
	public static void main(String args[]) throws IOException
	{
		Reader lector = new Reader("src\\extras\\files.csv");
		
		Trie trie=lector.leer();
		
		input = args[0];
		String input_aux = input;
		input.toLowerCase();
		
		//SE CREA UNA COPIA DEL INPUT
		String copia=input+"";
		
		//SI PREDICE COSAS HASTA 6 PALABRAS, HAY QUE RECORTARLO
		
			//TEORICAMENTE, EL NUMERO DE ESPACIOS REPRESENTA QUE HAY [ESPACIOS+1] PALABRAS
		//ENTONCES
		
		//SE CORTA EL INPUT HASTA TENER LAS DOS ULTIMAS PALABRAS	
		while (recortar(2)>=2)
		{
			
		}
		
		String aux=input;

			ArrayList predicciones=(ArrayList) trie.autocompletar(input);
			if (predicciones.size() != 0)
			{
				trie.mostrarPredicciones(predicciones, input_aux, input);
			}
			else
			{
				System.out.println(input+"\n"+"No se encontraron coincidencias");
			}
			

	}
	
	
	public static int recortar(int max)
	{
		
		 int espacios = 0;
		 int flag=0;
		 int firstEspacio=-1;
		 for (int i = 0; i < input.length(); i++) 
		 {
			 if (input.charAt(i) == ' ')
			 {
				 espacios++;
				 if (flag==0)
				 {
					 flag=1;
					 firstEspacio=i;
				 }
			 }
		 }
		 
		 if (espacios>=max)
		 {
			 input=input.substring(firstEspacio+1);
		 }
		 return espacios;
	}
}
