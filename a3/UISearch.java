//Alexander Marshall - 100487187

class UISearch {
	public static void main(String[] args) {
		Searcher s = new Searcher("UOIT.txt");
		View v = new View();
		s.buildIndex();

		resetControl re = new resetControl(s, v);
		searchControl se = new searchControl(s, v);

		v.resetButton.addActionListener(re);
		v.searchButton.addActionListener(se);
	}
}
