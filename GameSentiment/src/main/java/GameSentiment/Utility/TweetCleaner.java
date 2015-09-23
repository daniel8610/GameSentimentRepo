package GameSentiment.Utility;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

public class TweetCleaner {
	
	
	public static String cleanTweet(String text){
		String temp;
		temp=text.replaceAll("((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", "");
		
		return temp.replaceAll("#[A-Za-z]*|@[A-Za-z]*", "");
	}

}
