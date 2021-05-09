/*
 * This app is developed for the department of nature and forestry to carryout reporting
 * and data storage in a more professional and effective way.
 */
package fonex;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.geometry.*;

import java.io.*;

/**
 *
 * @author Seumx Plus
 */
public class Fonex extends smx.jfx.application.Application {
    
    private Double xoff,yoff; private Stage stg;
    
    /**
     * This is where the application is initialized
     * @throws IOException 
     */
    @Override
    public void init() throws IOException {
        
        System.out.println("System is starting...!");
        
        //check for neccessary files availability
        java.io.File dir=new java.io.File("data");
        java.io.File farm=new java.io.File("data/input.bat");
        java.io.File sawe=new java.io.File("data/sawyers.bat");
        java.io.File pests=new java.io.File("data/pests.bat");
        java.io.File reports=new java.io.File("data/reports.bat");
        
        //creating files if not existing
        if(!farm.exists()) {
            dir.mkdirs();
            
            fonex.api.Head cus=new fonex.api.Head();
    
        java.util.HashSet<String> sup=new java.util.HashSet(); 
        java.util.Map<String, fonex.api.Supervision> map=new java.util.HashMap();
    
        java.util.HashSet<String> ch=new java.util.HashSet(); 
        fonex.api.Challenge chh=new fonex.api.Challenge();
    
        fonex.api.Compiler compiler=new fonex.api.Compiler();
            
            //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            /*/Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            */
            FileOutputStream out=new FileOutputStream(farm);
            ObjectOutputStream obj=new ObjectOutputStream(out);
            obj.writeObject(listy); obj.flush();
            
        }
        /*
        if(!sawe.exists()) {
            dir.mkdirs();
            java.util.Properties pr=new java.util.Properties();
            
            //write Object
            FileOutputStream out=new FileOutputStream(sawe);
            ObjectOutputStream obj=new ObjectOutputStream(out);
            obj.writeObject(pr); obj.flush();
            
        }
        
        if(!pests.exists()) {
            dir.mkdirs();
            java.util.Properties pr=new java.util.Properties();
            
            //write Object
            FileOutputStream out=new FileOutputStream(pests);
            ObjectOutputStream obj=new ObjectOutputStream(out);
            obj.writeObject(pr); obj.flush();
            
        }
        */
        if(!reports.exists()) {
            dir.mkdirs();
            java.util.Properties pr=new java.util.Properties();
            
            //write Object
            FileOutputStream out=new FileOutputStream(reports);
            ObjectOutputStream obj=new ObjectOutputStream(out);
            obj.writeObject(pr); obj.flush();
            
        }
        
    }
    
    /**
     * This is where the program and the UI graph execution starts
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        //give stage value to stg
        this.stg=stage;
        
        //Stage icon
        Image im=new Image(new FileInputStream("gif/Fonex.png"));
        
        //stage primary configurations
        stage.initStyle(StageStyle.TRANSPARENT); stage.getIcons().add(im); 
        stage.setWidth(901); stage.setHeight(571); stage.setTitle("Fonex");
        
        //dealing with the nodes and layouts hear
        //upper panel
        ImageView v=new ImageView(im); v.setFitWidth(51); v.setFitHeight(41);
        Label l=new Label("Fonex"); 
        l.setStyle("-fx-font: bold 37px 'Century GOTHIC'; -fx-text-fill:white");
        
        
        smx.jfx.layout.HBox bh=new smx.jfx.layout.HBox(); bh.setPadding(new Insets(1));
        bh.setStyle("-fx-background-color:green"); bh.getChildren().addAll(l);
        
        //two Buttons
        smx.jfx.control.Button m=new smx.jfx.control.Button("-");
        smx.jfx.control.Button x=new smx.jfx.control.Button("x");
        
        m.setDefaultStyle("-fx-background-color: green; -fx-font: normal 23px 'Century GOTHIC'; -fx-text-fill: white;");
        m.setHoverStyle("-fx-background-color: darkgreen; -fx-font: normal 23px 'Century GOTHIC'; -fx-text-fill: white;");
        
        x.setDefaultStyle("-fx-background-color: green; -fx-font: normal 23px 'Century GOTHIC'; -fx-text-fill: white;");
        x.setHoverStyle("-fx-background-color: red; -fx-font: normal 23px 'Century GOTHIC'; -fx-text-fill: white;");
        
        m.setOnAction(ev->{
            stage.setIconified(true);
        });
        
        x.setOnAction(ev->{
            stage.close();
        });
        
        smx.jfx.layout.GridPane hb=new smx.jfx.layout.GridPane(); hb.setPadding(new Insets(1)); hb.setHgap(5);
        hb.setStyle("-fx-background-color:green"); hb.add(m,0,0); hb.add(x,1,0);
        
        smx.jfx.layout.BorderPane bp=new smx.jfx.layout.BorderPane(); bp.setPadding(new Insets(0));
        bp.setStyle("-fx-background-color:green"); bp.setLeft(bh); bp.setRight(hb);
        
        /*
        Make this upper panel the movable object of the UI
        */
        bp.setOnMousePressed(ev->{
            xoff=ev.getSceneX(); yoff=ev.getSceneY();
        });
        
        bp.setOnMouseDragged(ev->{
            stage.setX(ev.getScreenX()-xoff); stage.setY(ev.getScreenY()-yoff);
        });
        
