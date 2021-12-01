package main.java.chat.server;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class ServerMG {
	private static final ServerMG servermg = new ServerMG();
	private ServerMG() {}
	public static ServerMG getServerMG() {
		return servermg;
	}
	
	//主界面操作
	private	ServerForm serverwin;
	//将窗体对象注册到管理类中
	public void setServerForm(ServerForm s) {
		serverwin=s;
	}
	//主界面日志框的文本内容
	public void setLogTxt( String str) {
		serverwin.txtLog.append(str+"\n\r");
	}
	
	
	//ServerSocket操作
	private  ServerSocket server;
	
	public boolean CreateServer(int port) {
		try {
			server = new ServerSocket(port);
			//开启监听
			new ServerListenner(server).start();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	 public void CloseServer() {
		 sendClosetoAll();
		 closeAllChat();
		 clearList();
		 try {
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	
	
	//Arraylist操作
	
	ArrayList<SocketThread> alOnlineList = new ArrayList<>();//存放所有歌服务器连接的客户端信息
	public synchronized void addList(SocketThread sc){
		alOnlineList.add(sc);
	}
	public  void clearList() {
		alOnlineList.clear();   
	}  
	
	
	public synchronized void removeList (SocketThread sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s =alOnlineList.get(i);
			if(s.equals(sc)) {
				alOnlineList.remove(sc);
				break;
			}
		}
	}
	
	
	//信息管理
	
	public void getOnlineNames(SocketThread sc) {
		if(alOnlineList.size()>0) {
		String sUsers = "";
		for(int i=0;i<alOnlineList.size();i++) {  
			SocketThread s = alOnlineList.get(i);
			sUsers+=s.getName()+ "_";
			}
		sc.sendMSG("USERLISTS|"+sUsers);
		}
	}
	
	public void sendNewUsertoAll(SocketThread sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s=alOnlineList.get(i);
			s.sendMSG("ADD|"+sc.getName());
		}
	}

	public SocketThread getServerCharByName(String sName) {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s =alOnlineList.get(i);
			if(s.getName().equals(sName)) {
				return s;
			}
		}
		return null;
	}
	
	public void sendMsgtoAll(String sMSG,SocketThread sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s = alOnlineList.get(i);
			if(!s.equals(sc)) {
				s.sendMSG(sMSG);
			}
		}
	}
	
	public void sendOfflineUsertoAll(SocketThread sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s = alOnlineList.get(i);
			if(!s.equals(sc)) {
				s.sendMSG("DEL|"+sc.getName());
			}
		}
	}
	
	public void sendClosetoAll() {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s = alOnlineList.get(i);
			s.sendMSG("CLOSE");
		}
	}
	
	public void closeAllChat() {
		for(int i=0;i<alOnlineList.size();i++) {
			SocketThread s = alOnlineList.get(i);
			s.closeChat();
		}
	}
	
	
}
