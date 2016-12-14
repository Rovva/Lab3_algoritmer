package ultimate_super_algorithm;

import ultimate_super_algorithm.NumberGenerator;
import ultimate_super_algorithm.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	

	NumberGenerator num;
	

	public static void main(String[] args) {
		

		long time;
		long startTime;
		
		int average = 100;
		
		
		
		for(int u = 100000; u <= 2000000; u += 100000){
			
			long tottime = 0;
			
			
			for(int t = 0; t < average; t++){
				
				NumberGenerator num = new NumberGenerator(u);
				DivideAndConquer DaC = new DivideAndConquer(num);
				/*
				System.out.println("-------------------");
				System.out.println(num.unsorted);
				System.out.println("-------------------");
				*/
				startTime = System.nanoTime();
				double[] MinMax = DaC.findquota(0, num.unsorted.size() - 1);
				time = (long) ((System.nanoTime() - startTime));
				tottime += time;
				/*
				System.out.println(time + " ns");
				System.out.println(time/1000000 + " ms");
				System.out.println("Quota: " + DaC.kvoten[1] + "/" + DaC.kvoten[0] + " = " + MinMax[0] + " | Min: " + MinMax[1] + " | Max: " + MinMax[2]);
				*/
				
			}
			
			System.out.println("-----------");
			System.out.println("MINMAX AVERAGE TIME AT SIZE:" + u);
			System.out.println("-----------");
			System.out.println("Average time: " + (tottime / average)/1000000.0  + " milli seconds");
			System.out.println("              " + (tottime / average)  + " nano seconds");
			System.out.println("-----------");
			System.out.println();

		}
		
	}

}
