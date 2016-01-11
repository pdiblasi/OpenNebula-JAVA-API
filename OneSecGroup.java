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

public class OneSecGroup {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneSecGroup(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new security group in OpenNebula.
     * @param template A string containing the template of the security group. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template) throws XmlRpcException{
        Object[] params = {session,template};

        Object[] result = (Object[])this.client.execute("one.secgroup.allocate",params);

                return result;
    }

    /**
     * Description: Clones an existing security group.
     * @param ID The ID of the security group to be cloned.
     * @param new_name Name for the new security group.
     * @param target_datastore_ID The ID of the target datastore. Optional, can be set to -1 to use the current one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new security group ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] clone(int ID, String new_name, int target_datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, new_name, target_datastore_ID};

        Object[] result = (Object[])this.client.execute("one.secgroup.clone",params);

                return result;
    }

    /**
     * Description: Deletes the given security group from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.secgroup.delete",params);

                return result;
    }
    
    /**
     * Description: Replaces the security group template contents.
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

        Object[] result = (Object[])this.client.execute("one.secgroup.update",params);

                return result;
    }
    
    /**
     * Description: Changes the permission bits of a security group.
     * @param ID The object ID.
     * @param USER_USE USER USE bit. If set to -1, it will not change.
     * @param USER_MANAGE USER MANAGE bit. If set to -1, it will not change.
     * @param USER_ADMIN USER ADMIN bit. If set to -1, it will not change.
     * @param GROUP_USE GROUP USE bit. If set to -1, it will not change.
     * @param GROUP_MANAGE GROUP MANAGE bit. If set to -1, it will not change.
     * @param GROUP_ADMIN GROUP ADMIN bit. If set to -1, it will not change.
     * @param OTHER_USE OTHER USE bit. If set to -1, it will not change.
     * @param OTHER_MANAGE OTHER MANAGE bit. If set to -1, it will not change.
     * @param OTHER_ADMIN OTHER ADMIN bit. If set to -1, it will not change.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chmod(int ID, int USER_USE, int USER_MANAGE, int USER_ADMIN, int GROUP_USE, int GROUP_MANAGE, int GROUP_ADMIN, int OTHER_USE, int OTHER_MANAGE, int OTHER_ADMIN) throws XmlRpcException{
        Object[] params = {session, ID, USER_USE, USER_MANAGE, USER_ADMIN, GROUP_USE, GROUP_MANAGE, GROUP_ADMIN, OTHER_USE, OTHER_MANAGE, OTHER_ADMIN};

        Object[] result = (Object[])this.client.execute("one.secgroup.chmod",params);

                return result;
    }
    
    /**
     * Description: Changes the ownership of a security group.
     * @param ID The object ID.
     * @param user_ID The User ID of the new owner. If set to -1, the owner is not changed.
     * @param group_ID The Group ID of the new group. If set to -1, the group is not changed.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chown(int ID, int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, ID, user_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.secgroup.chown",params);

                return result;
    }
    
    /**
     * Description: Renames a security group.
     * @param ID The object ID.
     * @param name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String name) throws XmlRpcException{
        Object[] params = {session, ID, name};

        Object[] result = (Object[])this.client.execute("one.secgroup.rename",params);

                return result;
    }
    
    /**
     * Description: Retrieves information for the security group.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.secgroup.info",params);

                return result;
    }

}
