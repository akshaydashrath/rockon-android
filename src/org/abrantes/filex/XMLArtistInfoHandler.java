package org.abrantes.filex;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


public class XMLArtistInfoHandler extends DefaultHandler{

	boolean artistTag = false;
	boolean artist2Tag = false;
	boolean smallTag = false;
	boolean mediumTag = false;
	boolean largeTag = false;
	boolean xlargeTag = false;
	
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
			if(!artistTag)
				artistTag = true;
			else
				artist2Tag = true;
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
			if(artist2Tag)
				artist2Tag = false;
			else
				artistTag = false;
		}
	}
	
	 @Override
	 public void characters(char ch[], int start, int length) {
		if(!artist2Tag){
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
		}
	 }
}
