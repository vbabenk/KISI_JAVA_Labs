package lab4;

import javax.swing.*;
import java.awt.*;

public class Main extends JApplet {
    @Override
    public void init() {
        Container contentPane = getContentPane();

        JPanel aPanel = new JPanel();
        aPanel.add(new JLabel("Поле ввода"));
        JTextField aField = new JTextField();
        aField.setPreferredSize(new Dimension(100, 20));
        aPanel.add(aField);
        aPanel.setPreferredSize(new Dimension(120, 50));
        contentPane.add(aPanel, BorderLayout.WEST);

        JPanel bPanel = new JPanel();
        bPanel.add(new JLabel("Поле вывода"));
        JTextField bField = new JTextField();
        bField.setPreferredSize(new Dimension(100, 20));
        bField.setEditable(false);
        bPanel.add(bField);
        bPanel.setPreferredSize(new Dimension(120, 50));
        contentPane.add(bPanel, BorderLayout.EAST);

        JPanel cPanel = new JPanel();
        JButton button = new JButton("Скопировать");
        button.addActionListener(e -> bField.setText(aField.getText()));
        cPanel.add(button);
        cPanel.setPreferredSize(new Dimension(120, 50));
        contentPane.add(cPanel, BorderLayout.CENTER);
    }
}
