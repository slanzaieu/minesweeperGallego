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
            String textWinner = "YOU ARE THE GALICIAN SCARCE SUN";
            String AnnouncementWinner = "You WON the galician game! I guess you're from Madrid  ";
            JOptionPane.showMessageDialog(null, AnnouncementWinner, textWinner, JOptionPane.INFORMATION_MESSAGE);
            new Difficulty();


        }
    }

    public void finishedGame(boolean lostGame) {

        if (lostGame) {

            String textLoser = "GAME OVER. PERCEBES WON.";
            String Announcement = "Sorry about that, but Einstein once said a galician never fails, only learns! :(";
            JOptionPane.showMessageDialog(null, Announcement, textLoser, JOptionPane.INFORMATION_MESSAGE);
            new Difficulty();

        }
    }
}
