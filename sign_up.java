import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;

public class sign_up extends JFrame implements ActionListener{
	
	TextField name_text;
	TextField ID_text;
	JPasswordField PW_text;
	JPasswordField PW_moretext;
	TextField address_text;
	
	public sign_up()
	{
		super("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		JPanel information = new JPanel();
		information.setLayout(new GridLayout(6,2));
		
		JLabel name = new JLabel("이름");
		name.setHorizontalAlignment(name.CENTER);
		information.add(name);
		
		name_text = new TextField(25);
		information.add(name_text);
		
		JLabel ID = new JLabel("아이디");
		ID.setHorizontalAlignment(ID.CENTER);
		information.add(ID);
		
		ID_text = new TextField(25);
		information.add(ID_text);
		
		JLabel PW = new JLabel("비밀번호");
		PW.setHorizontalAlignment(PW.CENTER);
		information.add(PW);
		
		PW_text = new JPasswordField(25);
		information.add(PW_text);
		
		JLabel PW_more = new JLabel("비밀번호 (한번 더)");
		PW_more.setHorizontalAlignment(PW_more.CENTER);
		information.add(PW_more);
		
		PW_moretext = new JPasswordField(25);
		information.add(PW_moretext);
		
		JLabel address = new JLabel("주소");
		address.setHorizontalAlignment(address.CENTER);
		information.add(address);
		
		address_text = new TextField(25);
		information.add(address_text);
		
		JButton save = new JButton("저장");
		save.addActionListener(this);
		information.add(save);
		
		JButton cancel = new JButton("취소");
		cancel.addActionListener(this);
		information.add(cancel);
		
		add(information,BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		String ButtonString = e.getActionCommand();
		if(ButtonString.equals("저장"))
		{
			try
			{
				if(PW_text.getText().equals(PW_moretext.getText()))
				{
					BufferedWriter writefile = new BufferedWriter(new FileWriter("member.txt",true));
					writefile.write(name_text.getText()+"/");
					writefile.write(ID_text.getText()+"/");
					writefile.write(PW_text.getText()+"/");
					writefile.write(address_text.getText()+"\r\n");
					writefile.close();
					JOptionPane.showMessageDialog(null, "member.txt에 저장되었습니다.");
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다. 다시 입력해 주세요.");
				}
			}
			catch (Exception error)
			{
				JOptionPane.showMessageDialog(null, "member.txt");
			}
		}
		
		if(ButtonString.equals("취소"))
		{
			dispose();
		}
	}
}
