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

public class OneDatastore {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneDatastore(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new datastore in OpenNebula.
     * @param template A string containing the template of the datastore. Syntax can be the usual attribute=value or XML.
     * @param cluster_ID The cluster ID. If it is -1, this datastore won’t be added to any cluster.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, template, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.datastore.allocate",params);

        return result;
    }

    /**
     * Description: Deletes the given datastore from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.datastore.delete",params);

        return result;
    }
    
    /**
     * Description: Replaces the datastore template contents.
     * @param ID The object ID.
     * @param template The new template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: Replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int ID, String template, int type) throws XmlRpcException{
        Object[] params = {session, ID, template, type};

        Object[] result = (Object[])this.client.execute("one.datastore.update",params);

        return result;
    }
    
    /**
     * Description: Changes the permission bits of a datastore.
     * @param ID The object ID.
     * @param USER_USE USER USE bit. If set to -1, it will not change.
     * @param USER_MANAGE USER MANAGE bit. If set to -1, it will not change.
     * @param USER_ADMIN USER ADMIN bit. If set to -1, it will not change.
     * @param GROUP_USE GROUP USE bit. If set to -1, it will not change.
     * @param GROUP_MANAGE GROUP MANAGE bit. If set to -1, it will not change.
     * @param GROUP_ADMIN GROUP ADMIN bit. If set to -1, it will not change.
     * @param OTHER_USE OTHER USE bit. If set to -1, it will not change.
     * @param OTHER_MANAGE OTHER MANAGE bit. If set to -1, it will not change.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chmod(int ID, int USER_USE, int USER_MANAGE, int USER_ADMIN, int GROUP_USE, int GROUP_MANAGE, int GROUP_ADMIN, int OTHER_USE, int OTHER_MANAGE, int OTHER_ADMIN) throws XmlRpcException{
        Object[] params = {session, ID, USER_USE, USER_MANAGE, USER_ADMIN, GROUP_USE, GROUP_MANAGE, GROUP_ADMIN, OTHER_USE, OTHER_MANAGE, OTHER_ADMIN};

        Object[] result = (Object[])this.client.execute("one.datastore.chmod",params);

        return result;
    }
    
    /**
     * Description: Changes the ownership of a datastore.
     * @param ID The object ID.
     * @param user_ID The User ID of the new owner. If set to -1, the owner is not changed.
     * @param group_ID The Group ID of the new group. If set to -1, the group is not changed.
     * @return     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.     * @throws XmlRpcException
     */
    public Object[] chown(int ID, int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, ID, user_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.datastore.chown",params);

        return result;
    }
    
    /**
     * Description: Renames a datastore.
     * @param ID The object ID.
     * @param name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String name) throws XmlRpcException{
        Object[] params = {session, ID, name};

        Object[] result = (Object[])this.client.execute("one.datastore.rename",params);

        return result;
    }
    
    /**
     * Description: Enables or disables a datastore.
     * @param ID The object ID.
     * @param enable True for enabling, false for disabling.
     * @return result[0] true or false whenever is successful or not.
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] enable(int ID, boolean enable) throws XmlRpcException{
        Object[] params = {session, ID, enable};

        Object[] result = (Object[])this.client.execute("one.datastore.enable",params);

        return result;
    }
    
    /**
     * Description: Retrieves information for the datastore.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.datastore.info",params);

        return result;
    }
    
}
