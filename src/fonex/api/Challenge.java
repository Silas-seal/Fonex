/*
 * This constructs and return the string dec. of the challenge
 */
package fonex.api;

/**
 *
 * @author Seumx Plus
 */
public class Challenge extends java.util.Properties {
    
    /**
     * Add a single challenge to the challenge instance
     * @param key
     * @param value 
     */
    public void addChallenge(String key, String value)
    {
        this.put(key,value);
    }
    
    /**
     * Removes a single challenge from instance
     * @param key 
     */
    public void removeChallenge(String key)
    {
        this.remove(key);
    }
    
}
