package com.ghost.games.numberhero.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
public class FileService {
	public void save(OutputStream outputStream,String content) throws IOException{
		outputStream.write(content.getBytes());
		outputStream.close();
	}
	public String read(InputStream inputStream) throws IOException{
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		byte[] buffer=new byte[1024];
		int len;
		while ((len=inputStream.read(buffer))!=-1) {
			outputStream.write(buffer,0,len);
		}
		byte[] data=outputStream.toByteArray();
		outputStream.close();
		inputStream.close();
		return new String(data);
	}
}
