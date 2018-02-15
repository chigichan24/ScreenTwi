import javax.swing.*;
import java.awt.*;

/**
 * Created by chigichan24 on 2018/02/15.
 */
public class TweetPanel extends JPanel {
    TweetPanel() {
        super();
        this.setBackground(new Color(0, 0, 0, 0));
        JLabel label = new JLabel();
        label.setText("これはテストです．");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));

        this.add(label);
    }
}
