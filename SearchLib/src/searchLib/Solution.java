package searchLib;

import java.util.LinkedList;

public class Solution {
	LinkedList<Action> actions;

	public Solution() {
		super();
		actions = new LinkedList<>();
	}

	public Solution(LinkedList<Action> solution) {
		super();
		this.actions = solution;
	}

	public LinkedList<Action> getActions() {
		return actions;
	}

	public void setActions(LinkedList<Action> actions) {
		this.actions = actions;
	}

}
