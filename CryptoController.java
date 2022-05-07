import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class CryptoController implements Initializable{
    
    @FXML
    private Button btnSubmit;

    @FXML
    private ChoiceBox cbCurrencySelector;

    @FXML
    private DatePicker dpStartDate;

    @FXML
    private DatePicker dpEndDate;
    
    @FXML
    private Label lblCurrency;

    @FXML
    private Label lblTradeVolume;

    @FXML
    private Label lblPeriodHigh;

    @FXML
    private Label lblPeriodLow;

    @FXML
    private Label lblPeriodOpen;

    @FXML
    private Label lblPeriodClose;

    @FXML
    private void handleButtonAction(ActionEvent e) {
        CryptoModel model = new CryptoModel();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> currencies = FXCollections.observableArrayList();
        cbCurrencySelector.getItems().clear();
        try {
            String tickersArray[] = new String[CryptoModel.numberOfTickers()];
            tickersArray = CryptoModel.getTickers();
            for (int i = 0; i < tickersArray.length; i++) {
                cbCurrencySelector.getItems().add(tickersArray[i]);

            }
        } catch (IOException e1) {
        }
        
        
    }


}
