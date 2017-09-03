package kMeans;

import java.util.ArrayList;
import java.util.Hashtable;

public class centroidUpdate {
	public static ArrayList<Double> newCentroid (ArrayList<ArrayList<Double>> c) {
		double Centroid = 0;
		/*ArrayList<ArrayList<Double>> newCentroid = new ArrayList<ArrayList<Double>>();*/
		int rows=c.size();
		int col=c.get(0).size();
		ArrayList<Double> newC = new ArrayList<Double>();
		for (int i = 0; i < col-1; i++) {
			double sum = 0;
		
			
				for (int j = 0; j <rows; j++) {
					sum = sum + c.get(j).get(i);
				}
				Centroid = sum / rows;
				newC.add(Centroid);
				
			}
		return newC;
	}

	public static ArrayList<ArrayList<Double>> CentroidUpdate(Hashtable<Integer, ArrayList<ArrayList<Double>>> clusters) {
		ArrayList<ArrayList<Double>> centroidUpdate = new ArrayList<ArrayList<Double>>();
		
		for(Integer key : clusters.keySet())
		{
			ArrayList<ArrayList<Double>> tempDataPoints=clusters.get(key);
			centroidUpdate.add(newCentroid(tempDataPoints));
			
		}
		//System.out.println("Centroid Update:"+centroidUpdate);
		return centroidUpdate;
	}
	
}
