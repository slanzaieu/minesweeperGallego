import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BombCell extends Cell {

    public BombCell(Point point)  {

        super(point);
        super.setString(" ");
    }

    @Override
    public boolean isBomb() {
        return true;
    }
}
