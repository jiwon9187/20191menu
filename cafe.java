
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class cafe extends JFrame implements ActionListener {
	private static int width = 1000;
	private static int height = 800;
	public static int NUMBER_OF_CHAR = 50;
	private JTextArea search;
	caffeine menu1;
	noncaffeine menu2;
	
	
	public cafe()
	{
		super("cafe");
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JMenu menu = new JMenu("menu");
		JMenuItem caffeine = new JMenuItem("caffeine");
		caffeine.addActionListener(this);
		menu.add(caffeine);
		JMenuItem noncaffeine = new JMenuItem("noncaffeine");
		noncaffeine.addActionListener(this);
		menu.add(noncaffeine);
		
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		setJMenuBar(bar);
		
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
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();
		
		if(buttonString.equals("caffeine"))
		{
			menu1 = new caffeine();
			menu1.setVisible(true);
		}
		else if(buttonString.equals("noncaffeine"))
		{
			menu2 = new noncaffeine();
			menu2.setVisible(true);
		}
		else
		{
			System.out.println("unexpected error");
		}
	}
	

}
