import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class Controller {

    @FXML
    private TextField result;
    private BigDecimal firstNumber = BigDecimal.ZERO;
    private String operator = "";
    private boolean start = true;
    private Calculator model = new Calculator();

    @FXML
    private void pressNumber(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    private void pressOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            firstNumber = new BigDecimal(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;

            result.setText(String.valueOf(model.calculate(firstNumber, new BigDecimal(result.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}