package searchLib;

import java.util.LinkedList;

public class ComplicatedAction {
	private Action action;
	private LinkedList<Action> history;

	public ComplicatedAction(Action action, LinkedList<Action> history) {
		super();
		this.action = action;
		this.history = history;
	}

	public Action getAction() {
		return action;
	}


	public LinkedList<Action> getHistory() {
		return history;
	}

	@Override
	public String toString() {
		String str = "";
		if (this.history != null) {
			for (Action a : this.history)
				str += a.toString() + " ";
		}
		if (this.action != null)
			str += this.action + " ";
		return str;

	}

}
