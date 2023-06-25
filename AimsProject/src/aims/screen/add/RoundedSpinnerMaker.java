package aims.screen.add;


import java.util.function.UnaryOperator;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.converter.DoubleStringConverter;

public class RoundedSpinnerMaker {
    public static void makeRoundedSpinner(Spinner<Double> spinner, double minVal, double maxVal, double initialVal, double increment) {
    	spinner.setValueFactory(
    		new SpinnerValueFactory.DoubleSpinnerValueFactory(minVal, maxVal, initialVal, increment)
    	);

        UnaryOperator<Change> doubleFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };

        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0, doubleFilter);

    	spinner.setEditable(true);
        spinner.getEditor().setTextFormatter(textFormatter);
        spinner.getEditor().focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                textFormatter.setValue(
                	roundToNearestIncrement(spinner.getValue(), increment)
                );
            }
        });
    }

    private static double roundToNearestIncrement(double value, double increment) {
    	double val = Math.round(value / increment) * increment * 100;
    	val = Math.round(val);
        return val / 100;
    }


}
