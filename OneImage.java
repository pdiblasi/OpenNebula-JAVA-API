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

public class OneImage {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneImage(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new image in OpenNebula.
     * @param template A string containing the template of the image. Syntax can be the usual attribute=value or XML.
     * @param datastore_ID The datastore ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, template, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.image.allocate",params);

        return result;
    }

    /**
     * Description: Clones an existing image.
     * @param ID The ID of the image to be cloned.
     * @param new_name Name for the new image.
     * @param target_datastore_ID The ID of the target datastore. Optional, can be set to -1 to use the current one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new image ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] clone(int ID, String new_name, int target_datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, new_name, target_datastore_ID};

        Object[] result = (Object[])this.client.execute("one.image.clone",params);

        return result;
    }
    
    /**
     * Description: Deletes the given image from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.image.delete",params);

        return result;
    }

    /**
     * Description: Enables or disables an image.
     * @param ID The Image ID.
     * @param enable True for enabling, false for disabling.
     * @return result[0] true or false whenever is successful or not.
     * result[1] The Image ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] enable(int ID, boolean enable) throws XmlRpcException{
        Object[] params = {session, ID, enable};

        Object[] result = (Object[])this.client.execute("one.image.enable",params);

        return result;
    }   
    
    /**
     * Description: Sets the Image as persistent or not persistent.
     * @param ID The Image ID.
     * @param persistent True for persistent, false for non-persisent.
     * @return result[0] true or false whenever is successful or not.
     * result[1] The Image ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] persistent(int ID, boolean persistent) throws XmlRpcException{
        Object[] params = {session, ID, persistent};

        Object[] result = (Object[])this.client.execute("one.image.persistent",params);

        return result;
    }    
    
    /**
     * Description: Changes the type of an Image.
     * @param ID The Image ID.
     * @param new_type New type for the Image. See the existing types in the Image template reference.
     * @return result[0] true or false whenever is successful or not.
     * result[1] The Image ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chtype(int ID, String new_type) throws XmlRpcException{
        Object[] params = {session, ID, new_type};

        Object[] result = (Object[])this.client.execute("one.image.chtype",params);

        return result;
    }     
     
    /**
     * Description: Replaces the image template contents.
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

        Object[] result = (Object[])this.client.execute("one.image.update",params);

        return result;
    }     
     
    /**
     * Description: Changes the permission bits of an image.
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

        Object[] result = (Object[])this.client.execute("one.image.chmod",params);

        return result;
    }     
     
    /**
     * Description: Changes the ownership of an image.
     * @param ID The object ID.
     * @param user_ID The User ID of the new owner. If set to -1, the owner is not changed.
     * @param group_ID The Group ID of the new group. If set to -1, the group is not changed.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chown(int ID, int user_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.image.chown",params);

        return result;
    }     
     
    /**
     * Description: Renames an image.
     * @param ID The object ID.
     * @param name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String name) throws XmlRpcException{
        Object[] params = {session, ID, name};

        Object[] result = (Object[])this.client.execute("one.image.rename",params);

        return result;
    }

    /**
     * Description: Deletes a snapshot from the image
     * @param ID The object ID.
     * @param snapshot_ID ID of the snapshot to delete
     * @return result[0] true or false whenever is successful or not
     * result[1] ID of the deleted snapshot/The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotdelete(int ID, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.image.snapshotdelete",params);

        return result;
    }

    /**
     * Description: Reverts image state to a previous snapshot
     * @param ID The object ID.
     * @param snapshot_ID ID of the snapshot to revert to
     * @return result[0] true or false whenever is successful or not
     * result[1] ID of the snapshot/The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotrevert(int ID, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.image.snapshotrevert",params);

        return result;
    }

    /**
     * Description: Flatten the snapshot of image and discards others
     * @param ID The object ID.
     * @param snapshot_ID ID of the snapshot to flatten
     * @return result[0] true or false whenever is successful or not
     * result[1] ID of the snapshot/The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotflatten(int ID, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.image.snapshotflatten",params);

        return result;
    }

    /**
     * Description: Retrieves information for the image.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.image.info",params);

        return result;
    }     

}
