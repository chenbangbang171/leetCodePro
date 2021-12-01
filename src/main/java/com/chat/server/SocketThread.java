package main.java.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
	Socket socket;
	BufferedReader br = null;
	PrintWriter pw = null;

	public SocketThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")));
			String str = "";

			while ((str = br.readLine()) != null) {
				String[] commands = str.split("\\|");

				File f = new File("D:/聊天记录/record.txt");
				// @3 追加+ 编码
				OutputStream out = new FileOutputStream(f, true);
				// 此处一定注意设置的编码格式与文件本身的编码格式是相同的，否则出现乱码
				OutputStreamWriter sw = new OutputStreamWriter(out, "utf-8");// 字符流
				PrintWriter pw = new PrintWriter(sw);

				if (commands[0].equals("LOGIN")) {
					String sUSER = commands[1];
					this.setName(sUSER);// 将用户名信息放入Thread当中
					ServerMG.getServerMG().getOnlineNames(this);// 将在线用户发送给新上线用户

					ServerMG.getServerMG().sendNewUsertoAll(this);// 将新用户发送给老用户

					ServerMG.getServerMG().addList(this);// 把信息添入用户列表中

				} else if (commands[0].equals("MSG")) {
					String SenderName = commands[1];
					String RecName = commands[2];
					String MSGinfo = commands[3];

					if (RecName.equals("ALL")) {
						String sMSG = "MSG|" + SenderName + "|" + MSGinfo;

						ServerMG.getServerMG().sendMsgtoAll(sMSG, this);

						ServerMG.getServerMG().setLogTxt(SenderName + "发送消息[" + MSGinfo + "]到" + RecName);
						pw.println(SenderName + "群发送消息[" + MSGinfo + "]到");// 将发送的消息写入聊天记录文件
						pw.flush();
					} else {

						SocketThread sc = ServerMG.getServerMG().getServerCharByName(RecName);
						if (sc != null) {
							String sMSG = "MSG|" + SenderName + "|" + MSGinfo;
							// ServerMG.getServerMG().sendMSG(sMSG,sc);
							sc.sendMSG(sMSG);
							// 写入消息日志
							ServerMG.getServerMG().setLogTxt(SenderName + "发送消息[" + MSGinfo + "]到" + RecName);
							pw.println(SenderName + "发送消息[" + MSGinfo + "]");// 将发送的消息写入聊天记录文件
							pw.flush();
						}
					}
				} else if (commands[0].equals("OFFLINE")) {
					String strName = commands[1];
					ServerMG.getServerMG().sendOfflineUsertoAll(this);
					ServerMG.getServerMG().removeList(this);

					break;
				}

				if (sw != null)
					sw.close();
				if (out != null)
					out.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (socket != null)
					socket.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
			// TODO: handle finally clause
		}

	}

	public void closeChat() {
		try {
			if (br != null)
				br.close();
			if (pw != null)
				pw.close();
			if (socket != null)
				socket.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		// TODO: handle finally clause
	}

	public void sendMSG(String str) {
		pw.println(str);
		pw.flush();
	}
}
