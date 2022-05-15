
public class DoorOpeningState extends DoorState  {
    Door gd;
    public DoorOpeningState (Door gd){
        this.gd = gd;
    }

    public  void down(){
        gd.setState(gd.getDoorPauseState());
    };
    public  void fullyOpen(){
        gd.setState(gd.getDoorOpenState());
    };

    public  void up(){
    };
}
