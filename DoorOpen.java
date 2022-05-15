
public class DoorOpen extends Command  {
    Door door;
    DoorState state;
    DoorState previousState;

    public DoorOpen(Door door) {
        this.door = door;
    }

    public void execute() {
        previousState = door.getState();
        door.open();
    }

    public void undo() {
        door.setState(previousState);
    }
}
