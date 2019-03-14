import java.awt.*;

public class EmptyCell extends Cell {

    String cellLabel;

    public EmptyCell(Point point) {

        super(point);
        this.cellLabel = " " ;

    }

}