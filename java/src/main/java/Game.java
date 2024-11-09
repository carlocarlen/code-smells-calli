public class Game {
    private Symbol _lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void Play(Symbol symbol, Position position) throws Exception {
        //if first move
        if (_lastSymbol == Symbol.EMPTY) {
            //if player is X
            if (symbol == Symbol.O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(position).isNotEmpty()) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, position);
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        if (_board.isRowNotEmpty(0)) {
            if (_board.isRowCompleted(0)) {
                return _board.getSymbolAt(new Position(0, 0));
            }
        }

        //if the positions in first row are taken
        if (_board.isRowNotEmpty(1)) {
            if (_board.isRowCompleted(1)) {
                return _board.getSymbolAt(new Position(1, 0));
            }
        }

        //if the positions in first row are taken
        if (_board.isRowNotEmpty(2)) {
            if (_board.isRowCompleted(2)) {
                return _board.getSymbolAt(new Position(2, 0));
            }
        }

        return Symbol.EMPTY;
    }

}

