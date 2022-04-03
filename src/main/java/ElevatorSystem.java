import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElevatorSystem {
    private final List<Elevator> elevators;
    private int numberOfElevators;

    public ElevatorSystem(int numOfElevator) {
        this.numberOfElevators = numOfElevator;
        int[] indexes = IntStream
                .range(0, numOfElevator)
                .toArray();

        this.elevators = Arrays
                .stream(indexes)
                .mapToObj(Elevator::new)
                .collect(Collectors.toList());
    }

    public void addElevator() {
        elevators.add(new Elevator(this.numberOfElevators));
        this.numberOfElevators++;
    }

    public int getNumberOfElevators() {
        return numberOfElevators;
    }

    public void pickup(int elevatorId, int floor) { //Add request
        this.elevators.get(elevatorId).getRequests().add(floor,
                this.elevators.get(elevatorId).getNextFloor(),
                this.elevators.get(elevatorId).getCurrentFloor());
    }

    public void update(int elevatorId, int currentFloor, int nextFloor) { //set new position for elevator
        this.elevators.get(elevatorId).setCurrentFloor(currentFloor);
        this.elevators.get(elevatorId).setNextFloor(nextFloor);
        this.elevators.get(elevatorId).setDirection(Directions.fromInt(currentFloor - nextFloor));
    }

    public List<int[]> status() { // status in array
        return this.elevators.stream().map(Elevator::giveStatus).collect(Collectors.toList());
    }

    public int[] elevatorStatus(int id) {  //status for one elevator
        return this.elevators.get(id).giveStatus();
    }

    public void printStatus() { //printed status
        List<int[]> result = status();
        System.out.print("[");
        for (int[] tuple : result) {
            System.out.printf(" (%d, %d, %d) ", tuple[0], tuple[1], tuple[2]);
        }
        System.out.print("]\n");
    }

    public void manageElevator(int id) { //step for one Elevator
        Elevator elevator = this.elevators.get(id);
        elevator.setCurrentFloor(elevator.getCurrentFloor() + elevator.getDirection().toUnit()); //move elevator

        if (elevator.getRequests().contains(elevator.getCurrentFloor())) //if floor was ordered remove from queue
            elevator.getRequests().remove(elevator.getCurrentFloor());

        //if reached destination, check next order
        if (elevator.getCurrentFloor() == elevator.getNextFloor() && !elevator.getRequests().isEmpty()) {
            elevator.setNextFloor(elevator.getRequests().pop());
            elevator.setDirection(Directions.fromInt(elevator.getCurrentFloor() - elevator.getNextFloor()));
        }
        //if reached destination and there is no requests, stay in place
        if (elevator.getCurrentFloor() == elevator.getNextFloor() && elevator.getRequests().isEmpty()) {
            elevator.setDirection(Directions.INPLACE);
        }
    }


    public void step() { //step for every elevator in system
        for (int i = 0; i < this.numberOfElevators; i++) {
            manageElevator(i);
        }
    }
}
