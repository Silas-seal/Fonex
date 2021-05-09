/*
 * This edits and return the head contents of the report
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class Head extends java.util.Properties {
    
    private String ln1,ln2,ln3,ln4,rn1,rn2,rn3,rn4,date,ad1,ad2,ad3,ad4,ref,para;
    
    /**
     * Setting address 4 line on Left Half
     * @param ln1
     * @param ln2
     * @param ln3
     * @param ln4 
     */
    public void setLeftAd(String ln1,String ln2,String ln3,String ln4) 
    {
        this.ln1=ln1; this.ln2=ln2; this.ln3=ln3; this.ln4=ln4;
    }
    
    /**
     * Setting address 4 line on Right Half
     * @param rn1
     * @param rn2
     * @param rn3
     * @param rn4 
     */
    public void setRightAd(String rn1,String rn2,String rn3,String rn4) 
    {
        this.rn1=rn1; this.rn2=rn2; this.rn3=rn3; this.rn4=rn4;
    }
    
    /**
     * Setting up the custom Date from User
     * @param date 
     */
    public void setDate(String date) 
    {
        this.date=date;
    }
    
    /**
     * set Addressee Data
     * @param ad1
     * @param ad2
     * @param ad3
     * @param ad4 
     */
    public void setAddressee(String ad1,String ad2,String ad3,String ad4)
    {
        this.ad1=ad1; this.ad2=ad2; this.ad3=ad3; this.ad4=ad4; 
    }
    
    /**
     * Setting up the custom reference
     * @param ref 
     */
    public void setReference(String ref)
    {
        this.ref=ref;
    }
    
    /**
     * Setting up custom description paragraph
     * @param para 
     */
    public void setPara(String para) 
    {
        this.para=para;
    }
    
    /**
     * Clears all values here to null!
     */
    @Override
    public void clear()
    {
        ln1=null;ln2=null;ln3=null;ln4=null;rn1=null;rn2=null;rn3=null;rn4=null;
        date=null;ad1=null;ad2=null;ad3=null;ad4=null;ref=null;para=null;
    }
    
    /*
    Here let us deal with the value returning
    */
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
    
    
    public String getRn1() 
    {
        return rn1;
    }
    public String getRn2() 
    {
        return rn2;
    }
    public String getRn3() 
    {
        return rn3;
    }
    public String getRn4() 
    {
        return rn4;
    }
    
    
    public String getAd1() 
    {
        return ad1;
    }
    public String getAd2() 
    {
        return ad2;
    }
    public String getAd3() 
    {
        return ad3;
    }
    public String getAd4() 
    {
        return ad4;
    }
    
    
    public String getDate() 
    {
        return date;
    }
    
    public String getRef() 
    {
        return ref;
    }
    
    public String getPara() 
    {
        return para;
    }
    
}
