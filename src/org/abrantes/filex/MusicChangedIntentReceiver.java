package org.abrantes.filex;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.graphics.drawable.TransitionDrawable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;


public class MusicChangedIntentReceiver	extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MUSICINTENT", "musicChanged");
		Filex filex =((Filex) context);
		
		
		try {
			/*
			 * Destroy song Progress Dialog if on screen
			 */
			try{
				if(filex.songProgressAlertDialog != null){
					/*
					 * dismiss (And remove) the song progress dialog
					 */
					filex.dismissDialog(R.layout.song_progress_dialog);
					filex.removeDialog(R.layout.song_progress_dialog);
					filex.songProgressAlertDialog = null;
					filex.songProgressView = null;
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			
			/*
			 * UpdateAlbumCursor
			 */
			filex.albumCursor.moveToPosition(
					filex.playerServiceIface.getAlbumCursorPosition());
			
			/*
			 * Update Song Cursor
			 */
			filex.songCursor = filex.initializeSongCursor(
					filex.albumCursor.getString(
							filex.albumCursor.getColumnIndexOrThrow(
									MediaStore.Audio.Albums.ALBUM)));
			filex.songCursor.moveToPosition(
					filex.playerServiceIface.getSongCursorPosition());
			
			/*
			 * Update Song UI
			 */
			filex.songProgressBar.setProgress(0);
			filex.songProgressBar.setMax((int) filex.songCursor.getDouble(
												filex.songCursor.getColumnIndex(
														MediaStore.Audio.Media.DURATION)));
			filex.updateSongTextUI();
			filex.triggerSongProgress();
			
			/*
			 * playPauseButton
			 */
//			TransitionDrawable playPauseTDrawable = (TransitionDrawable) filex.playPauseImage.getDrawable();
//			playPauseTDrawable.setCrossFadeEnabled(true);
//			playPauseTDrawable.startTransition(1);
//			playPauseTDrawable.invalidateSelf();
		
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CursorIndexOutOfBoundsException e){
			e.printStackTrace();
			
			// TODO: Maybe resync service and frontend cursors....
			
			try{
				filex.initializeAlbumCursor();
				filex.albumCursor.moveToNext();
				filex.initializeSongCursor(
						filex.albumCursor.getString(
								filex.albumCursor.getColumnIndexOrThrow(
										MediaStore.Audio.Albums.ALBUM)));
			}catch(Exception ee){
				ee.printStackTrace();
			}
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	
}