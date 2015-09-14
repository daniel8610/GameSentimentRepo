package GameSentiment.Utility;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

public class TweetCleaner {
	
	//regex rimuovi un qualsiasi stringa che inizia con # e contiene 0 (*)o piu lettere presenti in [A-Za-z] o ( | )....
	public static String cleanTweet(String text){
		String temp;
		temp=text.replaceAll("((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)", "");
		
		return temp.replaceAll("#[A-Za-z]*|@[A-Za-z]*", "");
	}

}
