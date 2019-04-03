import java.awt.*;

public class BombCell extends Cell {

    public BombCell(Point point) {

        super(point);
        super.setString(" ");

    }

    @Override
    public boolean isBomb() {
        return true;
    }
}


