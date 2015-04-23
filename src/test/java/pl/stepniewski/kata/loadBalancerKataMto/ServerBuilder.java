package pl.stepniewski.kata.loadBalancerKataMto;

public class ServerBuilder {

	private int capacity;

	public ServerBuilder withCapacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public Server build() {
		return new Server(capacity);
	}

}
