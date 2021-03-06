/*
 * @(#)Canevas.java	1.0 26-Feb-04
 */
package models.MG;
import java.awt.Graphics;
import java.awt.Color;
import modulecoFramework.modeleco.EWorld;
import modulecoFramework.modeleco.CAgent;
/**
 * Re-define the colors of the agents in the bottom panel (<em>Canevas</em>),
 * depending on their state.
 * 
 * @author Gilles Daniel (gilles@cs.man.ac.uk)
 * @version 1.0, 26-Feb-04
 */
public class Canevas extends modulecoGUI.grapheco.Canevas {
	/**
	 * Store the state of each agent
	 */
	protected boolean state[][];
	/**
	 * Define the color used to represent agents
	 */
	protected Color c[];
	/**
	 * Create a new canevas
	 */
	public Canevas() {
		super();
	}
	/**
	 * This method has to be re-implemented (over-written)
	 */
	public void setCAgent(CAgent cAgent) {
		//System.out.println("[Canevas.setCAgent()]");
		this.eWorld = (EWorld) cAgent;
		c = ((World) eWorld).getColors();
		size = (new Double(Math.sqrt(eWorld.getAgentSetSize()))).intValue();
		state = new boolean[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				state[j][i] = ((Agent) (eWorld.get(j * size + i)))
						.getBooleanState();
		drawAble = true; // DP 20/08/2002
	}
	/**
	 * Set the color of agents
	 */
	protected void drawPoint(Graphics g, int i, int j, int a, int b, int x,
			int y) {
		if (eWorld != null) {
			int i1, j1;
			// Get the state of the agent
			//System.out.println("[Canevas.drawPoint()]");
			state[j][i] = ((Agent) (eWorld.get(j * size + i)))
					.getBooleanState();
			//	Set his color
			g.setColor(c[(state[j][i] == true ? 0 : 1)]);
			i1 = i * a;
			j1 = j * b;
			// Draw a circle if the size of the world is smaller than 20, or a
			// rectangle by default
			if (size < 20)
				// Draw a circle
				g.fillArc(i1 + 1 + x / 2, j1 + 1 + y / 2, a - 2, b - 2, 0, 360);

			else
				g.fillRect(i1 + 1 + x / 2, j1 + 1 + y / 2, a, b);
		}
	}
}
