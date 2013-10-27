package contents;

import controller.PageController;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Presentation of JavaOne 2013
 * 
 * @author tomo
 */
public class JavaOne2013Presentation extends Application {
    public static final double WIDTH = 800.0;
    public static final double HEIGHT = 600.0;
    private String[] pages = {
        "Page01Title.fxml"
        ,"Page02Intro.fxml"
        ,"Page03Before.fxml"
        ,"Page04After.fxml"
        ,"Page05Raspi1.fxml"
        ,"Page06Raspi1.fxml"
        ,"Page06Raspi1_1.fxml"
        ,"Page07Raspi1.fxml"
        ,"Page08Raspi1.fxml"
        ,"Page09Raspi1.fxml"
        ,"Page10Raspi2.fxml"
        ,"Page11Raspi3.fxml"
        ,"Page12Raspi3.fxml"
        ,"Page13Raspi3.fxml"
        ,"Page99Party.fxml"
    };
    private int pageIx;
    private Group root;
    private PageController presentController;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        root = new Group();
        root.setOnMouseClicked(e -> {
            if (!presentController.doAction()){
                try {
                    goForward();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
        goForward();
    }

    private void goForward() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(pages[pageIx]));
        Node next = (Node) loader.load();
        presentController = loader.getController();
        root.getChildren().add(next);
        Node present = null;
        if (root.getChildren().size() > 1){
            present = root.getChildren().get(0);
        }
        translatePage(next, present);
        pageIx++;
        if (pageIx >= pages.length){
            pageIx = 0;
        }
        
    }

    private void translatePage(Node next, final Node present){
        TranslateTransition fadein = new TranslateTransition(Duration.seconds(1));
        fadein.setNode(next);
        fadein.setFromX(WIDTH);
        fadein.setToX(0);
        fadein.play();
        if (present != null){
            TranslateTransition fadeout = new TranslateTransition(Duration.seconds(1));
            fadeout.setNode(present);
            fadeout.setToX(-WIDTH);
            fadeout.setOnFinished(e -> {
                root.getChildren().remove(present);
            });
            fadeout.play();
        }
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
