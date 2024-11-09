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
        else if (_board.TileAt(position.x(), position.y()).Symbol != Symbol.EMPTY) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, position.x(), position.y());
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(0, 0).Symbol != Symbol.EMPTY &&
                _board.TileAt(0, 1).Symbol != Symbol.EMPTY &&
                _board.TileAt(0, 2).Symbol != Symbol.EMPTY) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(1, 0).Symbol != Symbol.EMPTY &&
                _board.TileAt(1, 1).Symbol != Symbol.EMPTY &&
                _board.TileAt(1, 2).Symbol != Symbol.EMPTY) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(2, 0).Symbol != Symbol.EMPTY &&
                _board.TileAt(2, 1).Symbol != Symbol.EMPTY &&
                _board.TileAt(2, 2).Symbol != Symbol.EMPTY) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return Symbol.EMPTY;
    }
}

