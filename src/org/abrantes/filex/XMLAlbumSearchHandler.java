package org.abrantes.filex;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;
import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


public class XMLAlbumSearchHandler extends DefaultHandler{

	public LinkedList<AlbumSearch> albumSearchList = new LinkedList<AlbumSearch>();

	boolean albumTag = false;
	boolean albumNameTag = false;
	boolean artistNameTag = false;
	boolean smallTag = false;
	boolean mediumTag = false;
	boolean largeTag = false;
	boolean xlargeTag = false;
	
	String albumName = null;
	String artistName = null;
	String smallAlbumArt = null;
	String mediumAlbumArt = null;
	String largeAlbumArt = null;
	String xlargeAlbumArt = null;
	
	@Override
    public void startElement(String namespaceURI, 
    							String localName,
    							String qName,
    							Attributes atts) 
	throws SAXException {
		if(localName.equals("image")){
			if(atts.getValue("size").equals("small")){
				smallTag = true;
			} else if(atts.getValue("size").equals("medium")){
				mediumTag = true;
			} else if(atts.getValue("size").equals("large")){
				largeTag = true;
			} else if(atts.getValue("size").equals("xlarge")){
				xlargeTag = true;
			}
		} else if(localName.equals("artist")){
			artistNameTag = true;
		} else if(localName.equals("album")){
			albumTag = true;
		} else if(localName.equals("name")){
			albumNameTag = true;
		}
	}
	
	@Override
	public void  endElement  (String uri, 
								String localName, 
								String qName)
	throws SAXException {
		if(localName.equals("image")){
			smallTag = false;
			mediumTag = false;
			largeTag = false;
			xlargeTag = false;
		} else if(localName.equals("artist")){
				artistNameTag = false;
		} else if(localName.equals("name")){
				albumNameTag = false;
		} else if(localName.equals("album")){
				albumTag = false;
				
				AlbumSearch albumSearch = new AlbumSearch();
				albumSearch.albumName = this.albumName;
				albumSearch.artistName = this.artistName;
				albumSearch.smallAlbumArt = this.smallAlbumArt;
				albumSearch.mediumAlbumArt = this.mediumAlbumArt;
				albumSearch.largeAlbumArt = this.largeAlbumArt;
				albumSearch.xlargeAlbumArt = this.xlargeAlbumArt;
				albumSearchList.add(albumSearch);
				
				this.albumName = null;
				this.artistName = null;
				this.smallAlbumArt = null;
				this.mediumAlbumArt = null;
				this.largeAlbumArt = null;
				this.xlargeAlbumArt = null;
		}
	}
	
	 @Override
	 public void characters(char ch[], int start, int length) {
		if(smallTag){
			 this.smallAlbumArt = new String(ch, start, length);
		 }
		 if(mediumTag){
			 this.mediumAlbumArt = new String(ch, start, length);
		 }
		 if(largeTag){
			 this.largeAlbumArt = new String(ch, start, length);
		 }
		 if(xlargeTag){
			 this.xlargeAlbumArt = new String(ch, start, length);
		 }
		 if(artistNameTag){
			 this.artistName = new String(ch, start, length);
		 }
		 if(albumNameTag){
			 this.albumName = new String(ch, start, length);
		 }
	}
}
