package javaHW;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SortWindowInit extends JPanel{
	HashMap<String,Integer> students;
	JButton jb1,jb2;
	JTable jt;
	JPanel jp;
	public SortWindowInit(HashMap<String,Integer> students) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.students=students;
		jb1=new JButton("…˝–Ú≈≈–Ú");
		jb2=new JButton("Ωµ–Ú≈≈–Ú");
		jp=new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		add(jp);
		JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);
        Vector<String> columnNames = new Vector<>();
        columnNames.add("≈≈√˚");
        columnNames.add("—ß∫≈");
        columnNames.add("≥…º®");
		jt=new JTable();
		Vector<Vector<String>> tableValues=new Vector<>();
		DefaultTableModel defaultTableModel = new DefaultTableModel(tableValues, columnNames);
		defaultTableModel.setRowCount(0);
		jt.setModel(defaultTableModel);
		scrollPane.setViewportView(jt);
		SortButtonListener sbl1=new SortButtonListener(SortButtonListener.SORT_MODE_ASCEND,students,defaultTableModel);
		SortButtonListener sbl2=new SortButtonListener(SortButtonListener.SORT_MODE_DESCEND,students,defaultTableModel);
		jb1.addActionListener(sbl1);
		jb2.addActionListener(sbl2);
		setVisible(true);
	}
}
class SortButtonListener implements ActionListener{
	int mode;
	final static int SORT_MODE_ASCEND=0;
	final static int SORT_MODE_DESCEND=1;
	HashMap<String,Integer> students;
	List<Map.Entry<String,Integer>> list;
	DefaultTableModel jtm;
	public SortButtonListener(int mode,HashMap<String,Integer> students,DefaultTableModel jtm) {
		this.mode=mode;
		this.students=students;
		this.jtm=jtm;
	}
	public void actionPerformed(ActionEvent e) {
		list=Sort(mode);
		int length=jtm.getRowCount();
		for(int j=0;j<length;j++) {
			jtm.removeRow(0);
		}
		for(int i=0;i<list.size();i++) {
			jtm.addRow(new String[] {i+1+"",list.get(i).getKey(),list.get(i).getValue()+""});
		}
	}
	public List<Map.Entry<String,Integer>> Sort(int mode) {
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(students.entrySet());
		switch(mode){
			case SORT_MODE_ASCEND:
				Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
		            //…˝–Ú≈≈–Ú
		            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
		            	return o1.getValue().compareTo(o2.getValue());
		            }
		        }); 
			break;
			case SORT_MODE_DESCEND:
				Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
		            //Ωµ–Ú≈≈–Ú
		            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2) {
		            	return o2.getValue().compareTo(o1.getValue());
		            }
		        }); 
			break;
			default:
		}
		return list;
	}
}
