/*
 Send Mail
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class InfoSaver implements smx.jfx.util.SRunnable {
    
    private String name,error; private double prog;
    
    Object obj;
    
    Thread th;
    
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
    
    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void run() {
        
        try {
            
            java.io.ObjectOutputStream obju=new java.io.
                    ObjectOutputStream(new java.io.FileOutputStream("data/input.bat"));this.prog=0.7;
            
            obju.writeObject(this.obj); obju.flush(); obju.close();this.prog=1;
            
        
        } catch (java.io.IOException io) {
            
            this.error=io.getMessage(); System.out.println(this.error);
            
        }
        
    }
    
    @Override
    public void start() {
        th=new Thread(this); th.start(); 
    }
    
    public String getError() {
        
        return error;
        
    }
    
    /**
     * This argument object will be written after!
     * @param object 
     */
    public void setObject(Object object)
    {
        this.obj=object;
    }
    
    /**
     * Return the writable object argument!
     * @return 
     */
    public Object getObjcet() 
    {
        return obj;
    }
    
}
