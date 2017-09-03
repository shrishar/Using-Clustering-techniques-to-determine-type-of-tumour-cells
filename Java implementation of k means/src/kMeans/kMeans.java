
/*Author: Shridivya Sharma
 * All the work is solely mine
 * UID: 2000109932
 * */

package kMeans;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class kMeans {

	public static void main(String[] args) {

		String csvFile = "D:\\college\\Sem 1\\Data Mining\\HW2\\DeltaFix2.csv"; // csv
																				// file
																				// location
		ArrayList<ArrayList<Double>> dataForInitialize = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> centroidInit = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> centroidNew = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> centroidPrev = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> ranCentroidInit = new ArrayList<ArrayList<Double>>();
		dataForInitialize = ReadData.ReadCSVData(csvFile); // Csv file is loaded
															// into array list

		Hashtable<Integer, ArrayList<ArrayList<Double>>> clusters = new Hashtable<Integer, ArrayList<ArrayList<Double>>>();
		// Number of Clusters

		Scanner s = new Scanner(System.in);
		System.out.println("enter number of clusters k:");
		int n = s.nextInt();

		System.out.println("Enter Threshold Value:");
		double t = s.nextDouble();

		double dprev = 0;
		centroidInit = centroidInitiate.centroidInit(n, dataForInitialize); // Randomly
																			// initiating
																			// centroid
																			// from
																			// the
																			// data
																			// set
		ranCentroidInit = centroidInitiate.ranCentroidInit(n);

		// System.out.println(centroidInit);

		dprev = centroidDistance.cDistance(centroidInit, ranCentroidInit);
		double dist = 0;

		clusters = euclidianDistance.eDistance(centroidInit, dataForInitialize);
		centroidNew = centroidUpdate.CentroidUpdate(clusters);

		dist = centroidDistance.cDistance(centroidNew, centroidInit);
		double delta = Math.abs(dist - dprev);
		// System.out.println(dist);
		int noOfIt = 0;
		while (delta > t) {
			centroidPrev = centroidNew;
			dprev = dist;
			clusters = euclidianDistance.eDistance(centroidNew, dataForInitialize);
			centroidNew = centroidUpdate.CentroidUpdate(clusters);
			dist = centroidDistance.cDistance(centroidNew, centroidPrev);
			noOfIt++;
			delta = Math.abs(dprev - dist);
			// System.out.println(noOfIt);
			// System.out.println("Distance "+delta);

		}
		System.out.println(
				"Error Rate for Clusters " + n + " is : " + centroidCount.errorRate(centroidCount.cenCount(clusters)));
	}
}