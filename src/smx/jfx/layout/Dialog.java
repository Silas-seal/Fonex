
package smx.jfx.layout;

/**
 *
 * @author Seumx Plus
 */

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Dialog extends Stage {
    
    public Dialog(Stage owner, boolean decorated, boolean resizable, double width, double height, Scene item, String title, Image icon)
    {
        
        this.initOwner(owner); this.setWidth(width); this.setHeight(height); this.getIcons().add(icon);
        item.setFill(Color.TRANSPARENT); this.setScene(item); this.setTitle(title);
        
        if(decorated) {
            this.initStyle(StageStyle.DECORATED);
        } else {
            this.initStyle(StageStyle.TRANSPARENT);
        }
        
        if(resizable) {
            this.setResizable(true);
        } else {
            this.setResizable(false);
        }
        
    }
    
    public void showDialog(Stage prototype) {
        
        if(prototype!=null) 
        {
            
            prototype.close();
            
            this.show();
            
        } else 
        {
            
            this.show();
            
        }
        
    }
    
}
