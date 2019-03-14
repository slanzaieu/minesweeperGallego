import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Difficulty extends JFrame {

    public enum Level {
        Easy, Medium, Hard
    }

    public Level level;

    private JPanel mainPanel;
    private JLabel setLevel;
    private JButton easyLevel;
    private JButton mediumLevel;
    private JButton hardLevel;



    public Difficulty() {

        Gui();

    }

    private void Gui() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPanel.setPreferredSize(new Dimension(300, 300));

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
        panel1.setPreferredSize(new Dimension(300, 50));

        setLevel = new JLabel("Set Level Difficulty");

        panel1.add(setLevel);

        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel2.setPreferredSize(new Dimension(300, 175));

        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel3.setPreferredSize(new Dimension(200, 50));

        easyLevel = new JButton("Easy");
        easyLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setVisible(false);
                level = Level.Easy;
                int numbCells = 64;
                int numbBombs = 8;
                new Game(level, numbCells, numbBombs);

            }
        });

        panel3.add(easyLevel);

        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel4.setPreferredSize(new Dimension(200, 50));

        mediumLevel= new JButton("Medium");
        mediumLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setVisible(false);
                level = Level.Medium;
                int numbCells = 162;
                int numbBombs = 24;
                new Game(level, numbCells, numbBombs);

            }
        });

        panel4.add(mediumLevel);

        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel5.setPreferredSize(new Dimension(200, 50));

        hardLevel = new JButton("Hard");
        panel5.add(hardLevel);
        hardLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setVisible(false);
                level = Level.Hard;
                int numbCells = 262;
                int numbBombs = 68;
                new Game(level, numbCells, numbBombs);

            }
        });

        panel2.add(panel3);
        panel2.add(panel4);
        panel2.add(panel5);

        mainPanel.add(panel1);
        mainPanel.add(panel2);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setSize(300, 300);
        setVisible(true);
    }

}
