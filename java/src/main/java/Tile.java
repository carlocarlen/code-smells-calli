
public class Tile
{
    public Symbol symbol = Symbol.EMPTY;

    public Tile() {
    }

    public void play(Symbol symbol) throws Exception {
        if (symbol == Symbol.EMPTY) {
            throw new Exception("Play empty is not allowed");
        }
        this.symbol = symbol;
    }

    public boolean isNotEmpty() {
        return this.symbol != Symbol.EMPTY;
    }
}