package GameSentiment.GameSentiment;

import java.util.LinkedList;

public class Tweet {
private String user;
private String text;
private String sentiment;
private LinkedList<String> listaUrl;
private String urlEntity;
//fa schifo cosi gestisci meglio urls e entita
public Tweet(String user,String text,LinkedList<String> urls){
	this.user=user;
	this.text=text;
	this.listaUrl=urls;
	this.urlEntity=null;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getSentiment() {
	return sentiment;
}
public void setSentiment(String sentiment) {
	this.sentiment = sentiment;
}
public LinkedList<String> getListaUrl() {
	return listaUrl;
}
public void setListaUrl(LinkedList<String> listaUrl) {
	this.listaUrl = listaUrl;
}
public String getUrlEntity() {
	return urlEntity;
}
public void setUrlEntity(String urlEntity) {
	this.urlEntity = urlEntity;
}

}
