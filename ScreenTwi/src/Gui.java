import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        this.setSize(window.width, window.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setUndecorated(true);

        this.setAlwaysOnTop(true);

        Container container = this.getContentPane();
        container.add(new FieldPanel());

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


    class FieldPanel extends JPanel implements MouseListener {
        FieldPanel() {
            super();
            this.setBackground(new Color(0, 0, 0, 0));
            JLabel label = new JLabel();
            label.setText("これはテストです．");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            this.add(label);
            this.addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                System.out.println("Clicked");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
