package javaHW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputWindowInit extends JPanel{
	JTextField jtf1,jtf2;
	JButton jb,jt;
	HashMap<String,Integer> students;
	JPanel jp;
	public InputWindowInit() {
		students=new HashMap<String,Integer>();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		jtf1=new JTextField("");
		jtf2=new JTextField("");
		jb=new JButton("保存");
		jt=new JButton("读取");
		jp=new JPanel();
		jp.add(jb);
		jp.add(jt);
		jtf1.addFocusListener(new JTextFieldHintListener("学号", jtf1));
		jtf2.addFocusListener(new JTextFieldHintListener("成绩", jtf2));
		add(jtf1);
		add(jtf2);
		add(jp);
		TextButtonListener tbl=new TextButtonListener(jtf1,jtf2,students);
		jb.addActionListener(tbl);
		TestListener tl=new TestListener(students);
		jt.addActionListener(tl);
		setVisible(true);
	}
	HashMap<String,Integer> getReport(){
		return students;
	}
}
class TextButtonListener implements ActionListener{
	HashMap<String,Integer> students;
	JTextField jtf1,jtf2;
	public TextButtonListener(JTextField jtf1,JTextField jtf2,HashMap<String,Integer> students) {
		this.jtf1=jtf1;
		this.jtf2=jtf2;
		this.students=students;
	}
	public void actionPerformed(ActionEvent e) {
		students.put(jtf1.getText(), Integer.valueOf(jtf2.getText()).intValue());
	}
	public HashMap<String,Integer> getReport(){
		return students;
	}
}
