import javax.swing.*;

public class Game {

    Difficulty.Level level;
    int numbCells;
    int numbBombs;

    public Game(Difficulty.Level level, int numbCells, int numbBombs){

        this.level = level;
        this.numbCells = numbCells;
        this.numbBombs = numbBombs;

        new Board(level, numbCells, numbBombs);
    }

    public void finishedGame(boolean lostGame) {

        if (lostGame){
            String textLoser = "GAME OVER";
            String Announcement = "The game has finished! :(";
            JOptionPane.showMessageDialog(null, Announcement, textLoser, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}