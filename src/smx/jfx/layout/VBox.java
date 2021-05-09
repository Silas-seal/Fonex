
package smx.jfx.layout;

/**
 *
 * @author Seumx Plus
 */

import javafx.scene.Node;
import javafx.util.*;
import javafx.animation.*;

public class VBox extends javafx.scene.layout.VBox {
    
    //private String stat="free";
    
    public void addS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.getChildren().add(node);
        
        fd.play();
        
    }
    
}