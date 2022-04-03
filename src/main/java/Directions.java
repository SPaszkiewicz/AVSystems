public enum Directions {
    UP,
    DOWN,
    INPLACE;

    int toUnit() { //Give 1 direction vector from enum
        switch (this) {
            case UP:
                return 1;
            case DOWN:
                return -1;
            case INPLACE:
            default:
                return 0;
        }
    }

    // gets difference between current floor and next floor so values should be opposite
    static Directions fromInt(int num) {
        if (num > 0) return DOWN;
        else if (num < 0) return UP;
        else return INPLACE;
    }
}
