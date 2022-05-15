
public class DoorClosingState extends DoorState  {
    Door door;
    public DoorClosingState (Door door){
        this.door = door;
    }

    public  void up(){
        door.setState(door.getDoorPauseState());
    };
    public  void fullyClosed(){
        door.setState(door.getDoorClosedState());
    };

    public  void down(){
    };
}
