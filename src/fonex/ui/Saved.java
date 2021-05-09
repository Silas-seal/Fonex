/*
 * The SVD Class
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
import javafx.stage.*;

import java.util.*;
import java.io.*;
import javafx.print.*;


public class Saved extends GridPane {
    
    private smx.jfx.layout.Dialog parad,yui,poi; private String uio=null,qur;
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "ConvertToTryWithResources"})
    public Saved(javafx.stage.Stage stg) 
    {
        
        /*
        read report property object
        */
        
        String def="-fx-background-color:darkgreen; -fx-font:normal 18px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: darkgreen;"
            + "-fx-border-radius: 8px 8px 8px 8px;"
            
            ,hover="-fx-background-color:green; -fx-font:normal 18px 'Century GOTHIC'; -fx-text-fill:white;"
            + "-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: green;"
            + "-fx-border-radius: 8px 8px 8px 8px;";
        
        
        
        try {
            
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("data/reports.bat"));
                Properties pr=(Properties) in.readObject();
                
                List<String> lst=new ArrayList(); Set set=pr.keySet(); Iterator it=set.iterator();
                
                while(it.hasNext()) {
                    
                    lst.add(it.next().toString());
                    
                }
                
                TextField fld=new TextField(); fld.setPrefWidth(517); 
                fld.setPromptText("Search Or Sort Reports by typing here!");
                fld.setStyle("-fx-font:normal 18px 'Century GOTHIC'; -fx-background-color:white;"
                        + "-fx-border-color:green; -fx-border-width:4px;");
                
                ListView lv=new ListView(FXCollections.observableArrayList(lst));
                lv.setPrefSize(718,489);
                
                lv.setStyle("-fx-accent:white; -fx-font:normal 18px 'Century GOTHIC'; "
                        + "-fx-control-inner-background:darkgreen;"
                        + "-fx-focus-color:darkgreen;");
                
                MenuItem del=new MenuItem("Delete!"); MenuItem edit=new MenuItem("Edit!");
                
                ContextMenu cm=new ContextMenu(edit,del); 
                cm.setStyle("-fx-font:normal 18px 'Century GOTHIC'; -fx-accent:darkgreen");
                
                lv.setContextMenu(cm);
                
                this.setPadding(new Insets(8,8,8,8)); this.setVgap(8); this.setHgap(8); this.setAlignment(Pos.TOP_LEFT);
                this.setStyle("-fx-background-color: linear-gradient(to bottom right,white,lightgrey);"); 
                this.add(fld,0,0); this.add(lv,0,1); 
                
                /*
                Deal with Reviews
                */
                
                smx.jfx.control.Button pri=new smx.jfx.control.Button("Print"); pri.setPrefWidth(381);
                pri.setDefaultStyle(def); pri.setHoverStyle(hover);
                
                smx.jfx.control.Button shr=new smx.jfx.control.Button("Send Via Email"); shr.setPrefWidth(381);
                shr.setDefaultStyle(def); shr.setHoverStyle(hover);
                
                
        smx.jfx.control.Button file=new smx.jfx.control.Button("Save To File"); file.setPrefWidth(518);
        file.setDefaultStyle(def); file.setHoverStyle(hover);
        
                
                WebView web=new WebView(); 
                
                /*
                Actions
                */
                
                edit.setOnAction(er->{
                    
                    try {
                    
                    String yre=lv.getSelectionModel().getSelectedItem().toString();
                    
                    String cont=pr.get(yre).toString();
                    
                    HTMLEditor edi=new HTMLEditor();
                    edi.setStyle("-fx-font:normal 16px 'Century GOTHIC'; -fx-background-color:white;"
                            + "-fx-control-inner-background:white; -fx-accent:darkgreen; -fx-focus-faint-color: white;"
                            + "-fx-focus-color:white;");
                    edi.setPrefSize(913,558);
                    
                    edi.setHtmlText(cont);
                    
                    smx.jfx.control.Button saver=new smx.jfx.control.Button("Save!"); saver.setPrefWidth(518);
                    saver.setDefaultStyle(def); saver.setHoverStyle(hover);
                    
                    if(parad!=null) {parad.close();}
                    
                    parad
            =new smx.jfx.layout.Dialog(stg,true,false,919,567,new javafx.scene.Scene(new VBox(edi,saver)),
                    "Edit Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
                    parad.showDialog(parad); 
                    
                    saver.setOnAction(eir->{
                        
                        pr.put(yre,edi.getHtmlText().replaceAll("contenteditable=\"true\"", "")
                            .replaceAll("bgcolor:white=\"\"","bgcolor=\"white\"").replaceAll("dir=\"ltr\"", ""));
                        
                        //OK! Lets Write The Object To File <farm.bat>
                        try {
                            
                        ObjectOutputStream oui=new ObjectOutputStream(new FileOutputStream("data/reports.bat"));
                        oui.writeObject(pr); oui.flush(); oui.close();
                        
                        parad.close();
                        
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    });
                    
                    
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    
                });
                
                del.setOnAction(ec->{
                    
                    String uyh=lv.getSelectionModel().getSelectedItem().toString();
                    
                    pr.remove(uyh);
                    
                    try {
                    ObjectOutputStream obg=new ObjectOutputStream(new FileOutputStream("data/reports.bat"));
                    obg.writeObject(pr); obg.flush(); obg.close();
                    }catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    lv.getItems().remove(uyh);
                    
                });
                
                fld.setOnKeyReleased(er->{
                    
                    List<String> ui=new ArrayList();
                    //Iterate
                    for(String str:lst) {
                        
                        if(str.contains(fld.getText())) 
                        {
                            
                            ui.add(str);
                            
                        }
                        
                    }
                    
                    lv.setItems(FXCollections.observableArrayList(ui));
                    
                });
                
                lv.setOnMouseClicked(io->{
                    
                    if(io.getClickCount()>1) {
                        
                    
                    try {
                    
                    if(io.getClickCount()>1) 
                    {
                        qur=lv.getSelectionModel().getSelectedItem().toString(); uio=qur;
                        
                        FileWriter write=new FileWriter(new File("temp.html"));
                        write.write(pr.getProperty(qur)); write.flush(); write.close();
        
                        web.getEngine().load(new File("temp.html").toURI().toURL().toString());
                        web.setPrefSize(847,557); web.setStyle("-fx-accent:darkgreen");
                        
                        if(parad!=null) {
        
            parad.close();
            
         parad
            =new smx.jfx.layout.Dialog(stg,true,false,891,557,new javafx.scene.Scene(new VBox(web,new HBox(pri,shr,file))),
                    "View Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
        }
        
        else {
            
            parad
            =new smx.jfx.layout.Dialog(stg,true,false,891,557,new javafx.scene.Scene(new VBox(web,new VBox(web,new HBox(pri,shr,file)))),
                    "View Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        parad.show();
        
            
        }
                        
                    }
                   
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    }
                });
                
                
                pri.setOnAction(ery->{
            
            PrinterJob job=PrinterJob.createPrinterJob();
            
            if(job!=null && job.showPrintDialog(parad)) 
            {
                
                web.getEngine().print(job);
                
                job.endJob(); parad.close();
                
            }
            
        });
                
                file.setOnAction(iue->{
                    
                    FileChooser ch=new FileChooser(); ch.setTitle("Save Report To File!");
                    ch.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("HTML File", "*.html"));
                    ch.setInitialFileName(qur);
                    
                    File yu=ch.showSaveDialog(parad);
                    
                    if(yu!=null) {
                        
                        try {
                            
                            FileWriter write=new FileWriter(yu);
                            write.write(pr.getProperty(qur)); write.flush(); write.close();
                            
                            //Write The Image File To The Directory
                            String brf="";
                            File DD=new File("gif"); String[] list=DD.list();
                            
                            for(String a:list) {
                                
                                if(pr.getProperty(qur).contains(a)) {
                                    brf=a;
                                }
                                
                            }
                            
                            FileInputStream fin=new FileInputStream("gif/"+brf);
                            
                            BufferedInputStream inb=new BufferedInputStream(fin);
                            
                            File hy=new File(yu.getParent()+"/gif"); hy.mkdir();
                            
                            FileOutputStream outi=new FileOutputStream(yu.getParent()+"/gif/"+brf);
                            
        byte data[] =new byte[1024];
        int red;
        while((red=inb.read(data,0,1024)) !=-1) {
            outi.write(data,0,red);
        }
                            
                            parad.close();
                            
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                        
                    }
                    
                });
                
                shr.setOnAction(yur->{
                    
                    String sty="-fx-background-color: white; -fx-focus-faint-color:white; -fx-font:normal 18px 'Century GOTHIC';";
                    
                    TextField ft1=new TextField(); ft1.setStyle(sty); ft1.setPrefWidth(317); ft1.setPromptText("Full Name");
                    
                    TextField ft2=new TextField(); ft2.setStyle(sty); ft2.setPrefWidth(317); ft2.setPromptText("Subject");
                    
                    TextField ft3=new TextField(); ft3.setStyle(sty); ft3.setPrefWidth(317); ft3.setPromptText("Recipiet (email)");
                    
                    smx.jfx.control.Button send=new smx.jfx.control.Button("Send NOW!"); send.setPrefWidth(381);
                send.setDefaultStyle(def); send.setHoverStyle(hover);
                    
                    GridPane pn=new GridPane(); pn.setVgap(8); pn.setHgap(8); pn.setPadding(new Insets(5,5,5,5));
                    pn.setAlignment(Pos.TOP_LEFT); pn.setStyle("-fx-background-color: whitesmoke; ");
                    
                    pn.add(ft1,0,0); pn.add(ft2,0,1); pn.add(ft3,0,2); pn.add(send,0,3);
                    
                    try {
                    if(yui!=null) {
        
            yui.close();
            
         yui
            =new smx.jfx.layout.Dialog(parad,true,false,403,248,new javafx.scene.Scene(pn),
                    "Send Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        yui.show();
        
        }
        
        else {
            
            yui
            =new smx.jfx.layout.Dialog(parad,true,false,403,248,new javafx.scene.Scene(pn),
                    "Send Report!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        yui.show();
        
            
        } }catch(IOException ui) {}
                    
                    send.setOnAction(er->{
                        
                        send.setDisable(true);
                        
                        fonex.api.Send sd=new fonex.api.Send();
                        sd.setCreditials(ft3.getText(), ft1.getText()+" : "+ft2.getText(), uio);
                        sd.setName("Mailing");
                        
                        sd.start();
                        
                        javafx.animation.FadeTransition uiy=
                new javafx.animation.FadeTransition(javafx.util.Duration.millis(1738));
        uiy.setCycleCount(1); uiy.setFromValue(0); uiy.setToValue(1); uiy.setAutoReverse(false);
        uiy.setNode(new Label()); uiy.play();
        
        uiy.setOnFinished(bv->{
            
            send.setDisable(false);
        
                        if(sd.getProgress()==1) {
                            yui.close();
                        } else {
                            
                            javafx.scene.text.Text l=new javafx.scene.text.Text
        ("Error Sending Mail!\nPlease Check Your Internet Connection\nAnd Try Again!\n\nError: "+sd.getError());
            l.setStyle("-fx-font:bold 18px 'Century GOTHIC'; -fx-text-fill:darkred;");
            
              try {
                    if(poi!=null) {
        
            poi.close();
            
         poi
            =new smx.jfx.layout.Dialog(yui,true,false,418,173,new javafx.scene.Scene(new javafx.scene.layout.HBox(l)),
                    "Error!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        poi.show();
        
        }
        
        else {
            
            poi
            =new smx.jfx.layout.Dialog(yui,true,false,418,173,new javafx.scene.Scene(new javafx.scene.layout.HBox(l)),
                    "Error!",new javafx.scene.image.Image(new java.io.FileInputStream("gif/Fonex.png")));
        
        poi.show();
        
            
        } }catch(java.io.IOException ui) {}
                            
                        }
                        
                        });
                        
                    });
                    
                });
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
