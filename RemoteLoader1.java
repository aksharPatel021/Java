public class RemoteLoader1 {

    public static void main(String[] args) throws CloneNotSupportedException{
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanLowCommand ceilingFanLow =
            new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium =
            new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh =
            new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff =
            new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, ceilingFanLow, ceilingFanOff);
        remoteControl.setCommand(1, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(2, ceilingFanHigh, ceilingFanOff);

        System.out.println("5 on buttons pressed at start");
        remoteControl.onButtonWasPushed(0); // ->low
        remoteControl.onButtonWasPushed(1); // ->medium
        remoteControl.onButtonWasPushed(0); // ->low
        remoteControl.onButtonWasPushed(2); // ->high
        remoteControl.onButtonWasPushed(1); // ->medium
        //System.out.println("undo stack\n"+remoteControl);
        // undo stack has
        //   ceilingFanMedium at top
        //   ceilingFanHigh  
        //   ceilingFanLow
        //   ceilingFanMedium
        //   ceilingFanLow at bottom
        System.out.println("undo command");
        remoteControl.undoButtonWasPushed(); // go back to high
        System.out.println("redo command");
        remoteControl.redoButtonWasPushed(); // return to medium
        //System.out.println("undo stack\n"+remoteControl);
        // undo stack has
        //   ceilingFanMedium at top
        //   ceilingFanHigh  
        //   ceilingFanLow
        //   ceilingFanMedium
        //   ceilingFanLow at bottom
        System.out.println("undo 4 commands");
        remoteControl.undoButtonWasPushed(); // go back to high
        remoteControl.undoButtonWasPushed(); // go back to low
        remoteControl.undoButtonWasPushed(); // go back to medium
        remoteControl.undoButtonWasPushed(); // go back to LOW
        //System.out.println("undo stack\n"+remoteControl);
        // redo stack has
        //   ceilingFanMedium at top
        //   ceilingFanLow  
        //   ceilingFanHigh
        //   ceilingFanMedium at bottom
        System.out.println("redo 4 commands");
        remoteControl.redoButtonWasPushed(); // return to medium
        remoteControl.redoButtonWasPushed(); // return to low
        remoteControl.redoButtonWasPushed(); // return to high
        remoteControl.redoButtonWasPushed(); // return to medium
        //System.out.println("undo stack\n"+remoteControl);
    }
}