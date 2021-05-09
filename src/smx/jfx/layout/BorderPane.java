
package smx.jfx.layout;

/**
 *
 * @author Seumx Plus
 */

import javafx.scene.Node;
import javafx.util.*;
import javafx.animation.*;

public class BorderPane extends javafx.scene.layout.BorderPane {
    
    //private String stat="free";
    
    /**
     * Set Right Side Node
     * @param node 
     */
    public void setRightS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.setRight(node);
        
        fd.play();
        
    }
    
    /**
     * Set Left Side Node
     * @param node 
     */
    public void setLeftS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.setLeft(node);
        
        fd.play();
        
    }
    
    /**
     * Set Top Side Node
     * @param node 
     */
    public void setTopS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.setTop(node);
        
        fd.play();
        
    }
    
    /**
     * Set Bottom Side Node
     * @param node 
     */
    public void setBottomS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.setBottom(node);
        
        fd.play();
        
    }
    
    /**
     * Set Center Node
     * @param node 
     */
    public void setCenterS(Node node) {
        
        FadeTransition fd=new FadeTransition(Duration.millis(999));
        fd.setFromValue(0); fd.setToValue(1); fd.setCycleCount(1); fd.setAutoReverse(false); fd.setNode(node);
        
        this.setCenter(node);
        
        fd.play();
        
    }
    
}