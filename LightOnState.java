
public class LightOnState extends LightState  {
    Light light;
    public LightOnState (Light light){
        this.light = light;
    }

    public  void push(){
        light.setState(light.getLightOffState());
    };

}
