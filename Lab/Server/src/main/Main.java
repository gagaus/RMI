package main;

import database.MovieDatabaseImpl;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
	
	private static final String SERVICE_NAME = "MovieDatabase";
	private static final int SERVER_PORT = Registry.REGISTRY_PORT;
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(SERVER_PORT);
			registry.rebind(SERVICE_NAME, new MovieDatabaseImpl());
			InetAddress serverAddr = InetAddress.getLocalHost();
			System.out.println("Server name   : " + serverAddr.getHostName());
			System.out.println("Running on    : " + serverAddr.getHostAddress());
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
