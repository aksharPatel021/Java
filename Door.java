
public class Door {
    DoorState state;
    DoorState openingState = new DoorOpeningState(this);
    DoorState closingState = new DoorClosingState(this);
    DoorState openState    = new DoorOpenState(this);
    DoorState closedState  = new DoorClosedState(this);
    DoorState pauseState   = new DoorPauseState(this);

    public Door() {
        // door starts as closed
        setState(closedState);
    }

    public DoorState getDoorOpeningState(){
        return openingState;
    }

    public DoorState getDoorClosingState(){
        return closingState;
    }

    public DoorState getDoorOpenState(){
        return openState;
    }

    public DoorState getDoorClosedState(){
        return closedState;
    }

    public DoorState getDoorPauseState(){
        return pauseState;
    }

    public void open() {
        state.up();
    }

    public void close() {
        state.down();
    }

    public void fullyClosed() {
        state.fullyClosed();
    }

    public void fullyOpen() {
        state.fullyOpen();
    }

    public void setState(DoorState state) {
        this.state = state;
        System.out.println("    door  in state="+state);
    }

    public DoorState getState() {
        return state;
    }

}
