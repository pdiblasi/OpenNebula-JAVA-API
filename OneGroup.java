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

public class OneGroup {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneGroup(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new group in OpenNebula.
     * @param name Name for the new group.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated Group ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String name) throws XmlRpcException{
        Object[] params = {session, name};

        Object[] result = (Object[])this.client.execute("one.group.allocate",params);

        return result;
    }

    /**
     * Description: Deletes the given group from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.group.delete",params);

        return result;
    }

    /**
     * Description: Retrieves information for the group.
     * @param ID The object ID. If it is -1, then the connected user’s group info info is returned
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.group.info",params);

        return result;
    }

    /**
     * Description: Replaces the group template contents.
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

        Object[] result = (Object[])this.client.execute("one.group.update",params);

        return result;
    }

    /**
     * Description: Adds a User to the Group administrators set
     * @param group_ID The group ID.
     * @param user_ID The user ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addadmin(int group_ID, int user_ID) throws XmlRpcException{
        Object[] params = {session, group_ID, user_ID};

        Object[] result = (Object[])this.client.execute("one.group.addadmin",params);

        return result;
    }

    /**
     * Description: Removes a User from the Group administrators set
     * @param group_ID The group ID.
     * @param user_ID The user ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] deladmin(int group_ID, int user_ID) throws XmlRpcException{
        Object[] params = {session, group_ID, user_ID};

        Object[] result = (Object[])this.client.execute("one.group.deladmin",params);

        return result;
    }

    /**
     * Description: Sets the group quota limits.
     * @param ID The object ID.
     * @param template The new quota template contents. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] quota(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.group.quota",params);

        return result;
    }

}
