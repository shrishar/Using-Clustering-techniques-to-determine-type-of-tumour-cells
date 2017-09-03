package kMeans;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadData {

	public static ArrayList<ArrayList<Double>> ReadCSVData(String csvFile){
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<ArrayList<Double>> InData = new ArrayList<ArrayList<Double>>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			line=br.readLine();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				ArrayList<Double> tuple=new ArrayList<Double>();
				String[] dArray = line.split(cvsSplitBy);
				for(int i=1;i<9;i++){
				tuple.add(Double.parseDouble(dArray[i]));
				}
			 InData.add(tuple);
			}
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	
	return InData;
}}
