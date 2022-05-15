
public class DoorClosedState extends DoorState  {
    Door gd;
    public DoorClosedState (Door gd){
        this.gd = gd;
    }

    public  void up(){
        gd.setState(gd.getDoorOpeningState());
    };

    public  void down(){
    };
}
