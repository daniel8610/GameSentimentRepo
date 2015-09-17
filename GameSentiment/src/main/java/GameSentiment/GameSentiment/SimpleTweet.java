package GameSentiment.GameSentiment;

import java.util.LinkedList;

public class SimpleTweet {
	private String text;
	private LinkedList<String> urlExpanded;
	public SimpleTweet(String text,LinkedList<String> urls){
		this.text=text;
		this.urlExpanded=urls;
	}
	public boolean hasUrl(){
		return this.urlExpanded!=null||this.urlExpanded.size()>0;
	}
	public LinkedList<String> getUrlExpanded() {
		return urlExpanded;
	}
	public void setUrlExpanded(LinkedList<String> urlExpanded) {
		this.urlExpanded = urlExpanded;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	} 
}
