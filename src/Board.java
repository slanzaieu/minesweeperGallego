import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.*;

public class Board extends JFrame implements ClickObserver {

    private JPanel mainPanel;
    private JPanel leftPanel;
    private Cell cell;
    private HashMap<Point, Cell> finderCellsHashMap = new HashMap<>();
    private Game game;
    private int rightCells;
    private int cellsLeft;
    private JLabel cellsCount;

    public Board(Game game, Difficulty.Level level, int numbCells, int numbBombs) {
        this.game = game;
        this.rightCells = 0;
        this.cellsLeft = numbCells - numbBombs;

        initializeGui(level, numbCells, numbBombs, cellsLeft);
    }

    public void initializeGui(Difficulty.Level level, int numbCells, int numbBombs, int cellsLeft) {

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        leftPanel = new JPanel();
        JLabel cellsCount = new JLabel();
        cellsCount.setText(String.valueOf(cellsLeft));
        JLabel bombCount = new JLabel();
        bombCount.setText(String.valueOf(numbBombs));
        bombCount.setOpaque(true);
        bombCount.setBackground(Color.RED);
        Font font = new Font("Courier", Font.BOLD,15);
        cellsCount.setFont(font);
        bombCount.setFont(font);


        leftPanel.add(cellsCount, BorderLayout.EAST);
        leftPanel.add(bombCount, BorderLayout.WEST);

        mainPanel.add(leftPanel, BorderLayout.PAGE_START);




        // boardPanel = new JPanel();
        // boardPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        int boardDimension;
        int frameDimension;

        switch (level) {

            case Easy:
                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 500;
                // boardPanel = boardCreator(boardDimension, frameDimension);
                // bombsPlacer(numbBombs, boardDimension);
                // addAction(boardDimension, numbBombs, numbCells);

                break;

            case Medium:

                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 450;
                // boardPanel = boardCreator(boardDimension, frameDimension);
                // bombsPlacer(numbBombs, boardDimension);
                // addAction(boardDimension, numbBombs, numbCells);

                break;

            case Hard:
            default:
                boardDimension = (int) Math.sqrt(numbCells);
                frameDimension = 550;
                // boardPanel = boardCreator(boardDimension, frameDimension);
                // bombsPlacer(numbBombs, boardDimension);
                // addAction(boardDimension, numbBombs, numbCells);
                break;
        }

        JPanel boardPanel = boardCreator(boardDimension, frameDimension);
        bombsPlacer(boardPanel, numbBombs, boardDimension);
        addAction(boardDimension, numbBombs, numbCells);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MineSweeper Gallego");
        setVisible(true);

    }


    private JPanel boardCreator(int boardDimension, int frameDimension) {

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

        return boardPanel;
    }

    public void bombsPlacer(JPanel boardPanel, int numbBombs, int boardDimension) {

        boolean isABomb;

        // JPanel newnewRow;

        int counterBombs = 0;

        Random random = new Random();

        while (counterBombs < numbBombs) {

            int x = random.nextInt(boardDimension);
            int y = random.nextInt(boardDimension);

            Point presentPoint = new Point(x, y);
            isABomb = finderCellsHashMap.get(presentPoint).isBomb();

            JPanel row = (JPanel) boardPanel.getComponent(y);

            // newnewRow = new JPanel();

            if (!isABomb) {
                // finderCellsHashMap.get(presentPoint).setBomb(true);
                cell = new BombCell(presentPoint);

                finderCellsHashMap.put(presentPoint, cell);
                cell.setPreferredSize(new Dimension(30, 30));

                System.out.format("Bomb(%d, %d)%n", x, y);
                row.remove(x);
                row.add(cell, x);
                // newnewRow.add(cell);
                // newnewRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
                counterBombs++;

            }

        }

    }

    @Override
    public Point cellClicked(Cell cell) {
        return cell.getPoint();
    }

    public void addAction(int boardDimension, int numbBombs, int numbCells) {

        for (Entry<Point, Cell> entry : finderCellsHashMap.entrySet()) {

            // Cell presentCell = finderCellsHashMap.get(point);
            Cell presentCell = entry.getValue();

            // String cell_class = presentCell.getClass().getName();
            // System.out.println(cell_class);

            presentCell.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    // int i = 0;

                    if (presentCell instanceof EmptyCell) {

                        if (presentCell.getBackground().equals(Color.GREEN)) {
                            return;
                        }

                        presentCell.setBackground(Color.GREEN);
                        presentCell.setOpaque(true);
                        presentCell.setBorderPainted(false);
                        presentCell.setEnabled(false);
                        // i++;
                        rightCells++;
                        cellsLeft = (numbCells - numbBombs) - rightCells;



                        if (numbCells - rightCells <= numbBombs) {
                            game.wonGame(true);
                        } else {
                            game.wonGame(false);
                        }

                    } else if (presentCell instanceof BombCell) {
                        presentCell.setBackground(Color.RED);
                        presentCell.setOpaque(true);
                        presentCell.setBorderPainted(false);
                        presentCell.setEnabled(false);
                        game.finishedGame(true);

                    } else {
                        System.out.println(presentCell);
                    }
                }
            });
        }

    }

}
