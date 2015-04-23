package pl.stepniewski.kata.loadBalancerKataMto;

import java.util.LinkedList;
import java.util.List;

public class Server {

	public static final double MAXIMUM_LOAD = 100d;
	public double currentLoadPecentage;
	private int capacity;
	private List<Vm> vms = new LinkedList<>();

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public boolean contains(Vm vm) {
		return vms.contains(vm);
	}

	public void addVm(Vm vm) {
		vms.add(vm);
		currentLoadPecentage = (double) vm.size / (double) capacity
				* MAXIMUM_LOAD;
	}

	public int vmsCount() {
		return vms.size();
	}

	public double getCapacity() {
		return this.capacity;
	}

	public boolean canFit(Vm vm) {
		return currentLoadPecentage
				+ ((double) vm.size / (double) this.capacity * MAXIMUM_LOAD) <= MAXIMUM_LOAD;
	}

}
