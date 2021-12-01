package main.java.chat.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ClientForm extends JFrame {

	public JPanel contentPane;
	public JTextField txtIP;
	public JTextField txtPort;
	public JTextField userName;
	public JTextArea textLog;
	public JList listUser;
	public JTextArea textSend;

	/**
	 * Launch the application.
	 */
	
	DefaultListModel<String>  itemUsers;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm frame = new ClientForm();
					frame.setVisible(true);
					ClientMG.getClientMG().setClientForm(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 658, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(14, 33, 72, 18);
		panel.add(lblIp);
		panel.setBorder(BorderFactory.createTitledBorder("配置信息"));
		
		txtIP = new JTextField();
		txtIP.setText("192.168.1.4");
		txtIP.setBounds(47, 30, 107, 24);
		panel.add(txtIP);
		txtIP.setColumns(10);
		
		JLabel label = new JLabel("端口：");
		label.setBounds(168, 33, 72, 18);
		panel.add(label);
		
		txtPort = new JTextField();
		txtPort.setText("8800");
		txtPort.setBounds(215, 30, 86, 24);
		panel.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setBounds(310, 33, 72, 18);
		panel.add(label_1);
		
		userName = new JTextField();
		userName.setText("czj");
		userName.setBounds(368, 32, 86, 24);
		panel.add(userName);
		userName.setColumns(10);
		
		JButton Loginbtn = new JButton("登录");
		Loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//连接服务器
				String IP= txtIP.getText().trim();
				int port = Integer.parseInt(txtPort.getText().trim());
				String user = userName.getText().trim();
				if(ClientMG.getClientMG().Connect(IP, port, user)) {
					ClientMG.getClientMG().setLogtxt("连接到服务...");
				}else {
					ClientMG.getClientMG().setLogtxt("连接服务器失败！");
				}
				
			}
		});
		Loginbtn.setBounds(477, 29, 68, 27);
		panel.add(Loginbtn);
		
		JButton Closebtn = new JButton("关闭");
		Closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出连接
				String SenderName = ClientMG.getClientMG().getClientThd().getName();
				 String strSend = "OFFLINE|"+SenderName;
				ClientMG.getClientMG().getClientThd().sendMSG(strSend);
				ClientMG.getClientMG().clearItems();
				ClientMG.getClientMG().setLogtxt("断开连接");  
			}
		});
		Closebtn.setBounds(565, 30, 67, 27);
		panel.add(Closebtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(11, 106, 334, 404);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 textLog = new JTextArea();
		textLog.setBounds(14, 25, 306, 366);
		panel_1.add(textLog);
		panel_1.setBorder(BorderFactory.createTitledBorder("聊天记录"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(359, 106, 286, 404);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder("在线用户"));
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(14, 512, 631, 171);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		 textSend = new JTextArea();
		textSend.setBounds(14, 25, 603, 87);
		panel_3.add(textSend);
		panel_3.setBorder(BorderFactory.createTitledBorder("操作"));
		
		JButton Sendsbtn = new JButton("群发");
		Sendsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String SenderName = ClientMG.getClientMG().getClientThd().getName();
				String RecName = "ALL";
				String MSGinfo  = textSend.getText().trim(); 
				String sMSG = "MSG|"+SenderName+"|"+RecName+"|"+MSGinfo;
				
				
				ClientMG.getClientMG().getClientThd().sendMSG(sMSG);
				 
				 ClientMG.getClientMG().setLogtxt("[我]: ");
				 ClientMG.getClientMG().setLogtxt(MSGinfo);
				 textSend.setText("");
				 
			
			}
		});
		Sendsbtn.setBounds(435, 131, 84, 27);
		panel_3.add(Sendsbtn);
		
		JButton Sendbtn = new JButton("发送");
		Sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//发送消息
				//获取选择的用户名称
				//组织交互协议串，发送给服务器端
				String SenderName = ClientMG.getClientMG().getClientThd().getName();
				String RecName = listUser.getSelectedValue().toString();
				String MSGinfo  = textSend.getText().trim();
				String sMSG = "MSG|"+SenderName+"|"+RecName+"|"+MSGinfo;
				ClientMG.getClientMG().getClientThd().sendMSG(sMSG);
			
			
				 ClientMG.getClientMG().setLogtxt("[我]: ");
				 ClientMG.getClientMG().setLogtxt(MSGinfo);
				 textSend.setText("");
			}
		});
		Sendbtn.setBounds(533, 131, 84, 27);
		panel_3.add(Sendbtn);
		
		itemUsers = new DefaultListModel<String>();
		listUser = new JList(itemUsers);
		listUser.setBounds(14, 24, 258, 367);
		panel_2.add(listUser);
		 
	}
}
