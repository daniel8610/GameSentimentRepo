package GameSentiment.GameSentiment;


import java.util.LinkedList;


import GameSentiment.Utility.BlackListController;
import GameSentiment.Utility.HtmlCleaner;


public class GameSentiment {
	private INamedEntityRecognition NERlibrary;
	public GameSentiment(){
		WrapperSentimentStanford.init();
		this.NERlibrary=NERFactory.getIstance().getStanfordNLP();
	}
	public LinkedList<ComplexTweet> exec(String topic,BlackListController bl,boolean espansioneQuery){
		LinkedList<EntitiesUrl> entitaTotTweet =new LinkedList<EntitiesUrl>();
		LinkedList<ComplexTweet> output=new LinkedList<ComplexTweet>();
		LinkedList<SimpleTweet> tweets=TweetManager.getTweets(topic);
		LinkedList<EntitiesUrl> allEntTweets=new LinkedList<EntitiesUrl>();
		for(SimpleTweet tw:tweets){
			if(tw.getText().length()>0){
				int sentiment=WrapperSentimentStanford.findSentiment(tw.getText());
				if(tw.hasUrl()==true){
					entitaTotTweet =new LinkedList<EntitiesUrl>();
					for(String url:tw.getUrlExpanded()){
						if(!bl.urlCheck(url)){
							String testopag=HtmlCleaner.getAndCleanHtml(url);
							EntitiesUrl e=new EntitiesUrl(url,NERlibrary.getEntities(testopag));
							entitaTotTweet.add(e);
							allEntTweets.add(e);
						}}}
				ComplexTweet tweet=new ComplexTweet(topic,tw.getText(),sentiment,entitaTotTweet);
				output.add(tweet);
			}

		}
		if(espansioneQuery==true&&allEntTweets.size()>0)
			this.queryExpansion(topic, bl, allEntTweets);
		
		return output;

	}

	private LinkedList<ComplexTweet> queryExpansion(String topic,BlackListController bl,LinkedList<EntitiesUrl> l){
		LinkedList<String> allEntity=new LinkedList<String>();
		LinkedList<ComplexTweet> output=new LinkedList<ComplexTweet>();
		for(EntitiesUrl entita: l)
			allEntity.addAll(entita.getEntetiesList());
		
		
		for(String tokenExp:allEntity)
			output.addAll(this.exec(topic+" "+tokenExp, bl, false));
		

		return output;
		
		
	}
}
