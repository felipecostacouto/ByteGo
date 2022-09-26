package model.entity.management;

public enum ADMOperation
{
    DELETE("DELETE"),
    PROMOTE("PROMOTE");

    private final String operation;

    ADMOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
