package GameSentiment.GameSentiment;

import GameSentiment.Utility.PropertiesManager;

public class NERFactory {
	private static NERFactory istanza; 
private NERFactory(){
	
}
public static NERFactory getIstance(){

	if(istanza==null)
		istanza=new NERFactory();
 return istanza;
}
public INamedEntityRecognition getNLPlibrary(){
	INamedEntityRecognition o=null;
	try {
		o = (INamedEntityRecognition) Class.forName("GameSentiment.GameSentiment"+new PropertiesManager().getValueForKey("libraryToUse")).newInstance();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("nome libreria errata scegli tra: OpenNLP , AlchemyAPI , StanfordNLP");
	} catch (InstantiationException e) {	
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	}
	return   o;
}

public INamedEntityRecognition getStanfordNLP(){
	INamedEntityRecognition o=new WrapperStanfordNLP();
	return o;
	}
}
