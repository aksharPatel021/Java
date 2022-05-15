
public class DoorPauseState extends DoorState  {
    Door gd;
    public DoorPauseState (Door gd){
        this.gd = gd;
    }

    public  void up(){
        gd.setState(gd.getDoorOpeningState());
    };
    public  void down(){
        gd.setState(gd.getDoorClosingState());
    };

}
