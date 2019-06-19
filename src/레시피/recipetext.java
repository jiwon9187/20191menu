
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

import javax.swing.*;

public class recipetext extends JFrame implements ActionListener{
	
	String name;
	String explan;
	String[] mtext = new String[10];
	int cnt=0;
	int i=0;
	JPanel image = new JPanel();
	JPanel explanpal = new JPanel();
	JTextArea text= new JTextArea();
	Container c;
	JButton before;
	JButton home;
	JButton after;
	
	recipetext(String name) throws FileNotFoundException{

		this.name = name;
		setTitle("asdf");
		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new GridLayout(1,2));
		
		String file = "src\\레시피\\"+name +".txt";
		File f = new File(file);
		Scanner text = new  Scanner(f);
		mtext[cnt++] = text.nextLine();
		while(text.hasNextLine()){
			mtext[cnt++] = text.nextLine();
		}
		
		setimage();
		c.add(image);
		setexplane();
		c.add(explanpal);
		
		setVisible(true);
	}

	void setimage()
	{
		image.setLayout(new BorderLayout());
		
		JLabel rname = new JLabel(name);
		rname.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		ImageIcon img1 = new ImageIcon("src\\레시피\\" + name + ".jpg");
		JLabel rimage = new JLabel(img1);
		
		image.add(rname, BorderLayout.NORTH);
		image.add(rimage, BorderLayout.CENTER);

	}
	
	void setexplane(){
		explanpal.setLayout(new BorderLayout());
		
		JPanel bpanel = new JPanel();
		JPanel bpanel2 = new JPanel();
		bpanel.setLayout(new FlowLayout());
		
		JPanel textpal = new JPanel();
		text = new JTextArea();
		
		JTextArea recipe = new JTextArea();
		
		ImageIcon img1 = new ImageIcon("src\\레시피\\before.png");		
		ImageIcon img2 = new ImageIcon("src\\레시피\\home.png");
		ImageIcon img3 = new ImageIcon("src\\레시피\\after.png");
		
		recipe.setFont(new Font("SansSerif", Font.BOLD, 20));
		recipe.setText("RECIPE");
		recipe.setColumns(5);
		recipe.setRows(2);
		bpanel2.add(recipe);
		
		before = new JButton(img1); 		
		before.addActionListener(this);

		home =  new JButton(img2);
		home.addActionListener(this);
		
		after =  new JButton(img3);
		after.addActionListener(this);
		
		explan = mtext[0];
		
		text.setFont(new Font("SansSerif", Font.BOLD, 20));
		text.setText(explan);
		

		textpal.add(text);
		text.setLineWrap(true);
		text.setColumns(20);
		text.setRows(10);
		explanpal.add(textpal, BorderLayout.CENTER);
		
		explanpal.add(bpanel2, BorderLayout.NORTH);
		
		bpanel.add(before);
		bpanel.add(home);
		bpanel.add(after);
		explanpal.add(bpanel, BorderLayout.SOUTH);
		explanpal.add(bpanel2, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == before)
		{
			if(i==0)
			{
				explan = mtext[i];
				text.setText(explan);
			}else {
			explan = mtext[--i];
			text.setText(explan);
			}
		}else if(e.getSource() == after)
		{
			if(i == cnt-1)
			{
				explan = mtext[cnt-1];
				text.setText(explan);
			}
			else{
				explan = mtext[++i];
				text.setText(explan);
			}
		}else if(e.getSource() == home)
		{
			
		}
		
	}
}

