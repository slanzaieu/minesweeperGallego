public class Game {

    Difficulty.Level level;
    int numbCells;
    int numbBombs;

    public Game(Difficulty.Level level, int numbCells, int numbBombs){

        this.level = level;
        this.numbCells = numbCells;
        this.numbBombs = numbBombs;

        new Board(level);
    }
}