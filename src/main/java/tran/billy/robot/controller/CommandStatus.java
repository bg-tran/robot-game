package tran.billy.robot.controller;

import java.util.Objects;

public class CommandStatus {

    private String status;

    public CommandStatus(Object status){

        this.status = (status != null) ?  status.toString() : "Ignored";
    }

    @Override
    public String toString() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandStatus that = (CommandStatus) o;
        return status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
