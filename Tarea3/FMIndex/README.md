# Tarea 3 - FM-Index

- Juanita Puentes Mozo, j.puentes@uniandes.edu.co, 201814823
- Laura Valentina Acosta Corredor, lv.acostac@uniandes.edu.co, 201911225
- Jhon Stewar Rayo Mosquera, j.rayom@uniandes.edu.co, 201720166

# Objetivos 
1. Entender el proceso de alineamiento de lecturas a un genoma de referencia
2. Visualizar alineamientos
3. Practicar trabajo en el cluster

# ¿Cómo correr el código?

Para ejecutar el script de *EntryPoint.java*

Se debe ejecutar el siguiente comando.

## Windows

`java -Xmx4g -cp lib\NGSEPcore_3.2.0.jar;bin uniandes.algorithms.fmindex.EntryPoint "data/sequences/coronavirus.fasta" "data/reads/coronavirus_10_20.fastq" "SuffixArray" "results/coronavirus_10_20.txt" true`

## Mac

`java -Xmx4g -cp lib/NGSEPcore_3.2.0.jar;bin uniandes.algorithms.fmindex.EntryPoint "data/sequences/coronavirus.fasta" "data/reads/coronavirus_10_20.fastq" "FM" "results/coronavirus_10_20.txt"`

Donde los argumentos son:

`args[0]` **->** Ruta al archivo Fasta con la secuencia a utilizar.

`args[1]` **->** Ruta al archivo FastQ con las lecturas a buscar en la secuencia.

`args[2]` **->** Comando a ejecutar. Puede ser **"SuffixArray"** o **"FM"**. Ambos producen el mismo resultado, pero usando algoritmos diferentes.

`args[3]`  **->**  Ruta donde se guardaran los indices donde se encontraron las lecturas en las secuencias.

`args[4]` **-> Opcional**  Parametro booleano que indica si el arreglo de sufijos se debe construir usando menos memoria o no.`.

Para las pruebas realizadas, se puede encontrar el conjunto de datos utilizado en la carpeta data segregado por lecturas y secuencias. Los resultados obtenidos pueden ser referenciados en la
carpeta results, donde el sufijo FM y SA indican que se obtuvo ese archivo de salida al correr el programa con el comando `FM` y `SuffixArray` respectivamente