        //Bulld left parts of the UI
        String def="-fx-background-color:darkgreen; -fx-font:normal 19px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: darkgreen;"
            + "-fx-border-radius: 8px 8px 8px 8px;"
            
            ,hover="-fx-background-color:darkgreen; -fx-font:normal 19px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: white;"
            + "-fx-border-radius: 8px 8px 8px 8px;";
        
        smx.jfx.control.Button repo=new smx.jfx.control.Button("Create"); repo.setDefaultStyle(def); 
        repo.setHoverStyle(hover); repo.setPadding(new Insets(9,9,9,9)); repo.setPrefWidth(164);
        
        smx.jfx.control.Button saved=new smx.jfx.control.Button("Saved"); saved.setDefaultStyle(def); 
        saved.setHoverStyle(hover); saved.setPadding(new Insets(9,9,9,9)); saved.setPrefWidth(164);
        
        smx.jfx.control.Button farm=new smx.jfx.control.Button("Welcome"); farm.setDefaultStyle(def); 
        farm.setHoverStyle(hover); farm.setPadding(new Insets(9,9,9,9)); farm.setPrefWidth(164);
        
        smx.jfx.control.Button sawy=new smx.jfx.control.Button("Quit"); sawy.setDefaultStyle(def); 
        sawy.setHoverStyle(hover); sawy.setPadding(new Insets(9,9,9,9)); sawy.setPrefWidth(164);
        
        smx.jfx.control.Button pest=new smx.jfx.control.Button("Pests"); pest.setDefaultStyle(def); 
        pest.setHoverStyle(hover); pest.setPadding(new Insets(9,9,9,9)); pest.setPrefWidth(164);
        
        smx.jfx.control.Button info=new smx.jfx.control.Button("Info"); info.setDefaultStyle(def); 
        info.setHoverStyle(hover); info.setPadding(new Insets(9,9,9,9)); info.setPrefWidth(164);
        
        smx.jfx.layout.VBox vb=new smx.jfx.layout.VBox(); vb.setPadding(new Insets(7));
        vb.setStyle("-fx-background-color:darkgreen"); vb.getChildren().addAll(farm,repo,saved,info,sawy);
        
        //Build center parts of the UI
        Label fo=new Label("Fonex"); 
        fo.setStyle("-fx-font:bold 147px 'Century GOTHIC';-fx-text-fill:lightgreen;");
        
        ImageView iv=new ImageView(im); iv.setFitWidth(213); iv.setFitHeight(213);
        
        javafx.animation.FadeTransition uiy=
                new javafx.animation.FadeTransition(javafx.util.Duration.millis(5713));
        uiy.setCycleCount(1000); uiy.setFromValue(0); uiy.setToValue(1); uiy.setAutoReverse(true);
        uiy.setNode(iv); uiy.play();
        
        Label fi=new Label("Make Supervision Reports Quicker and Smarter!\nv1.1.8");
        fi.setStyle("-fx-font:bold 18px 'Century GOTHIC';-fx-text-fill:azure;");
        
        smx.jfx.layout.VBox vo=new smx.jfx.layout.VBox(); vo.setPadding(new Insets(7));
        vo.setAlignment(Pos.CENTER); 
        vo.setStyle("-fx-background-color:darkgreen");
        vo.getChildren().addAll(iv,fo,fi);
        
        fonex.ui.Report report=new fonex.ui.Report(stage); 
        
        //Build bottom parts of the UI
        Label co=new Label("© Seumx Plus 2021. All Rights Reserved.");
        co.setStyle("-fx-font: normal 16px 'Century GOTHIC'; -fx-text-fill:white");
        
        smx.jfx.layout.HBox btm=new smx.jfx.layout.HBox(); btm.setPadding(new Insets(5,5,5,5));
        btm.setAlignment(Pos.CENTER);
        btm.setStyle("-fx-background-color:green"); btm.getChildren().addAll(co);
        
        //making up the borderPane for the UI
        smx.jfx.layout.BorderPane ui=new smx.jfx.layout.BorderPane(); ui.setPadding(new Insets(0));
        ui.setStyle("-fx-background-color:transparent");
        ui.setTop(bp); ui.setCenter(vo); ui.setBottom(btm); ui.setLeft(vb);
        
        Scene sn=new Scene(ui);
        stage.setScene(sn); 
        
        fonex.ui.PreLoader pre=new fonex.ui.PreLoader();
        pre.showPre(stage);
        
        /*
        Action to the Menu Buttons
        */
        repo.setOnAction(ev->{
            
            ui.setCenter(report);
            
        });
        
        saved.setOnAction(ev->{
            
            fonex.ui.Saved savedi=new fonex.ui.Saved(stage); 
        
            ui.setCenter(savedi);
            
        });
        
        farm.setOnAction(ev->{
            
            ui.setCenter(vo);
            
        });
        
        sawy.setOnAction(ev->{
            
            stage.close();
            
        });
        
        pest.setOnAction(ev->{
            
            
            
        });
        
        info.setOnAction(ev->{
            try {
            fonex.ui.Info inu=new fonex.ui.Info();
            ui.setCenter(inu);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        
    }
    
    /**
     * Application stops by calling this function
     */
    @Override
    public void stop() {
        System.out.println("System is Shutting down!");
    }
    
    /**
     * @return
     */
    public Stage getStage() {
        return this.stg;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
