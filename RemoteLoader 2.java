 

public class RemoteLoader {
 
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("\nloader beginning");
        // initiallize door, light, remote
        Door door = new Door();
        Light light = new Light();
        RemoteControlWithUndo rc = new RemoteControlWithUndo(door, light);
        
        System.out.println("pressing open  door: ");
        rc.openPushed(); //press door open button
        System.out.println("sensor says fully open: ");
        door.fullyOpen(); //sensor tells door its fully open
        System.out.println("pressing close door: ");
        rc.closePushed(); //press door close button
        System.out.println("sensor says fully closed: ");
        door.fullyClosed(); //sensor tells door its fully closed
        
        System.out.println("pressing push for light: ");
        rc.lightPushed();   // press push light button 
        System.out.println("pressing push for light: ");
        rc.lightPushed();    // press push light button 
        
        System.out.println("4 undos");
        rc.undoWasPushed();
        rc.undoWasPushed();
        rc.undoWasPushed();
        rc.undoWasPushed();
    }
}
