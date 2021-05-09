/*
 * This class edits the supervision work of the report
 */

package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class Supervision extends java.util.Properties {
    
    private String name,dec,comments;
    
    /**
     * Setting up a custom supervision name
     * @param name 
     */
    public void setName(String name)
    {
        this.name=name;
    }
    
    /**
     * Setting up description for the super
     * @param dec 
     */
    public void setDescription(String dec) 
    {
        this.dec=dec;
    }
    
    /**
     * Setting up custom comments
     * @param comments 
     */
    public void setComments(String comments) 
    {
        this.comments=comments;
    }
    
    /**
     * returns the name of the super
     * @return 
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * returns the description detail of the super
     * @return 
     */
    public String getDescription() 
    {
        return dec;
    }
    
    /**
     * returns the custom comments of the super
     * @return 
     */
    public String getComments() 
    {
        return comments;
    }
    
}
