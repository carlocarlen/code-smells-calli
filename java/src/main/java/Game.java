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
        if (_board.TileAt(new Position(0, 0)).isNotEmpty() &&
                _board.TileAt(new Position(0, 1)).isNotEmpty() &&
                _board.TileAt(new Position(0, 2)).isNotEmpty()) {
            //if first row is full with same symbol
            if (_board.TileAt(new Position(0, 0)).symbol ==
                    _board.TileAt(new Position(0, 1)).symbol &&
                    _board.TileAt(new Position(0, 2)).symbol == _board.TileAt(new Position(0, 1)).symbol) {
                return _board.TileAt(new Position(0, 0)).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Position(1, 0)).isNotEmpty() &&
                _board.TileAt(new Position(1, 1)).isNotEmpty() &&
                _board.TileAt(new Position(1, 2)).isNotEmpty()) {
            //if middle row is full with same symbol
            if (_board.TileAt(new Position(1, 0)).symbol ==
                    _board.TileAt(new Position(1, 1)).symbol &&
                    _board.TileAt(new Position(1, 2)).symbol ==
                            _board.TileAt(new Position(1, 1)).symbol) {
                return _board.TileAt(new Position(1, 0)).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(new Position(2, 0)).isNotEmpty() &&
                _board.TileAt(new Position(2, 1)).isNotEmpty() &&
                _board.TileAt(new Position(2, 2)).isNotEmpty()) {
            //if middle row is full with same symbol
            if (_board.TileAt(new Position(2, 0)).symbol ==
                    _board.TileAt(new Position(2, 1)).symbol &&
                    _board.TileAt(new Position(2, 2)).symbol ==
                            _board.TileAt(new Position(2, 1)).symbol) {
                return _board.TileAt(new Position(2, 0)).symbol;
            }
        }

        return Symbol.EMPTY;
    }
}

