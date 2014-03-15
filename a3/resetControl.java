//Alexander Marshall - 100487187
import java.awt.event.*;

public class resetControl implements ActionListener {
	Searcher s;
	View v;

	public resetControl(Searcher s, View v) {
		this.s = s; 
		this.v = v;
	}

	public void actionPerformed(ActionEvent e) {
		v.textSearch.setText(null);
		v.result.setText(null);
		v.searchTime.setText(null);
	}
}
