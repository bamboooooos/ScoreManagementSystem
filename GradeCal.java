package javaHW;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class GradeCal {
	public static void main(String[]args) {
		new WindowInit();
	}
}
class WindowInit extends JFrame{
	public WindowInit() {
		JTabbedPane jtp=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		setTitle("�ɼ�����");
		setVisible(true);
		setBounds(100,100,310,260);
		add(jtp);
		InputWindowInit iwi=new InputWindowInit();
		jtp.addTab("����",iwi);
		QueryWindowInit qwi=new QueryWindowInit(iwi.getReport());
		jtp.addTab("��ѯ",qwi);
		SortWindowInit swi=new SortWindowInit(iwi.getReport());
		jtp.addTab("����",swi);
	}
}


//���������Ƿ����
class TestListener implements ActionListener{
	HashMap<String,Integer> students;
	public TestListener(HashMap<String,Integer> students) {
		this.students=students;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("����ĳɼ�������Ϊ:");
		for(String key:students.keySet()) {
			System.out.println(key+":"+students.get(key));
		}
		System.out.println("-----------------------");
	}
}
