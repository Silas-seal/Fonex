/*
 * This class edist and returns the dec. of the Data collector and compiler
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class Compiler extends java.util.Properties {
    
    private String ln1,ln2,ln3,ln4,remarks;
    
    /**
     * 
     * @param ln1
     * @param ln2
     * @param ln3
     * @param ln4 
     */
    public void setCompiler(String ln1,String ln2,String ln3,String ln4) 
    {
        this.ln1=ln1; this.ln2=ln2; this.ln3=ln3; this.ln4=ln4;
    }
    
    /**
     * Setting up the final remarks on the report
     * @param remarks 
     */
    public void setRemarks(String remarks) 
    {
        this.remarks=remarks;
    }
    
    /**
     * Will Clear all values here to null!
     */
    @Override
    public void clear()
    {
        ln1=null; ln2=null; ln3=null; ln4=null; remarks=null;
    }
    
    public String getLn1() 
    {
        return ln1;
    }
    
    public String getLn2() 
    {
        return ln2;
    }
    
    public String getLn3() 
    {
        return ln3;
    }
    
    public String getLn4() 
    {
        return ln4;
    }
    
    public String getRemarks()
    {
        return remarks;
    }
}
