/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page13Controller implements Initializable,PageController {
    @FXML Text p1;
    @FXML Text p2;
    @FXML Text p3;
    
    private Text[] texts;
    private int index;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        texts = new Text[]{p2,p3};
        for (Text text : texts) {
            text.setOpacity(0);
        }
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            TranslateTransition t = new TranslateTransition(Duration.seconds(3));
            t.setNode(texts[index]);
            t.setFromX(800.0);
            t.setToX(50.0);
            texts[index].setOpacity(1.0);
            t.play();
//            NodeTransitions.fadein(texts[index],5);
            index++;
            return true;
        }
        return false;
    }
    
}
