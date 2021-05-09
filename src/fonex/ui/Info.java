/*
 * App Information
 */
package fonex.ui;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.geometry.*;

import java.io.*;

/**
 *
 * @author Seumx Plus
 */
public class Info extends javafx.scene.layout.GridPane {
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Info() throws IOException {
        
        String dtls="APP NAME: \n\t\tFONEX\nVersion: 1.1.8_A.S\n"
                + "Developer:\n\t\tMuwanguzi $ilas\n"
                + "Release Date: Monday, 3rd May, 2021.\nCompany: #Seumx Plus"
                + "\n\t\t#Remote Station [remotestation.github.io]\n"
                + "Email: silas.seal7@gmail.com"
                + "\nWebsite: https://silas-seal.github.io/seumxplus.smx/";
        
        Label l1=new Label(dtls);
        l1.setStyle("-fx-font: normal 18px 'Century GOTHIC'; -fx-text-fill:azure;");
        
        ImageView iv=new ImageView(new Image(new FileInputStream("gif/Fonex.png"))); iv.setFitWidth(238); iv.setFitHeight(238);
        
        this.setPadding(new Insets(8,8,8,8)); this.setVgap(8); this.setHgap(8); this.setAlignment(Pos.TOP_LEFT);
        this.setStyle("-fx-background-color:darkgreen"); this.add(iv,0,0); this.add(l1,0,1);
        
    }
    
}
