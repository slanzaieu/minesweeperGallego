import java.awt.*;

public class BombCell extends Cell {

    public BombCell(Point point) {

        super(point);
        super.setBomb(true);
        super.setString("x");
        super.setBackground(Color.RED);
        super.setOpaque(true);

    }
}

