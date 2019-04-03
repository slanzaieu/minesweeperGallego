import javax.swing.*;
import java.awt.event.WindowEvent;

public class Game {

    Difficulty.Level level;
    int numbCells;
    int numbBombs;

    public Game(Difficulty.Level level, int numbCells, int numbBombs) {

        this.level = level;
        this.numbCells = numbCells;
        this.numbBombs = numbBombs;

        new Board(this, level, numbCells, numbBombs);
    }

    public void wonGame(boolean wontheGame) {

        if (wontheGame) {
            String textWinner = "YOU BEAT ME!";
            String AnnouncementWinner = "You finished the game! :)";
            JOptionPane.showMessageDialog(null, AnnouncementWinner, textWinner, JOptionPane.INFORMATION_MESSAGE);


        }
    }

    public void finishedGame(boolean lostGame) {

        if (lostGame) {

            String textLoser = "GAME OVER";
            String Announcement = "The game has finished! :(";
            JOptionPane.showMessageDialog(null, Announcement, textLoser, JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
