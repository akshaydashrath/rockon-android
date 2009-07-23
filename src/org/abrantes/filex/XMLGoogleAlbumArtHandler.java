package org.abrantes.filex;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


public class XMLGoogleAlbumArtHandler extends DefaultHandler{

	public int MAX_IMAGES = 3;
	
	String imageDataTagBaseString = "tDataImage";
	
	boolean[] imageDataTag = {
			false,
			false,
			false
	};
//	boolean smallTag = false;
//	boolean mediumTag = false;
//	boolean largeTag = false;
//	boolean xlargeTag = false;
	
	String[] albumArtUrl = {
		null,
		null,
		null
	};
//	String smallAlbumArt = null;
//	String mediumAlbumArt = null;
//	String largeAlbumArt = null;
//	String xlargeAlbumArt = null;
	
	@Override
    public void startElement(String namespaceURI, 
    							String localName,
    							String qName,
    							Attributes atts) 
	throws SAXException {
		try{
			if(localName.equals("td")){
				for(int i = 0; i < MAX_IMAGES; i++){
					if(atts.getValue("id").equals(imageDataTagBaseString+Integer.toString(i))){
						imageDataTag[i] = true;
					}
				}
			}
			if(localName.equals("img")){
				for(int i = 0; i < MAX_IMAGES; i++){
					if(imageDataTag[i]){
						int urlCharIndex = 0;
						for(int j = 0; j < 3; j++){
							urlCharIndex = atts.getValue("src").indexOf(':', urlCharIndex);
						}
						albumArtUrl[i] = new String(
							atts.getValue("src").substring(urlCharIndex));
					}
				}
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void  endElement  (String uri, 
								String localName, 
								String qName)
	throws SAXException {
		if(localName.equals("td")){
			for(int i = 0; i < MAX_IMAGES; i++){
				imageDataTag[i] = false;
			}
		}
//		
//		if(localName.equals("image")){
//			smallTag = false;
//			mediumTag = false;
//			largeTag = false;
//			xlargeTag = false;
//		}
	}
	
	 @Override
	 public void characters(char ch[], int start, int length) {
//		 if(smallTag){
//			 this.smallAlbumArt = new String(ch, start, length);
//		 }
//		 if(mediumTag){
//			 this.mediumAlbumArt = new String(ch, start, length);
//		 }
//		 if(largeTag){
//			 this.largeAlbumArt = new String(ch, start, length);
//		 }
//		 if(xlargeTag){
//			 this.xlargeAlbumArt = new String(ch, start, length);
//		 }
	 }
	 
	 public void clear(){
		 for(int i = 0; i < MAX_IMAGES; i++){
			 imageDataTag[i] = false;
			 albumArtUrl[i] = null;
		 }
	 }
}
