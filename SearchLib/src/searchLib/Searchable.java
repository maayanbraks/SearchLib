package searchLib;

import java.util.HashMap;

public interface Searchable<T>
{
	public State<T> getInitialState();
	public State<T> getGoalState();
	public HashMap<ComplicatedAction,State<T>> getAllPossibleStates(State<T> state);

}
