package GameSentiment.GameSentiment;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class WrapperStanfordNLP {
	static StanfordCoreNLP pipeline;

    public static void init() {
    	//pipeline è un oggetto che sa fare tokenize, ssplit, parse, sentiment
        pipeline = new StanfordCoreNLP("MyPropFile.properties");
    }
    
    //questo da un sentiment totale prendendo la sentence piu lunga
    public static int findSentiment(String tweet) {

        int mainSentiment = 0;
        if (tweet != null && tweet.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(tweet);
            for (CoreMap sentence : annotation
                    .get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence
                        .get(SentimentCoreAnnotations.AnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }
        }
        return mainSentiment;
    }
    //Da Finire perche in una frase da il sentiment di ogni sentence bisogna fare un 
    //risultato finale es pos +1 very pos +2 .....
    public static String findSentiment2(String tweet) {
        String sentiment="NonTrovato";
        if (tweet != null && tweet.length() > 0) {
            
            Annotation annotation = pipeline.process(tweet);
            List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
            for (CoreMap sentence : sentences) {
            	sentiment = sentence.get(SentimentCoreAnnotations.ClassName.class);
            	 System.out.println(sentiment + "\t" + sentence);
            }
        }
        return sentiment;
    }

}
