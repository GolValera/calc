enum OperationType {
    DIVISION ("/"),
    MULTIPLYING ("*"),
    SUBTRACTION ("-"),
    ADDITION ("+");


    final String value;

    OperationType(String value) {
        this.value = value;
    }
}
