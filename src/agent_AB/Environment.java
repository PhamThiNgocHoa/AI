package agent_AB; 

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	 public static final Action UP = new DynamicAction("UP");
	    public static final Action DOWN = new DynamicAction("DOWN");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
    public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		
		this.agent =agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
//		if (action == SUCK_DIRT) {
//			String agan = envState.getAgentLocation();
//			envState.setLocationState(agan, LocationState.CLEAN);
//		}else if(action == MOVE_LEFT) {
//			envState.setAgentLocation(LOCATION_A);
//		}else if(action==MOVE_RIGHT) {
//			envState.setAgentLocation(LOCATION_B);
//		}
//		return envState;
//	}
	
	 if (action == SUCK_DIRT) {
         String agentLoc = envState.getAgentLocation();
         envState.setLocationState(agentLoc, LocationState.CLEAN);
         return envState;
     } else if (action == MOVE_LEFT) {
         // Xử lý di chuyển sang trái
    	 envState.setAgentLocation(LOCATION_B);
     } else if (action == MOVE_RIGHT) {
         // Xử lý di chuyển sang phải
    	 envState.setAgentLocation(LOCATION_C);
     } else if (action == UP) {
         // Xử lý di chuyển lên
    	 envState.setAgentLocation(LOCATION_D);
     } else if (action == DOWN) {
         // Xử lý di chuyển xuống
    	 envState.setAgentLocation(LOCATION_A);
     }
     return envState;
 }
	
	


	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		Percept p = new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
		return p;
	}

	private Percept Percept(String agentLocation, LocationState locationState) {
		// TODO Auto-generated method stub
		return null;
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

//		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
//				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
//			
//			isDone = true;// if both squares are clean, then agent do not need to do any action
//		
		 // Kiểm tra tất cả các ô (A, B, C, D) nếu đều sạch thì isDone = true
	    if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
	            && (es.getLocationState(LOCATION_D) == LocationState.CLEAN)) {
	        isDone = true;
	    }
		es.display();
		
		
	}
	

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
	
	private int agentScore = 0; // Khởi tạo biến để lưu điểm của agent
	private Action lastAction;
	public EnvironmentState executeAction1(Action action) {
        Action lastAction = action; // Gán hành động cuối cùng
        // ... (các xử lý khác)
		return envState;
    }
    // Phương thức tính điểm hiệu suất
    public int getPerformanceMeasure() {
        int score = 0;

        if (lastAction == SUCK_DIRT) {
            agentScore += 500; // Cộng 500 điểm nếu hành động là SUCK
        } else if (lastAction == MOVE_LEFT || lastAction == MOVE_RIGHT || lastAction == UP || lastAction == DOWN) {
            agentScore -= 10; // Trừ 10 điểm cho các hành động di chuyển
        } else if (lastAction == NoOpAction.NO_OP) {
            agentScore -= 100; // Trừ 100 điểm nếu agent không thể di chuyển
        }

        return agentScore;
    }
}
