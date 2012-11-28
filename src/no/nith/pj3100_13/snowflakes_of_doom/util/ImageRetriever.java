package no.nith.pj3100_13.snowflakes_of_doom.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;

public class ImageRetriever {

	public static Drawable getImageFromWeb(String imageUrl) { 
		InputStream is = null;  
		try {
			URL url = new URL(imageUrl);
			
			is = new BufferedInputStream(url.openStream());
			
			return Drawable.createFromStream(is, null);
		 
		} catch (MalformedURLException e) {

		} catch (IOException e) {

		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {

				}   
			}
		}
		return null; 
	}
	
}
