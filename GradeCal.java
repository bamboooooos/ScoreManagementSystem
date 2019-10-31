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
		setTitle("成绩管理");
		setVisible(true);
		setBounds(100,100,310,260);
		add(jtp);
		InputWindowInit iwi=new InputWindowInit();
		jtp.addTab("输入",iwi);
		QueryWindowInit qwi=new QueryWindowInit(iwi.getReport());
		jtp.addTab("查询",qwi);
		SortWindowInit swi=new SortWindowInit(iwi.getReport());
		jtp.addTab("排序",swi);
	}
}


//测试输入是否可用
class TestListener implements ActionListener{
	HashMap<String,Integer> students;
	public TestListener(HashMap<String,Integer> students) {
		this.students=students;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("保存的成绩表内容为:");
		for(String key:students.keySet()) {
			System.out.println(key+":"+students.get(key));
		}
		System.out.println("-----------------------");
	}
}
