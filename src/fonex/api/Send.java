/*
 Send Mail
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class Send implements smx.jfx.util.SRunnable {
    
    private String name; private double prog; private javafx.stage.Stage stg,poi;
    
    private String to,sub,con,error; private Thread th;
    
    @Override
    public void setName(String name) {
        this.name=name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setProgress(double prog) {
        this.prog=prog;
    }
    
    @Override
    public double getProgress() {
        return prog;
    }
    
    public void setCreditials(String to, String sub, String con)
    {
        this.to=to; this.sub=sub; this.con=con;
    }
    
    public void setStage(javafx.stage.Stage stg) {
         this.stg=stg;
    }
    
    @Override
    public void run() {
        
        try {
        prog=0.7;
        //prepare
        fonex.Sender sd=new fonex.Sender("smtp.gmail.com");
        sd.setFro("info.seumxplus@gmail.com"); sd.setTo(to);
        sd.setUser("info.seumxplus@gmail.com"); sd.setPass("absolute13");
        sd.setSubject(sub); sd.setContent(con); sd.arrange();
        
        //send
        sd.send();
        
        prog=1;
        
        } catch (Exception io) {
            
            System.out.println(io.getMessage()); this.error=io.getMessage();
            
        }
        
    }
    
    @Override
    public void start() {
        th=new Thread(this); th.start(); 
    }
    
    public String getError() {
        
        return error;
        
    }
    /*
    public void taggle() {
        System.out.println("Progress Ind!");
        for(double i=0; i<83; i++) {
            try {
            this.prog=i/100; Thread.sleep(138);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
    }*/
    
}
