package main.java.chat.server;
import java.net.*;


public class ServerListenner extends Thread{
	Socket socket=null;
	ServerSocket server = null;
	public ServerListenner(ServerSocket server) {
		this.server=server;
	}
	
	public void run() {
		try {
			while(true) {
				socket = server.accept();
				//主界面的信息显示
				ServerMG.getServerMG().setLogTxt("客户端："+socket);
				 
				//开启新线程进行通讯
				new SocketThread(socket).start();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
