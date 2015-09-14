package GameSentiment.GameSentiment;

import java.util.LinkedList;

public class Tweet {
private String topic;
private String text;
private int sentiment;
private String url;
private LinkedList<String> urlEntity;
//fa schifo cosi gestisci meglio urls e entita
public Tweet(String topic ,String text,int sentiment,String url,LinkedList<String> entità){
	this.topic=topic;
	this.text=text;
	this.sentiment=sentiment;
	this.url=url;
	this.urlEntity=entità;
}

public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getSentiment() {
	return sentiment;
}
public void setSentiment(int sentiment) {
	this.sentiment = sentiment;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public LinkedList<String> getUrlEntity() {
	return urlEntity;
}
public void setUrlEntity(LinkedList<String> urlEntity) {
	this.urlEntity = urlEntity;
}

}
