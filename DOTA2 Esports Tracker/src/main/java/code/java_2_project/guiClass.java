package code.java_2_project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;



public class guiClass extends Application {
    private TableView<matchData> tableView = new TableView<>();
    crudClass crudClass = new crudClass();
    btAddClass btAddClassObject = new btAddClass();



    public void start(Stage primaryStage){
        //-------------------------------Build a Table------------------------------------------------------------------
        //MatchID Column
        TableColumn<matchData, Integer> matchIdTableColumn = new TableColumn<>("Match ID");
        matchIdTableColumn.setMinWidth(100);
        matchIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("matchID"));

        //Hero Name column
        TableColumn<matchData, String> heroTableColumn = new TableColumn<>("Hero Name");
        heroTableColumn.setMinWidth(100);
        heroTableColumn.setCellValueFactory(new PropertyValueFactory<>("hero"));

        //Kills column
        TableColumn<matchData, Integer> killsTableColumn = new TableColumn<>("Kills");
        killsTableColumn.setMinWidth(100);
        killsTableColumn.setCellValueFactory(new PropertyValueFactory<matchData, Integer>("kills"));

        //Deaths column
        TableColumn<matchData, Integer> deathsTableColumn = new TableColumn<>("Deaths");
        deathsTableColumn.setMinWidth(100);
        deathsTableColumn.setCellValueFactory(new PropertyValueFactory<>("deaths"));

        //Win column
        TableColumn<matchData, Boolean> winTableColumn = new TableColumn<>("Win?");
        winTableColumn.setMinWidth(100);
        winTableColumn.setCellValueFactory(new PropertyValueFactory<>("win"));



        tableView.setItems(crudClass.getData());
        tableView.getColumns().addAll(matchIdTableColumn, heroTableColumn, killsTableColumn, deathsTableColumn,
                winTableColumn);

        //--------------------------------------------------------------------------------------------------------------


        //-----------------------------Buttons--------------------------------------------------------------------------
        //Add Button
        Button btAdd = new Button("Add");
        btAdd.setOnAction(actionEvent -> {
            // Process events
            handleClickEvent();
            //Submit Button on Add Page
           btAddClassObject.btSubmitData.setOnAction(actionEvent1 -> {
               handleAddEvent();
           });

        });

        //Delete Button
        Button btDelete = new Button("Delete");
        btDelete.setOnAction(actionEvent -> {
            matchData selectedItem = tableView.getSelectionModel().getSelectedItem();
            tableView.getItems().remove(selectedItem);
        });

        //Edit Button
        Button btEdit = new Button("Edit");
        btEdit.setOnAction(actionEvent -> {
        int selectedItemIndex = tableView.getSelectionModel().getSelectedIndex();
          handleClickEvent();
            btAddClassObject.btSubmitData.setOnAction(actionEvent1 -> {
                handleEditEvent();  // Create option for partial edits

             });
        }); // Edit must edit all fields

        //Search Button
        Button btSearch = new Button("Search");
        btSearch.setOnAction(actionEvent -> {

            //Create Scene
            handleSearchClickEvent();
            btAddClassObject.btSubmitData.setOnAction(actionEvent1 -> {
                if (btAddClassObject.checkBoxMatchID.isSelected())   // 1 checkbox
                {
                    int matchID = Integer.parseInt(btAddClassObject.tfMatchID.getText());
                   String str = String.valueOf(crudClass.matchDataObservableList.stream().filter(matchData -> matchID==matchData.getMatchID()).findAny());
                    //Stage for Search Result
                    Stage stage1 = new Stage();
                    Scene scene1 = new Scene(new TextArea(str),200,200);
                    stage1.setScene(scene1);
                    stage1.show();
                }

                if (btAddClassObject.checkBoxHero.isSelected())   // 2 checkbox
                {
                    String hero = btAddClassObject.tfHero.getText();
                    String str = String.valueOf(crudClass.matchDataObservableList.stream().filter(matchData -> hero.equals(matchData.getHero())).findAny());
                    //Stage for Search Result
                    Stage stage1 = new Stage();
                    Scene scene1 = new Scene(new TextArea(str),200,200);
                    stage1.setScene(scene1);
                    stage1.show();
                }

                if (btAddClassObject.checkBoxWin.isSelected())   //3 checkbox
                {
                    boolean win = Boolean.parseBoolean(btAddClassObject.tfWin.getText());
                    String str = String.valueOf(crudClass.matchDataObservableList.stream().filter(matchData -> matchData.isWin()).findAny());
                    //Stage for Search Result
                    Stage stage1 = new Stage();
                    Scene scene1 = new Scene(new TextArea(str),200,200);
                    stage1.setScene(scene1);
                    stage1.show();
                }
            });
        });

