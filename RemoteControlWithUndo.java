 
import java.util.Stack;
//
// This is the invoker
//
public class RemoteControlWithUndo
 {
	Command[] onCommands;
	Command[] offCommands;
	private Stack<Command> undoStack = new Stack<>(); 
	private Stack<Command> redoStack = new Stack<>();
 
	public RemoteControlWithUndo() {
		onCommands = new Command[7];
		offCommands = new Command[7];
 
		Command noCommand = new NoCommand();
		for(int i=0;i<7;i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
  
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
 
	public void onButtonWasPushed(int slot) throws CloneNotSupportedException{
		onCommands[slot].execute();
		undoStack.push((Command)onCommands[slot].clone());
	}
 
	public void offButtonWasPushed(int slot) throws CloneNotSupportedException{
		offCommands[slot].execute();
		undoStack.push((Command)offCommands[slot].clone());
	}
 
	public void undoButtonWasPushed() {
            if (undoStack.empty()) return;
            Command toUndo = undoStack.pop();
            toUndo.undo();
            redoStack.push(toUndo);
	}
	public void redoButtonWasPushed() {
            if (redoStack.empty()) return;
            Command toRedo = redoStack.pop();
            toRedo.execute();
            undoStack.push(toRedo);
	}
  
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("\n[undo] " + undoStack + "\n");
		stringBuff.append("\n[redo] " + redoStack + "\n");
		return stringBuff.toString();
	}
}
