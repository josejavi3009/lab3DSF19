package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;

public class IntegerSorterTester2 {
	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
	
	public static void main(String[] args) { 
		
		//the sample given in lab
		Integer[] example = {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
		
		
		sortersList.add(new BubbleSortSorter<Integer>()); 
		sortersList.add(new SelectionSortSorter<Integer>()); 
		sortersList.add(new InsertionSortSorter<Integer>()); 
		
//		test("Sorting Using Default Comparator<Integer>", null); 
		test("Sorting Using IntegerComparator1", new IntegerComparator1(), example); 
		test("Sorting Using IntegerComparator2", new IntegerComparator2(), example); 
	}
	
	private static void test(String msg, Comparator<Integer> cmp, Integer[] original) { 


		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Integer[] arr; 
		
		for (int i=1; i<=20; i += 5) { 
			showArray("\n ---Original array of size " + original.length + " to sort:", original); 
			
			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Integer> sorter = sortersList.get(s); 
			    arr = original.clone(); 
			    sorter.sort(arr, cmp);
			    showArray(sorter.getName() + ": ", arr); 
			}
		}
	}

	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}

}
