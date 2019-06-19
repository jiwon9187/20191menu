import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class login extends JFrame implements ActionListener{
	
	TextField IDText;
	JPasswordField pwText;
	
	public static void main(String[] args)
	{
		login gui = new login();
		gui.setVisible(true);
	}

	public login()
	{
		super("커피에 대한 모든 것");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		JLabel coffeeImage = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\coffee1.jpeg"));
		add(coffeeImage, BorderLayout.CENTER);
		
		JPanel IDPanel = new JPanel();
		IDPanel.setLayout(new GridLayout(2,3));
		
		JLabel idLabel = new JLabel("   아이디 : ");
		idLabel.setHorizontalAlignment(idLabel.CENTER);
		IDPanel.add(idLabel);
		
		IDText = new TextField(25);
		IDPanel.add(IDText);
		
		JButton LoginButton = new JButton("로그인");
		LoginButton.addActionListener(this);
		IDPanel.add(LoginButton);
		
		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setHorizontalAlignment(pwLabel.CENTER);
		IDPanel.add(pwLabel);
		
		pwText = new JPasswordField(25);
		IDPanel.add(pwText);
		
		JButton signupButton = new JButton("회원가입");
		signupButton.addActionListener(this);
		IDPanel.add(signupButton);
		add(IDPanel,BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonCommand = e.getActionCommand();
		
		if(buttonCommand.equals("회원가입"))
		{
			sign_up signup = new sign_up();
			
		}
		
		else if(buttonCommand.equals("로그인"))
		{
			try
			{
				int check=0;
				String info;
				String[] array;
				BufferedReader readfile = new BufferedReader(new FileReader("member.txt"));
				while((info=readfile.readLine())!=null)
				{
					array=info.split("/");
					if(IDText.getText().equals(array[1]) && pwText.getText().equals(array[2]))
					{
						check=1;
					}
				}
				readfile.close();
				if(check==1)
				{
					JOptionPane.showMessageDialog(null, "로그인이 되었습니다");
					cafe gui = new cafe();
				}
				else if(check==0)
				{
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
				}
				dispose();
			}
			
			catch (ArrayIndexOutOfBoundsException err)
			{
				JOptionPane.showMessageDialog(null, "가입된 회원이 없습니다. 회원 가입 후 진행해 주세요.");
			}
			
			catch (IOException error)
			{
				error.printStackTrace();
			}
		}
	}
	
}
