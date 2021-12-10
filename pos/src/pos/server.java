package pos;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

class server extends JFrame {
	private Container con;
	private ServerSocket ss;
	private Socket soc;
	private PrintWriter pw;
	private BufferedReader br;
	private Scanner sc;
	private ArrayList al = new ArrayList();
	private TextArea ta = new TextArea();
	private TextArea ta2 = new TextArea(5, 30);
	int sum = 0;
	public void init() {
		con = this.getContentPane(); // JFrame 위에 Container를 올린다.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x를 누르면 클로즈 시킨다.
		con.setLayout(new BorderLayout());
		con.add("Center", ta);
		con.add("South", ta2);
	}
	
	public server() throws Exception {
		
		this.setSize(400, 300);
		init();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = (int) (screen.getWidth() / 2 - this.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - this.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setVisible(true);
		ss = new ServerSocket(12345);
		sc = new Scanner(System.in);
		while (true) {
			soc = ss.accept();
			JCustomer cc = new JCustomer(soc);
			cc.start();
			}
	}
	class JCustomer extends Thread {
		Socket soc;
		JCustomer(Socket soc) {
			this.soc = soc;
		}
		
		public void run() {
			while (true) {
				try {
					br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					String msg1 = br.readLine();
					String son = "" + msg1.charAt(0);
					String msg = msg1.substring(1);
					String temp = "";
					ta.append(msg1 + "\n");
					
				} catch (Exception e) {
				}
			}
		}
	}
	}
	
	