package org.abrantes.filex;

import java.io.File;
import java.io.IOException;

import org.abrantes.filex.R.drawable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;



public class SongCursorAdapter extends SimpleCursorAdapter{
	private Cursor 				songCursor;
    private Context 			context;
    public int					viewWidth;
    public int					songInitialPosition;
    
    public SongCursorAdapter(Context context, 
    							int layout, 
    							Cursor c,
    							String[] from,
    							int[] to) 
    {
        super(context, layout, c, from, to);
        this.songCursor = c;
        this.context = context;
        this.songInitialPosition = c.getPosition();
        
        /*
         * Read the width of the Navigator
         */
//        viewWidth = (int) Math.floor(
//        				((SongFest) context).display.getWidth() * 
//        				((SongFest) context).NAVIGATOR_SCREEN_FRACTION
//        				);
//        params = new LayoutParams(LayoutParams.FILL_PARENT, viewWidth);
        
        /*
         * Create the Overlay Gradient
         */
//        overlayGradient = new GradientDrawable(GradientDrawable.Orientation.TL_BR,
//                								new int[] { 0x00000000, 
//        													0x22FFFFFF,
//        													0x00000000 });
//        overlayGradient.setGradientCenter((float) Math.floor(viewWidth * 0.75),
//        									(float) Math.floor(viewWidth * 0.75));
//        overlayGradient.setShape(GradientDrawable.RECTANGLE);
}

    /* (non-Javadoc)
     * This is where you actually create the item view of the list
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
    	/*
    	 * Get the item list text components and fill them
    	 */
//    	LinearLayout songLayout = 	(LinearLayout)
//    								view.findViewById(R.id.songlist_item_song_name_layout);
//    	TextView songName = 		(TextView)
//    								view.findViewById(R.id.songlist_item_song_name);
//    	TextView songDuration = 	(TextView)
//    								view.findViewById(R.id.songlist_item_song_duration);
//    	ImageView songPreview =		(ImageView)
//									view.findViewById(R.id.songlist_item_preview);
//    	ImageView songRecommend =	(ImageView)
//									view.findViewById(R.id.songlist_item_recommend);
//    	songPreview.setImageResource(android.R.drawable.ic_menu_rotate);
//    	songRecommend.setImageResource(android.R.drawable.ic_menu_send);
    	
    	TextView songName = 		(TextView)
			view.findViewById(R.id.songlist_item_song_name);
    	TextView songDuration = 	(TextView)
			view.findViewById(R.id.songlist_item_song_duration);
    	
    	songName.setText(cursor.getString(
				cursor.getColumnIndex(
						MediaStore.Audio.Media.TITLE)));
    	try{
    		double duration = new Double (cursor.getString(
    									cursor.getColumnIndex(
												MediaStore.Audio.Media.DURATION)));
	    	double minutes = Math.floor(duration / 1000 / 60);
	    	double seconds = duration / 1000 % 60;
	    	if(seconds > 10)
	    		songDuration.setText(String.valueOf((int)minutes)+":"+String.valueOf((int)seconds));
	    	else
	    		songDuration.setText(String.valueOf((int)minutes)+":0"+String.valueOf((int)seconds));
    	} catch (Exception e){
    		e.printStackTrace();
    		songDuration.setText("e:-e");
    	}
    	// Even
//    	try {
//			if(cursor.getPosition() == ((Filex) context).playerServiceIface.getSongCursorPosition()){
//				view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.song_bg_selected));
//			} else {
//				if(cursor.getPosition() % 2 == 0){
////    		view.setBackgroundColor(Color.argb(0, 0, 0, 0));
//					view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.song_bg_light));
////    		view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.song_bg));
//				//Odd	
//				} else {
//					//view.setBackgroundColor(Color.argb(33, 0, 0, 0));
////    		view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.song_bg_light));
//					view.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.song_bg));
//				}
//			}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		} catch (NotFoundException e) {
//			e.printStackTrace();
//		}
    	    	
