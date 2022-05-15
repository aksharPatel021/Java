
public class DoorOpenState extends DoorState  {
    Door gd;
    public DoorOpenState (Door gd){
        this.gd = gd;
    }

    public  void down(){
        gd.setState(gd.getDoorClosingState());
    };

    public  void up(){
    };
}
