package javaHW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class QueryWindowInit extends JPanel{
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JTextArea jta;
	HashMap<String,Integer> students;
	public QueryWindowInit(HashMap<String,Integer> students) {
		this.students=students;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		jtf=new JTextField(16);
		jb=new JButton("查询");
		jta=new JTextArea();
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jtf.addFocusListener(new JTextFieldHintListener("学号", jtf));
		add(jp);
		add(jta);
		QueryButtonListener qbl=new QueryButtonListener(jtf,jta,students);
		jb.addActionListener(qbl);
		setVisible(true);
	}
}
class QueryButtonListener implements ActionListener{
	HashMap<String,Integer> students;
	JTextField jtf;
	JTextArea jta;
	public QueryButtonListener(JTextField jtf,JTextArea jta,HashMap<String,Integer> students) {
		this.jtf=jtf;
		this.jta=jta;
		this.students=students;
	}
	public void actionPerformed(ActionEvent e) {
		String ToQuery=jtf.getText();
		if(students.containsKey(ToQuery)) {
			jta.setText("学号为"+ToQuery+"的同学成绩为:"+students.get(ToQuery));
		}else{
			jta.setText("查询的学号不存在");
		}
	}
}