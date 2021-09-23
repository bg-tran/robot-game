package tran.billy.robot.navigation;

import java.util.Objects;

public class Position {
    private final int col;
    private final int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    public static Position getPosition(String col, String row){

        try {
            return new Position(Integer.parseInt(col.trim()),Integer.parseInt(row.trim()));

        }catch (NumberFormatException | NullPointerException e){
            return null;
        }
    }

    @Override
    public String toString() {
        return "(" +col + "," + row + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return col == position.col && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
