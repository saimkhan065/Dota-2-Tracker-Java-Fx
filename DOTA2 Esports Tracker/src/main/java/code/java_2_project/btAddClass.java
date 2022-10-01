package code.java_2_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class btAddClass  {
    protected TextField tfMatchID = new TextField();
    protected TextField tfHero = new TextField();
    protected TextField tfKills = new TextField();
    protected TextField tfDeaths = new TextField();
    protected TextField tfWin = new TextField();
    protected Button btSubmitData = new Button("Submit");
    protected GridPane gridPane;
    protected CheckBox checkBoxMatchID = new CheckBox();
    protected CheckBox checkBoxHero =   new CheckBox();
    protected CheckBox checkBoxWin = new CheckBox();


    public btAddClass() {
    }

    protected GridPane btAddStage() {
        gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Match ID:"), 0, 0);
        gridPane.add(tfMatchID, 1, 0);
        gridPane.add(new Label("Hero:"), 0, 1);
        gridPane.add(tfHero, 1, 1);
        gridPane.add(new Label("Kills:"), 0, 2);
        gridPane.add(tfKills, 1, 2);
        gridPane.add(new Label("Deaths:"), 0, 3);
        gridPane.add(tfDeaths, 1, 3);
        gridPane.add(new Label("Win(true/false):"), 0, 4);
        gridPane.add(tfWin, 1, 4);
        gridPane.add(btSubmitData, 1, 5);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfMatchID.setAlignment(Pos.BOTTOM_RIGHT);
        tfHero.setAlignment(Pos.BOTTOM_RIGHT);
        tfKills.setAlignment(Pos.BOTTOM_RIGHT);
        tfDeaths.setAlignment(Pos.BOTTOM_RIGHT);
        tfWin.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane.setHalignment(btSubmitData, HPos.RIGHT);

        return gridPane;

    } // Common Pane for basic events
    protected void btAddClassClear(){
        tfMatchID.clear();
        tfHero.clear();
        tfKills.clear();
        tfDeaths.clear();
        tfWin.clear();
    } // Clear all fields
    protected GridPane btAddStageSearch() {
        ObservableList<String> options =  FXCollections.observableArrayList("true", "false"); // list for ComboBox options
        gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Match ID:"), 0, 0);
        gridPane.add(checkBoxMatchID,1,0);
        gridPane.add(tfMatchID, 2, 0);
        gridPane.add(new Label("Hero:"), 0, 1);
        gridPane.add(checkBoxHero, 1, 1);
        gridPane.add(tfHero, 2, 1);
        gridPane.add(new Label("Win:"), 0, 3);
        gridPane.add(checkBoxWin,1,3);
        ComboBox comboBox = new ComboBox<>(options);
        gridPane.add(comboBox, 2, 3);  //ComboBox instead of textfield
        comboBox.getSelectionModel().selectFirst();
        
        gridPane.add(btSubmitData, 1, 5);

        

        //Add CheckBox for Labels


        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfMatchID.setAlignment(Pos.BOTTOM_RIGHT);
        tfHero.setAlignment(Pos.BOTTOM_RIGHT);
        tfWin.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane.setHalignment(btSubmitData, HPos.RIGHT);

        return gridPane;

    } // Pane for search Event

}

