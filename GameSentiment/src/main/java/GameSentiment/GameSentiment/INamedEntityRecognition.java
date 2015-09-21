package GameSentiment.GameSentiment;

import java.util.HashMap;
import java.util.LinkedList;

public interface INamedEntityRecognition {

public  HashMap<String, LinkedList<String>>  getEntities(String html);

}
