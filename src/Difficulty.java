import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Difficulty extends JFrame {



    public enum Level {
        Easy, Medium, Hard
    }



    public Level level;

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel setLevel;
    private JButton easyLevel;
    private JButton mediumLevel;
    private JButton hardLevel;



    public Difficulty() {

        initializedGui();

    }

    private void initializedGui() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setLevel = new JLabel("How good are you?");
        mainPanel.add(setLevel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));



        easyLevel = new JButton("Easy");
        easyLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                level = Level.Easy;
                int numbCells = 64;
                int numbBombs = 8;
                new Game(level, numbCells, numbBombs);

            }
        });

        mediumLevel= new JButton("Medium");
        mediumLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                level = Level.Medium;
                int numbCells = 162;
                int numbBombs = 24;

                new Game(level, numbCells, numbBombs);

            }
        });


        hardLevel = new JButton("Hard");
        hardLevel.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                level = Level.Hard;
                int numbCells = 262;
                int numbBombs = 68;
                new Game(level, numbCells, numbBombs);

            }
        });

        buttonPanel.add(easyLevel, BorderLayout.LINE_START);
        buttonPanel.add(mediumLevel, BorderLayout.CENTER);
        buttonPanel.add(hardLevel, BorderLayout.LINE_END);

        add(mainPanel, BorderLayout.PAGE_START);
        add(buttonPanel, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

}
