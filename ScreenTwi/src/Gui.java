import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chigichan24 on 2018/02/14.
 */
public class Gui extends JFrame implements StatusListener {

    private TwitterStream twitter_stream;

    Gui() {
        super();
        String[] tags = {"kosen12s"};
        twitter_stream = new TwitterStream();
        if (twitter_stream.stream != null) {
            twitter_stream.stream.addListener(this);
            twitter_stream.stream.filter(tags);
        }
        initJFrame();

    }

    private void initJFrame() {

        Rectangle window = getWindowSize();
        this.setTitle("TweetScreen");
        this.setSize(window.width, window.height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);

        this.setBackground(new Color(0, 0, 0, 0));
        this.setVisible(true);

    }

    private Rectangle getWindowSize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        if (env == null) {
            return new Rectangle(0, 0);
        }
        return env.getMaximumWindowBounds();
    }


    @Override
    public void onStatus(Status status) {
        if (!status.getText().startsWith("RT")) {
            this.setVisible(false);

            Container container = this.getContentPane();
            container.removeAll();
            container.add(new TweetPanel(status.getUser().getName(), status.getText()), BorderLayout.SOUTH);

            this.setVisible(true);
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
