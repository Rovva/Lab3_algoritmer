package ultimate_super_algorithm;

import java.util.ArrayList;

import ultimate_super_algorithm.NumberGenerator;

public class DivideAndConquer {
	
    NumberGenerator num;
	ArrayList startArray;	
	static int cost;
	public double[] kvoten;

	
	
	public DivideAndConquer(NumberGenerator num) {
    	
    	this.num = num;
		this.startArray = num.unsorted;
		this.cost = 0;
		this.kvoten = new double[2];
        
    }
	
	
	
	
	public double[] findquota(int low, int high){
		
		double[] result1;
		double[] result2;
		
		if((high - low + 1) > 2 ){
			int middle = low + (high - low) / 2;
			result1 = findquota(low, middle);
			result2 = findquota(middle + 1, high);
			return Compare(result1, result2);
			
		} else {
			
			return MinMax(low, high);
			
		}
		
	}
	
	public double[] MinMax(int low, int high){
		double[] result = new double[3];
		
		if ((double)startArray.get(low) < (double)startArray.get(high)){
			result[0] = (((double)startArray.get(high))/(double)startArray.get(low));
			result[1] = (double)startArray.get(low);
			result[2] = (double)startArray.get(high);
		} else if (low == high) {
			result[0] = 0;
			result[1] = (double)startArray.get(high);
			result[2] = (double)startArray.get(low);
			
		} else {
			result[0] = 0;
			result[1] = (double)startArray.get(high);
			result[2] = (double)startArray.get(low);
		}
			
		return result;
		
	}
	
	public double[] Compare(double[] result1, double[] result2){
		
		double[] result = new double[3];
		
		//CHECK MIN
		if (result1[1] < result2[1]){
			result[1] = result1[1];
		} else {
			result[1] = result2[1];
		}
		
		//CHECK MAX
		if (result1[2] > result2[2]){
			result[2] = result1[2];
		} else {
			result[2] = result2[2];
		}
		
		//COMPARE QUOTA
		if (result1[0] == 0) {
			if(result2[0] == 0){
				result[0] = result2[2]/result1[1];
				//kvoten[0] = result1[1];   //ALLA KVOTEN GREJS ÄR TEST
				//kvoten[1] = result2[2];
			} 
			else if (result2[0] > result2[2]/result1[1]) {
				result[0] = result2[0];
				//kvoten[0] = result2[1];
				//kvoten[1] = result2[2];
			} else {
				result[0] = result2[2]/result1[1];
				//kvoten[0] = result1[1]; 
				//kvoten[1] = result2[2];
			}			
		}
		else if (result2[0] == 0) {
			if (result1[0] > result2[2]/result1[1]){
				result[0] = result1[0];
				//kvoten[0] = result1[1];
				//kvoten[1] = result1[2];
			} else {
				result[0] = result2[2]/result1[1];
				//kvoten[0] = result1[1]; 
				//kvoten[1] = result2[2];
			}
		} else {
			if (result1[0] > result2[0]){
				if (result1[0] > result2[2]/result1[1]){
					result[0] = result1[0];
					//kvoten[0] = result1[1];
					//kvoten[1] = result1[2];
				} else {
					result[0] = result2[2]/result1[1];
					//kvoten[0] = result1[1]; 
					//kvoten[1] = result2[2];
				}
			} else {
				if (result2[0] > result2[2]/result1[1]){
					result[0] = result2[0];
					//kvoten[0] = result2[1];
					//kvoten[1] = result2[2];
				} else {
					result[0] = result2[2]/result1[1];
					//kvoten[0] = result1[1]; 
					//kvoten[1] = result2[2];
				} 
			}
		}
		
		/*
		
		if((int)startArray.get(result1[0]) <= (int)startArray.get(result2[0])){
			
			result[0] = result1[0];
			
		} else if(result2[0] < result2[1]) {
			
			result[0] = result2[0];
			result[1] = result2[1];
			
		} else {
			
			result[0] = result1[0];
			
			if((int)startArray.get(result1[1]) >= (int)startArray.get(result2[1])){
				
				if(result1[1] >= result1[0]){
					result[1] = result1[1];
				}
				
				else if(result2[1] >= result1[0] && ((int)startArray.get(result1[0]) < (int)startArray.get(result2[1]))) {
					
					result[1] = result2[1];
					
				} else {
					System.out.println("It is impossible to find a max/min for array1: [" + result1[0] + ", " + result1[1] + "] and array2: " + result2[0] + ", " + result2[1] + "]"  );
					System.out.println("Because indicies are not allowed");
					System.out.println("Maybe return a min/max that is the biggest? ...since max/min doesn't work?");
					
				}
				
			} else {
				
				result[1] = result2[1];
				
			}
			
			
		}
		
		if((int)startArray.get(result1[1]) >= (int)startArray.get(result2[1])){
			
			result[1] = result1[1];
			
		} else {
			
			result[1] = result2[1];
			
		}
		
		*/
		
		/*
		
		
		if ((result1[0] >= result2[0]) && (result1[0] >= result2[1])){
			result1[0] = result2[0];
		} 
		
		if (result1[1] <= result2[1]){
			
			result1[1] = result2[1];
		}
		*/
		
		return result;
		
		
	}

}
