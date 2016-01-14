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
public class OneCluster {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneCluster(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }

    /**
     * Description: Allocates a new cluster in OpenNebula.
     * @param name Name for the new cluster.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated cluster ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String name) throws XmlRpcException{
        Object[] params = {session, name};

        Object[] result = (Object[])this.client.execute("one.cluster.allocate",params);

        return result;
    }

    /**
     * Description: Deletes the given cluster from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.cluster.delete",params);

        return result;
    }

    /**
     * Description: Replaces the cluster template contents.
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

        Object[] result = (Object[])this.client.execute("one.cluster.update",params);

        return result;
    }

    /**
     * Description: Adds a host to the given cluster.
     * @param ID The cluster ID.
     * @param host_ID The host ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addhost(int ID, int host_ID) throws XmlRpcException{
        Object[] params = {session, ID, host_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.addhost",params);

        return result;
    }

    /**
     * Description: Removes a host from the given cluster.
     * @param ID The cluster ID.
     * @param host_ID The host ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delhost(int ID, int host_ID) throws XmlRpcException{
        Object[] params = {session, ID, host_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.delhost",params);

        return result;
    }

    /**
     * Description: Adds a datastore to the given cluster.
     * @param ID The cluster ID.
     * @param datastore_ID The datastore ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] adddatastore(int ID, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.adddatastore",params);

        return result;
    }

    /**
     * Description: Removes a datastore from the given cluster.
     * @param ID The cluster ID.
     * @param datastore_ID The datastore ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] deldatastore(int ID, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.deldatastore",params);

        return result;
    }

    /**
     * Description: Adds a vnet to the given cluster.
     * @param ID The cluster ID.
     * @param vnet_ID The vnet ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addvnet(int ID, int vnet_ID) throws XmlRpcException{
        Object[] params = {session, ID, vnet_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.addvnet",params);

        return result;
    }

    /**
     * Description: Removes a vnet from the given cluster.
     * @param ID The cluster ID.
     * @param vnet_ID The vnet ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delvnet(int ID, int vnet_ID) throws XmlRpcException{
        Object[] params = {session, ID, vnet_ID};

        Object[] result = (Object[])this.client.execute("one.cluster.delvnet",params);

        return result;
    }

    /**
     * Description: Renames a cluster.
     * @param ID The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String new_name) throws XmlRpcException{
        Object[] params = {session, ID, new_name};

        Object[] result = (Object[])this.client.execute("one.cluster.rename",params);

        return result;
    }

    /**
     * Description: Retrieves information for the cluster.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.cluster.info",params);

        return result;
    }
}
