package student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	  public void move() {
	        this.row++;
	    }
	// check whether this Queen can attack the given Queen (q)

	    public boolean isConflict(Queen q) {
	        return this.row == q.getRow() || // Check same row
	               this.column == q.getColumn() || // Check same column
	               Math.abs(this.row - q.getRow()) == Math.abs(this.column - q.getColumn()); // Check diagonals
	    }
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
