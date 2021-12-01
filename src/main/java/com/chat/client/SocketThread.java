package main.java.chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread{
	Socket socket=null;
	BufferedReader br= null;
	PrintWriter pw= null;
	public SocketThread(Socket socket,String user) {
		super(user);//登录时用的用户名
		this.socket=socket;
	}
	
	public void run() {
		try {
			br = new BufferedReader( new InputStreamReader(socket.getInputStream(),"UTF-8"));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8")));
			String str = "";
			String sLOGIN="LOGIN|"+this.getName();
			sendMSG(sLOGIN);
			
			while((str=br.readLine())!=null) { 
				 String [] commands = str.split("\\|");
				 if(commands[0].equals("USERLISTS")){
					 String [] sUsers = commands[1].split("\\_");
					 ClientMG.getClientMG().addItems(sUsers);
					 
				 }else if(commands[0].equals("ADD")){
					 String sNewUser = commands[1];
					 ClientMG.getClientMG().addItem(sNewUser);
				 }else if(commands[0].equals("MSG")) {
					 String SenderName = commands[1];
					 String MSGinfo = commands[2];	
					 ClientMG.getClientMG().setLogtxt("["+SenderName+"] ");
					 ClientMG.getClientMG().setLogtxt(MSGinfo);
					 
					
					 
					  
				 }else if(commands[0].equals("DEL")) {
					 String sName = commands[1];
					 ClientMG.getClientMG().removeItem(sName);
					 ClientMG.getClientMG().setLogtxt(sName+"下线了");
				 }else if(commands[0].equals("CLOSE")) {
					 ClientMG.getClientMG().clearItems();
					 ClientMG.getClientMG().setLogtxt("服务器已关闭！");
					 
					 break;
				 }
				 
				 
				 
				//ClientMG.getClientMG().setLogtxt(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
				if(pw!=null)pw.close();
				if(socket!=null)socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void sendMSG(String str) {
		pw.println(str);
		pw.flush(); 
	}

}
