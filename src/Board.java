import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

public class Board extends JFrame implements ClickObserver {


    private JPanel mainPanel;
    private Cell cell;
    private HashMap<Point, Cell> finderCellsHashMap = new HashMap<>();
    private Game game;



    public Board(Difficulty.Level level, int numbCells, int numbBombs) {
        initializeGui(level, numbCells, numbBombs);
    }



    public void initializeGui(Difficulty.Level level, int numbCells, int numbBombs) {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        int boardDimension;
        int frameDimension;

        switch (level) {

            case Easy:
                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 500;
                boardCreator(boardDimension, frameDimension);
                bombsPlacer(numbBombs, boardDimension);
                addAction(boardDimension);

                break;

            case Medium:

                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 450;
                boardCreator(boardDimension, frameDimension);
                bombsPlacer(numbBombs, boardDimension);
                addAction(boardDimension);
                break;

            case Hard:
                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 550;
                boardCreator(boardDimension, frameDimension);
                bombsPlacer(numbBombs, boardDimension);
                addAction(boardDimension);
                break;

        }

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MineSweeper Gallego");
        setVisible(true);

    }

    public void boardCreator(int boardDimension, int frameDimension) {

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel newRow;

        mainPanel.setPreferredSize(new Dimension(frameDimension, frameDimension));
        boardPanel.setPreferredSize(new Dimension(frameDimension, frameDimension));
        setSize(frameDimension, frameDimension);

        for (int i = 0; i < boardDimension; i++) {

            newRow = new JPanel();

            for (int j = 0; j < boardDimension; j++) {

                Point point = new Point(i, j);
                cell = new EmptyCell(point);

                finderCellsHashMap.put(point, cell);
                cell.setPreferredSize(new Dimension(30, 30));
                newRow.add(cell);
                newRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

            }

            boardPanel.add(newRow);
        }
        mainPanel.add(boardPanel);

    }

    public void bombsPlacer(int numbBombs, int boardDimension) {

        boolean isABomb;

        int counterBombs = 0;

        Random random = new Random();

        while (counterBombs < numbBombs) {

            int x = random.nextInt(boardDimension);
            int y = random.nextInt(boardDimension);

            Point presentPoint = new Point(x, y);
            isABomb = finderCellsHashMap.get(presentPoint).getBomb();

            if (!isABomb) {
                finderCellsHashMap.get(presentPoint).setBomb(true);
                cell = new BombCell(presentPoint);

                finderCellsHashMap.put(presentPoint, cell);
                counterBombs++;

            }

        }

    }

    @Override
    public Point cellClicked(Cell cell) {
        return cell.getPoint();
    }

    public void addAction(int boardDimension) {

        for (Point point : finderCellsHashMap.keySet()) {

            Cell presentCell = finderCellsHashMap.get(point);
            String cell_class = presentCell.getClass().getName();
            System.out.println(cell_class);

            presentCell.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (presentCell instanceof EmptyCell) {
                        presentCell.setBackground(Color.GREEN);
                        presentCell.setOpaque(true);
                        presentCell.setBorderPainted(false);

                    } else if (presentCell instanceof BombCell) {
                        presentCell.setBackground(Color.RED);
                        presentCell.setOpaque(true);
                        presentCell.setBorderPainted(false);
                        game.finishedGame(true);
                    }
                }
            });
        }

    }

}

