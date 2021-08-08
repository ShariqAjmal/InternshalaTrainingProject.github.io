package com.shariq.java;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

public static void main(String[] args){
launch(args);
}

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

    System.out.println("Start");

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("App_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);



        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
}

private MenuBar createMenu(){
    Menu fileMenu=new Menu("Text");
MenuItem newMenuItem=new MenuItem("New");

newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("New Menu Item");

    }

});
//Separator-------
    SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
MenuItem quitMenuItem=new MenuItem("Quit");

    quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("QUIT...");
            Platform.exit();
            System.exit(0);
        }
      /*  quitMenuItem.setOnAction(event->{ System.out.println("QUIT...");
            Platform.exit();
            System.exit(0);});*/

    });


            fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);


//help-----
    Menu helpMenu=new Menu("Help");
MenuItem aboutApp=new MenuItem("About");


aboutApp.setOnAction(event -> aboutApp());

  helpMenu.getItems().addAll(aboutApp);



    MenuBar menuBar=new MenuBar();
    menuBar.getMenus().addAll(fileMenu,helpMenu);


    return menuBar;

}


    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner");

        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType>clickedBtn=alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button Click");

        }
        if (clickedBtn.isPresent() && clickedBtn.get()==noBtn){
            System.out.println("No button Click");

        }
    }
    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();

    }
}
