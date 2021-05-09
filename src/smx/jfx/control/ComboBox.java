
package smx.jfx.control;

/**
 *
 * @author Seumx Plus
 */
public class ComboBox extends javafx.scene.control.ComboBox {
    
    //declare memory locations
    private String def="-fx-background-color:whitesmoke; -fx-font:normal 16px 'Calibri'; -fx-text-fill:black;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: royalblue;"
            + "-fx-border-radius: 8px 8px 8px 8px;"
            
            ,hover="-fx-background-color:white; -fx-font:normal 16px 'Calibri'; -fx-text-fill:black;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: green;"
            + "-fx-border-radius: 8px 8px 8px 8px;";
    
    /**
     * Constructor for the ComboBox
     */
    public ComboBox() {
        
        this.setStyle(def);
        
        //hover action
        this.setOnMouseMoved(ev->{
            this.setStyle(hover);
        });
        
        this.setOnMouseExited(ev->{
           this.setStyle(def); 
        });
        
        //focus action
        this.setOnKeyTyped(er->{
            this.setStyle(hover);
        });
        
    }
    /**
     * This method sets default style of the combo
     * @param def 
     */
    public void setDefStyle(String def) {
        this.def=def;
        this.setStyle(def);
    }
    
    /**
     * This method sets style to be applied when user moves mouse over
     * @param hover 
     */
    public void setHoverStyle(String hover) {
        this.hover=hover;
    }
    
}
