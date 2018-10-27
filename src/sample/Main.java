package sample;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Servicebook fordBook = new Servicebook(new ArrayList<Service>());

        Group root = new Group();

        //Error field

        Label error = new Label("Errors");
        error.setLayoutX(100);
        error.setLayoutY(500);

        root.getChildren().add(error);

        //form to add service

        TextField day = new TextField();
        day.setLayoutX(200);
        day.setLayoutY(50);

        Text labelDay = new Text(50, 55, "enter day");

        TextField month = new TextField();
        month.setLayoutX(200);
        month.setLayoutY(90);

        Text labelMonth = new Text(50, 95, "enter month");

        TextField year = new TextField();
        year.setLayoutX(200);
        year.setLayoutY(130);

        Text labelYear = new Text(50, 135, "enter year");

        TextField mileage = new TextField();
        mileage.setLayoutX(200);
        mileage.setLayoutY(170);

        Text labelMileage = new Text(50, 175, "enter mileage");

        root.getChildren().addAll(day,month,year,mileage,labelDay,labelMonth,labelYear,labelMileage);

        // adding the button to submit a new service

        Button submitNewServicebtn = new Button("Submit service");
        submitNewServicebtn.setLayoutX(100);
        submitNewServicebtn.setLayoutY(200);

        root.getChildren().add(submitNewServicebtn);

        //Text with all services

        Text allServices = new Text(75, 250, "No services to show");
        allServices.setWrappingWidth(400);

        root.getChildren().add(allServices);

        EventHandler<MouseEvent>submitNewService = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    fordBook.addService(new Service(Integer.parseInt(mileage.getText()), new Date(Integer.parseInt(day.getText()),Integer.parseInt(month.getText()), Integer.parseInt(year.getText()))));

                    allServices.setText(fordBook.getAllServices().toString());

                }

                catch (Exception e){
                    error.setText("something went wrong");
                }
            }
        };

        submitNewServicebtn.addEventFilter(MouseEvent.MOUSE_CLICKED, submitNewService);

        // setting up the scene


        Scene mainScene = new Scene(root, 500,600, Color.rgb(155,30,100));
        mainScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}