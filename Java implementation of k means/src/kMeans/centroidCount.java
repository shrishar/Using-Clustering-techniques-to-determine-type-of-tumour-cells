package kMeans;

import java.util.ArrayList;
import java.util.Hashtable;

public class centroidCount {

	public static ArrayList<Integer> cCount(ArrayList<ArrayList<Double>> count) {
		ArrayList<Double> tempCount = new ArrayList<Double>();
		ArrayList<Integer> returnCount = new ArrayList<Integer>();
		int rows = count.size();
		double d = 0;
		int bCount=0,mCount=0;
		for (int i = 0; i < rows; i++) {
			     tempCount=count.get(i);
			   
			     d=tempCount.get(7);
			     if(d==2){
			    	 bCount++;
			     }
			     else
			     {
			    	 mCount++;
			     }
		}
	
		returnCount.add(bCount);
		returnCount.add(mCount);
	   
		return returnCount;
	}

	public static Hashtable<Integer,ArrayList<ArrayList<Integer>>> cenCount(Hashtable<Integer, ArrayList<ArrayList<Double>>> clusters) {
		int rows = clusters.size();
		ArrayList<Integer> count = new ArrayList<Integer>();
		
		Hashtable<Integer,ArrayList<ArrayList<Integer>>> CenCount = new Hashtable<Integer, ArrayList<ArrayList<Integer>>>();
		
		for (int i = 0; i < rows; i++) {
			ArrayList<ArrayList<Integer>> bmCount = new ArrayList<ArrayList<Integer>>();
			//System.out.println(clusters);
			count=cCount(clusters.get(i));
			bmCount.add(count);
			CenCount.put(i, bmCount);
		}

		return CenCount;

	}

	public static float errorRate(Hashtable<Integer, ArrayList<ArrayList<Integer>>>CenCount){
		int rows = CenCount.size();
		float errorRate=0;
		for(Integer key : CenCount.keySet())
		{
			ArrayList<ArrayList<Integer>> bmCount=CenCount.get(key);
		
			for(int i=0;i<bmCount.size();i++){
				ArrayList<Integer> benmalCount = new ArrayList<Integer>();
			benmalCount=bmCount.get(i);
			float b=benmalCount.get(0);
			float m= benmalCount.get(1);
			//System.out.println(b+ " "+m);
			float sum=b+m;
			if(b>m){
				errorRate= errorRate+(m/sum);
			}
			else
			{
				errorRate=errorRate+(b/sum);
			}
			}	
		}
		return errorRate;
	}
}
