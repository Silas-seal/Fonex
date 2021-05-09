
package smx.jfx.util;

/**
 *
 * @author Seumx Plus
 */
public class SThreads implements SRunnable {
    
    private java.util.List<SRunnable> list=null;
    private String name=null;
    private Thread th=null;
    private double prog=0;
    
    /**
     * method sets the name of the thread to the argument string
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name=name;
    }
    
    /**
     * method returns the name of the thread
     * @return 
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Create runnable list and set To run multiple threads at ago!
     * @param list 
     */
    public void setThreads(java.util.List<SRunnable> list) {
        
        this.list=list;
        
    }
    
    /**
     * Run the thread
     */
    @Override
    public void run() {
        
        if(list!=null) {
        
        list.forEach((run) -> {
            run.start();
            System.out.println("Running Thread: "+run.getName());
        });
        
        }
        
        list=null;
        
    }
    
    /**
     * Start execution
     */
    @Override
    public void start() {
        th=new Thread(this); th.start();
    }
    
    /**
     * method sets progress of thread task
     * @param prog 
     */
    @Override
    public void setProgress(double prog) {
        this.prog=prog;
    }
    
    /**
     * returns the progress double
     * @return 
     */
    @Override
    public double getProgress() {
        return prog;
    }
    
}
