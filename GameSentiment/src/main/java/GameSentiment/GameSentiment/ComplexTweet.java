package GameSentiment.GameSentiment;

import java.util.LinkedList;

public class ComplexTweet {
private String topic;
private String text;
private int sentiment;
private LinkedList<EntitiesUrl> urlEntity;
public ComplexTweet(String topic ,String text,int sentiment,LinkedList<EntitiesUrl> entità){
	this.topic=topic;
	this.text=text;
	this.sentiment=sentiment;
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
public LinkedList<EntitiesUrl> getUrlEntity() {
	return urlEntity;
}
public void setUrlEntity(LinkedList<EntitiesUrl> urlEntity) {
	this.urlEntity = urlEntity;
}

public String getTopic() {
	return this.topic;
}

}
