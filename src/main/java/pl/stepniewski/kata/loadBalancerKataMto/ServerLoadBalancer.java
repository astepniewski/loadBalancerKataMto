package pl.stepniewski.kata.loadBalancerKataMto;

import java.util.LinkedList;
import java.util.List;

public class ServerLoadBalancer {

	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			addToCapableLessLoaderServer(servers, vm);
		}
	}

	private void addToCapableLessLoaderServer(Server[] servers, Vm vm) {
		List<Server> serversWithEnoughCapacity = findServersWithEnoughCapacity(servers, vm);
		for (Server server : servers) {
			if (server.canFit(vm))
				serversWithEnoughCapacity.add(server);
		}
		Server lessLoaded = extractLessLoadedServer(serversWithEnoughCapacity);
		if (lessLoaded != null)
			lessLoaded.addVm(vm);
	}

	private List<Server> findServersWithEnoughCapacity(Server[] servers, Vm vm) {
		List<Server> serversWithEnoughCapacity = new LinkedList<>();
		for (Server server : servers) {
			if (server.canFit(vm))
				serversWithEnoughCapacity.add(server);
		}
		return serversWithEnoughCapacity;
	}

	private Server extractLessLoadedServer(List<Server> servers) {
		Server lessLoaded = null;
		for (Server server : servers) {
			if (lessLoaded == null
					|| lessLoaded.currentLoadPecentage > server.currentLoadPecentage) {
				lessLoaded = server;
			}
		}
		return lessLoaded;
	}

}
