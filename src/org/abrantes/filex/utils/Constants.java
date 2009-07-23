package org.abrantes.filex.utils;

public class Constants{
	/*
	 * Preferences
	 */
	public final String PREFS_DIR = "/sdcard/RockOn/preferences/";
	public final String PREFS_NAME = "RockOnPreferences";
	
	/*
	 * Settings categories
	 */
    private String KEY_SETTINGS_CATEGORY_PARENT = "parent";
    private String KEY_SETTINGS_CATEGORY_PLAYLIST = "playlist";
    
    /*
     * Settings ScrobbleDroid
     */
//    public static final String KEY_PREFERENCE_SCROBBLE_DROID = "scrobble_droid";
//    public static final String KEY_TOGGLE_SCROBBLE_DROID = "scrobble_droid";

    /*
     * Last song keys
     */
    public final String KEY_PREFERENCE_LAST_ALBUM = "last_album";
    public final String KEY_PREFERENCE_LAST_SONG = "last_song";
    public final String KEY_PREFERENCE_LAST_SONG_POSITION = "last_song_position";
	
	/*
	 * Playlist Stuff
	 */
	public final String PREF_KEY_PLAYLIST = "Playlist";

	public final long PLAYLIST_ALL = -1;	
	public final long PLAYLIST_RECENT = -2;	
	public final long PLAYLIST_NONE = -500;	

	/*
	 * Intents
	 */
	public final String		MUSIC_CHANGED = "org.abrantes.filex.intent.action.MUSIC_CHANGED";  
    public final String		ALBUM_CHANGED = "org.abrantes.filex.intent.action.ALBUM_CHANGED";
    public final String		MEDIA_BUTTON_PAUSE = "org.abrantes.filex.intent.action.MEDIA_BUTTON_PAUSE";  
    public final String		MEDIA_BUTTON_PLAY = "org.abrantes.filex.intent.action.MEDIA_BUTTON_PLAY";
    
	
	/*
	 * Recent Songs Stuff
	 */
	public final String PREF_KEY_RECENT_PERIOD = "recent_period";
	
	public final int RECENT_PERIOD_DEFAULT_IN_DAYS = 15;
	
	/*
	 * Activity Codes
	 */
	public final int PREFERENCES_REQUEST = 1;
	
	/*
	 * Interaction Intervals
	 */
	public final double DOUBLE_CLICK_INTERVAL = 700;

}
