
package smx.jfx.util;

/**
 *
 * @author Seumx Plus
 */
public class Wait implements SRunnable {
    
    private Thread th; private SRunnable runnable=null; private String name; private double prog=0;
    
    public void setRunnable(SRunnable runnable) {
        this.runnable=runnable;
    }
    
    @Override
    public void setName(String name) {
        this.name=name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
       
        if(runnable!=null)
        {
            runnable.start();
        }
        else {
            System.out.println("No Thread!");
        }
        try {
        Thread.sleep(137);}
        catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void start() 
    {
        th=new Thread(this); th.start();
    }
    
     
    @Override
    public void setProgress(double prog) {
        this.prog=prog;
    }
    
    @Override
    public double getProgress() {
        return prog;
    }
    
}
