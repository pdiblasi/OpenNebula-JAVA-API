/*
* Copyright 2016 Paolo Di Blasi <ingpdiblasi at gmail.com>
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*    http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
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

public class OneDocument {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneDocument(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new document in OpenNebula.
     * @param template A string containing the document template contents. Syntax can be the usual attribute=value or XML.
     * @param type The document type.Type is an integer value used to allow dynamic pools compartmentalization.

Let’s say you want to store documents representing Chef recipes, and EC2 security groups; you would allocate documents of each kind with a different type. This type is then used in the one.documentpool.info method to filter the results.

     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, int type) throws XmlRpcException{
        Object[] params = {session, template, type};

        Object[] result = (Object[])this.client.execute("one.document.allocate",params);

        return result;
    }

    /**
     * Description: Clones an existing virtual machine document.
     * @param ID The ID of the document to be cloned.
     * @param name Name for the new document.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new document ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] clone(int ID, String name) throws XmlRpcException{
        Object[] params = {session, ID, name};

        Object[] result = (Object[])this.client.execute("one.document.clone",params);

        return result;
    }

    /**
     * Description: Deletes the given document from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.document.delete",params);

        return result;
    }
    
    /**
     * Description: Replaces the document template contents.
     * @param ID The object ID.
     * @param template The new document template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: Replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int ID, String template, int type) throws XmlRpcException{
        Object[] params = {session, ID, template, type};

        Object[] result = (Object[])this.client.execute("one.document.update",params);

        return result;
    }
    
    /**
     * Description: Changes the permission bits of a document.
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

        Object[] result = (Object[])this.client.execute("one.document.chmod",params);

        return result;
    }

    /**
     * Description: Changes the ownership of a document.
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

        Object[] result = (Object[])this.client.execute("one.document.chown",params);

        return result;
    }
    
    /**
     * Description: Renames a document.
     * @param ID The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String new_name) throws XmlRpcException{
        Object[] params = {session, ID, new_name};

        Object[] result = (Object[])this.client.execute("one.document.rename",params);

        return result;
    }
    
    /**
     * Description: Locks the document at the api level. The lock automatically expires after 2 minutes.
     * @param ID The object ID.
     * @param requesting_app String to identify the application requesting the lock.
     * @return result[0] true or false whenever is successful or not
     * result[1] True if the lock was granted, and false if the object is already locked. / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] lock(int ID, String requesting_app) throws XmlRpcException{
        Object[] params = {session, ID, requesting_app};

        Object[] result = (Object[])this.client.execute("one.document.lock",params);

        return result;
    }

    /**
     * Description: Unlocks the document at the api level.
     * @param ID The object ID.
     * @param requesting_app String to identify the application requesting the lock.
     * @return result[0] true or false whenever is successful or not
     * result[1] The object ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] unlock(int ID, String requesting_app) throws XmlRpcException{
        Object[] params = {session, ID, requesting_app};

        Object[] result = (Object[])this.client.execute("one.document.unlock",params);

        return result;
    }
    
    /**
     * Description: Retrieves information for the document.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.document.info",params);

        return result;
    }
    
}