        //Save Button
        Button btSave = new Button("Save Data");
        btSave.setOnAction(actionEvent -> {
            try {

                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
                dataOutputStream.writeUTF(String.valueOf(crudClass.matchDataObservableList));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Instructions Button
        Button btInstruction = new Button("INSTRUCTIONS!");
        btInstruction.setOnAction(actionEvent -> {
            Stage stage = new Stage();
            Scene scene = new Scene(new TextArea("WELCOME!\nRemember to input data for all fields when ADDING or EDITING " +
                    "records in the tracker!!\nIncorrect Values might be recorded in such a case !\nSAVED DATA can be" +
                    " found at Java_2_Project/data.txt"));
            stage.setTitle("Instructions");
            stage.setScene(scene);
            stage.show();
        });
        //--------------------------------------------------------------------------------------------------------------


        HBox hBox =new HBox(5);//Hbox for all Buttons
        hBox.getChildren().addAll(btAdd, btDelete, btEdit, btSearch, btSave, btInstruction);

        VBox vBox = new VBox();//Vbox for tableView
        vBox.getChildren().addAll(tableView);
        vBox.getChildren().add(hBox);



        //Create Final Scene
        Scene scene = new Scene(vBox, 500, 300);
        primaryStage.setScene(scene);// Set scene in primaryStage
        primaryStage.setTitle("DOTA 2 Stats Tracker");
        primaryStage.show();// Show primaryStage

    }

    //-------------------------------------Event Handlers---------------------------------------------------------------

    public void handleClickEvent(){
        // Create a scene and place it in the stage
        Stage Stage = new Stage();
        Scene scene = new Scene(btAddClassObject.btAddStage(), 400, 250);
        Stage.setTitle("DOTA 2 Stats Tracker"); // Set title
        Stage.setScene(scene); // Place the scene in the stage
        Stage.show(); // Display the stage
    }

    public void handleSearchClickEvent(){
        // Create a scene and place it in the stage
        Stage Stage = new Stage();
        Scene scene = new Scene(btAddClassObject.btAddStageSearch(), 400, 250);
        Stage.setTitle("DOTA 2 Stats Tracker - Search"); // Set title
        Stage.setScene(scene); // Place the scene in the stage
        Stage.show(); // Display the stage
    }

    public void handleAddEvent(){
        int matchID = Integer.parseInt(btAddClassObject.tfMatchID.getText());
        String hero = btAddClassObject.tfHero.getText();
        int kills = Integer.parseInt(btAddClassObject.tfKills.getText());
        int deaths = Integer.parseInt(btAddClassObject.tfDeaths.getText());
        String win = btAddClassObject.tfWin.getText();

        crudClass.add(matchID, hero, kills, deaths, Boolean.parseBoolean(win));
        btAddClassObject.btAddClassClear();
    }

    public void handleEditEvent(){
        int selectedItemIndex = tableView.getSelectionModel().getSelectedIndex();
        int matchID = Integer.parseInt(btAddClassObject.tfMatchID.getText());
        String hero = btAddClassObject.tfHero.getText();
        int kills = Integer.parseInt(btAddClassObject.tfKills.getText());
        int deaths = Integer.parseInt(btAddClassObject.tfDeaths.getText());
        String win = btAddClassObject.tfWin.getText();
            crudClass.matchDataObservableList.set(selectedItemIndex, new matchData (matchID, hero, kills, deaths, Boolean.parseBoolean(win)));
        btAddClassObject.btAddClassClear();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        launch();
    }
}
