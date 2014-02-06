package csci2020u.a1;

import java.util.*;
import java.io.*;

public class QuickSorter {
	//initialize the sorter with an array
	public void QuickSorter(String[] strings){
		int size = strings.length;
		sort(strings, 0, size-1);
	}

	//start the quicksort algorithim
	public void sort(String[] arr, int start, int end){
		if(start < end){
			String pivot = arr[end];
			int i = start; int j = end;

			while(i != j){
				if(arr[i].compareTo(pivot) < 0){
					i++;
				}else{
					arr[j] = arr[i];
					arr[i] = arr[j-1];
					j--;
				}
			}

			arr[j] = pivot;
			sort(arr, start, j-1);
			sort(arr, j+1, end);
		}
	}
}