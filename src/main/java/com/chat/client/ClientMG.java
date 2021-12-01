package main.java.chat.client;

import java.net.Socket;

public class ClientMG {
	private static final ClientMG clientmg = new ClientMG();
	private ClientMG() {};
	public static ClientMG getClientMG() {
		return clientmg;
	}
	
	private ClientForm clientWin;
	public void setClientForm(ClientForm c) {
		clientWin = c;
	}
	
	public void setLogtxt(String str) {
		clientWin.textLog.append(str+"\r\n");
	}
	
	public void addItem(String user) {
		clientWin.itemUsers.addElement(user);
	} 
	
	public void addItems(String[] users) {
		for(int i=0;i<users.length;i++){
			clientWin.itemUsers.addElement(users[i]);
		}
	}
	
	public void removeItem(String sNname) {
		clientWin.itemUsers.removeElement(sNname);
	}
	
	
	public void clearItems() {
		clientWin.itemUsers.clear();
	}
	
	SocketThread sthd =null;
	public boolean Connect(String IP,int port,String user) {
		Socket socket = null;
		try {
			socket = new Socket(IP,port);
			System.out.println(socket);
			sthd= new SocketThread(socket, user);
			sthd.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public SocketThread getClientThd() {
		return sthd;
	}
	
	
	
}
