package de.shiftingbytes.sftputil;


public class RemoteToLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 SftpConnection conn = new SftpConnection();
		 conn.setHost("");
		 conn.setRemoteFilename("");
		 conn.setUser("");
		 conn.setPassword("");
		 //conn.setPort();
		 System.out.print(conn.get());
		 
		 
		 
	}

}
