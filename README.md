# Desafio 5
### Equipo Rocket


El presente desafío tiene por objetivo procesar la informacion proporcionada mediante un .CSV para posteriormente trabajarla en un trie. El cual permitirá mostrar sugerencias para autocompletar frases a partir de un input ingresado por el usuario.

Para poder ejecutar el programa se debe.

1. Descargar la carpeta **Desafio 5**. En ella se encontrara el ejecutable **predictor.jar**.
2. Abrir el ejecutable mediante consola.
3. Una vez abierta la consola es necesario dirigirse a la ubicación donde se descargó el proyecto. (ej. cd desktop...) 
4. Ya en la ubicación del ejecutable, escribir el siguiente comando.

~~~
java -jar predictor.jar "frase que se desea autocompletar"
~~~

**Notas:** 
- Es necesario que la frase se escriba entre comillas, ya que ingresa como argumento directo al main del programa.
- En caso de que no se encuentren registros similares a la frase ingresada el programa terminará retornando el input sumado a un mensaje que especifique que no se encontraron coincidencias.
