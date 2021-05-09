
package smx.jfx.control;

/**
 *
 * @author Seumx Plus
 */
public class ProgressBar extends javafx.scene.control.ProgressBar {
    
    //declare memory locations
    private String def="-fx-background-color:whitesmoke; -fx-font:normal 16px 'Calibri'; -fx-text-fill:black;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: royalblue;"
            + "-fx-border-radius: 8px 8px 8px 8px; -fx-accent: darkslateblue;";
    
    public ProgressBar() {
        
        this.setStyle(def);
        
    }
    
    public void setDefStyle(String def) {
        this.def=def;
        this.setStyle(def);
    }
    
}
