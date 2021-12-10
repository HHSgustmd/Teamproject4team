package pos;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class pos extends JFrame implements Runnable{
	
	private TextArea ta1 = new TextArea(20, 15);
	private TextArea ta2 = new TextArea(20, 15);
	
	private InetAddress ia;
	private Socket soc;
	private PrintWriter pw;
	private BufferedReader br;
	
	private JPanel contentPane;
	private JTextField txtpos;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	
	String son;
	int count = 0;
	int cou = 0;
	int[] price = new int[8];
	menuDAO dao = new menuDAO(); 
	ArrayList<menuDTO> list = dao.select2(); 
	String[] menu = new String[8];
	String [] ColName = {"ÀÌ¸§","°¡°Ý","¼ö·®"};
	String [][] Data ;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.WHITE);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	public void run() {
		while (true) {
			try {
			} catch (Exception e) {
			}
		}
	}
	
	
	public void Pclient() throws Exception {
		try {
		ia = InetAddress.getByName("Localhost");
		soc = new Socket(ia, 12345);
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));
		br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		Thread th = new Thread(this);
		th.start();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	      EventQueue.invokeLater(new Runnable() {
	          public void run() {
	             try {
	                pos frame = new pos();
	                frame.setVisible(true);
	             } catch (Exception e) {
	                e.printStackTrace();
	             }
	          }
	       });

	}
	
	
	/**
	 * Create the frame.
	 */
	public pos() {
		if (list != null) { 
			
			for (menuDTO i : list) { 
				menu [count] = i.getMenuName();
				count++;
			}
			for (menuDTO z : list) { 
				price[cou] = z.getMenuPrice();
				cou++;
			}
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1389, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uAD00\uB9AC");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBounds(170, 10, 90, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC810\uD3EC\uBA85");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_1.setBounds(22, 71, 90, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uC810\uC8FC\uBA85");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_3.setBounds(264, 79, 90, 27);
		contentPane.add(lblNewLabel_3);
		
		txtpos = new JTextField();
		txtpos.setText("\uC11C\uC6D0POS\uC810");
		txtpos.setBounds(110, 79, 116, 21);
		contentPane.add(txtpos);
		txtpos.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("\uC774\uB2E4\uD615");
		textField_2.setColumns(10);
		textField_2.setBounds(378, 79, 116, 21);
		contentPane.add(textField_2);

		table = new JTable(model);
		table.setBounds(34, 174, 521, 145);
		contentPane.add(table);
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\pic\\KakaoTalk_20211206_040454951.png"));
		lblNewLabel_5.setBounds(22, 350, 144, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\pic\\KakaoTalk_20211206_040454827.png"));
		lblNewLabel_5_1.setBounds(22, 404, 144, 35);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon("C:\\pic\\KakaoTalk_20211206_040455059.png"));
		lblNewLabel_5_2.setBounds(22, 461, 144, 35);
		contentPane.add(lblNewLabel_5_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 350, 135, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(178, 404, 135, 35);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\pic\\KakaoTalk_20211206_040453939.png"));
		btnNewButton.setBounds(336, 351, 97, 145);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\pic\\KakaoTalk_20211206_040454122.png"));
		btnNewButton_1.setBounds(458, 350, 97, 146);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2.setBounds(774, 404, 55, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("2");
		btnNewButton_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(829, 404, 55, 51);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("3");
		btnNewButton_2_2.setToolTipText("3");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_2.setBounds(885, 404, 55, 51);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("<-");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_3.setBounds(941, 404, 55, 51);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_3_1 = new JButton("CLR");
		btnNewButton_2_3_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		btnNewButton_2_3_1.setBounds(941, 461, 55, 51);
		contentPane.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_2_1 = new JButton("6");
		btnNewButton_2_2_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_2_1.setBounds(885, 461, 55, 51);
		contentPane.add(btnNewButton_2_2_1);
		
		JButton btnNewButton_2_4 = new JButton("4");
		btnNewButton_2_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_4.setBounds(774, 461, 55, 51);
		contentPane.add(btnNewButton_2_4);
		
		JButton btnNewButton_2_1_1 = new JButton("5");
		btnNewButton_2_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_1_1.setBounds(829, 461, 55, 51);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_3_2 = new JButton(".");
		btnNewButton_2_3_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_3_2.setBounds(941, 522, 55, 51);
		contentPane.add(btnNewButton_2_3_2);
		
		JButton btnNewButton_2_2_2 = new JButton("9");
		btnNewButton_2_2_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_2_2.setBounds(885, 522, 55, 51);
		contentPane.add(btnNewButton_2_2_2);
		
		JButton btnNewButton_2_5 = new JButton("7");
		btnNewButton_2_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_5.setBounds(774, 522, 55, 51);
		contentPane.add(btnNewButton_2_5);
		
		JButton btnNewButton_2_1_2 = new JButton("8");
		btnNewButton_2_1_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_1_2.setBounds(829, 522, 55, 51);
		contentPane.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_3_3 = new JButton("00");
		btnNewButton_2_3_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_3_3.setBounds(941, 580, 55, 51);
		contentPane.add(btnNewButton_2_3_3);
		
		JButton btnNewButton_2_2_3 = new JButton("0");
		btnNewButton_2_2_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_2_3.setBounds(885, 580, 55, 51);
		contentPane.add(btnNewButton_2_2_3);
		
		JButton btnNewButton_2_6 = new JButton("\uD655\uC778");
		btnNewButton_2_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnNewButton_2_6.setBounds(774, 580, 110, 51);
		contentPane.add(btnNewButton_2_6);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(178, 461, 135, 35);
		contentPane.add(textArea);
		
		textField_6 = new JTextField();
		textField_6.setBounds(774, 350, 222, 35);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		int a = 20000;
		int b = 16000;
		JButton btnNewButton_3_2 = new JButton("ÁÖ¹®¿Ï·á");
		btnNewButton_3_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mo = textField_3.getText();
				String to= textField_4.getText();
				int a = Integer.parseInt(mo);
				int b = Integer.parseInt(to);
				int c = a - b;
				String g = String.valueOf(c);
				textArea.append(g);
					
				try {	
					
					Pclient();// ¹öÆÛ¿¡ ÀúÀåµÈ °ªÀ» ¼ÒÄÏ¿¡ ÀúÀåÇÏ¿© ¼­¹ö¿¡ º¸³»´Â ¸Þ¼Òµå
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					Object temp = table.getValueAt(row,col); // Å×ÀÌºí¿¡ ÀúÀåµÈ °ªÀ» ¹Þ¾Æ¿È
					String r = temp.toString(); // ¹Þ¾Æ¿Â °ªÀ» ¹®ÀÚ¿­·Î º¯È¯ ÇÔ*/
					pw.println(r); 				// ÀúÀå µÈ ¹®ÀÚ¿­À» ÀúÀå
					pw.flush();					// ÀúÀåÇÏ¿© ¹öÆÛ¿¡ Ãß°¡ 
				
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
			}
		});
		btnNewButton_3_2.setIcon(new ImageIcon("C:\\Users\\pinkp\\Desktop\\\uACB0\uC81C.png"));
		btnNewButton_3_2.setBounds(1037, 350, 256, 277);
		contentPane.add(btnNewButton_3_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(707, 76, 586, 257);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("½Ä»ç·ù", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton_4 = new JButton(menu[0]);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				order(0,0);
			}
		});
		btnNewButton_4.setBounds(23, 10, 121, 70);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton(menu[1]);
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order(1,1);
			}
		});
		btnNewButton_4_1.setBounds(169, 10, 121, 70);
		panel.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton(menu[2]);
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				order(2,2);
			}
		});
		btnNewButton_4_2.setBounds(317, 10, 121, 70);
		panel.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3 = new JButton(menu[3]);
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				order(3,3);
			}
		});
		btnNewButton_4_3.setBounds(450, 10, 121, 70);
		panel.add(btnNewButton_4_3);
		
		JButton btnNewButton_4_4 = new JButton(menu[4]);
		btnNewButton_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				order(4,4);
			}
		});
		btnNewButton_4_4.setBounds(23, 101, 121, 70);
		panel.add(btnNewButton_4_4);
		
		JButton btnNewButton_4_5 = new JButton(menu[5]);
		btnNewButton_4_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				order(5,5);
			}
		});
		btnNewButton_4_5.setBounds(169, 101, 121, 70);
		panel.add(btnNewButton_4_5);
		
		JButton btnNewButton_4_6 = new JButton(menu[6]);
		btnNewButton_4_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				order(6,6);
			}
		});
		btnNewButton_4_6.setBounds(317, 101, 121, 70);
		panel.add(btnNewButton_4_6);
		
		JButton btnNewButton_4_7 = new JButton(menu[7]);
		btnNewButton_4_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						order(7,7);
			}
		});
		btnNewButton_4_7.setBounds(450, 101, 121, 70);
		panel.add(btnNewButton_4_7);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("»çÀÌµå", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("À½·á", null, panel_2, null);
		
		JLabel lblNewLabel_6 = new JLabel("\uC0C1\uD488\uBA85");
		lblNewLabel_6.setBounds(93, 150, 55, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uAC00\uACA9");
		lblNewLabel_7.setBounds(281, 156, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uAC1C\uC218");
		lblNewLabel_8.setBounds(453, 156, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(34, 153, 174, 21);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(204, 153, 180, 21);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(377, 153, 178, 21);
		contentPane.add(textField_9);
	}
	public void order(int a, int b) {
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		m.addRow(new Object[]{menu[a],price[b],1});
		int rowCont = table.getRowCount();
		int sum =0;
		for(int i=0;i<rowCont;i++) {
			sum += (int)table.getValueAt(i, 1);
		}
		textField_4.setText(String.valueOf(sum));
	}
}

