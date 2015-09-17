package GameSentiment.Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
 

public class UrlExpander {
 
    public static void main(String[] args) throws IOException {
        String shortenedUrl = "http://fb.me/47oQn4NEh";
        String expandedURL = expandUrl(shortenedUrl);
         
        System.out.println(shortenedUrl + "-->" + expandedURL); 
    }
     
    public static String expandUrl(String shortenedUrl) throws IOException {
        URL url = new URL(shortenedUrl);    
        // open connection
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); 
        
        // stop following browser redirect
        httpURLConnection.setInstanceFollowRedirects(false);
         
        // extract location header containing the actual destination URL
        String expandedURL = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
         
        return expandedURL;
    }
}