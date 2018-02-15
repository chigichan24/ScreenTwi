import javax.swing.*;
import java.awt.*;

/**
 * Created by chigichan24 on 2018/02/15.
 */
public class TweetPanel extends JPanel {
    TweetPanel(String user_name, String tweet) {
        super();
        this.setPreferredSize(new Dimension(100, 30));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(createLabel(user_name, tweet));
        System.out.println(this.getPreferredSize());
    }

    private String constructViewText(String user_name, String tweet) {
        return tweet + " :" + user_name;
    }

    private JLabel createLabel(String user_name, String tweet) {
        JLabel label = new JLabel();
        label.setText(constructViewText(user_name, tweet));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(0, 0, 255));
        return label;
    }

}
