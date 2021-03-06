package pl.stepniewski.kata.loadBalancerKataMto;

import java.util.LinkedList;
import java.util.List;

public class Server {

	public static final double MAXIMUM_LOAD = 100d;
	private double currentLoadPecentage;
	private int capacity;
	private List<Vm> vms = new LinkedList<>();

	public Server(int capacity) {
		this.capacity = capacity;
	}

	public double getCurrentLoadPecentage() {
		return currentLoadPecentage;
	}

	public boolean contains(Vm vm) {
		return vms.contains(vm);
	}

	public void addVm(Vm vm) {
		this.vms.add(vm);
		this.currentLoadPecentage += loadOfVm(vm);
	}

	private double loadOfVm(Vm vm) {
		return (double) vm.size / (double) capacity * MAXIMUM_LOAD;
	}

	public int vmsCount() {
		return vms.size();
	}

	public double getCapacity() {
		return this.capacity;
	}

	public boolean canFit(Vm vm) {
		return currentLoadPecentage + loadOfVm(vm) <= MAXIMUM_LOAD;
	}
}
