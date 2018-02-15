import javax.swing.*;
import java.awt.*;

/**
 * Created by chigichan24 on 2018/02/14.
 */
public class Gui extends JFrame {

    Gui() {
        super();
        initJFrame();

    }

    private void initJFrame() {

        Rectangle window = getWindowSize();
        this.setTitle("TweetScreen");
        this.setSize(window.width, window.height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);

        Container container = this.getContentPane();
        container.add(new TweetPanel("chigichan24", "これはテストツイートです"), BorderLayout.NORTH);
        container.add(new TweetPanel("chigichan24", "ほげふがだぞ〜〜"), BorderLayout.NORTH);

        this.getContentPane().setBackground(new Color(0, 0, 255));
        this.setVisible(true);

    }

    private Rectangle getWindowSize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        if (env == null) {
            return new Rectangle(0, 0);
        }
        return env.getMaximumWindowBounds();
    }


}
