 

public abstract class Command implements Cloneable  {
	public abstract void execute();
	public abstract void undo();
        public Object clone() throws CloneNotSupportedException{
            try {
                Command c = (Command) super.clone();
                return c; 
            }
            catch (CloneNotSupportedException e){
                System.out.println("clone not supported "+e.getMessage());
                return null;
            }
        }
}
