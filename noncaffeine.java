
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

public class noncaffeine extends JFrame implements ActionListener {
	private static int width = 1000;
	private static int height = 800;
	public static int NUMBER_OF_CHAR = 50;
	private JTextArea search;
	public noncaffeine()
	{
		super("noncaffeine");
		setSize(width, height);
		setLayout(new BorderLayout());
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 1));
		
		search = new JTextArea("Search Menu");
		search.setBackground(Color.white);
		search = new JTextArea("Search Menu");
		JScrollPane scrollPane = new JScrollPane(search);
		add(scrollPane);
		
		JButton searchButton = new JButton("search");
		searchButton.addActionListener(this);
		searchPanel.add(searchButton);
		add(searchPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}	
}
