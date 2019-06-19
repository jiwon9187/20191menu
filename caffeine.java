
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class caffeine extends JFrame implements ActionListener {
	private static int width = 1000;
	private static int height = 800;
	public static int NUMBER_OF_CHAR = 50;
	private JTextArea search;
	
	public caffeine()
	{
		super("caffeine");
		setSize(width, height);
		setLayout(new BorderLayout());
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 1));
		
		search = new JTextArea("Search Menu");
		JScrollPane scrollPane = new JScrollPane(search);
		
		search.setBackground(Color.white);
		add(scrollPane);
		
		JButton searchButton = new JButton("search");
		searchButton.addActionListener(this);
		searchPanel.add(searchButton);
		add(searchPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
