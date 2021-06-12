/*
 * Report Pane
 */
package fonex.ui;

/**
 *
 * @author Seumx Plus
 */

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.scene.web.*;

import java.util.*;
import java.io.*;
import javafx.print.*;
//import java.net.*;

/**
This is the Report UI of the APP
*/
public class Report extends smx.jfx.layout.GridPane {
    
    private smx.jfx.layout.Dialog parad; private boolean rdy=false;
    
    private String report=null,uik="";
    
    private String thm="darkgreen", img="gif/Fonex.png", slo="DIGITAL PRO-REPORT";
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "ConvertToTryWithResources"})
    public Report(javafx.stage.Stage stg) throws Exception 
    {
        //Initialising two Heads api for app
    /*
    This First is default for Kamuli!
    */
    fonex.api.Head kam=new fonex.api.Head();
    kam.setLeftAd("KAMULI DISTRICT LOCAL GOVERNMENT", "P.O BOX 88, KAMULI", "", "");
    kam.setLeftAd("DEPARTMENT OF NATURAL", "RESOURCES/FORESTRY SECTOR", "BUGABULA SOUTH", "");
    
    /*
    Theme and Logo Valuables!
    */
    
    //Bulld left parts of the UI
        String def="-fx-background-color:darkgreen; -fx-font:normal 18px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: darkgreen;"
            + "-fx-border-radius: 8px 8px 8px 8px;"
            
            ,hover="-fx-background-color:green; -fx-font:normal 18px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: green;"
            + "-fx-border-radius: 8px 8px 8px 8px;",
                
                tfo="-fx-font:normal 18px 'Century GOTHIC'; -fx-background-color:white; -fx-text-fill:darkgreen;"
                + "-fx-control-inner-background:darkgreen; -fx-accent:darkgreen; -fx-focus-color:white;",
                
                tar="-fx-font:normal 18px 'Century GOTHIC'; -fx-text-fill:darkgreen; -fx-border-color:darkgreen; -fx-border-width:5px;"
                + "-fx-control-inner-background:white; -fx-accent:darkgreen; -fx-focus-color:darkgreen;";
    
    /*
    This second is a custom api
    */
    //Read Object
    ObjectInputStream inn=new ObjectInputStream(new FileInputStream("data/input.bat"));
    List<Object> lsti=(ArrayList<Object>) inn.readObject();
    
    fonex.api.Head cus=(fonex.api.Head)lsti.get(0);
    
    HashSet<String> sup=(HashSet)lsti.get(1);
    Map<String, fonex.api.Supervision> map=(Map)lsti.get(2);
    
    HashSet<String> ch=(HashSet)lsti.get(3);
    fonex.api.Challenge chh=(fonex.api.Challenge)lsti.get(4);
    
    fonex.api.Compiler compiler=(fonex.api.Compiler)lsti.get(5);
    
    /*Get the list to ch list<String>
    HashSet<String> ch=new HashSet(); Set sey=chh.keySet(); Iterator ite=sey.iterator();
    while(ite.hasNext()) {
        String uij=(String)ite.next();
        if(uij.length()>1) {
            ch.add(uij);
        }
    }*/
    java.util.List<Object> list=new java.util.ArrayList(); 
            list.add(cus); list.add(sup); list.add(map); list.add(ch); list.add(chh); 
            list.add(compiler);
    
    /*
    Here is the header form for 4line input
    */
    Label lf=new Label("Left"); Label rt=new Label("Right");
    lf.setStyle("-fx-font:bold 20px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
    rt.setStyle("-fx-font:bold 20px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
    
    //left fields
    TextField tf1=new TextField(cus.getLn1()); tf1.setPrefWidth(387); tf1.setPromptText("Left Address Line 1");
    tf1.setStyle(tfo);
    
    TextField tf2=new TextField(cus.getLn2()); tf2.setPrefWidth(387); tf2.setPromptText("Left Address Line 2");
    tf2.setStyle(tfo);
    
    TextField tf3=new TextField(cus.getLn3()); tf3.setPrefWidth(387); tf3.setPromptText("Left Address Line 3");
    tf3.setStyle(tfo);
    
    TextField tf4=new TextField(cus.getLn4()); tf4.setPrefWidth(387); tf4.setPromptText("Left Address Line 4");
    tf4.setStyle(tfo);
    
    //Postra
    //right fields
    TextField rf1=new TextField(cus.getRn1()); rf1.setPrefWidth(387); rf1.setPromptText("Right Address Line 1");
    rf1.setStyle(tfo);
    
    TextField rf2=new TextField(cus.getRn2()); rf2.setPrefWidth(387); rf2.setPromptText("Right Address Line 2");
    rf2.setStyle(tfo);
    
    TextField rf3=new TextField(cus.getRn3()); rf3.setPrefWidth(387); rf3.setPromptText("Right Address Line 3");
    rf3.setStyle(tfo);
    
    TextField rf4=new TextField(cus.getRn4()); rf4.setPrefWidth(387); rf4.setPromptText("Right Address Line 4");
    rf4.setStyle(tfo);
    
    smx.jfx.control.Button parag=new smx.jfx.control.Button("Initial Paragraph"); parag.setPrefWidth(251);
    parag.setDefaultStyle(def); parag.setHoverStyle(hover);
    
    smx.jfx.control.Button ok=new smx.jfx.control.Button("Commit"); ok.setPrefWidth(251);
    ok.setDefaultStyle(def); ok.setHoverStyle(hover);
    
    GridPane pn=new GridPane(); pn.setPadding(new Insets(5,5,5,5)); pn.setVgap(9); pn.setHgap(18);
    pn.setAlignment(Pos.CENTER); pn.setStyle("-fx-background-color:whitesmoke");
    
    //add nodes to GridLayout
    pn.add(lf,0,0); pn.add(rt,1,0);
    pn.add(tf1,0,1); pn.add(rf1,1,1);
    pn.add(tf2,0,2); pn.add(rf2,1,2);
    pn.add(tf3,0,3); pn.add(rf3,1,3);
    pn.add(tf4,0,4); pn.add(rf4,1,4);
    /*pn.add(canc,0,5);*/
    
    //four line addresse
    TextField ads1=new TextField(cus.getAd1()); ads1.setPrefWidth(387); ads1.setPromptText("Addressee Line 1");
    ads1.setStyle(tfo);
    
    TextField ads2=new TextField(cus.getAd2()); ads2.setPrefWidth(387); ads2.setPromptText("Addressee Line 2");
    ads2.setStyle(tfo);
    
    TextField ads3=new TextField(cus.getAd3()); ads3.setPrefWidth(387); ads3.setPromptText("Addressee Line 3");
    ads3.setStyle(tfo);
    
    TextField ads4=new TextField(cus.getAd4()); ads4.setPrefWidth(387); ads4.setPromptText("Addressee Line 4");
    ads4.setStyle(tfo);
    
    //Date
    Label dat=new Label("Date & Reference"); 
    dat.setStyle("-fx-font:bold 18px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
    
    TextField dtt=new TextField(cus.getDate()); dtt.setPrefWidth(387); dtt.setPromptText("Date (XXXX, DD. MM,YYYY)");
    dtt.setStyle(tfo);
    
    //Reference
   
    TextField re=new TextField(cus.getRef()); re.setPrefWidth(317); re.setPromptText("Reference/Reason");
    re.setStyle(tfo);
    
    TextField sl=new TextField(); sl.setPrefWidth(317); sl.setPromptText("Custom LOGO Title");
    sl.setStyle(tfo); sl.setDisable(false);
    
    //Theme Combo Box and custom image and sluwgun
    ComboBox theme=new ComboBox(); theme.setPrefWidth(138); theme.setStyle(tar);
    theme.setValue("Theme"); theme.getItems().addAll("Default","Blue", "Red", "Black", "Grey", "Orange");
    
    ComboBox logo=new ComboBox(); logo.setPrefWidth(138); logo.setStyle(tar);
    logo.setValue("Logo"); logo.getItems().addAll("Default","Uganda", "Custom");
    
    GridPane pn1=new GridPane(); pn1.setPadding(new Insets(5,5,5,5)); pn1.setVgap(9); pn1.setHgap(18);
    pn1.setAlignment(Pos.CENTER); pn1.setStyle("-fx-background-color:whitesmoke");
    
    pn1.add(ads1,0,0); pn1.add(ads2,1,0);
    pn1.add(ads3,0,1); pn1.add(ads4,1,1);
    pn1.add(sl,0,2); pn1.add(dtt,1,2);
    
    GridPane head=new GridPane(); 
    head.setPadding(new Insets(8,8,8,8)); head.setVgap(8); head.setHgap(8); head.setAlignment(Pos.TOP_LEFT);
    head.setStyle("-fx-backgroung-color:whitesmoke"); head.add(pn,0,0); head.add(pn1,0,1); head.add(re,0,2); 
    head.add(new HBox(parag,ok,theme,logo),0,3);
    
    /*
    Dialog!
    */
    smx.jfx.layout.Dialog dialog
            =new smx.jfx.layout.Dialog(stg,true,false,839,513,new javafx.scene.Scene(head),
                    "Enter Primary Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
    
    
    /*
    Button For The Head Credintials
    */
    smx.jfx.control.Button pri=new smx.jfx.control.Button("Enter Primary Information"); pri.setPrefWidth(637);
    pri.setDefaultStyle(def); pri.setHoverStyle(hover);
    
    /*
    The supervision panel
    */
    Label sul=new Label("Supervision");
    sul.setStyle("-fx-font:bold 20px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
    
    ListView lvs=new ListView(FXCollections.observableArrayList(sup));
    lvs.setStyle("-fx-control-inner-background:darkgreen; -fx-accent:white; -fx-font:normal 17px 'Century GOTHIC';"
            + "-fx-focus-color:darkgreen;");
    lvs.setPrefSize(637,91);
    
    smx.jfx.control.Button rmv=new smx.jfx.control.Button("Remove"); rmv.setPrefWidth(317);
    rmv.setDefaultStyle(def); rmv.setHoverStyle(hover);
    
    smx.jfx.control.Button add=new smx.jfx.control.Button("Add"); add.setPrefWidth(317);
    add.setDefaultStyle(def); add.setHoverStyle(hover);
    
    GridPane supe=new GridPane(); 
    supe.setPadding(new Insets(3,3,3,3)); supe.setVgap(3); supe.setHgap(3); supe.setAlignment(Pos.TOP_LEFT);
    supe.setStyle("-fx-backgroung-color:whitesmoke"); supe.add(sul,0,0); supe.add(lvs,0,1); supe.add(new HBox(rmv,add),0,2);
    
    
    /*
    The Challenges Panel
    */
    Label che=new Label("Challenges");
    che.setStyle("-fx-font:bold 20px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
    
    ListView chs=new ListView(FXCollections.observableArrayList(ch));
    chs.setStyle("-fx-control-inner-background:darkgreen; -fx-accent:white; -fx-font:normal 17px 'Century GOTHIC';"
            + "-fx-focus-color:darkgreen;");
    chs.setPrefSize(637,91);
    
    smx.jfx.control.Button rmv1=new smx.jfx.control.Button("Remove"); rmv1.setPrefWidth(317);
    rmv1.setDefaultStyle(def); rmv1.setHoverStyle(hover);
    
    smx.jfx.control.Button add1=new smx.jfx.control.Button("Add"); add1.setPrefWidth(317);
    add1.setDefaultStyle(def); add1.setHoverStyle(hover);
    
    GridPane chal=new GridPane(); 
    chal.setPadding(new Insets(3,3,3,3)); chal.setVgap(3); chal.setHgap(3); chal.setAlignment(Pos.TOP_LEFT);
    chal.setStyle("-fx-backgroung-color:whitesmoke"); chal.add(che,0,0); chal.add(chs,0,1); chal.add(new HBox(rmv1,add1),0,2);
    
    
    /*
    Button For The Head Credintials
    */
    smx.jfx.control.Button sec=new smx.jfx.control.Button("Enter Final Information"); sec.setPrefWidth(637);
    sec.setDefaultStyle(def); sec.setHoverStyle(hover);
    
    
    /*
    Button For The Head Credintials
    */
    smx.jfx.control.Button gen=new smx.jfx.control.Button("#Create Report"); gen.setPrefWidth(317);
    gen.setDefaultStyle(def); gen.setHoverStyle(hover);
    
    smx.jfx.control.Button clear=new smx.jfx.control.Button("Clear Current Input!"); clear.setPrefWidth(317);
    clear.setDefaultStyle(def); clear.setHoverStyle(hover.replaceAll("green","red"));
    
    
    /*
    This is The real Grid (this)
    */
    
    this.setPadding(new Insets(8,8,8,8)); this.setVgap(8); this.setHgap(8); this.setAlignment(Pos.TOP_LEFT);
    this.setStyle("-fx-background-color: linear-gradient(to bottom right,white,lightgrey);"); 
    this.add(pri,0,0); this.add(supe,0,1); this.add(chal,0,2);
    this.add(sec,0,3); this.add(new HBox(clear,gen),0,4);
    
    
    //We Lets go to the Actions
    /*
    These are the actions to the above declared and configured buttons
    */
    
    /*
    Am here detailing with the logo and theme items!
    */
    
    clear.setOnAction(ev->{
        
        chs.setItems(null); lvs.setItems(null); map.clear(); chh.clear();
        
        cus.clear(); compiler.clear(); ch.clear(); sup.clear();
        
        /*DEF*/
        tf1.setText(cus.getLn1()); tf2.setText(cus.getLn2()); tf3.setText(cus.getLn3());
        tf4.setText(cus.getLn4());
        
        rf1.setText(cus.getRn1()); rf2.setText(cus.getRn2()); rf3.setText(cus.getRn3());
        rf4.setText(cus.getRn4());
        
        ads1.setText(cus.getAd1()); ads2.setText(cus.getAd2()); ads3.setText(cus.getAd3());
        ads4.setText(cus.getAd4());
        
        sl.setText(null); dtt.setText(cus.getDate()); re.setText(cus.getRef());
        
        //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            
        
    });
    
    theme.setOnAction(er->{
        
        String sel=(String)theme.getValue();
        
        switch(sel) {
            case "Default":
                thm="darkgreen";
                break;
            case "Blue":
                thm="navy";
                break;
            case "Grey":
                thm="darkslategrey";
                break;
            case "Red":
                thm="darkred";
                break;
            case "Black":
                thm="black";
                break;
            case "Orange":
                thm="darkorange";
                break;
            default:
                thm="darkgreen";
                break;
        }
        
    });
    
    logo.setOnAction(er->{
        
        String sel=(String)logo.getValue();
        
        switch(sel) {
            
            case "Default":
                img="gif/Fonex.png"; slo="DIGITAL PRO-REPORT";
                break;
            case "Uganda":
                img="gif/cof.jpg"; slo="THE REPUBLIC OF UGANDA";
                break;
            case "Custom":
                javafx.stage.FileChooser chu=new javafx.stage.FileChooser();
                chu.getExtensionFilters().addAll(new javafx.stage.FileChooser.ExtensionFilter("PNG Image", "*.png"),
                        new javafx.stage.FileChooser.ExtensionFilter("JPG Image", "*.jpg"));
                chu.setTitle("Chooser Custom LOGO Image!"); chu.setInitialDirectory(new File("gif"));
                
                String fyl;
                
                String mysel=chu.showOpenDialog(dialog).getPath();
                
                File fyuo=new File(mysel);
                
                fyl="gif/"+fyuo.getName(); File file=new File(fyl);
                
                fonex.api.IOAction ios=new fonex.api.IOAction();
                try {
                    
                    if(!file.exists()) { System.out.println("Writing!");
                ios.copyFile(mysel, fyl);
                    } else System.out.println("Exists!");
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
                    img=fyl; slo=sl.getText();
                    
                break;
            default: 
                img="gif/Fonex.png"; slo="DIGITAL PRO-REPORT";
                break;
            
        }
        
    });
    
    //There you go!
    pri.setOnAction(ev->{
        
        dialog.show();
        
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            cus.setLeftAd(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText());
        
            cus.setRightAd(rf1.getText(), rf2.getText(), rf3.getText(), rf4.getText());
        
            cus.setAddressee(ads1.getText(), ads2.getText(), ads3.getText(), ads4.getText());
        
            cus.setDate(dtt.getText());
        
            cus.setReference(re.getText());
            
            /*/Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            */
            if(dialog.isShowing()) {
            fddu.play();}
            
        });
        
    });
    
    parag.setOnAction(ev->{
        rdy=true;
        try {
        
        TextArea area=new TextArea(cus.getPara()); area.setStyle(tar); area.setPrefSize(718,349);
        area.setManaged(true); area.setWrapText(true); area.setPromptText("Enter Initial Introductory Paragraph Here!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(418);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(17);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(area,0,0); vbg.add(cmt,0,1);
        
        if(parad!=null) {
            parad.close();
        parad
            =new smx.jfx.layout.Dialog(dialog,true,false,718,447,new javafx.scene.Scene(vbg),
                    "Enter Initial Paragraph!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(dialog,true,false,718,447,new javafx.scene.Scene(vbg),
                    "Enter Initial Paragraph!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
            
        }
        
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            cus.setPara(area.getText());
            
            /*/Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            */
            if(rdy) {
            fddu.play();}
        });
        
        //Action to cmt
        cmt.setOnAction(er->{
            
            cus.setPara(area.getText());
            
            parad.close(); rdy=false;
            
        });
        
        } catch(java.io.IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    });
    
    ok.setOnAction(ev->{
        
        /*
        Hahahaaah! Lets add these head values to the Head class
        */
        
        cus.setLeftAd(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText());
        
        cus.setRightAd(rf1.getText(), rf2.getText(), rf3.getText(), rf4.getText());
        
        cus.setAddressee(ads1.getText(), ads2.getText(), ads3.getText(), ads4.getText());
        
        cus.setDate(dtt.getText());
        
        cus.setReference(re.getText());
        
        dialog.close();
        
    });
    
    
    /*
    Supervision Button Actions
    */
    add.setOnAction(eu->{
        
        try {
        
        //Adding super visions
        TextField tfg=new TextField(); tfg.setPrefWidth(589); tfg.setStyle(tfo); tfg.setPromptText("Enter Supervision Title(Name)");
        
        TextArea superv=new TextArea(); superv.setStyle(tar); superv.setPrefSize(588,289); 
        superv.setManaged(true); superv.setWrapText(true); superv.setPromptText("Enter Your Supervision Details Here!");
        
        TextArea comment=new TextArea(); comment.setStyle(tar); comment.setPrefSize(588,289);
        comment.setManaged(true); comment.setWrapText(true); comment.setPromptText("Enter Your Comment Here!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(518);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(17);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(tfg,0,0); vbg.add(superv,0,1); vbg.add(comment,0,2); vbg.add(cmt,0,3);
        
        if(parad!=null) {
            
            parad.close();
        
        parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,497,new javafx.scene.Scene(vbg),
                    "Add Supervision Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,497,new javafx.scene.Scene(vbg),
                    "Add Supervision Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show(); }
        
        rdy=true; 
        
        /*Save Transition*//*
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            if(!tile.equals(tfg.getText())) {
                sup.remove(tile); tile=tfg.getText();
            }
            
            fonex.api.Supervision sp1=new fonex.api.Supervision(); sp1.setName(tfg.getText()); 
            sp1.setDescription(superv.getText()); sp1.setComments(comment.getText());
            
            map.put(tile, sp1);
            
            //add to list
            sup.add(tile);
            
            //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            
            if(rdy) {
            fddu.play();}
            
        });
            */
        
        
        /*
        Actions to cmt
        */
        cmt.setOnAction(yu->{
            
            //if(!sup.contains(tfg.getText())) {
            
            fonex.api.Supervision sp1=new fonex.api.Supervision(); sp1.setName(tfg.getText()); 
            sp1.setDescription(superv.getText()); sp1.setComments(comment.getText());
            
            map.put(tfg.getText(), sp1);
            
            //add to listView
            sup.add(tfg.getText()); lvs.setItems(FXCollections.observableArrayList(sup));
            
            parad.close(); rdy=false;
            //}
            
        });
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    });
    
    rmv.setOnAction(eu->{
        
        //remove from list, listView, map
        String tre=lvs.getSelectionModel().getSelectedItem().toString();
        
        if(tre!=null) {
            
        sup.remove(tre); lvs.getItems().remove(tre); map.remove(tre);
        
        //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            
        
        }
    });
    
    lvs.setOnMouseClicked(ev->{
        
        if(ev.getClickCount()>=2) {
            
            String tryo=lvs.getSelectionModel().getSelectedItem().toString();
            
            /*
            View current values and make them editable
            */
            try {
        
        //Adding super visions
        TextField tfg=new TextField(map.get(tryo).getName()); tfg.setPrefWidth(589); tfg.setStyle(tfo); tfg.setPromptText("Enter Supervision Title(Name)");
        
        TextArea superv=new TextArea(map.get(tryo).getDescription()); superv.setStyle(tar); superv.setPrefSize(588,289); 
        superv.setManaged(true); superv.setWrapText(true); superv.setPromptText("Enter Your Supervision Details Here!");
        
        TextArea comment=new TextArea(map.get(tryo).getComments()); comment.setStyle(tar); comment.setPrefSize(588,289);
        comment.setManaged(true); comment.setWrapText(true); comment.setPromptText("Enter Your Comment Here!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(518);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(17);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(tfg,0,0); vbg.add(superv,0,1); vbg.add(comment,0,2); vbg.add(cmt,0,3);
        
        if(parad!=null) {
            
        parad.close();
            
        parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,497,new javafx.scene.Scene(vbg),
                    "Review/Edit Supervision Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,497,new javafx.scene.Scene(vbg),
                    "Review/Edit Supervision Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show(); rdy=true;
        
        //jdvhdjfkdshgi
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            fonex.api.Supervision sp1=new fonex.api.Supervision(); sp1.setName(tryo); 
            sp1.setDescription(superv.getText()); sp1.setComments(comment.getText());
            
            map.remove(tryo);
            
            map.put(tryo, sp1);
            
            //add to listView
            /*if(!tryo.equals(tfg.getText())) {
                
                sup.remove(tryo);
                
            sup.add(tfg.getText());
            
            }*/
			
            /*/Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();*/
            
            if(rdy) {
            fddu.play();}
		});
            
        }
        /*
        Actions to cmt
        */
        cmt.setOnAction(yu->{
            
            fonex.api.Supervision sp1=new fonex.api.Supervision(); sp1.setName(tfg.getText()); 
            sp1.setDescription(superv.getText()); sp1.setComments(comment.getText());
            
            map.remove(tryo);
            
            map.put(tfg.getText(), sp1);
            
            //add to listView
            if(!tryo.equals(tfg.getText())) {
                
                sup.remove(tryo);
                
            sup.add(tfg.getText()); lvs.setItems(FXCollections.observableArrayList(sup));
            
            }
            
            parad.close(); rdy=false;
            
        });
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
            
        }
        
    });
    
    
    /*
    Challenges SUITS!
    */
    add1.setOnAction(ev->{
        
        try {
        
        TextField tfg=new TextField(); tfg.setPrefWidth(589); tfg.setStyle(tfo); tfg.setPromptText("Enter Challenge Title(Name)");
        
        TextArea superv=new TextArea(); superv.setStyle(tar); superv.setPrefSize(588,339); 
        superv.setManaged(true); superv.setWrapText(true); superv.setPromptText("Enter Your Challenge Details Here!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(518);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(17);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(tfg,0,0); vbg.add(superv,0,1); vbg.add(cmt,0,3);
        
        if(parad!=null) {
        
            parad.close();
            
        parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,437,new javafx.scene.Scene(vbg),
                    "Challenges Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,437,new javafx.scene.Scene(vbg),
                    "Challenges Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
            
            parad.show();
            
        }
        
        rdy=true;
        
        /*Save Transition*//*
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            if(!uik.equals(tfg.getText())) {
                ch.remove(uik); uik=tfg.getText(); chh.remove(uik);
            }
           
               chh.put(uik, superv.getText());
               //ADD TO LIST!
               ch.add(uik);
            
            //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            
            if(rdy) {
            fddu.play();}
            
		});
        */
        /*
        Actions
        */
        cmt.setOnAction(io->{
            
                ch.add(tfg.getText()); chh.put(tfg.getText(), superv.getText());
                
                chs.setItems(FXCollections.observableArrayList(ch));
                
                parad.close(); rdy=false;
                
            
        });
        
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    });
    
    rmv1.setOnAction(ev->{
        
        String uio=chs.getSelectionModel().getSelectedItem().toString();
        
        ch.remove(uio); chh.remove(uio); chs.getItems().remove(uio);
        
        //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
        
    });
    
    chs.setOnMouseClicked(ev->{
        
        if(ev.getClickCount()>=2) {
            
            try {
                
                String uio=chs.getSelectionModel().getSelectedItem().toString();
        
        TextField tfg=new TextField(uio); tfg.setPrefWidth(589); tfg.setStyle(tfo); tfg.setPromptText("Enter Challenge Title(Name)");
        
        TextArea superv=new TextArea(chh.getProperty(uio)); superv.setStyle(tar); superv.setPrefSize(588,339); 
        superv.setManaged(true); superv.setWrapText(true); superv.setPromptText("Enter Your Challenge Details Here!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(518);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(17);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(tfg,0,0); vbg.add(superv,0,1); vbg.add(cmt,0,3);
        
        if(parad!=null) {
         
            parad.close();
        
        parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,437,new javafx.scene.Scene(vbg),
                    "Review/Edit Challenges Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,437,new javafx.scene.Scene(vbg),
                    "Review/Edit Challenges Information!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
            
        }
        
        rdy=true;
        
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            /*ch.remove(uio);*/ uik=tfg.getText();
                
            //ch.add(uik);
                   
            chh.put(uio, superv.getText());
		
            
            /*/Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            */
            if(rdy) {
            fddu.play();}
		});
        
        /*
        Actions
        */
        cmt.setOnAction(io->{
            
            if(!uio.equals(tfg.getText())) {
                
                ch.remove(uio);
                
                ch.add(tfg.getText()); 
                
                chs.setItems(FXCollections.observableArrayList(ch));
                
                
            }
                chh.put(tfg.getText(), superv.getText());
                
                parad.close(); rdy=false;
           
        });
        
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
            
        }
        
    });
    
    
    /*
    This is Interesting! Going towards the best!
    FINAL INFO
    */
    sec.setOnAction(ev->{
        
        try {
        
        TextField tfg=new TextField(compiler.getLn1()); tfg.setPrefWidth(489); tfg.setStyle(tfo); tfg.setPromptText("Compiler Line #1");
        
        TextField tfg2=new TextField(compiler.getLn2()); tfg2.setPrefWidth(589); tfg2.setStyle(tfo); tfg2.setPromptText("Compiler Line #2");
        
        TextField tfg3=new TextField(compiler.getLn3()); tfg3.setPrefWidth(589); tfg3.setStyle(tfo); tfg3.setPromptText("Compiler Line #3");
        
        TextField tfg4=new TextField(compiler.getLn4()); tfg4.setPrefWidth(589); tfg4.setStyle(tfo); tfg4.setPromptText("Compiler Line #4");
        
        TextArea superv=new TextArea(compiler.getRemarks()); superv.setStyle(tar); superv.setPrefSize(588,339); 
        superv.setManaged(true); superv.setWrapText(true); superv.setPromptText("Enter Your Final Remarks On The Report!");
        
        smx.jfx.control.Button cmt=new smx.jfx.control.Button("Commit"); cmt.setPrefWidth(518);
        cmt.setDefaultStyle(def); cmt.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(8);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(superv,0,0); vbg.add(tfg,0,1); vbg.add(tfg2,0,2);
        vbg.add(tfg3,0,3); vbg.add(tfg4,0,4); vbg.add(cmt,0,5);
        
        if(parad!=null) {
        
            parad.close();
            
        parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,501,new javafx.scene.Scene(vbg),
                    "Final Report Remarks!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        } else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,718,501,new javafx.scene.Scene(vbg),
                    "Final Report Remarks!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
            
        }
        
        /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3478));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            compiler.setCompiler(tfg.getText(), tfg2.getText(), tfg3.getText(), tfg4.getText());
            
            compiler.setRemarks(superv.getText());
            
			
            /*/Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            */
            if(parad.isShowing()) {
            fddu.play();}
		});
        
        /*Let Us Take Action!*/
        cmt.setOnAction(uio->{
            
            compiler.setCompiler(tfg.getText(), tfg2.getText(), tfg3.getText(), tfg4.getText());
            
            compiler.setRemarks(superv.getText());
            
            parad.close();
            
        });
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    });
    
    
    gen.setOnAction(yui->{
        
        /*
        String to give a vivid Report!
        */
        report="<html><head><title>Report</title></head> <body bgcolor=\"white\"> <font face=\"Century GOTHIC\" size=\"+1\">"
                
                + "<table border=\"9\" bordercolor=\""+thm+"\" cellpadding=\"5\" cellspacing=\"5\" width=\"100%\" bgcolor=\"white\">"
                
                + "<tr><th><table border=\"0\" bordercolor=\"white\" cellpadding=\"5\" cellspacing=\"5\">"
                + "<tr><th width=\"418\" align=\"left\" valign=\"top\"><big>"+cus.getLn1()+"</big><br/><big>"+cus.getLn2()+"</big><br/><big>"+cus.getLn3()+"</big><br/><big>"+cus.getLn4()+"</big></th>"
                
                + "<th width=\"418\" align=\"center\"><img src=\""+img+"\" width=\"103\" height=\"103\" alt=\"COAT\" /><br/>"
                + "<font face=\"Century GOTHIC\" size=\"+0\">"+slo+"</font></th>"
                
                + "<th width=\"418\" align=\"left\" valign=\"top\"><big>"+cus.getRn1()+"</big><br/><big>"+cus.getRn2()+"</big><br/><big>"+cus.getRn3()+"</big><br/><big>"+cus.getRn4()+"</big><br/></th>"
                + "</tr></table></th></tr>"
                
                + "<tr><th bgcolor=\""+thm+"\" hieght=\"173\"></th></tr>"
                
                + "<tr><th align=\"right\">"+cus.getDate()+"</th></tr>"
                
                + "<tr><th align=\"left\"><big>"+cus.getAd1()+"<br/>"+cus.getAd2()+"<br/>"+cus.getAd3()+"<br/>"+cus.getAd4()+""
                + "</big></th></tr>"
                
                + "<tr><th align=\"center\"><font color=\"navy\"><h3>"+cus.getRef()+"</h3></font></th></tr>"
                
                + "<tr><td align=\"left\"><div><font face=\"Century GOTHIC\" size=\"+1\">"
                + ""+cus.getPara().replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>")+"</font></div></td></tr>"
                
                + "<tr><th align=\"left\" bgcolor=\""+thm+"\"><font color=\"white\">"
                + "<h3>REPORT BREAK-DOWN</h3></font></th></tr><tr><td align=\"left\">";
                
                Iterator it=sup.iterator();
                
                while(it.hasNext()) {
                    
                    String me=it.next().toString();
                    
                    fonex.api.Supervision supo=map.get(me);
                    
                    String dec=supo.getDescription().replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>"); 
                    
                    String comen=supo.getComments().replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>");
                    
                    report=report+"<font color=\"navy\"><h4>"+supo.getName()+"</h4></font>"+dec+"<p/>"
                            + "<font color=\"darkblue\"><h4>COMMENTS</h4></font><p/>"+comen+"<p/>";
                    
                }
                
                report=report+"</td></tr>";
                
                
                Iterator it2=ch.iterator();
                
                
                report=report+"<tr><th align=\"left\" bgcolor=\""+thm+"\"><font color=\"white\">"
                        + "<h3>CHALLENGES</h3></font></th></tr><tr><td align=\"left\">";
                
                
                while(it2.hasNext()) {
                    
                    String mu=it2.next().toString();
                    
                    String iol=chh.getProperty(mu).replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>");
                    
                    report=report+"<font color=\"darkred\"><h4>"+mu+"</h4></font>"+iol+"<p/>";
                    
                }
                
                report=report+"</td></tr>";
                /*
                report=report+"<tr><th align=\"left\" bgcolor=\"navy\">";
                */
                String rmx="\""+compiler.getRemarks().replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>")+
                        "\"".replaceAll("\n\n", "<p/>").replaceAll("\n", "<br/>");
                /*
                report=report+"</th></tr>";
                */
                report=report+"<tr><th bgcolor=\""+thm+"\" hieght=\"173\"> </th></tr><p/><tr><th align=\"left\"><font color=\"darkslategrey\">"+rmx+"</font><p/>"
                        + "This Information is collected and compiled by:<p/>"
                        + "<h3>"+compiler.getLn1()+"<br/>"+compiler.getLn2()+"<br/>"+compiler.getLn3()+"<br/>"+compiler.getLn4()+"<br/>";
                
                
                report=report+"</th></tr>"
                        + "<tr><th align=\"center\"><i>Powered by Seumx Plus<br/>#Seumx Plus 2021.</th></tr>";
                
                report = report+ "</table>"
                
                + "</font></body></html>";
        
        /*
        Write report to temp File
        */
        
        try {
        
        FileWriter write=new FileWriter(new File("temp.html"));
        write.write(report); write.flush(); write.close();
        
        WebView web=new WebView(); web.getEngine().load(new File("temp.html").toURI().toURL().toString());
        web.setPrefSize(847,557); web.setStyle("-fx-accent:darkgreen");
        
        smx.jfx.control.Button save=new smx.jfx.control.Button("Save"); save.setPrefWidth(518);
        save.setDefaultStyle(def); save.setHoverStyle(hover);
        
        smx.jfx.control.Button print=new smx.jfx.control.Button("Print"); print.setPrefWidth(518);
        print.setDefaultStyle(def); print.setHoverStyle(hover);
        
        smx.jfx.layout.GridPane vbg=new smx.jfx.layout.GridPane(); vbg.setPadding(new Insets(4,4,4,4)); vbg.setVgap(8);
        vbg.setStyle("-fx-background-color:whitesmoke"); vbg.add(web,0,0); vbg.add(new HBox(save,print),0,1);
        
        if(parad!=null) {
        
            parad.close();
            
         parad
            =new smx.jfx.layout.Dialog(stg,true,false,877,557,new javafx.scene.Scene(vbg),
                    "Generated Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        }
        
        else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,877,557,new javafx.scene.Scene(vbg),
                    "Generated Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
            
        }
        
        /*
        Get Over Here!
        */
        save.setOnAction(ery->{
            
            /*
            Read & Write property File
            */
            try {
                
                String name="";
                
                ObjectInputStream in=new ObjectInputStream(new FileInputStream("data/reports.bat"));
                Properties pr=(Properties) in.readObject();
                
                //see if name exists
                Set seti=pr.keySet(); Iterator iti=seti.iterator(); boolean huy=false;
                
                while(iti.hasNext()) {
                    if(iti.next().equals(cus.getDate())) {
                        huy=true;
                    }
                }
                
                if(huy) {
                    
                    Label lio=new Label("Report With Name \n\""+cus.getDate()+"\" Exists! \n\n"
                            + "Do you want to Replace?\n[\\\\\\\\\\]");
                    lio.setStyle("-fx-font:bold 18px 'Century GOTHIC'; -fx-text-fill:darkgreen;");
                    
                    smx.jfx.control.Button rpc=new smx.jfx.control.Button("Replace!"); rpc.setPrefWidth(518);
                    rpc.setDefaultStyle(def); rpc.setHoverStyle(hover.replaceAll("green","royalblue"));
                    
                   smx.jfx.layout.Dialog exi
            =new smx.jfx.layout.Dialog(parad,true,false,417,219,new javafx.scene.Scene(new VBox(lio,rpc)),
                    "Report Exists!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        exi.show();
        
        rpc.setOnAction(er->{
            
            pr.put(cus.getDate(), report);
                    try {
                    ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/reports.bat"));
                    out.writeObject(pr); out.flush(); out.close();
                
                    exi.close(); parad.close();
                    } catch(IOException ex) {
                        System.out.println(ex.getMessage());
                    }
            
        });
                    
                } else {
                    
                    pr.put(cus.getDate(), report);
                    
                    ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/reports.bat"));
                    out.writeObject(pr); out.flush(); out.close();
                
                    parad.close();
                
                }
                
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        });
        
        print.setOnAction(ery->{
            
            PrinterJob job=PrinterJob.createPrinterJob();
            
            if(job!=null && job.showPrintDialog(stg)) 
            {
                
                web.getEngine().print(job);
                
                job.endJob(); parad.close();
                
            }
            
        });
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    });
    
    /*Saving animation of all!*/
    /*Save Transition*/
        javafx.animation.FadeTransition fddu=new javafx.animation.FadeTransition(javafx.util.Duration.millis(3578));
        fddu.setCycleCount(1); fddu.setAutoReverse(true); fddu.setFromValue(1); fddu.setToValue(1); 
        fddu.setNode(new javafx.scene.layout.HBox()); fddu.play();
        
        fddu.setOnFinished(ex->{
            
            //Init
            java.util.List<Object> listy=new java.util.ArrayList(); 
            listy.add(cus); listy.add(sup); listy.add(map); listy.add(ch); listy.add(chh); 
            listy.add(compiler);
            
            //Writing
            fonex.api.InfoSaver svu=new fonex.api.InfoSaver();
            svu.setName("THY"); svu.setObject(listy); svu.start();
            
            fddu.play();
            
        });
    
    }
    
}
