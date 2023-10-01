package agent_AB; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);

		env.step(6);	
		 // Lấy điểm hiệu suất và hiển thị ra màn hình
        int finalScore = env.getPerformanceMeasure();
        System.out.println("Final Score: " + finalScore);
		
		}
}
