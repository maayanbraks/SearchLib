package searchLib;

public class State<T> {
	private State<T> cameFrom;
	private double cost;
	private T state;
	private ComplicatedAction action;

	public State(State<T> cameFrom, double cost, T state, ComplicatedAction action) {
		super();
		this.cameFrom = cameFrom;
		this.cost = cost;
		this.state = state;
		this.action = action;
	}

	public State(State<T> state) {
		super();
		this.cameFrom = state.cameFrom;
		this.cost = state.cost;
		this.state = state.state;
		this.action = state.action;

	}

	public State() {
		super();
		this.cameFrom = null;
		this.cost = 9999;
		this.action = null;
		this.state = null;
	}



	public ComplicatedAction getAction() {
		return action;
	}

	public void setAction(ComplicatedAction action) {
		this.action = action;
	}

	public State<T> getCameFrom() {

		return cameFrom;
	}

	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public T getState() {
		return state;
	}

	public void setState(T state) {
		this.state = state;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return state.equals(((State<T>) obj).state);
	}

	@Override
	public int hashCode() {
		return state.hashCode();
	}

}
