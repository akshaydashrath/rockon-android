package org.abrantes.filex.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RockOnPreferenceManager{
	
	int MAX_PREF_LENGTH = 1000;
	String preferenceDir = null;
	
	public RockOnPreferenceManager(String preferenceDir){
		this.preferenceDir = preferenceDir;
	}


	/******************************
	 * 
	 * Strings
	 * 
	 ******************************/
	public boolean putString(String key, String val){
		try{
			File prefFile = new File(preferenceDir, key);
			if(!prefFile.exists())
				prefFile.createNewFile();
			FileWriter prefWriter = new FileWriter(prefFile);
			prefWriter.write(val);
			prefWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;	
		}
	}
	
	public String getString(String key, String defaultVal){
		try{
			String prefVal = "";
			File prefFile = new File(preferenceDir, key);
			if(!prefFile.exists())
				return defaultVal;
			FileReader prefReader = new FileReader(prefFile);
			int c;
			while(true){
				c = prefReader.read();
				if(c == -1)
					break;
				prefVal += (char) c;
			}
			prefReader.close();
			return prefVal;
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;	
		}
	}
	

	/******************************
	 * 
	 * Integers
	 * 
	 ******************************/
	public boolean putInt(String key, int val){
		try{
			return putString(key, String.valueOf(val));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getInt(String key, int defaultVal){
		try{
			return (new Integer(getString(key, String.valueOf(defaultVal))));
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;
		}
	}
	
	

	/******************************
	 * 
	 * Longs
	 * 
	 ******************************/
	public boolean putLong(String key, long val){
		try{
			return putString(key, String.valueOf(val));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public long getLong(String key, long defaultVal){
		try{
			return (new Long(getString(key, String.valueOf(defaultVal))));
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;
		}
	}
	

	/******************************
	 * 
	 * Floats
	 * 
	 ******************************/
	public boolean putFloat(String key, float val){
		try{
			return putString(key, String.valueOf(val));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public float getFloat(String key, float defaultVal){
		try{
			return (new Float(getString(key, String.valueOf(defaultVal))));
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;
		}
	}
	
	/******************************
	 * 
	 * Doubles
	 * 
	 ******************************/
	public boolean putDouble(String key, double val){
		try{
			return putString(key, String.valueOf(val));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public double getDouble(String key, double defaultVal){
		try{
			return (new Double(getString(key, String.valueOf(defaultVal))));
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;
		}
	}
	
	/******************************
	 * 
	 * Booleans
	 * 
	 ******************************/
	public boolean putBoolean(String key, boolean val){
		try{
			return putString(key, String.valueOf(val));
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getBoolean(String key, boolean defaultVal){
		try{
			return (new Boolean(getString(key, String.valueOf(defaultVal))));
		} catch (Exception e) {
			e.printStackTrace();
			return defaultVal;
		}
	}
	
	/*****************************
	 * 
	 * Contains
	 * 
	 *****************************/
	public boolean contains(String key){
		try{
			File prefFile = new File(preferenceDir, key);
			if(prefFile.exists())
				return true;
			else
				return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
}