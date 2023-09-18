package uniandes.algorithms.readsanalyzer;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import ngsep.sequences.QualifiedSequence;
import ngsep.sequences.QualifiedSequenceList;
import ngsep.sequences.io.FastaSequencesHandler;

/**
 * Simple script that simulates error free reads from a text in fasta format
 * @author Jorge Duitama
 *
 */
public class SimpleReadsSimulator {
	/**
	 * Main class that executes the program
	 * @param args Array of arguments:
	 * args[0]: Source sequence in fasta format. If many sequences are present, it only takes the first sequence
	 * args[1]: Length of the reads to simulate
	 * args[2]: Number of reads to simulate
	 * args[3]: Path to the output file
	 * args[4]: Error percentaje
	 * @throws Exception If the fasta file can not be loaded
	 */
	public static void main(String[] args) throws Exception {
		String filename = "C:\\Users\\laura\\OneDrive\\Documentos\\GitHub\\ALGORITMOS\\ISIS4006\\Tarea2\\ReadsAnalyzer\\data\\HS_MIT.fasta";
		//int readLength = Integer.parseInt(args[1]);
		int readLength = 50;
		//int numReads = Integer.parseInt(args[2]);
		int numReads = 20;
		//String outFile = args[3];
		String outFile = "C:\\Users\\laura\\OneDrive\\Documentos\\GitHub\\ALGORITMOS\\ISIS4006\\Tarea2\\ReadsAnalyzer\\data\\HS_MIT_"+String.valueOf(readLength)+"_"+String.valueOf(numReads)+"_errorRate_out.fastq";
		//double errorRate = Double.parseDouble(args[4]);
		double errorRate = 0.2;
		FastaSequencesHandler handler = new FastaSequencesHandler();
		handler.setSequenceType(StringBuilder.class);
		QualifiedSequenceList sequences = handler.loadSequences(filename);
		if(sequences.size()==0) throw new Exception("No sequences found in file: "+filename);
		QualifiedSequence seq = sequences.get(0);
		String sequence = seq.getCharacters().toString();
		int seqLength = sequence.length();
		System.out.println("Length of the sequence to simulate reads: "+seqLength);
		double averageRD = ((double)numReads*readLength)/seqLength;
		System.out.println("Expected average RD: "+averageRD);
		char [] fixedQS = new char [readLength];
		Arrays.fill(fixedQS, '5');
		String fixedQSStr = new String(fixedQS);
		Random random = new Random();
		
		try (PrintStream out = new PrintStream(outFile)){
			// TODO: Generar lecturas aleatorias. Utilizar el objeto random para generar una posicion aleatoria de inicio
			// en la cadena sequence. Extraer la lectura de tamanho readLength e imprimirla en formato fastq.
			// Utilizar la cadena fixedQSStr para generar calidades fijas para el formato
    
    		for (int i = 0; i < numReads; i++) {
        		int inicio = random.nextInt(seqLength - readLength);

				String readSequence = sequence.substring(inicio, inicio + readLength); 
				readSequence = introduceRandomErrors(readSequence, errorRate); 
                
				// Formato fastq
				out.println("@" + i + " simulacion_read"); 
				out.println(readSequence); 
				out.println("+"); 
				out.println(fixedQSStr); 
					
				}
		}
	}

	// Función para introducir errores aleatorios
    private static String introduceRandomErrors(String sequence, double errorRate) {
        StringBuilder secuenciaModif = new StringBuilder(sequence);
        Random random = new Random();
        for (int i = 0; i < sequence.length(); i++) {
            if (random.nextDouble() < errorRate) {
                char randomBase = getRandomBase(sequence.charAt(i));
                secuenciaModif.setCharAt(i, randomBase);
            }
        }
        return secuenciaModif.toString();
    }

	// Función para obtener una base aleatoria diferente a la original
    private static char getRandomBase(char originalBase) {
        Random random = new Random();
        char[] possibleBases = {'A', 'C', 'G', 'T'};
        char randomBase;
        do {
            randomBase = possibleBases[random.nextInt(4)];
        } while (randomBase == originalBase);
        return randomBase;
    }
}
