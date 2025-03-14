# Agent-Based Simulation

## Project Overview
The simulation models agents moving in a continuous 2D space (500×500) where they interact based on proximity. Each agent’s movement is influenced by the number of neighboring agents within a fixed radius. The system demonstrates how agent density and interaction radii affect the overall convergence of the simulation.

### Core Features
- **Agent Types:**
  - **SocialAgent:** Moves when fewer than a threshold number of neighbors are detected.
  - **AntiSocialAgent:** Moves when too many neighbors are present.
- **Landscape:** Manages the 2D environment and agent updates.
- **Simulation Loop:** Runs until the system stabilizes (no agents move) or a maximum iteration limit is reached.
- **Experiments:** Includes tests varying the number of SocialAgents and the agent interaction radius.

## Extensions

### Dynamic Simulation Controls (GUI)
- Developed using Java Swing.
- Provides a user-friendly interface for dynamic input of simulation parameters (landscape dimensions, number of agents, interaction radius, and maximum iterations).
- Includes control buttons (Start, Pause, Resume) and a speed slider for real-time simulation adjustments.
- Displays real-time statistics such as the current iteration count and the number of agents that moved in the last update.

### LeaderAgent Influence on Simulation Convergence
- Introduces a new agent type called **LeaderAgent**.
- LeaderAgents remain static (their `updateState` method is empty) and act as anchors that constrain the movement of nearby SocialAgents and AntiSocialAgents.
- Experiments indicate that even a small number of LeaderAgents can significantly alter convergence dynamics.
- For example, experiments with 150 SocialAgents showed a baseline stabilization in 680 iterations. Adding LeaderAgents increased iterations in a non-linear fashion—with 16 LeaderAgents yielding around 930 iterations—before excessive numbers (e.g., 128 or 150) led to timeouts.

## Experiments
Three key experiments were performed:
1. **Varying the Number of SocialAgents:** Tested with 50, 100, 150, 200, and 250 agents.
2. **Varying the Agent Radius:** Tested with radii of 5, 10, 15, 20, 25, 30, and 35.
3. **LeaderAgent Influence:** With a constant 150 SocialAgents, varied the number of LeaderAgents.


## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or later.
- An IDE (e.g., Eclipse, IntelliJ) or command-line tools.
- Git (to clone the repository).

### Compilation and Execution

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Muneeb-ii/Agent_Based_Simulation.git
   cd Agent_Based_Simulation
2. **Compile the Project:**
   ```bash
   javac *.java
3. **Run the Simulations:**
    - _Baseline Simulation (No LeaderAgents):_
      ```bash
      cd src
      java AgentSimulation 150
    - _Simulation with LeaderAgents (e.g., 16 LeaderAgents):_
      ```bash
      cd extension
      java AgentSimulationExt 16 150
5. Run the GUI Version (No LeaderAgents):
   ```bash
   cd extension
   java AgentSimulationGUI
Follow the on-screen prompts to enter the simulation parameters.

## Code Structure
- **Agent.java:** Abstract base class for all agents.
- **SocialAgent.java & AntiSocialAgent.java:** Implement agent-specific behavior.
- **LeaderAgent.java:** Implements the static leader agent.
- **Landscape.java:** Manages the simulation environment and agent interactions.
- **LandscapeDisplay.java / LandscapeDisplayGUI.java:** Handle the visualization of the simulation.
- **AgentSimulation.java, AgentSimulationExt.java, AgentSimulationGUI.java:** Contain the simulation driver logic.

## Acknowledgments
- Stack Overflow
- GeeksForGeeks
- Oracle Documentation for Java Swing and JFrame
- Special thanks to my peers and instructors for their feedback.
