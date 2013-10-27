/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page03Controller implements Initializable, PageController {
    @FXML Text p1;
    @FXML Text p2;
    @FXML Text p3;
    @FXML Text p4;
    @FXML Text p5;
    @FXML Text p6;
    @FXML Text p7;
    
    private Text[] texts;
    private int index;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        texts = new Text[]{p1,p2,p3,p4,p5,p6,p7};
        for (Text text : texts) {
            text.setOpacity(0);
        }
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            NodeTransitions.fadein(texts[index]);
            index++;
            return true;
        }
        return false;
    }
    
}
