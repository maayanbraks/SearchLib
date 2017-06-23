package searchLib;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T> {
	protected PriorityQueue<State<T>> open;
	protected HashSet<State<T>> closed;
	private State<T> finalState;
	protected int evaluatedNodes;

	public CommonSearcher(int evaluatedNodes, PriorityQueue<State<T>> openList) {
		super();
		this.evaluatedNodes = evaluatedNodes;
		this.open = openList;
	}

	protected LinkedList<Action> backTrace(State<T> goalState) {

		LinkedList<Action> actions = new LinkedList<>();
		State<T> state = goalState;
		while (state != null) {

			if (state.getAction() != null) {

				if (state.getAction().getAction() != null) {
					actions.addFirst(state.getAction().getAction());
					if (state.getAction().getHistory() != null) {
						for (int i = state.getAction().getHistory().size() - 1; i >= 0; i--) {
							actions.addFirst(state.getAction().getHistory().get(i));
						}
					}
				}
			}

			state = state.getCameFrom();
		}

		return actions;

	}

	public State<T> getFinalState() {
		return finalState;
	}

	public void setFinalState(State<T> finalState) {
		this.finalState = finalState;
	}

	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	public PriorityQueue<State<T>> getOpen() {
		return open;
	}

	@Override
	public int getNumberOfNodesEvaluated() {
		// TODO Auto-generated method stub
		return evaluatedNodes;
	}

	public CommonSearcher() {
		finalState = null;
		open = new PriorityQueue<>(new Comparator<State<T>>() {

			@Override
			public int compare(State<T> o1, State<T> o2) {
				// TODO Auto-generated method stub
				return ((int) (o1.getCost() - o2.getCost()));
			}
		});
		evaluatedNodes = 0;
	}

	@Override
	public abstract Solution search(Searchable<T> searchable);

}
