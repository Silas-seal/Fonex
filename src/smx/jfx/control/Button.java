
package smx.jfx.control;

import javafx.geometry.*;

/**
 *
 * @author Seumx Plus
 */
public class Button extends javafx.scene.control.Button {
    
    //declare memory locations
    private String def="-fx-background-color:whitesmoke; -fx-font:normal 16px 'Calibri'; -fx-text-fill:black;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: royalblue;"
            + "-fx-border-radius: 8px 8px 8px 8px;"
            
            ,hover="-fx-background-color:white; -fx-font:normal 16px 'Calibri'; -fx-text-fill:black;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: green;"
            + "-fx-border-radius: 8px 8px 8px 8px;";
    
    //default with String KOL
    /**
     * Constructor for the Button class with String to set Button text
     * @param ui 
     */
    public Button(String ui) {
        
        this.setText(ui); this.setStyle(def); this.setPadding(new Insets(8));
        
        //hover action
        this.setOnMouseMoved(ev->{
            this.setStyle(hover);
        });
        
        this.setOnMouseExited(ev->{
           this.setStyle(def); 
        });
        
    }
    
    /**
     * This method sets style to be applied to this button when user moves mouse over
     * @param hover 
     */
    public void setHoverStyle(String hover) {
        
        this.hover=hover;
        
    }
    
    /**
     * This method sets the default style for this Button
     * @param style 
     */
    public void setDefaultStyle(String style) {
        
        this.def=style;
        this.setStyle(def);
        
    }
    
}
