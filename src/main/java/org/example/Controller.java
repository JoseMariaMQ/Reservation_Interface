package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements EventHandler<ActionEvent> {

    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldLastName1;
    @FXML
    private TextField fieldLastName2;
    @FXML
    private TextField fieldCompany;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldNumberCompanions;
    @FXML
    private TextArea fieldObservations;
    @FXML
    private Button btnReserve;
    @FXML
    private Label labelMessage1;
    @FXML
    private Label labelMessage2;

    public void initialize() {
        btnReserve.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Acciones cuando se pulsa el botón RESERVAR
        if(actionEvent.getSource() == btnReserve) {
            //Comprobación de campos vacios
            String[] fields = new String[]{
                    fieldName.getText(),
                    fieldLastName1.getText(),
                    fieldLastName2.getText(),
                    fieldCompany.getText(),
                    fieldEmail.getText(),
                    fieldNumberCompanions.getText(),
                    fieldObservations.getText()
            };
            //Recorremos el array de los campos y comprobamos si alguno esta vacío
            int cont = 0;
            for (String field : fields) {
                if (field.equals("")) {
                    //Mostramos texto si algún campo esta vacío
                    labelMessage1.setText("Tienes que rellenar todos los campos.");
                    cont++;
                }
                //Si el contador esta en 0 los campos están completos
                if (cont == 0) {
                    //Quitamos texto si ha rellenado campos
                    labelMessage1.setText(null);
                }
            }

            if(!validateMail(fieldEmail.getText())) {
                labelMessage2.setText("El email no es válido.");
            } else {
                labelMessage2.setText(null);
            }
        }
    }

    public static boolean validateMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

}
