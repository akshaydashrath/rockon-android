package org.abrantes.filex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;


public class MediaButtonPauseIntentReceiver	extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MEDIABUTTONPAUSE", "pausetriggered");
		Filex filex =((Filex) context);
		try {
			TransitionDrawable playPauseTDrawable = (TransitionDrawable) filex.playPauseImage.getDrawable();
			playPauseTDrawable.setCrossFadeEnabled(true);
			playPauseTDrawable.reverseTransition(500);
			playPauseTDrawable.invalidateSelf();
			
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 150);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 300);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 450);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 600);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 750);
			
			filex.stopSongProgress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}