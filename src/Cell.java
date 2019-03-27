import javax.swing.JButton;
import java.awt.*;

public class Cell extends JButton {

    Point point;
    String text;
    boolean isABomb;

    public Cell(Point point){

        this.point = point ;
        text = " " ;

    }

    public void setBomb(boolean isBomb) {

        this.isABomb = isABomb;
    }

    public void setString(String text) {

        this.text = text;
    }

    public Point getPoint() {

        return point;
    }

    public boolean getBomb() {

        return isABomb;
    }

}
