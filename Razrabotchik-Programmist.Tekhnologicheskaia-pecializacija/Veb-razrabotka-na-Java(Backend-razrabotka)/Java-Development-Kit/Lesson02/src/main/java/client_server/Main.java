package client_server;

import client_server.client.domain.ClientController;
import client_server.client.ui.ClientGUI;
import client_server.server.domain.ServerController;
import client_server.server.repository.FileStorage;
import client_server.server.ui.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerWindow(), new FileStorage());

        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}
