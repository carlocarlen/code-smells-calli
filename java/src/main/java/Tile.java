
public class Tile
{
    private final Position position;
    public char Symbol;

    public Tile(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}