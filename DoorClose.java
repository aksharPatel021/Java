
public class DoorClose extends Command  {
    Door door;
    DoorState state;
    DoorState previousState;

    public DoorClose(Door door) {
        this.door = door;
    }

    public void execute() {
        previousState = door.getState();
        door.close();
    }

    public void undo() {
        door.setState(previousState);
    }
}
