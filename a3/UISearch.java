//Alexander Marshall - 100487187
import javax.swing.*;
import java.awt.*;

public class UISearch extends JFrame {
	public UISearch() {
		setTitle("UOIT Course Look-Up");
		JPanel root = new JPanel();
		JPanel search = new JPanel();
		JPanel help = new JPanel();
		JPanel results = new JPanel();
		JPanel time = new JPanel();

		this.getContentPane().add(root);
		root.setLayout(new BorderLayout());
		root.add(search, BorderLayout.NORTH);
		root.add(results, BorderLayout.CENTER);
		root.add(time, BorderLayout.SOUTH);

		//Search Bar and Button
		search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
		JTextField textSearch = new JTextField();
		textSearch.setPreferredSize(new Dimension(200, 24));
		JButton searchButton = new JButton("Search!");
		search.add(textSearch); search.add(searchButton);

		//Helpful Text
		JTextArea helpText = new JTextArea("Enter text above and get results below!");
		helpText.setFont(new Font("Calibri", Font.ITALIC, 16));
		helpText.setEditable(false);
		help.add(helpText);

		//Course Code and Title Results
		results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));
		results.add(help);
		
		//Total Search Time

		this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
	}

	public static void main(String[] args) {
		new UISearch();
	}
}
