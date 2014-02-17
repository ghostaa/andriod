package com.ghost.games.numberhero.activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ghost.games.numberhero.file.FileService;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class FileTest  extends AndroidTestCase{
	private static final String TAG="FileService";
	public void testSave() throws IOException{
		OutputStream outputStream  = this.getContext().openFileOutput("version", Context.MODE_PRIVATE);
		FileService service=new FileService();
		service.save(outputStream, "content");
	
	}
	public void testRead() throws IOException{
		InputStream inputStream = this.getContext().openFileInput("version");
		FileService service=new FileService();
		String content = service.read(inputStream);
		Log.i(TAG, content);
	}
	public void testReadVersionFile() throws IOException{
		InputStream inputStream = this.getContext().getAssets().open("version");
		FileService service=new FileService();
		String content = service.read(inputStream);
		inputStream.close();
		this.getContext().getAssets().close();
		Log.i(TAG, content);
	} 
}
