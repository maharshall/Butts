//Alexander Marshall - 100487187
import java.util.*;
import java.io.*;
import java.lang.String;

public class Search2 {
	static long timerStart;

	public static Map<String, List<String>> buildIndex(String filename) {
		try {
			Map <String, List<String>> courses = new HashMap<String, List<String>>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			
			while((line = br.readLine()) != null) {
				String[] info = line.split("            ");
				String code = info[0];
				String temp = info[1];

				String[] temp2 = temp.split(" ");
				List<String> title = new ArrayList<String>();

				for(int i=0; i<temp2.length; ++i){
					if(courses.containsKey(temp2[i])) {
						List<String> codes = courses.get(temp2[i]);
						codes.add(code);
						courses.remove(temp2[i]);
						courses.put(temp2[i], codes);
					} else {
						List<String> codes = new ArrayList<String>();
						codes.add(code);
						courses.put(temp2[i], codes);
					}
				}
			}

			return courses;

		} catch(IOException e) {
			System.out.println("File cannot be found! Maybe you made a typo :(");
		}
		return null;
	}

	public static void search(Map<String, List<String>> index, String keyword) {
		for(Map.Entry<String, List<String>> c : index.entrySet()) {
			if(c.getKey().toLowerCase().equals(keyword.toLowerCase())) {
				String[] codes = c.getValue().toArray(new String[c.getValue().size()]);
				for(int i=0; i<codes.length; ++i) {
					System.out.println(codes[i]);
				}
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
		Map <String, List<String>> courses = buildIndex(filename);
		String keyword = args[1];
		resetTimer();
		search(courses, keyword);
		long time = readTimerMilliseconds();
		System.out.println("\nTook "+time+" milliseconds to search for keyword "+keyword);
	}
}

