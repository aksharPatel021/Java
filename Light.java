
public class Light {
    LightState state;
    LightState onState = new LightOnState(this);
    LightState offState = new LightOffState(this);

    public Light() {
        // light starts as turned off
        setState(offState);
    }

    public LightState getLightOnState(){
        return onState;
    }

    public LightState getLightOffState(){
        return offState;
    }

    public void push() {
        state.push();
    }

    public void setState(LightState state) {
        this.state = state;
        System.out.println("    light in state="+state);
    }

    public LightState getState() {
        return state;
    }

}
