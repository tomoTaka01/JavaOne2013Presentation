/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page99Controller implements Initializable,PageController {
    @FXML AnchorPane root;
    @FXML Text p10;
    @FXML ImageView image;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        transitionText();
    }    

    @Override
    public boolean doAction() {
        transitionText();
        return true;
//        return false;
    }

    private void transitionText() {
        Rectangle rectangle = new Rectangle(80,80,250,200);
//        rectangle.setVisible(true);
//        rectangle.setFill(Color.WHITE);
//        rectangle.setFill(null);
//        root.getChildren().add(rectangle);
//        p10.setLayoutX(600);
//        p10.setLayoutY(400);
        
        Image dukeImage = new Image("duke.png");
        ImageView duke =  new ImageView(dukeImage);
//        root.getChildren().add(duke);
        duke.setTranslateX(80.0 - dukeImage.getWidth()/2.0);
        duke.setTranslateY(80.0 - dukeImage.getHeight()/2.0);
        duke.setRotate(135.0);
        
        Text t1 = new Text("蟹");
        t1.setLayoutX(80);
        t1.setLayoutY(80);
        Text t2 = new Text("楽");
        t2.setLayoutX(100);
        t2.setLayoutY(80);
        PathTransition p1 = getXXX(t1, rectangle);
        PathTransition p2 = getXXX(t2, rectangle);
        root.getChildren().addAll(t1,t2);
        ParallelTransition xxx = new ParallelTransition(p1,p2);
        xxx.play();
//        initAnimation(root, null);
    }
        private void initAnimation(AnchorPane root, final Button button) {
        Rectangle rect = new Rectangle(80, 80, 250, 200);
        rect.setStroke(Color.GRAY);
        rect.setFill(null);
        root.getChildren().add(rect);

        // アニメーションさせるノード
        Image dukeImage = new Image("duke.png");
        ImageView duke =  new ImageView(dukeImage);
        root.getChildren().add(duke);

        // アニメーションを行なわせるパス
        Rectangle path = new Rectangle(80, 80, 250, 200);
        
        // アニメーションの開始点に移動させる
        duke.setTranslateX(80.0 - dukeImage.getWidth()/2.0);
        duke.setTranslateY(80.0 - dukeImage.getHeight()/2.0);
        duke.setRotate(135.0);
        
        // 移動のアニメーション
        PathTransition transition = new PathTransition();
        // アニメーションの時間は4000ミリ秒
        transition.setDuration(Duration.millis(4_000L));
        // アニメーション対象の設定
        transition.setNode(duke);
        // アニメーションを行なわせるパス
        transition.setPath(path);
        // パスに沿って回転させる
        transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        // 繰り返し回数の設定
        transition.setCycleCount(2);
        transition.play();
    }

    private PathTransition getXXX(Text t1, Shape rec) {
        PathTransition path = new PathTransition();
        path.setDuration(Duration.seconds(10));
        path.setNode(t1);
        path.setPath(rec);
        path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Animation.INDEFINITE);
        path.setAutoReverse(false);
//        path.play();
        return path;
    }

}
