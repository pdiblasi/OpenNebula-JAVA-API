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

public class OneVDC {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneVDC(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new VDC in OpenNebula.
     * @param template A string containing the template of the VDC. Syntax can be the usual attribute=value or XML.
     * @param cluster_ID The cluster ID. If it is -1, this virtual network won’t be added to any cluster.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, template, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.allocate",params);

                return result;
    }

    /**
     * Description: Deletes the given VDC from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.vdc.delete",params);

                return result;
    }

    /**
     * Description: Replaces the VDC template contents.
     * @param ID The object ID.
     * @param template The new template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: Replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int ID, String template, int type) throws XmlRpcException{
        Object[] params = {session,ID, template, type};

        Object[] result = (Object[])this.client.execute("one.vdc.update",params);

                return result;
    }

    /**
     * Description: Renames a VDC.
     * @param ID The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String new_name) throws XmlRpcException{
        Object[] params = {session, ID, new_name};

        Object[] result = (Object[])this.client.execute("one.vdc.rename",params);

                return result;
    }

    /**
     * Description: Retrieves information for the VDC.
     * @param ID The object ID. If it is -1, then the connected user’s VDC info info is returned
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.vdc.info",params);

                return result;
    }

    /**
     * Description: Adds a group to the VDC
     * @param VDC_ID The VDC ID.
     * @param group_ID The group ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addgroup(int VDC_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.addgroup",params);

                return result;
    }

    /**
     * Description: Deletes a group from the VDC
     * @param VDC_ID The VDC ID.
     * @param group_ID The group ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delgroup(int VDC_ID, int group_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, group_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.delgroup",params);

                return result;
    }

    /**
     * Description: Adds a cluster to the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param cluster_ID The Cluster ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addcluster(int VDC_ID, int zone_ID, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.addcluster",params);

                return result;
    }

    /**
     * Description: Deletes a cluster from the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param cluster_ID The Cluster ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delcluster(int VDC_ID, int zone_ID, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.delcluster",params);

                return result;
    }

    /**
     * Description: Adds a host to the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param host_ID The Host ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addhost(int VDC_ID, int zone_ID, int host_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, host_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.addhost",params);

                return result;
    }

    /**
     * Description: Deletes a host from the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param host_ID The Host ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delhost(int VDC_ID, int zone_ID, int host_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, host_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.delhost",params);

                return result;
    }

    /**
     * Description: Adds a datastore to the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param datastore_ID The Datastore ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] adddatastore(int VDC_ID, int zone_ID, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.adddatastore",params);

                return result;
    }

    /**
     * Description: Deletes a datastore from the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param datastore_ID The Datastore ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.

     * @throws XmlRpcException
     */
    public Object[] deldatastore(int VDC_ID, int zone_ID, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.deldatastore",params);

                return result;
    }

    /**
     * Description: Adds a vnet to the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param vnet_ID The Vnet ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] addvnet(int VDC_ID, int zone_ID, int vnet_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, vnet_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.addvnet",params);

                return result;
    }

    /**
     * Description: Deletes a vnet from the VDC
     * @param VDC_ID The VDC ID.
     * @param zone_ID The Zone ID.
     * @param vnet_ID The Vnet ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delvnet(int VDC_ID, int zone_ID, int vnet_ID) throws XmlRpcException{
        Object[] params = {session, VDC_ID, zone_ID, vnet_ID};

        Object[] result = (Object[])this.client.execute("one.vdc.delvnet",params);

                return result;
    }

    
}
