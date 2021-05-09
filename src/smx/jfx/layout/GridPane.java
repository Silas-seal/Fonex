
package smx.jfx.layout;

/**
 *
 * @author Seumx Plus
 */

import javafx.scene.Node;
import javafx.util.*;
import javafx.animation.*;

public class GridPane extends javafx.scene.layout.GridPane {
    
    //private String stat="free";
    
    public void addS(Node node, int col, int row) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.add(node,col,row);
        
        fd.play();
        
    }
    
}