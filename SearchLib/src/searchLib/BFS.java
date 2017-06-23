package searchLib;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BFS<T> extends CommonSearcher<T> {

	@Override
	public Solution search(Searchable<T> searchable) {
		this.open = new PriorityQueue<>(new Comparator<State<T>>() {

			@Override
			public int compare(State<T> o1, State<T> o2) {
				return (int) (o1.getCost() - o2.getCost());
			}
		});

		this.closed = new HashSet<>();
		this.closed.clear();
		this.open.add(searchable.getInitialState());
		State<T> state = null;
		while (!this.open.isEmpty()) {
			state = this.open.poll();
			this.evaluatedNodes++;
			this.closed.add(state);
			if (state.equals(searchable.getGoalState())) {

				Solution solution = new Solution();
				solution.setActions(backTrace(state));
				setFinalState(state);
				return solution;
			}
			HashMap<ComplicatedAction, State<T>> hm = searchable.getAllPossibleStates(state);

			for (ComplicatedAction action : hm.keySet()) {
				State<T> s = hm.get(action);
				if (!this.closed.contains(s)) {
					if (!this.open.contains(s))
						this.open.add(s);
					else {
						for (State<T> os : this.open) {
							if (os.equals(s)) {
								if (s.getCost() < os.getCost()) {
									this.open.remove(os);
									os.setCost(s.getCost());
									this.open.add(os);
								}
							}
						}
					}
				}

			}

		}
		return null;

	}
}
