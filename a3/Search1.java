//Alexander Marshall - 100487187
import java.util.*;
import java.io.*;
import java.lang.String;

public class Search1 {
	static long timerStart;

	public static Map<String, String> buildIndex(String filename) {
		try {
			Map <String, String> courses = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			
			while((line = br.readLine()) != null) {
				String[] info = line.split("            ");
				String code = info[0];
				String title = info[1];
				courses.put(code, title);
			}

			return courses;

		} catch(IOException e) {
			System.out.println("File cannot be found! Maybe you made a typo :(");
		}
		return null;
	}

	public static void search(Map<String, String> index, String keyword) {
		for(Map.Entry<String, String> c : index.entrySet()) {
			if(c.getValue().toLowerCase().contains(keyword.toLowerCase())) {
				System.out.println(c.getKey()+" : "+c.getValue());
			}
		}

	}

	public static void resetTimer() {
		timerStart = System.currentTimeMillis();
  }

    public static long readTimerMilliseconds() {
			return System.currentTimeMillis() - timerStart;
  }

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Example usage: java Search1 UOIT.txt CSCI 2040U CSCI 2050U");
			return;
		}

		String filename = args[0];
		Map <String, String> courses = buildIndex(filename);
		String keyword = args[1];
		resetTimer();
		search(courses, keyword);
		long time = readTimerMilliseconds();
		System.out.println("Took "+time+" milliseconds to search for keyword "+keyword);
	}
}
