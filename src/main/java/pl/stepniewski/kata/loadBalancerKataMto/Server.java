package pl.stepniewski.kata.loadBalancerKataMto;

public class Server {

	private static final double MAXIMUM_LOAD = 100d;
	public double currentLoadPecentage;
	private int capacity;

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm theVm) {
		return true;
	}

	public void addVm(Vm vm) {
		currentLoadPecentage = (double) vm.size / (double) capacity * MAXIMUM_LOAD;
	}

}
