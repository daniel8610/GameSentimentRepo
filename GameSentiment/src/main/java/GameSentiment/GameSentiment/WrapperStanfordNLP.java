package GameSentiment.GameSentiment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;

public class WrapperStanfordNLP implements INamedEntityRecognition{
	
	private String serializedClassifier;
	private AbstractSequenceClassifier<CoreLabel> classifier;
	//private NERClassifierCombiner classifier;
	
	public WrapperStanfordNLP(){
		
		try {
			serializedClassifier = "training/english.all.3class.distsim.crf.ser.gz";
			classifier = CRFClassifier.getClassifier(serializedClassifier);
			//classifier = new NERClassifierCombiner(false, false, serializedClassifier);
		} catch (Exception e) {
			System.out.println("Exception in WrapperStanfordNLP constructor");
		}
	}
	
	

/*MODO MIO
    private	LinkedList<String> getTypeEntitie(String output,String type){
    	LinkedList<String> l = new LinkedList<String>();
    	l.add(type);
    	String[] r1=Jsoup.parse(output).getElementsByTag(type).html().replaceAll("\\r|\\n", "#").split("#");
    	if(!r1[0].equals("")){
    		for(String s:r1){
    			if(!l.contains(s))
    				l.add(s);
    		}
    		      
*/
    private	HashMap<String, LinkedList<String>> getAll(String output){
    	LinkedList<String> resultORG = new LinkedList<String>();
    	LinkedList<String> resultPER = new LinkedList<String>();
    	LinkedList<String> resultLOC = new LinkedList<String>();
    	Iterator<Element> it = Jsoup.parse(output).getElementsByTag("ORGANIZATION").iterator();
    	while (it.hasNext()){
    		String entity = it.next().text();
    		if (!resultORG.contains(entity)){
    			resultORG.add(entity);
    		}
    	}
    	Iterator<Element> it2 = Jsoup.parse(output).getElementsByTag("PERSON").iterator();
    	while (it2.hasNext()){
    		String entity = it2.next().text();
    		if (!resultPER.contains(entity)){
    			resultPER.add(entity);
    		}
    	}
    	Iterator<Element> it3 = Jsoup.parse(output).getElementsByTag("LOCATION").iterator();
    	while (it3.hasNext()){
    		String entity = it3.next().text();
    		if (!resultLOC.contains(entity)){
    			resultLOC.add(entity);
    		}
    	}
    	HashMap<String,LinkedList<String>> result=new HashMap();
    	result.put("ORGANIZATION", resultORG);
    	result.put("PERSON", resultPER);
    	result.put("LOCATION", resultLOC);
    	
    	return result;
    	
    }
  /*  MODO MIO
	public LinkedList<String> getEntities(String html) {
		

		LinkedList<String> result = new LinkedList<String>();
		String output=this.classifier.classifyToString(html, "inlineXML", true); 
	    result.addAll(this.getTypeEntitie(output, "LOCATION"));
	    result.addAll(this.getTypeEntitie(output, "PERSON"));
	    result.addAll(this.getTypeEntitie(output, "ORGANIZATION"));
		return result;
	}
	*/
    public HashMap<String, LinkedList<String>> getEntities(String html) {
	    if(html!=null){
		String output=this.classifier.classifyToString(html, "inlineXML", true);
		return this.getAll(output);
	    }else{
	    	return new HashMap<String,LinkedList<String>>();
	    }
	}
	
}
