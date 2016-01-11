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

public class OneUser {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneUser(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new user in OpenNebula
     * @param username username for the new user
     * @param password password for the new user
     * @param auth_driver authentication driver for the new user. If it is an empty string, then the default (‘core’) is used
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated User ID / The error string.
     * result[2] Error code.

     * @throws XmlRpcException
     */
    public Object[] allocate(String username, String password, String auth_driver) throws XmlRpcException{
        Object[] params = {session, username, password, auth_driver};

        Object[] result = (Object[])this.client.execute("one.user.allocate",params);

                return result;
    }

    /**
     * Description: Deletes the given user from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.user.delete",params);

                return result;
    }

    /**
     * Description: Changes the password for the given user.
     * @param ID The object ID.
     * @param password The new password
     * @return result[0] true or false whenever is successful or not
     * result[1] The User ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] passwd(int ID, String password) throws XmlRpcException{
        Object[] params = {session, ID, password};

        Object[] result = (Object[])this.client.execute("one.user.passwd",params);

                return result;
    }
    
    /**
     * Description: Generates or sets a login token.
     * @param username The user name to generate the token for
     * @param token The token, if empty oned will generate one
     * @param valid_period Valid period in seconds; 0 reset the token and -1 for a non-expiring token.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new token / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] login(String username, String token, int valid_period) throws XmlRpcException{
        Object[] params = {session, username, token, valid_period};

        Object[] result = (Object[])this.client.execute("one.user.login",params);

                return result;
    }
        
    /**
     * Description: Replaces the user template contents.
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

        Object[] result = (Object[])this.client.execute("one.user.update",params);

                return result;
    }
    
    /**
     * Description: Changes the authentication driver and the password for the given user.
     * @param ID The object ID.
     * @param new_auth_driver The new authentication driver.
     * @param new_password The new password. If it is an empty string, the password is not changed.
     * @return result[0] true or false whenever is successful or not
     * result[1] The User ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chauth(int ID, String new_auth_driver, String new_password) throws XmlRpcException{
        Object[] params = {session, ID, new_auth_driver, new_password};

        Object[] result = (Object[])this.client.execute("one.user.chauth",params);

                return result;
    }
    
    /**
     * Description: Sets the user quota limits.
     * @param ID The object ID.
     * @param template The new quota template contents. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] quota(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.user.quota",params);

                return result;
    }

    /**
     * Description: Changes the group of the given user.
     * @param user_ID The User ID.
     * @param group_ID The Group ID of the new group.
     * @return result[0] true or false whenever is successful or not
     * result[1] The User ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chgroup(int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, user_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.user.chgroup",params);

                return result;
    }

    /**
     * Description: Adds the User to a secondary group.
     * @param user_ID The User ID.
     * @param group_ID The Group ID of the new group.
     * @return result[0] true or false whenever is successful or not
     * result[1] The User ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addgroup(int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, user_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.user.addgroup",params);

                return result;
    }

    /**
     * Description: Removes the User from a secondary group
     * @param user_ID The User ID.
     * @param group_ID The Group ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The User ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delgroup(int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.user.delgroup",params);

                return result;
    }

    /**
     * Description: Retrieves information for the user.
     * @param ID The object ID. If it is -1, then the connected user’s own info info is returned
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.user.info",params);

                return result;
    }
    
    
    
    
    
}
