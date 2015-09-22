package GameSentiment.GameSentiment;


import java.util.HashMap;
import java.util.LinkedList;

public class EntitiesUrl {
  private String url;
  private HashMap<String,LinkedList<String>>  entities;
  public EntitiesUrl(String url,HashMap<String,LinkedList<String>> e){
	  this.setUrl(url);
	  this.setEntities(e);
	  
  }
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public HashMap<String,LinkedList<String>> getEntities() {
	return entities;
}
public void setEntities(HashMap<String,LinkedList<String>> entities) {
	this.entities = entities;
}
public LinkedList<String> getEntetiesList(){
	if(this.entities.size()==0)
		return new LinkedList<String>();
	LinkedList<String> lista=new LinkedList<String>();
	for(LinkedList<String> l:this.entities.values()){
		lista.addAll(l);
	}
	return lista;
}

}
