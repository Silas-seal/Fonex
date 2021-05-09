
package smx.jfx.application;

/**
 *
 * @author Seumx Plus
 * JavaFX Application extension to a more efficient and threadable class
 */

public class Application extends javafx.application.Application {
    
    private static smx.jfx.util.SRunnable run=null;
    
    /**
     * This method will add the Runnable thread to the application instance. After setting, the thread will 
     * be started automatically and Runnable set back to null again.
     * @param run 
     */
    public static void setRunnable(smx.jfx.util.SRunnable run) {
        Application.run=run;
    }
    
    /**
     * This method returns the runnable value. Returns null if Runnable does not exist.
     * @return 
     */
    public static smx.jfx.util.SRunnable getRunnable() {
        return run;
    }
    
    /**
     * This is where the Javafx scene graph application is implemented.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(javafx.stage.Stage stage) throws Exception {
        
    }
    
    /**
     * This method allows the application to start with multithreading enabled. Will wait until you set the Runnable, then
     *  run the Thread.
     */
    public static void launchThread() { 
        
        Application ds=new Application();
        
        javafx.animation.FadeTransition fd=new javafx.animation.FadeTransition(javafx.util.Duration.millis(1178)); 
        fd.setCycleCount(1); fd.setFromValue(0); fd.setToValue(1); fd.setAutoReverse(false); 
        fd.setNode(new javafx.scene.layout.GridPane()); fd.play();
        
        fd.setOnFinished(ui->{
            smx.jfx.util.SRunnable th=Application.getRunnable();
            if(th!=null) {
                System.out.println("Running Thread: "+th.getName());
                smx.jfx.util.Wait wt=new smx.jfx.util.Wait(); wt.setRunnable(th); wt.start(); ds.setRunnable(null);
            } else {
                //System.out.println("No Thread!");
            }
            fd.play();
        });
        
    }
    
    /**
     * This method will track progress of the trackable task and present it on the ProgressBar
     * @param run
     * @param bar 
     */
    public void trackProgress(smx.jfx.util.SRunnable run, javafx.scene.control.ProgressBar bar) {
        
        //create transimission
        javafx.animation.FadeTransition fd=new javafx.animation.FadeTransition(javafx.util.Duration.millis(818));
        fd.setCycleCount(1); fd.setAutoReverse(false); fd.setFromValue(0); fd.setToValue(1); fd.setNode(new javafx.scene.layout.GridPane());
        fd.play();
        
        fd.setOnFinished(ev->{
            
            double prog=run.getProgress();
            
            bar.setProgress(prog);
            
            if(prog<1) {
                fd.play();
            }
            
        });
        
    }
    
    /**
     * This method will track progress of the trackable task and present it on the ProgressIndicator
     * @param run
     * @param bar 
     */
    public void trackProgress(smx.jfx.util.SRunnable run, javafx.scene.control.ProgressIndicator bar) {
        
        //create transimission
        javafx.animation.FadeTransition fd=new javafx.animation.FadeTransition(javafx.util.Duration.millis(818));
        fd.setCycleCount(1); fd.setAutoReverse(false); fd.setFromValue(0); fd.setToValue(1); fd.setNode(new javafx.scene.layout.GridPane());
        fd.play();
        
        fd.setOnFinished(ev->{
            
            double prog=run.getProgress();
            
            bar.setProgress(prog);
            
            if(prog<1) {
                fd.play();
            }
            
        });
        
    }
    
}
