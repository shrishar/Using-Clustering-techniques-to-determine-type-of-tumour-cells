package kMeans;

import java.util.ArrayList;
import java.util.Random;

public class centroidInitiate {
	
	public static ArrayList<ArrayList<Double>> ranCentroidInit(int k){
		ArrayList<ArrayList<Double>> ranCentroidInit = new ArrayList<ArrayList<Double>>();
		int rndNo;
		double fRnd;
		Random rndNos = new Random();
		for(int j=0;j<k;j++){
			ArrayList<Double> random = new ArrayList<Double>();
		   for(int i=0;i<7;i++){
			rndNo=rndNos.nextInt(10);
			String rnd=Integer.toString(rndNo);
			fRnd=Double.parseDouble(rnd);
			random.add(fRnd);			
		}
		   ranCentroidInit.add(random);
		}
		return ranCentroidInit;
		
		
	}
	public static ArrayList<ArrayList<Double>> centroidInit(int k, ArrayList<ArrayList<Double>> centroid) {
		ArrayList<ArrayList<Double>> kcentroids = new ArrayList<ArrayList<Double>>();
		int rndNo;
		Random randomno = new Random(); //random selection of centroid

		for (int i = 0; i < k; i++) {
			rndNo = randomno.nextInt(centroid.size());
			ArrayList<Double> temp=centroid.get(rndNo);
			
			kcentroids.add(temp);
		}
//System.out.println("initial " + kcentroids);
		return kcentroids;

	}
}
