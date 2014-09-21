/** 
 * SFTP connection data and available operations
 * Facade for jsch library
 * 
 * @author      Markus Rührmair 
 * @date 		21.09.2014
 */
package de.shiftingbytes.sftputil;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class SftpConnection {


	
	private String host;
	private String user;
	private String password;
	private int port = 0;
	private String errorDescription;
	
	private String localFilename;
	private String remoteFilename;
	
	
	private SftpService sftp;
	
	
	public SftpConnection(){
		
		this.sftp = new SftpService();
		
	}
	
	public String get(){
		String result = null;
		
		try{
			this.sftp.setConnectionConf(this);
			sftp.connect();
			InputStream initialStream = sftp.getOperation();
			
		
			File targetFile = new File(this.localFilename);
		
			
			FileUtils.copyInputStreamToFile(initialStream, targetFile);
			result = targetFile.getName();
			sftp.disconnect();
			 
			
		}
		catch(Exception e)
		{
			this.errorDescription = e.getLocalizedMessage();
			result = this.errorDescription;
			
		}
		return result;
	}
	
	public void put(){
		
		
	}
	
	public void delete(){
		
		
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public String getRemoteFilename() {
		return remoteFilename;
	}

	public void setRemoteFilename(String remoteFilename) {
		this.remoteFilename = remoteFilename;
	}

	public String getLocalFilename() {
		return localFilename;
	}

	public void setLocalFilename(String localFilename) {
		this.localFilename = localFilename;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
}
