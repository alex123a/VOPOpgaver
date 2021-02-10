package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML
    private RadioButton ellipseButton;

    @FXML
    private ToggleGroup shapes;

    @FXML
    private RadioButton rectangleButton;

    @FXML
    private RadioButton circleButton;

    @FXML
    private RadioButton squareButton;

    @FXML
    private Button getInfoBut;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextArea textArea;

    ShapeFacade shapeFacade = ShapeFacade.getInstance();

    @FXML
    void getInfo(ActionEvent event) {
        double text1Double = Double.parseDouble(text1.getText());
        double text2Double = Double.parseDouble(text2.getText());

        switch((ShapeFacade.SHAPES)shapes.getSelectedToggle().getUserData()) {
            case ELLIPSE:
                textArea.setText(shapeFacade.getShapeInfo(ShapeFacade.SHAPES.ELLIPSE, text1Double, text2Double));
                break;
            case CIRCLE:
                textArea.setText(shapeFacade.getShapeInfo(ShapeFacade.SHAPES.CIRCLE, text1Double));
                break;
            case RECTANGLE:
                textArea.setText(shapeFacade.getShapeInfo(ShapeFacade.SHAPES.RECTANGLE, text1Double, text2Double));
                break;
            case SQUARE:
                textArea.setText(shapeFacade.getShapeInfo(ShapeFacade.SHAPES.SQUARE, text1Double));
                break;
        }
    }

    public void initialize() {
        ellipseButton.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        circleButton.setUserData(ShapeFacade.SHAPES.CIRCLE);
        rectangleButton.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        squareButton.setUserData(ShapeFacade.SHAPES.SQUARE);
    }

    public void hideText() {
        switch((ShapeFacade.SHAPES)shapes.getSelectedToggle().getUserData()) {
            case ELLIPSE:
                text2.setOpacity(100);
                break;
            case CIRCLE:
                text2.setOpacity(0);
                break;
            case RECTANGLE:
                text2.setOpacity(100);
                break;
            case SQUARE:
                text2.setOpacity(0);
                break;
        }
    }

}
