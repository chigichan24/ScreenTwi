import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;


/**
 * Created by chigichan24 on 2018/02/15.
 */

public class TwitterStream implements StatusListener {

    public TwitterStream(String[] tags) {
        final boolean DEBUG = false;
        final String OAUTH_CONSUMERKEY = System.getenv("OAUTH_CONSUMERKEY");
        final String OAUTH_CONSUMERSECRET = System.getenv("OAUTH_CONSUMERSECRET");
        final String OAUTH_ACCESSTOKEN = System.getenv("OAUTH_ACCESSTOKEN");
        final String OAUTH_ACCESSTOKENSECRET = System.getenv("OAUTH_ACCESSTOKENSECRET");
        final String[] track = tags;
        Configuration configuration = new ConfigurationBuilder()
                .setDebugEnabled(DEBUG)
                .setOAuthConsumerKey(OAUTH_CONSUMERKEY)
                .setOAuthConsumerSecret(OAUTH_CONSUMERSECRET)
                .setOAuthAccessToken(OAUTH_ACCESSTOKEN)
                .setOAuthAccessTokenSecret(OAUTH_ACCESSTOKENSECRET)
                .build();

        twitter4j.TwitterStream stream = new TwitterStreamFactory(configuration).getInstance();
        stream.addListener(this);

        FilterQuery filter = new FilterQuery();
        filter.track(track);
        stream.filter(filter);
    }

    @Override
    public void onStatus(Status status) {
        if (!status.getText().startsWith("RT")){
            System.out.println(status.getText());
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }

}