    	/*
    	 * Add click listeners to each component
    	 */
    	//songName.setOnClickListener(this.songListSongClick);
    	//songLayout.setOnClickListener(this.songListSongClick);
    	//view.setOnClickListener(this.songListSongClick);
    	//songPreview.setOnClickListener(this.songListPreviewClick);
    	//songRecommend.setOnClickListener(this.songListRecommendClick);

//    	ImageView albumImage = 			(ImageView)
//    									view.findViewById(R.id.navigator_albumart_image);
//    	albumImage.setLayoutParams(params);
//    	
//    	ImageView albumImageOverlay = 	(ImageView)
//    									view.findViewById(R.id.navigator_albumart_overlay);
//    	//albumImageOverlay.setImageDrawable(overlayGradient);
//    	albumImageOverlay.setLayoutParams(params);
//    	
//		String albumCoverPath = cursor.getString(
//									cursor.getColumnIndex(
//											MediaStore.Audio.Albums.ALBUM_ART));
		/*
		 * If the album art exists put it in the listView, otherwise
		 * just use the default image
		 */
//		if(albumCoverPath != null){
//			/*
//			 * First check the albumThumbsize and then get the album art just
//			 * with the resolution that is strictly required
//			 */
//			Options opts = new Options();
//			opts.inJustDecodeBounds = true;
//			Bitmap albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//
//			opts.inJustDecodeBounds = false;
//			opts.inSampleSize = (int) Math.max(1, 
//												Math.floor(opts.outWidth/viewWidth)
//												);
//			albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//			if(albumCoverBitmap != null)
//				albumImage.setImageBitmap(albumCoverBitmap);
//		} else {
//			// TODO:
//			// adjust sample size dynamically
//			Options opts = new Options();
//			opts.inSampleSize = NO_COVER_SAMPLING_INTERVAL;
//			//Bitmap albumCoverBitmap = BitmapFactory.decodeFile(albumCoverPath, opts);
//			Bitmap albumCoverBitmap = BitmapFactory.decodeResource(this.context.getResources(),
//															R.drawable.cdcover, opts);
//			if(albumCoverBitmap != null)
//				albumImage.setImageBitmap(albumCoverBitmap);
//		}
    }
    
//    OnClickListener	songListSongClick = new OnClickListener(){
//		@Override
//		public void onClick(View songTextView) {
//			Log.i("LIST", "SONG CLICK");
//			/* 
//			 * Check song position 
//			 */
//			int position = ((Filex) context).
//								songListView.getPositionForView(songTextView);
//			songCursor.moveToPosition(position);
//			
//			/*
//			 * UpdateUI
//			 */
//			((Filex) context).updateSongTextUI();
//			((Filex) context).songProgressBar.setProgress(0);
//			((Filex) context).songProgressBar.setMax((int) songCursor.getDouble(
//															songCursor.getColumnIndex(
//																	MediaStore.Audio.Media.DURATION)));
//			
//			// TODO: use slide down animation 
//			// Might not be necessary
//			((Filex) context).hideSongListUI();
//			((Filex) context).showMainUI();
//			
//			/*
//			 * Play song
//			 */
//			try
//			{
//				((Filex) context).playerServiceIface.play(((Filex) context).albumCursorPositionPlaying,
//															songCursor.getPosition());
//			} catch (RemoteException e) {
//				e.printStackTrace();
//			}
////			String songPath = songCursor.getString(
////								songCursor.getColumnIndex(
////									MediaStore.Audio.Media.DATA));
////			((Filex) context).playSong(songPath);
//		}
//    };
//    OnClickListener	songListPreviewClick = new OnClickListener(){
//		@Override
//		public void onClick(View arg0) {
//			Log.i("LIST", "PREVIEW CLICK");			
//		}
//    };    
//    OnClickListener	songListRecommendClick = new OnClickListener(){
//		@Override
//		public void onClick(View arg0) {
//			Log.i("LIST", "SHARE CLICK");			
//		}
//    };
}