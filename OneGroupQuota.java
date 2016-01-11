/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetest;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
/**
 *
 * @author pdiblasi
 */

public class OneGroupQuota {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneGroupQuota(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Returns the default group quota limits.
     * @return result[0] true or false whenever is successful or not
     * result[1] The quota template contents / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info() throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.groupquota.info",params);

        return result;
    }
    
    /**
     * Description: Updates the default group quota limits.
     * @param new_quota The new quota template contents. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The quota template contents / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(String new_quota) throws XmlRpcException{
        Object[] params = {session, new_quota};

        Object[] result = (Object[])this.client.execute("one.groupquota.update",params);

        return result;
    }    
    
}
