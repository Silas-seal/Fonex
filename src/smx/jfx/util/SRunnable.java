
package smx.jfx.util;

/**
 *
 * @author Seumx Plus
 */
public interface SRunnable extends Runnable {
    
    public void start();
    
    public void setName(String name);
    
    public String getName();
    
    public void setProgress(double prog);
    
    public double getProgress();
    
}
