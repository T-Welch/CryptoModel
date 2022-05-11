import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
// import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
// import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
// import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;



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
    private void handleButtonAction(ActionEvent e) throws MalformedURLException {
        String startDate;
        String endDate;
        CryptoModel model = new CryptoModel();

        
        String ticker = (String) cbCurrencySelector.getValue();
        System.out.println(ticker);
        try {
            startDate = dpStartDate.getValue().toString();
            endDate = dpEndDate.getValue().toString();

            model.queryAPI(model.constructURL(ticker, startDate, endDate));
        
            if (model.isGoodQuery()) {
                lblCurrency.setText("Currency: USD");
                lblTradeVolume.setText("Trade Volume: " + model.getPeriodNumberTransactions());
                lblPeriodHigh.setText("Period High: $" + model.getPeriodATH());
                lblPeriodLow.setText("Period Low: $" + model.getPeriodATL());
                lblPeriodOpen.setText("Period Open: $" + model.getPeriodOpen());
                lblPeriodClose.setText("Period Close: $" + model.getPeriodClose());
                
            } else {
                Alert alert = new Alert(AlertType.ERROR, "You have entered invalid data. Some common errors may be:\nDate is set to today\nDate is set > 2 years previous\nDate is set to the future\nSelected currency did not exist on one more more of the selected days\nor you did not select a currency", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.show();
            }
        } catch (Exception f) {
            Alert alert = new Alert(AlertType.ERROR, "You have entered invalid data in the date field", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            
        }















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
