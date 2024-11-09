import java.util.HashMap;
import java.util.Map;

public class Board
{
    private final Map<Position, Tile> boardMap = new HashMap<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                boardMap.put(new Position(i, j), new Tile());
            }
        }
    }

    public Tile TileAt(Position position)
    {
        return boardMap.get(position);
    }

    public void AddTileAt(Symbol symbol, Position position) throws Exception {
        TileAt(position).play(symbol);
    }
}