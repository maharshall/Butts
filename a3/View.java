//Alexander Marshall - 100487187
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
	JTextField textSearch;
	JTextArea result;
	JTextArea searchTime;
	JButton resetButton;
	JButton searchButton;
	JTextArea count;

	public View() {
		//all the panels to be used
		setTitle("UOIT Course Look-Up");
		JPanel root = new JPanel();
		JPanel search = new JPanel();
		JPanel results = new JPanel();
		JPanel time = new JPanel();

		//root is the main panel, and contains the others
		this.getContentPane().add(root);
		root.setLayout(new BorderLayout());
		root.add(search, BorderLayout.NORTH);
		root.add(time, BorderLayout.SOUTH);
		root.add(results, BorderLayout.CENTER);

		//search bar and search/clear buttons
		search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
		textSearch = new JTextField();
		searchButton = new JButton("Search");
		resetButton = new JButton("Clear");
		search.add(textSearch); 
		search.add(searchButton); 
		search.add(resetButton);

		//results and scroll bar
		result = new JTextArea();
		result.setEditable(false);
		JScrollPane scroll = new JScrollPane(result);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.createVerticalScrollBar();
		scroll.setPreferredSize(new Dimension(500, 550));
		results.add(scroll);

		//search time and item count
		searchTime = new JTextArea();
		searchTime.setEditable(false);
		time.add(searchTime);

		this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
	}

}
