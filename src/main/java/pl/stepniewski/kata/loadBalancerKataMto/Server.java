package pl.stepniewski.kata.loadBalancerKataMto;

public class Server {

	public double currentLoadPecentage;
	public int capacity;

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm theVm) {
		return true;
	}

}
