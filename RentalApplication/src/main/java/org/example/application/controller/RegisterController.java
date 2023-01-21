package org.example.application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.application.view.RegisterClientView;

public class RegisterController implements EventHandler<ActionEvent> {

    private RegisterClientView registerClientView;
    //private UserServiceRestClient userServiceRestClient;

    public RegisterController(RegisterClientView registerClientView){
        this.registerClientView = registerClientView;
        //this.userServiceRestClient = new UserServiceRestClient();
    }
    @Override
    public void handle(ActionEvent event) {
    }

}