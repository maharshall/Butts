// Un-comment the lines below to verify that the sorting method works properly
package csci2020u.a1;

import csci2020u.a1.Helper;
import java.util.Arrays;

public class Benchmark {
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Class usage: java csci2020u.a1.Benchmark <string length> <array length>");
			return;
		}

		int stringLen = Integer.parseInt(args[0]);
		int arrayLen = Integer.parseInt(args[1]);

		Helper.resetTimer();
		String[] arr = Helper.makeArray(stringLen, arrayLen);
//		System.out.println(Arrays.deepToString(arr));
		System.out.printf("Created %d strings of length %d in %.0f milliseconds\n", 
       		arrayLen, stringLen, Helper.readTimerMilliseconds() / 1.0f);

		QuickSorter qs = new QuickSorter();
		Helper.resetTimer();
		qs.QuickSorter(arr);

//		System.out.println(Arrays.deepToString(arr));
		System.out.printf("~Sorted %d strings of length %d in %.0f milliseconds\n\n", 
       		arrayLen, stringLen, Helper.readTimerMilliseconds() / 1.0f);
	}
}