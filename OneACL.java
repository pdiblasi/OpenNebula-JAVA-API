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




public class OneACL {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneACL(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Adds a new ACL rule.
     * @param user User component of the new rule. A string containing a hex number.
     * @param resource Resource component of the new rule. A string containing a hex number.
     * @param rights Rights component of the new rule. A string containing a hex number.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated ACL rule ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addrule(String user, String resource, String rights) throws XmlRpcException{
        Object[] params = {session, user, resource, rights};

	Object[] result = (Object[])this.client.execute("one.acl.addrule",params);

	return result;
    }

    /**
     * Description: Deletes an ACL rule.
     * @param ACL_ID ACL rule ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The ACL rule ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delrule(int ACL_ID) throws XmlRpcException{
        Object[] params = {session, ACL_ID};

	Object[] result = (Object[])this.client.execute("one.acl.delrule",params);

	return result;
    }

    /**
     * Description: Returns the complete ACL rule set.
     * @param ACL_ID ACL rule ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ACL_ID) throws XmlRpcException{
        Object[] params = {session, ACL_ID};

	Object[] result = (Object[])this.client.execute("one.acl.info",params);

	return result;
    }
 
}
