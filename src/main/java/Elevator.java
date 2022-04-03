

public class Elevator {
    private final int id;
    private int currentFloor;
    private int nextFloor;
    private Directions direction = Directions.INPLACE;
    private final Request requests = new Request();

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.nextFloor = 0;
    }

    public Request getRequests() {
        return requests;
    }

    public int[] giveStatus() {
        return new int[]{this.id, this.currentFloor, nextFloor};
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }
}
