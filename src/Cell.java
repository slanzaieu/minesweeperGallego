import javax.swing.JButton;
import java.awt.*;

public class Cell extends JButton {

    Point point;
    String cellLabel;

    public Cell(Point point){

        this.point = point ;
        cellLabel = "label" ;

    }

}