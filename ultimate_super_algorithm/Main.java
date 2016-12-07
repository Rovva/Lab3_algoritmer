package ultimate_super_algorithm;

import ultimate_super_algorithm.NumberGenerator;
import ultimate_super_algorithm.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	

	NumberGenerator num;
	Sorter sort;

	public static void main(String[] args) {	
		int n = 10;
		NumberGenerator num = new NumberGenerator(n);
		DivideAndConquer DaC = new DaC(num);
		System.out.println("-------------------");
		System.out.println(num.unsorted);
		System.out.println("-------------------");
		System.out.println(DaC.findquota(0, num.unsorted.size() - 1));
		
	}

}
