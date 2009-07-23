package org.abrantes.filex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;


public class MediaButtonPlayIntentReceiver	extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("MEDIABUTTONPLAY", "playtriggered");
		Filex filex =((Filex) context);
		try {
			TransitionDrawable playPauseTDrawable = (TransitionDrawable) filex.playPauseImage.getDrawable();
			playPauseTDrawable.setCrossFadeEnabled(true);
			playPauseTDrawable.startTransition(500);
			playPauseTDrawable.invalidateSelf();
			
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 150);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 300);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 450);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 600);
			filex.invalidateCurrentSongLayout.sendEmptyMessageDelayed(0, 750);
			
			filex.triggerSongProgress();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}