package main.java.chat.server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerForm extends JFrame {

	public JPanel contentPane;
	public JTextField txtPort;
	public JTextArea txtLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
					ServerMG.getServerMG().setServerForm(frame);//把当前窗体对象注册到管理类中
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(75, 0, -65, 10);
		contentPane.add(panel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 457, 94);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("配置信息"));
		
		JLabel label = new JLabel("端口:");
		label.setBounds(14, 37, 72, 18);
		panel_1.add(label);
		
		txtPort = new JTextField();
		txtPort.setText("8800");
		txtPort.setBounds(56, 34, 86, 24);
		panel_1.add(txtPort);
		txtPort.setColumns(10);
		
		JButton button = new JButton("开启服务");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//开启服务
				int port = Integer.parseInt(txtPort.getText().trim());//服务器监听端口
				if(ServerMG.getServerMG().CreateServer(port)) {
					ServerMG.getServerMG().setLogTxt("服务器开启...");
					
					
				}else {
					ServerMG.getServerMG().setLogTxt("服务器开启失败！");
				}
				
			}
		});
		button.setBounds(184, 33, 113, 27);
		panel_1.add(button);
		
		JButton button_1 = new JButton("关闭服务");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//关闭服务
				ServerMG.getServerMG().CloseServer();
				
			}
		});
		button_1.setBounds(311, 33, 113, 27);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 107, 457, 361);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createTitledBorder("消息记录"));
		
		txtLog = new JTextArea();
		txtLog.setLineWrap(true);
		txtLog.setBounds(14, 26, 429, 319);
		panel_2.add(txtLog);
	}
}
