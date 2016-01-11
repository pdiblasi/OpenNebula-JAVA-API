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

public class OneSystem {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneSystem(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Returns the OpenNebula core version
     * @return result[0] true or false whenever is successful or not
     * result[1] The OpenNebula version, e.g. 4.4.0
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] version() throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.system.version",params);

                return result;
    }

    /**
     * Description: Returns the OpenNebula configuration
     * @return result[0] true or false whenever is successful or not
     * result[1] The loaded oned.conf file, in XML form
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] config() throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.system.config",params);

                return result;
    }    

}
