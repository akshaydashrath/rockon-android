package org.abrantes.filex;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;

/********************************
 * 
 * Definitions
 * @author fabrantes
 *
 ********************************/

/********************************
 * 
 * ShareSong class
 * 
 ********************************/
public class ShareSong{
	String songName = null;
	String albumName = null;
	String artistName = null;
	String songFilePath = null;
	Filex filex = null;
	
	public ShareSong(Context context, Cursor songCursor){
			filex = (Filex)context;
	
			try{
				songName = songCursor.getString(
							songCursor.getColumnIndex(
								MediaStore.Audio.Media.TITLE));
				albumName = songCursor.getString(
								songCursor.getColumnIndex(
									MediaStore.Audio.Media.ALBUM));
				artistName = songCursor.getString(
								songCursor.getColumnIndex(
									MediaStore.Audio.Media.ARTIST));
				songFilePath = songCursor.getString(
									songCursor.getColumnIndex(
											MediaStore.Audio.Media.DATA));
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void shareByMail(){
		String emailText = "Hey! Check these guys out... they are awesome!\n"+
							"\n"+
							"Recommendation:\n"+
							songName+" from "+artistName;
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, emailText);
		sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Music recommendation");
		//sendIntent.putExtra(Intent.EXTRA_STREAM, InputStream or URI);
		sendIntent.setType("message/rfc822");
		filex.startActivity(Intent.createChooser(sendIntent, "Choose Email Client")); 
	}
	
}