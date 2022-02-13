package data;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Csv writer
 * Extract data
 *
 */
public class CsvWriter {


	/**
	 * Write data into csv file
	 * @param data data to write
	 */
    public static void WriteCsv(String data) {
    	try (PrintWriter writer = new PrintWriter("Results.csv")) {
    		
    		writer.write(data);
    	      
    	} catch (FileNotFoundException e) {
    		System.out.println(e.getMessage());
    	}
    }

	/**
	 * Creates a basis for the csv file
	 * @return the StringBuilder
	 */
    public static StringBuilder newSb() {
    	
    	StringBuilder sb = new StringBuilder();
		sb.append("method");
		sb.append(";");
		sb.append("subMethod");
		sb.append(";");
    	sb.append("minimumFrequency");
    	sb.append(";");
    	sb.append("beamWidth");
    	sb.append(";");
    	sb.append("beamDepth");
    	sb.append(";");
		sb.append("firstGroupSize");
		sb.append(";");
		sb.append("firstGroupDescriptors");
		sb.append(";");
		sb.append("firstGroupScore");
		sb.append(";");
		sb.append("qualityScore");
		sb.append(";");
		sb.append("executionTime");
		sb.append(";");
    	sb.append("\n");
    	
    	return sb;
    }

}
