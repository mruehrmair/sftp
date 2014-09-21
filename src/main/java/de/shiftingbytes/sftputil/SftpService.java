
/** 
 * SFTP service class using jsch library
 * 
 * @author      Markus Rührmair 
 * @date 		21.09.2014
 */



package de.shiftingbytes.sftputil;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpService {
	
	
	
	
	private static int DEFAULTPORT = 22;
	private SftpConnection connectionConf;
	
	private ChannelSftp channel;
	private Session session;
	
	public SftpConnection getConnectionConf() {
		return connectionConf;
	}

	public void setConnectionConf(SftpConnection connectionConf) {
		this.connectionConf = connectionConf;
	}
	
	public SftpService()
	{
		
		
	}
	
	
	public void connect() throws JSchException{
		
		
		
		JSch jsch=new JSch();
		int port = this.connectionConf.getPort()>0 ? this.connectionConf.getPort() : DEFAULTPORT; 
		Session session=jsch.getSession(this.connectionConf.getUser(),this.connectionConf.getHost() , port);
		session.setPassword(this.connectionConf.getPassword());
		
		java.util.Properties config = new java.util.Properties(); 
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		
		this.session = session;
		this.session.connect();
		
		
		
		
        Channel channel=session.openChannel("sftp");
        channel.connect();
        ChannelSftp c=(ChannelSftp)channel;
        this.channel = c;
		
	}
	
	
	public void disconnect()
	{
		this.session.disconnect();
	}
	
	
	
	
	public InputStream getOperation() throws SftpException{
		
		InputStream is = this.channel.get(this.connectionConf.getRemoteFilename());
		
		return is;
			
		
	}
	
	

	
	
}

