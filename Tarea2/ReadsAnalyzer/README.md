# Tarea 2 - Ensamblaje de genomas


- Juanita Puentes Mozo, j.puentes@uniandes.edu.co, 201814823
- Laura Valentina Acosta Corredor, lv.acostac@uniandes.edu.co, 201911225
- Jhon Stewar Rayo Mosquera, j.rayom@uniandes.edu.co, 201720166


# Objetivos 
1. Realizar una implementación sencilla del algoritmo OLC para ensamblaje de
genomas
2. Diferenciar conteos de lecturas de conteos de k-mers
3. Practicar una implementación de grafos dirigidos

# ¿Cómo correr el código?

Para ejecutar el script de *ReadsAnalyzerExample.java*, el cual tiene dos funcionalidades.

1. Ensamblar un texto/secuencia dado construyendo el grafo de solapes.
2. Calcular k-mers de un texto/secuencia dado

Se debe ejecutar el siguiente comando.

## Windows

java -Xmx4g -cp lib\NGSEPcore_3.2.0.jar;bin uniandes.algorithms.readsanalyzer.ReadsAnalyzerExample "Overlap" "<Ruta de archivo de entrada>" 10

## Mac

java -Xmx4g -cp lib/NGSEPcore_3.2.0.jar:bin uniandes.algorithms.readsanalyzer.ReadsAnalyzerExample "Overlap" "<Ruta de archivo de entrada>" 10

Donde los argumentos son:

args[0] -> Funcionalidad a ejecutar: "Overlap" o "Kmers"
args[1] -> Archivo con las lecturas a analizar en formato fastq
args[2] -> Parámetro opcional. Para el comando “Overlap” permite cambiar el sobrelape mínimo. Para el comando “Kmers”, permite cambiar el tamaño del k-mer

---

Para ejecutar el script de *SimpleReadsSimulator.java*, el cual genera ejemplos de lectura de un archivo en formato fasta, se puede ejecutar el siguiente comando.

## Windows

java -Xmx4g -cp lib\NGSEPcore_3.2.0.jar;bin uniandes.algorithms.readsanalyzer.SimpleReadsSimulator "data\HS_MIT.fasta" 100 20 "<Ruta de archivo de salida>" 1.0

## Mac

java -Xmx4g -cp lib/NGSEPcore_3.2.0.jar:bin uniandes.algorithms.readsanalyzer.SimpleReadsSimulator "data\HS_MIT.fasta" 100 20 "<Ruta de archivo de salida>" 1.0

Donde los argumentos son:

args[0] -> Archivo de entrada en formato fasta
args[1] -> Tamano de las secuencias de lectura a simular
args[2] -> Numero de lecturas a simular
args[3] -> Porcentaje de error para generar lecturas con ciertos errors mas alineadas a lo que se obtiene con secuencacion de ADN

Para ambos casos se deben ejecutar estos comandos desde la raiz del proyecto.