import javax.swing.*;

/**
 * Created by chigichan24 on 2018/02/14.
 */
public class Gui {
    private JPanel panel1;

    public static void init() {
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
