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

    public boolean isRowCompleted(int row) {
        return TileAt(new Position(row, 0)).symbol ==
                TileAt(new Position(row, 1)).symbol &&
                TileAt(new Position(row, 2)).symbol ==
                        TileAt(new Position(row, 1)).symbol;
    }

    boolean isRowNotEmpty(int x) {
        return TileAt(new Position(x, 0)).isNotEmpty() &&
                TileAt(new Position(x, 1)).isNotEmpty() &&
                TileAt(new Position(x, 2)).isNotEmpty();
    }
}