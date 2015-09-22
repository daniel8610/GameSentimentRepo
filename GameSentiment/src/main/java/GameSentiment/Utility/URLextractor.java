package GameSentiment.Utility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;

import twitter4j.TwitterException;

public class URLextractor {
public static String extractURL(String text){
	LinkExtractor linkExtractor = LinkExtractor.builder().build();
	LinkedList<String> listaurl=new LinkedList<String>();
	try{
		
	Iterable<LinkSpan> l = linkExtractor.extractLinks(text);
	 Iterator<LinkSpan> links=l.iterator();
	
	 
	LinkSpan link = links.next();
	link.getBeginIndex(); 
	link.getEndIndex();   
	
	return text.substring(link.getBeginIndex(), link.getEndIndex());
	
	} catch (NoSuchElementException e) {
		return null;
	}
	
}
}
