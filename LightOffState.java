
public class LightOffState extends LightState  {
    Light light;
    public LightOffState (Light light){
        this.light = light;
    }

    public  void push(){
        light.setState(light.getLightOnState());
    };

}
