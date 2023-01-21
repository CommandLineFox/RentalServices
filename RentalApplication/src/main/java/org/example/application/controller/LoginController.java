package org.example.application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class LoginController implements EventHandler<ActionEvent> {

    private TextField username;
    private TextField password;
    //private UserServiceRestClient userServiceRestClient;

    public LoginController(TextField username, TextField password) {
        this.username = username;
        this.password = password;
        //userServiceRestClient = new UserServiceRestClient();
    }

    @Override
    public void handle(ActionEvent event) {
    }
}
