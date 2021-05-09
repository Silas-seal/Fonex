/*
 * Dealing with io actions in application
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class IOAction {
    
    /**
     * This method once called will copy the original file to the destination. 
     * @param original
     * @param destination
     * @throws java.io.IOException 
     */
    public void copyFile(String original, String destination) throws java.io.IOException {
        
        java.io.BufferedInputStream bfn=
                new java.io.BufferedInputStream(new java.io.FileInputStream(original));
        
        java.io.FileOutputStream out=
                new java.io.FileOutputStream(destination);
        
        byte data[] =new byte[1024];
        
        int read;
        
        while((read=bfn.read(data,0,1024))!=-1) 
        {
            out.write(data,0,read);
        }
        
    }
    
    /**
     * This method writes the string to the file of destination!
     * @param str
     * @param destination
     * @throws java.io.IOException 
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public void writeString(String str, String destination) throws java.io.IOException
    {
        
        java.io.FileWriter writer=new java.io.FileWriter(destination); 
        writer.write(str); writer.flush(); writer.close();
        
    }
    
    /**
     * Read Uni-code String from file
     * @param file
     * @return
     * @throws java.io.IOException 
     */
    public String readString(String file) throws java.io.IOException 
    {
        
        java.io.DataInputStream in=
                new java.io.DataInputStream(new java.io.FileInputStream(file)); 
        
        int read; String str="";
        
        while(in.available()!=-1)
        {
            str=in.readUTF();
        }
        
        return str;
        
    }
    
    /**
     * To return file name
     * @param str
     * @return 
     */
    public String getFileName(String str)
    {
        char[] a=str.toCharArray();
        
        int u=Integer.valueOf(a[a.length-1])+1;
        
        String rtn="";
        
        for(int i=0; i<a.length-2; i++)
        {
            rtn=rtn+a[i];
        }
        
        rtn=rtn+u;
        
        return rtn;
    }
    
}
