 
import java.util.Stack;
public class RemoteControlWithUndo
 {
    Door door;
    Light light;
    Command lightPushed;
    Command openDoor;
    Command closeDoor;
    private Stack<Command> undoStack = new Stack<>(); 
    private Stack<Command> redoStack = new Stack<>();
 
    public RemoteControlWithUndo(Door door, Light light) {
        // set up buttons
        this.light = light;
        lightPushed = new LightPushed(light);
        this.door = door;
        openDoor = new DoorOpen(door);
        closeDoor = new DoorClose(door);
    }
 
    public void openPushed() throws CloneNotSupportedException{
        openDoor.execute();
        undoStack.push((Command)openDoor.clone());
    }
 
    public void closePushed() throws CloneNotSupportedException{
        closeDoor.execute();
        undoStack.push((Command)closeDoor.clone());
    }
    public void lightPushed() throws CloneNotSupportedException{
        lightPushed.execute();
        undoStack.push((Command)lightPushed.clone());
    }
 
    public void undoWasPushed() {
            if (undoStack.empty()) return;
            Command toUndo = undoStack.pop();
            toUndo.undo();
            redoStack.push(toUndo);
    }
    public void redoWasPushed() {
            if (redoStack.empty()) return;
            Command toRedo = redoStack.pop();
            toRedo.execute();
            undoStack.push(toRedo);
    }
  
    public String toString() {
        return "\n[undo] " + undoStack + "\n"+"[redo] " + redoStack + "\n";
    }
}
