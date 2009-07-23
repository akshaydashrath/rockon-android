package org.abrantes.filex;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class PlaylistArrayAdapter extends ArrayAdapter{

	Context context;
	ArrayList<Playlist> playlistArray;
	
	public PlaylistArrayAdapter(Context context, 
								int layoutResourceId,
								List playlists) {
		super(context, layoutResourceId, playlists);
		this.context = context;
		this.playlistArray = (ArrayList<Playlist>) playlists;
	}

    /* (non-Javadoc)
     * This is where you actually create the item view of the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
		View view;
    	if(convertView != null)
    		view = convertView;
    	else
    		view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
    									.inflate(R.layout.playlist_item, parent, false);
    	
    	((TextView) view.findViewById(R.id.playlist_name)).setText(playlistArray.get(position).name);
    	
    	return view;
    }
}