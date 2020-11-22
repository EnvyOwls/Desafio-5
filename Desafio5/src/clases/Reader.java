package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Reader 
{

	private String path;
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
	public Reader (String path)
	{
		this.setPath(path);
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	//*********************SEPARADOR MARCA FRUNA********************************


	public Trie leer() throws IOException
	{
		
		Trie trie =new Trie();
		BufferedReader br=new BufferedReader(new FileReader(path));
		String linea="";
		String split = ",";
		//QUE NO LEA ENCABEZADOS
		linea = br.readLine();
		
		System.out.print("Leyendo el dataset");
		int contador=1;
		while ((linea = br.readLine()) != null)
		{
			String[] separador = linea.split(split);
			
			//SE PASA A UTF 8 O QUEDAN SIMBOLOS RAROS EN EL STRING
			byte[] ptext = separador[2].getBytes(ISO_8859_1); 
			String value = new String(ptext, UTF_8);
			
			//System.out.println(value);
			
			String palabras[]=value.split(" ");
			String temp;
			for (int i=0;i<palabras.length;i++)
			{	
				//ESTO SIRVE PAL DEBUG
				temp=palabras[i];
				//trie.insert(temp);
				
				StringBuilder str= new StringBuilder();
				int cont=0;
				while (cont <4)
				{
					if (i+cont>=palabras.length)
					{
						break;
					}
					str.append(palabras[i+cont]);
					trie.insert(str.toString().toLowerCase());
					str.append(" ");
					cont++;
				}
			
			}
			contador++;
			if (contador%10000==0)
			{
				System.out.print(".");
			}
		}
		System.out.println("\nFin de la lectura");
		return trie;
	}
	
	
}
