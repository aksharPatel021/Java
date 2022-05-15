
public class LightPushed extends Command{
    Light light;

    public LightPushed(Light light) {
        this.light = light;
    }

    public void execute() {
        light.push();
    }

    public void undo() {
        light.push();
    }
}
