/*
 * This class deals with initial animations of the application
 */
package fonex.ui;

/**
 *
 * @author Seumx Plus
 */

import java.io.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.StageStyle;

public class PreLoader {
    
    private smx.jfx.layout.Dialog stg; private final GridPane gp;
    
    /**
     * This is to arrange the pre-loader
     * @throws IOException 
     */
    public PreLoader() throws IOException {
        
        ImageView iv=new ImageView(new Image(new FileInputStream("gif/Fonex.png"))); iv.setFitWidth(208); iv.setFitHeight(208);
        
        javafx.scene.control.Label say=new javafx.scene.control.Label("Fonex");
        javafx.scene.control.Label ver=new javafx.scene.control.Label("v1.1.8");
        
        say.setStyle("-fx-text-fill:white; -fx-font:bold 53px 'Century GOTHIC'");
        ver.setStyle("-fx-text-fill:white; -fx-font:normal 25px 'Century GOTHIC'");
        
        GridPane dep=new GridPane();
        dep.setPadding(new Insets(8,8,8,8)); dep.setVgap(8); dep.setHgap(8); dep.setAlignment(Pos.BOTTOM_CENTER);
        dep.setStyle("-fx-background-color: linear-gradient(to bottom right,darkgreen,azure);");
        dep.add(say,0,0); dep.add(ver,0,1);
        
        GridPane rel=new GridPane();
        rel.setPadding(new Insets(8,8,8,8)); rel.setVgap(8); rel.setHgap(8); rel.setAlignment(Pos.CENTER);
        rel.setStyle("-fx-background-color: linear-gradient(to bottom right,darkgreen,azure); "
                + "-fx-background-radius:0px 31px 0px 31px;"); 
        rel.add(iv,0,0); rel.add(dep,1,0);
        
        //create a dialog!
        stg=new smx.jfx.layout.Dialog(stg,true,false,417,241,new javafx.scene.Scene(rel),
                    null,new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        gp=rel;
    
        stg.initStyle(StageStyle.TRANSPARENT);
    }
    
    /**
     * Showing the pre-loader and animating to soft interface!
     * @param stage 
     */
    public void showPre(javafx.stage.Stage stage) {
        
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(12478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(0.3); fddu.setToValue(1); 
        fddu.setNode(gp); fddu.play();
        
        stg.show();
        
        fddu.setOnFinished(ex->{ System.out.println("Load!");
            
            stg.close(); stage.show();
            
        });
        
    }
    
}
