package kMeans;

import java.util.ArrayList;

public class centroidDistance {

	public static double cDistance(ArrayList<ArrayList<Double>> centroidNew,ArrayList<ArrayList<Double>> centroidPrev){
		
		int size= centroidNew.size();
		double dist= 0;
		for(int i=0;i<size;i++)
		{
			dist=dist+euclidianDistance.distanceCal(centroidNew.get(i), centroidPrev.get(i));
		}
		
		return dist;
	}
}
