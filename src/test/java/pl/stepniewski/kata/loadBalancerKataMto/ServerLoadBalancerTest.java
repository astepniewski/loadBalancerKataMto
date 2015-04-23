package pl.stepniewski.kata.loadBalancerKataMto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static pl.stepniewski.kata.loadBalancerKataMto.CurrentLoadPercentageMatcher.hasLoadPercentageOf;
import static pl.stepniewski.kata.loadBalancerKataMto.ServerBuilder.server;
import static pl.stepniewski.kata.loadBalancerKataMto.VmBuilder.vm;

import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void balancingAServer_noVms_serverStaysEmpty() {
		Server theServer = a(server().withCapacity(1));

		balance(aListOfServersWith(theServer), anEmptyListOfVms());

		assertThat(theServer, hasLoadPercentageOf(0.0d));
	}

	@Test
	public void balancingOneServerWithOneSlotCapacity_andOneSlotVm_fillsTheServerWithTheVm() {
		Server theServer = a(server().withCapacity(1));
		Vm theVm = a(vm().ofSize(1));
		balance(aListOfServersWith(theServer), aListOfVmsWith(theVm));

		assertThat(theServer, hasLoadPercentageOf(100.0d));
		assertThat("the server should contain vm", theServer.contains(theVm));
	}

	@Test
	public void balancingOneServerWithTenSlotsCapacity_andOneSlotVm_fillTheServerWithTenPercent() {
		Server theServer = a(server().withCapacity(10));
		Vm theVm = a(vm().ofSize(1));
		balance(aListOfServersWith(theServer), aListOfVmsWith(theVm));

		assertThat(theServer, hasLoadPercentageOf(10.0d));
		assertThat("the server should contain vm", theServer.contains(theVm));
	}

	private void balance(Server[] servers, Vm[] vms) {
		new ServerLoadBalancer().balance(servers, vms);

	}

	private Vm[] anEmptyListOfVms() {
		return new Vm[0];
	}

	private Vm[] aListOfVmsWith(Vm vm) {
		return new Vm[] { vm };
	}

	private Server[] aListOfServersWith(Server server) {
		return new Server[] { server };
	}

	private <T> T a(Builder<T> builder) {
		return builder.build();
	}

}
