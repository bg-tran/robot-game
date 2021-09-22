package tran.billy.games.robot.sufaces;

import tran.billy.games.robot.navigation.Position;

/**
 * An implementation of the rectangle surface to place the robot on
 *
 */
public class RectTable implements Surface{
    private int columnNo;
    private int rowNo;

    public RectTable(int column, int row){
        columnNo = column;
        rowNo = row;
    }

    @Override
    public boolean isPositionAvailable(Position position) {
        return position != null
                && (position.getCol() + 1) * (position.getCol() - this.columnNo) < 0
                && (position.getRow() + 1) * (position.getRow() - this.rowNo) < 0;
    }
}
