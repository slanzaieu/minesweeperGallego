import javax.swing.JButton;
import java.awt.*;

public abstract class Cell extends JButton {

    Point point;
    String text;

    public Cell(Point point) {

        this.point = point;
        text = " ";

    }

    public void setString(String text) {

        this.text = text;
    }

    public Point getPoint() {

        return point;
    }

    public abstract boolean isBomb();



}
