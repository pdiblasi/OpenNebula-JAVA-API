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

/**
* Templates Management
*/

public class OneTemplate {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneTemplate(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }

    /**
     * Description: Allocates a new template in OpenNebula.
     * @param template A string containing the template contents. Syntax can be the usual attribute=value or XML.
     * @return result[0] Boolean	true or false whenever is successful or not
     * result[1] Int/String	The allocated resource ID / The error string.
     * result[2] Int	Error code.
     * @throws XmlRpcException
     */
    
    public Object[] allocate(String template) throws XmlRpcException{
        Object[] params = {session, template};

        Object[] result = (Object[])this.client.execute("one.template.allocate",params);

                return result;
    }

    /**
     * Description: Clones an existing virtual machine template.
     * @param ID The ID of the template to be cloned.
     * @param new_template Name for the new template.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new template ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] clone(int ID, String new_template) throws XmlRpcException{
        Object[] params = {session, ID, new_template};

        Object[] result = (Object[])this.client.execute("one.template.clone",params);

                return result;
    }
    
    /**
     * Description: Deletes the given template from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new template ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.template.delete",params);

                return result;
    }    

    /**
     * Description: Instantiates a new virtual machine from a template.
     * @param ID The object ID.
     * @param name Name for the new VM instance. If it is an empty string, OpenNebula will assign one automatically.
     * @param hold False to create the VM on pending (default), True to create it on hold.
     * @param template A string containing an extra template to be merged with the one being instantiated. It can be empty. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new virtual machine ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] instantiate(int ID, String name, boolean hold, String template) throws XmlRpcException{
        Object[] params = {session, ID, name, hold, template};

        Object[] result = (Object[])this.client.execute("one.template.instantiate",params);

                return result;
    }    

    /**
     * Description: Replaces the template contents.
     * @param ID The object ID.
     * @param template The new template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int ID, String template, int type) throws XmlRpcException{
        Object[] params = {session, ID, template, type};

        Object[] result = (Object[])this.client.execute("one.template.update",params);

                return result;
    }        

    /**
     * Description: Changes the permission bits of a template.
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

        Object[] result = (Object[])this.client.execute("one.template.chmod",params);

                return result;
    }    
    
    /**
     * Description: Changes the ownership of a template.
     * @param ID The object ID.
     * @param User_ID The User ID of the new owner. If set to -1, the owner is not changed.
     * @param Group_ID The Group ID of the new group. If set to -1, the group is not changed.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] chown(int ID, int User_ID, int Group_ID) throws XmlRpcException{
        Object[] params = {session, ID, User_ID, Group_ID};

        Object[] result = (Object[])this.client.execute("one.template.chown",params);

                return result;
    }

    /**
     * Description: Renames a template.
     * @param ID The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String new_name) throws XmlRpcException{
        Object[] params = {session, new_name};

        Object[] result = (Object[])this.client.execute("one.template.rename",params);

                return result;
    }

    /**
     * Description: Retrieves information for the template.
     * @param ID The object ID.
     * @param process optional flag to process the template and include extended information, such as the SIZE for each DISK
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID, boolean process) throws XmlRpcException{
        Object[] params = {session, ID, process};

        Object[] result = (Object[])this.client.execute("one.template.info",params);

                return result;
    }
    
    
}
