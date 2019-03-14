import java.awt.*;

public class BombCell extends Cell {

    String cellLabel;

    public BombCell(Point point) {

        super(point);
        this.cellLabel = "*" ;

    }
}
