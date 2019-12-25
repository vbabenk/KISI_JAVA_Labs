package lab5;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends JFrame {
    public Main() throws Exception {
        super("Hello World");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JLabel label = new JLabel("hello world");
        label.setSize(label.getPreferredSize());
        setLayout(null);
        getContentPane().add(label);

        label.setLocation(50, 50);

        new Thread(() -> {
            int dx = 1;
            int dy = 1;

            while (true) {
                Point point = label.getLocation();
                point.x += dx;
                point.y += dy;

                boolean border = false;

                if (point.x < 0) {
                    point.x = 0;
                    dx = -dx;
                    border = true;
                } else if (point.x + label.getWidth() > getWidth() - 15) {
                    point.x = getWidth() - label.getWidth() - 15;
                    dx = -dx;
                    border = true;
                }

                if (point.y < 0) {
                    point.y = 0;
                    dy = -dy;
                    border = true;
                } else if (point.y + label.getHeight() > getHeight() - 40) {
                    point.y = getHeight() - label.getHeight() - 40;
                    dy = -dy;
                    border = true;
                }

                if (border) {
                    char[] data = label.getText().toCharArray();
                    for (int i = 0; i < data.length; i++) {
                        data[i] = ThreadLocalRandom.current().nextBoolean()
                                ? Character.toUpperCase(data[i])
                                : Character.toLowerCase(data[i]);
                    }
                    label.setText(String.valueOf(data));
                    label.setSize(label.getPreferredSize());
                }

                label.setLocation(point);
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(new Dimension(480, 320));
        setLocationRelativeTo(null);
        setVisible(true);

        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
