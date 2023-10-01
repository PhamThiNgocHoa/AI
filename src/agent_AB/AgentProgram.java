package agent_AB;

import java.util.Random;

import agent_AB.Environment.LocationState;

public class AgentProgram {

//	public Action execute(Percept p) {// location, status
//		//TODO
//		if(p.getLocationState() == LocationState.DIRTY) {
//			return Environment.SUCK_DIRT;
//		}else if(p.getAgentLocation() == Environment.LOCATION_A) {
//			return Environment.MOVE_RIGHT;
//		}else if(p.getAgentLocation() == Environment.LOCATION_B) {
//			return Environment.MOVE_LEFT;
//		}else if(p.getAgentLocation() == Environment.LOCATION_C) {
//			return Environment.DOWN;
//		}else if(p.getAgentLocation() == Environment.LOCATION_D) {
//			return Environment.UP;
//		}
//		return NoOpAction.NO_OP;
//		
//	}
	
	public Action execute(Percept p) {
        if (p.getLocationState() == LocationState.DIRTY) {
            return Environment.SUCK_DIRT;
        } else if (p.getLocationState() == LocationState.CLEAN) {
            // Chọn một hành động ngẫu nhiên
            Random rand = new Random();
            int randomAction = rand.nextInt(4); // 0-3
            switch (randomAction) {
                case 0:
                    return Environment.UP;
                case 1:
                    return Environment.DOWN;
                case 2:
                    return Environment.MOVE_LEFT;
                case 3:
                    return Environment.MOVE_RIGHT;
                default:
                    return NoOpAction.NO_OP;
            }
        }
        return NoOpAction.NO_OP;
    }
}