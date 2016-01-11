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

public class OneVN {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneVN(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Allocates a new virtual network in OpenNebula.
     * @param template A string containing the template of the virtual network. Syntax can be the usual attribute=value or XML.
     * @param cluster_ID The cluster ID. If it is -1, this virtual network won’t be added to any cluster.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, template, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.vn.allocate",params);

                return result;
    }

    /**
     * Description: Deletes the given virtual network from the pool.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.vn.delete",params);

                return result;
    }

    /**
     * Description: Adds address ranges to a virtual network.
     * @param ID The object ID.
     * @param template 	template of the address ranges to add. Syntax can be the usual attribute=value or XML, see below.
     * 
     * Examples of valid templates:
     * AR = [TYPE = IP4, IP = 192.168.0.5, SIZE = 10 ]
     * or

&lt;TEMPLATE&gt;
  &lt;AR&gt;
    &lt;TYPE&gt;IP4&lt;/TYPE&gt;
    &lt;IP&gt;192.168.0.5&lt;/IP&gt;
    &lt;SIZE&gt;10&lt;/SIZE&gt;
  &lt;/AR&gt;
&lt;/TEMPLATE&gt;

     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] add_ar(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.vn.add_ar",params);

                return result;
    }

    /**
     * Description: Removes an address range from a virtual network.
     * @param ID The object ID.
     * @param ar_ID ID of the address range to remove.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rm_ar(int ID, int ar_ID) throws XmlRpcException{
        Object[] params = {session, ID, ar_ID};

        Object[] result = (Object[])this.client.execute("one.vn.rm_ar",params);

                return result;
    }

    /**
     * Description: Updates the attributes of an address range.
     * @param ID The object ID.
     * @param template template of the address ranges to update. Syntax can be the usual attribute=value or XML, see below.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update_ar(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.vn.update_ar",params);

                return result;
    }

    /**
     * Description: Reserve network addresses.
     * @param ID The virtual network to reserve from.
     * @param template Template, see below.
     * 
     * The third parameter must be an OpenNebula ATTRIBUTE=VALUE template, with these values:

SIZE	Size of the reservation;	
NAME	If set, the reservation will be created in a new Virtual Network with this name;	
AR_ID	ID of the AR from where to take the addresses;	
NETWORK_ID	Instead of creating a new Virtual Network, the reservation will be added to the existing virtual network with this ID;	
MAC	First MAC address to start the reservation range [MAC, MAC+SIZE];	
IP	First IPv4 address to start the reservation range [IP, IP+SIZE];	
     * 
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] reserve(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.vn.reserve",params);

                return result;
    }

    /**
     * Description: Frees a reserved address range from a virtual network.
     * @param ID The object ID.
     * @param ar_ID ID of the address range to free.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] free_ar(int ID, int ar_ID) throws XmlRpcException{
        Object[] params = {session, ID, ar_ID};

        Object[] result = (Object[])this.client.execute("one.vn.free_ar",params);

                return result;
    }

    /**
     * Description: Holds a virtual network Lease as used.
     * @param ID The object ID.
     * @param template template of the lease to hold, e.g. LEASES=[IP=192.168.0.5].
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] hold(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.vn.hold",params);

                return result;
    }

    /**
     * Description: Releases a virtual network Lease on hold.
     * @param ID The object ID.
     * @param template template of the lease to release, e.g. LEASES=[IP=192.168.0.5].
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] release(int ID, String template) throws XmlRpcException{
        Object[] params = {session, ID, template};

        Object[] result = (Object[])this.client.execute("one.vn.release",params);

                return result;
    }

    /**
     * Description: Replaces the virtual network template contents.
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

        Object[] result = (Object[])this.client.execute("one.vn.update",params);

                return result;
    }

    /**
     * Description: Changes the permission bits of a virtual network.
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

        Object[] result = (Object[])this.client.execute("one.vn.chmod",params);

                return result;
    }

    /**
     * Description: Changes the ownership of a virtual network.
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

        Object[] result = (Object[])this.client.execute("one.vn.chown",params);

                return result;
    }

    /**
     * Description: Renames a virtual network.
     * @param ID The object ID.
     * @param name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String name) throws XmlRpcException{
        Object[] params = {session, ID, name};

        Object[] result = (Object[])this.client.execute("one.vn.rename",params);

                return result;
    }

    /**
     * Description: Retrieves information for the virtual network.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.vn.info",params);

                return result;
    } 
    
}
