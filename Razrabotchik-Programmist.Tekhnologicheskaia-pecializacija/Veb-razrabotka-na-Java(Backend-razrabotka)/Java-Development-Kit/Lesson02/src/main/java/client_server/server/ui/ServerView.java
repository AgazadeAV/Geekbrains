package client_server.server.ui;

import client_server.server.domain.ServerController;

public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}
