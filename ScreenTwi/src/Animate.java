import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chigichan24 on 2018/02/15.
 */
public class Animate {

    private JPanel panel = null;
    private Rectangle from = null;
    private Rectangle to = null;
    private long start_time;
    private static final int RUN_TIME = 10000;
    private static final int DELAY_TIME = 10;

    public Animate(JPanel panel, Rectangle from, Rectangle to) {
        this.panel = panel;
        this.from = from;
        this.to = to;
    }

    public void start() {
        Timer timer = new Timer(DELAY_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long duration = System.currentTimeMillis() - start_time;
                double progress = (double) duration / (double) RUN_TIME;

                if (progress > 1f) {
                    progress = 1f;
                    ((Timer) e.getSource()).stop();
                }

                Rectangle now_state = calcProgress(from, to, progress);
                panel.setBounds(now_state);
            }
        });
        timer.start();
    }

    private Rectangle calcProgress(Rectangle from, Rectangle to, double progress) {
        Rectangle bounds = new Rectangle();

        if (from == null || to == null) {
            return null;
        }

        bounds.setLocation(calcProgress(from.getLocation(), to.getLocation(), progress));
        bounds.setSize(calcProgress(from.getSize(), to.getSize(), progress));

        return bounds;
    }

    private Point calcProgress(Point from, Point to, double progress) {
        if (from == null || to == null) {
            return null;
        }
        return new Point(calcProgress(from.x, to.x, progress), calcProgress(from.y, to.y, progress));
    }

    private int calcProgress(int start, int end, double progress) {
        int distance = end - start;

        int value = (int) Math.round((double) distance * progress);
        value += start;

        return value;
    }

    private Dimension calcProgress(Dimension from, Dimension to, double progress) {
        if (from == null || to == null) {
            return null;
        }

        return new Dimension(calcProgress(from.width, to.width, progress), calcProgress(from.height, to.height, progress));
    }
}
