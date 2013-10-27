package transition;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Node Transition
 * 
 * @author tomo
 */
public class NodeTransitions {
   public static void fadein(Node node){
       fadein(node, 1);
   } 
   public static void fadein(Node node, double seconds){
       FadeTransition transition = new FadeTransition(Duration.seconds(seconds));
       transition.setNode(node);
       transition.setToValue(1.0);
       transition.play();
   }
}
