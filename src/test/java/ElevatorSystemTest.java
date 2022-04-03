import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorSystemTest {

    @Test
    void update() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(3);

        elevatorSystem.update(0, 1, 3);
        elevatorSystem.update(1, 3, 3);
        elevatorSystem.update(2, 2, 7);

        assertArrayEquals(new int[]{0, 1, 3}, elevatorSystem.elevatorStatus(0));
        assertArrayEquals(new int[]{1, 3, 3}, elevatorSystem.elevatorStatus(1));
        assertArrayEquals(new int[]{2, 2, 7}, elevatorSystem.elevatorStatus(2));

        elevatorSystem.update(0, 17, 4);
        elevatorSystem.update(1, 0, 5);
        elevatorSystem.update(2, 12, 12);

        assertArrayEquals(new int[]{0, 17, 4}, elevatorSystem.elevatorStatus(0));
        assertArrayEquals(new int[]{1, 0, 5}, elevatorSystem.elevatorStatus(1));
        assertArrayEquals(new int[]{2, 12, 12}, elevatorSystem.elevatorStatus(2));
    }

    @Test
    void status() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(2);
        elevatorSystem.update(0, 2, 1);
        elevatorSystem.update(1, 3, 7);
        assertArrayEquals(new int[]{0, 2, 1}, elevatorSystem.status().get(0), "Wrong status 1");
        assertArrayEquals(new int[]{1, 3, 7}, elevatorSystem.status().get(1), "Wrong status 2");
        assertEquals(2, elevatorSystem.status().size(), "Wrong size 1");
    }

    @Test
    void step() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(4);
        //setup start
        elevatorSystem.update(0, 1, 3);
        elevatorSystem.update(1, 3, 3);
        elevatorSystem.update(2, 2, 7);
        elevatorSystem.update(3, 7, 5);
        elevatorSystem.pickup(0, 2);
        elevatorSystem.pickup(3, 5);
        elevatorSystem.pickup(3, 5);
        elevatorSystem.pickup(3, 7);
        //Testing
        elevatorSystem.step();
        assertArrayEquals(new int[]{0, 2, 3}, elevatorSystem.elevatorStatus(0), "Wrong status 1");
        assertArrayEquals(new int[]{1, 3, 3}, elevatorSystem.elevatorStatus(1), "Wrong status 2");
        assertArrayEquals(new int[]{2, 3, 7}, elevatorSystem.elevatorStatus(2), "Wrong status 3");
        assertArrayEquals(new int[]{3, 6, 5}, elevatorSystem.elevatorStatus(3), "Wrong status 4");
        elevatorSystem.step();
        assertArrayEquals(new int[]{0, 3, 3}, elevatorSystem.elevatorStatus(0), "Wrong status 5");
        assertArrayEquals(new int[]{1, 3, 3}, elevatorSystem.elevatorStatus(1), "Wrong status 6");
        assertArrayEquals(new int[]{2, 4, 7}, elevatorSystem.elevatorStatus(2), "Wrong status 7");
        assertArrayEquals(new int[]{3, 5, 5}, elevatorSystem.elevatorStatus(3), "Wrong status 8");
        elevatorSystem.pickup(0, 0);
        elevatorSystem.step();
        assertArrayEquals(new int[]{0, 3, 0}, elevatorSystem.elevatorStatus(0), "Wrong status 9");
        assertArrayEquals(new int[]{1, 3, 3}, elevatorSystem.elevatorStatus(1), "Wrong status 10");
        assertArrayEquals(new int[]{2, 5, 7}, elevatorSystem.elevatorStatus(2), "Wrong status 11");
        assertArrayEquals(new int[]{3, 5, 5}, elevatorSystem.elevatorStatus(3), "Wrong status 12");
        elevatorSystem.step();
        assertArrayEquals(new int[]{0, 2, 0}, elevatorSystem.elevatorStatus(0), "Wrong case 13");
        assertArrayEquals(new int[]{1, 3, 3}, elevatorSystem.elevatorStatus(1), "Wrong case 14");
        assertArrayEquals(new int[]{2, 6, 7}, elevatorSystem.elevatorStatus(2), "Wrong case 15");
        assertArrayEquals(new int[]{3, 5, 5}, elevatorSystem.elevatorStatus(3), "Wrong case 16");
    }

    @Test
    void addElevator() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(10);
        elevatorSystem.addElevator();
        elevatorSystem.addElevator();
        assertEquals(12, elevatorSystem.getNumberOfElevators());
        assertArrayEquals(new int[]{10, 0, 0}, elevatorSystem.elevatorStatus(10), "Wrong status 1");
        assertArrayEquals(new int[]{11, 0, 0}, elevatorSystem.elevatorStatus(11), "Wrong status 2");
    }
}