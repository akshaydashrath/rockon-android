package org.abrantes.filex;

import org.abrantes.filex.utils.Constants;
import org.abrantes.filex.utils.RockOnPreferenceManager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class PlayerServiceConnection implements ServiceConnection{

	Filex filex;
	PlayerServiceConnection(Filex filex){
		this.filex = filex;
	}
	
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		Log.i("SCONN", "Service connected");
		
		if(filex == null || service == null){
			Log.i("SCONN", "But failed to get service interface for some reason");
			return;
		}
		
		filex.playerServiceIface = PlayerServiceInterface.
										Stub.
											asInterface(service);
		/*
		 * Set some preferences
		 */
		RockOnPreferenceManager prefs = (new RockOnPreferenceManager(filex.FILEX_PREFERENCES_PATH));
		try{
			filex.playerServiceIface.setRecentPeriod(
					prefs
						.getInt(filex.constants.PREF_KEY_RECENT_PERIOD, filex.constants.RECENT_PERIOD_DEFAULT_IN_DAYS));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Set Shuffle
		 */
		try{
			filex.playerServiceIface.setShuffle(filex.SHUFFLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Set Scrobbling
		 */
		try{
//			Log.i("SCRBLREADING", ""+filex.getSharedPreferences(Filex.PREFS_NAME, 0)
			Log.i("SCRBLREADING", ""+prefs
									.getBoolean(Filex.PREFS_SCROBBLE_DROID, false));
			filex.playerServiceIface.setScrobbleDroid((boolean)
//					filex.getSharedPreferences(Filex.PREFS_NAME, 0)
					prefs
					.getBoolean(Filex.PREFS_SCROBBLE_DROID, false));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Set the playlist of the service
		 */
		try {
			filex.playerServiceIface.setPlaylist(filex.playlist);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * Reset albumCursor of the Service
		 */
		try {
			filex.playerServiceIface.resetAlbumCursor();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		/*
		 * Get whatever the service is playing
		 */
		filex.getCurrentPlaying();
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		// TODO Auto-generated method stub
		
	}
	
}