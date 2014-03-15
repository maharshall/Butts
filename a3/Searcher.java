//Alexander Marshall - 100487187
import java.util.*;
import java.io.*;
import java.lang.String;

public class Searcher {
	static long time;
	String filename;
  Map<String, String> courses;
	int i;

	public Searcher(String filename) {
		this.filename = filename;
	}

	public void buildIndex() {
		try {
			courses = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			
			while((line = br.readLine()) != null) {
				String[] info = line.split("            ");
				String code = info[0];
				String title = info[1];
				courses.put(code, title);
			}
		} catch(IOException e) {
			System.out.println("File cannot be found! Maybe you made a typo :(");
		}
	}

	public String search(String keyword) {
		i = 0;
		String results = "";
		long timeStart = System.currentTimeMillis();
		for(Map.Entry<String, String> c : courses.entrySet()) {
			if(c.getValue().toLowerCase().contains(keyword.toLowerCase())) {
				i += 1;
				results += (c.getKey()+" : "+c.getValue()+"\n");
			}
		}
		time = System.currentTimeMillis() - timeStart;
		return results;
	}

	public long getTime() {
		return time;
	}

	public int getCount() {
		return i;
	}

}
