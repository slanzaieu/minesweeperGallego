import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {


    private JPanel mainPanel;
    private JButton cell;

    public Board(Difficulty.Level level) {
        Gui(level);
    }

    public void Gui(Difficulty.Level level) {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel newRow;

        switch(level) {

            case Easy:

                mainPanel.setPreferredSize(new Dimension(325, 325));
                boardPanel.setPreferredSize(new Dimension(300, 300));
                setSize(350, 350);

                for (int i = 0; i < 8; i++) {
                    newRow = new JPanel();
                    for (int j = 0; j < 8; j++){
                        Point point = new Point(i,j);
                        cell = new Cell(point);
                        cell.setPreferredSize(new Dimension(50, 50));
                        newRow.add(cell);
                        newRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
                    }

                    boardPanel.add(newRow);
                }

                break;

            case Medium:

                mainPanel.setPreferredSize(new Dimension(400, 400));
                boardPanel.setPreferredSize(new Dimension(375, 375));
                setSize(425, 425);

                for (int i = 0; i < 14; i++) {
                    newRow = new JPanel();
                    for (int j = 0; j < 14; j++){
                        Point point = new Point(i,j);
                        cell = new Cell(point);
                        cell.setPreferredSize(new Dimension(25, 25));
                        newRow.add(cell);
                        newRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
                    }
                    boardPanel.add(newRow);
                }

                break;

            case Hard:

                mainPanel.setPreferredSize(new Dimension(525, 525));
                boardPanel.setPreferredSize(new Dimension(500, 500));

                setSize(550, 550);
                for (int i = 0; i < 18; i++) {
                    newRow = new JPanel();
                    for (int j = 0; j < 18; j++){
                        Point point = new Point(i,j);
                        cell = new Cell(point);
                        cell.setPreferredSize(new Dimension(25, 25));
                        newRow.add(cell);
                        newRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
                    }

                    boardPanel.add(newRow);
                }
        }

        mainPanel.add(boardPanel);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setVisible(true);

    }
}
