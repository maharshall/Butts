//Alexander Marshall - 100487187
import java.awt.event.*;

public class searchControl implements ActionListener {
	Searcher s;
	View v;

	public searchControl(Searcher s, View v) {
		this.s = s; 
		this.v = v;
	}

	public void actionPerformed(ActionEvent e) {
		String keyword = v.textSearch.getText();
		String searchResults = s.search(keyword);
		if(searchResults.equals("")) {
			v.result.setText("No results!");
			return;
		}
		v.result.setText(searchResults);
		v.searchTime.setText("Took "+s.getTime()+" millisecond(s) to search for keyword '"+ 
				keyword+"'; "+s.getCount()+" results.");
	}
}
