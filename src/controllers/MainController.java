package controllers;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import mathematic.PolishNotation;
import syntax.ErrorEntry;
import syntax.MathSyntaxAnalyzer;

import javax.swing.event.ChangeListener;

public class MainController {

    @FXML
    private ListView<ErrorEntry> listViewErrors;

    @FXML
    private TextArea textAreaInfixExpression;

    @FXML
    private TextArea textAreaPostfixExpression;

    @FXML
    private TextArea textAreaResult;

    @FXML
    private void initialize() {
        textAreaInfixExpression.textProperty().addListener((obs,old,niu)->{
            textChanged();
        });
    }

    @FXML
    private void textChanged() {
        try {
            var mathSyntaxAnalyzer = new MathSyntaxAnalyzer();
            textAreaInfixExpression.textProperty().set(textAreaInfixExpression.getText());

            var infix = mathSyntaxAnalyzer.parseInfix(textAreaInfixExpression.getText());
            var postfix = PolishNotation.infixToPostfix(infix);

            textAreaPostfixExpression.clear();
            textAreaResult.clear();
            for (var token: postfix) {
                textAreaPostfixExpression.appendText(token.toString() + ' ');
            }

            if (mathSyntaxAnalyzer.getErrorEntries().size() > 0) {

            }
            else {
                var result = PolishNotation.calculate(postfix);
                textAreaResult.textProperty().set(result.getValue().toString());
            }
        }
        catch (Exception ex) {

        }
    }
}