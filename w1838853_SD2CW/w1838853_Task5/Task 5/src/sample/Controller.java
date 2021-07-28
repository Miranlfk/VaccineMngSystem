package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    int age = 0;
    int Nic = 0;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastnameText;

    @FXML
    private TextField ageText;

    @FXML
    private TextField city;

    @FXML
    private TextField nicText;

    @FXML
    private ChoiceBox vt;

    @FXML
    private Button submitBtn;

    /**
     * Referred to the the link below when implementing the Choice Box
     * https://youtu.be/MUw7MHIibBc
     */
    @FXML
    private void initialize(){
        vt.setValue("Select option");
        vt.setItems(FXCollections.observableArrayList("AstraZeneca","Sinopharm","Pfizer"));
    }



    @FXML
    public void viewReceipt() throws Exception{
        String time= new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").format(new Date());
        try {
            age = Integer.parseInt(ageText.getText());
            Nic = Integer.parseInt(nicText.getText());
        }catch (NumberFormatException ex){
            System.out.println("Enter an Integer Value!");
            return;
        }
        Stage receiptStage = (Stage) submitBtn.getScene().getWindow();
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Receipt.fxml"));


        Label fNametext = (Label) root.lookup("#lb1");
        fNametext.setText(firstNameText.getText());

        Label lNametext = (Label) root.lookup("#lb2");
        lNametext.setText(lastnameText.getText());

        Label userAge = (Label) root.lookup("#lb3");
        userAge.setText(ageText.getText());

        Label cityText = (Label) root.lookup("#lb4");
        cityText.setText(city.getText());

        Label userNic = (Label) root.lookup("#lb5");
        userNic.setText(nicText.getText());

        Label userVTchoice = (Label) root.lookup("#lb6");
        userVTchoice.setText(vt.getValue().toString());

        Label timeStamp = (Label) root.lookup("#lb7");
        timeStamp.setText(time);


        mainStage.setTitle("Receipt");
        mainStage.setScene(new Scene(root,450,520));
        mainStage.show();



    }

}
