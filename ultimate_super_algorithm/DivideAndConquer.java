package ultimate_super_algorithm;

import java.util.ArrayList;

import sorting.NumberGenerator;

public class DivideAndConquer {
	
    NumberGenerator num;
	int[] unsorted;	
	
	
	public DivideAndConquer(NumberGenerator num) {
    	
    	this.num = num;
		this.unsorted = num.unsorted.toArray();
        
    }
	
	
	
	public int[] findquota(int low, int high){
		
		int[] result1;
		int[] result2;
		
		if((high - low + 1) > 2 ){
			int middle = low + (high - low) / 2;
			result1 = findquota(low, middle);
			result2 = findquota(middle + 1, high);
			return Compare(result1, result2);
			
		} else {
			
			return MinMax(low, high);
			
		}
		
	}
	
	public int[] MinMax(int low, int high){
		int[] result = new int[2];
		if (low < high){
			
			if(unsorted[low] <= unsorted[high]){
				
				result[0] = unsorted[low];
				result[1] = unsorted[high];

				
			} else {
				
				result[1] = unsorted[low];
				result[0] = unsorted[high];

			}
			
		} else {
			//THEY ARE THE SAME
			result[0] = unsorted[low];
			result[1] = unsorted[low];

		}
		return result;
		
	}
	
	public int[] Compare(int[] result1, int[] result2){
		
		if (result1[0] >= result2[0]){
			result1[0] = result2[0];
		} 
		
		if (result1[1] <= result2[1]){
			
			result1[1] = result2[1];
		}
		
		return result1;
			
	}

}
