import java.util.ArrayList;
import java.util.HashSet;

public class Request {
    private final ArrayList<Integer> ordered = new ArrayList<>();
    private final HashSet<Integer> set = new HashSet<>();

    public ArrayList<Integer> getOrdered() { //Mainly used for tests
        return ordered;
    }

    public HashSet<Integer> getSet() { //Mainly used for tests
        return set;
    }

    void add(int floor, int currentOrder, int currentFloor) { //if are not queued and not in progress add to queue
        if (!this.set.contains(floor) && currentOrder != floor && currentFloor != floor) {
            ordered.add(floor);
            set.add(floor);
        }
    }

    void remove(int floor) { //Used when floor is queued and elevator is on it
        ordered.remove((Integer) floor);
        set.remove(floor);
    }

    int pop() { //Give first not served order
        int floor = ordered.get(0);
        ordered.remove(0);
        set.remove(floor);
        return floor;
    }

    boolean contains(int floor) {
        return set.contains(floor);
    }

    int getSize(){
        return ordered.size();
    }

    boolean isEmpty(){
        return ordered.isEmpty();
    }
}
