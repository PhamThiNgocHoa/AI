package agent_AB; 

public abstract class Action {
	
    public static final Action DOWN = new DynamicAction("DOWN");
    public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	 public static final Action UP = new DynamicAction("UP");
	public abstract boolean isNoOp();
}