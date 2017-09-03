package kMeans;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class euclidianDistance {

	public static double distanceCal(ArrayList<Double> dist1, ArrayList<Double> dist2) {
		double dist = 0;
		double aDist = 0;
		double sum = 0, square = 0;
		for (int i = 0; i < dist1.size()-1; i++) {
			aDist = dist1.get(i) - dist2.get(i);
			square = Math.pow(aDist, 2);
			sum = sum + square;
		}
		dist = Math.sqrt(sum);
		return dist;
	}

	public static Hashtable<Integer, ArrayList<ArrayList<Double>>> eDistance(ArrayList<ArrayList<Double>> kcentroids,
			ArrayList<ArrayList<Double>> dataForInitialize) {
		Hashtable<Integer, ArrayList<ArrayList<Double>>> clusters = new Hashtable<Integer, ArrayList<ArrayList<Double>>>();

		double dist = 0;
		int key;
		int k = kcentroids.size();
		//System.out.println("my Data: "+dataForInitialize);
		for (int i = 0; i < dataForInitialize.size(); i++) { // distance for
			TreeMap<Double, Integer> eDist = new TreeMap<Double, Integer>(); // each
																// point
			for (int j = 0; j < kcentroids.size(); j++) {
				dist = distanceCal(kcentroids.get(j), dataForInitialize.get(i));
																			
																				// function
																				// to
																				// calculate
																				// distance
				eDist.put(dist, j);
			}

			Integer tempKey = eDist.get(eDist.firstKey());
			if (clusters.containsKey(tempKey)) {
				ArrayList<ArrayList<Double>> tempArrList = clusters.get(tempKey);
				tempArrList.add(dataForInitialize.get(i));
				clusters.put(tempKey, tempArrList);
			} else {
				ArrayList<ArrayList<Double>> tempArrList = new ArrayList<>();
				tempArrList.add(dataForInitialize.get(i));
				clusters.put(tempKey, tempArrList);
			}

		}
		return clusters;
	}
	
}
