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
public class OneHost {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneHost(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }

    /**
     * Description: Allocates a new host in OpenNebula
     * @param hostname      String	Hostname of the machine we want to add
     * @param im_mad_name   String	The name of the information manager (im_mad_name), this values are taken from the oned.conf with the tag name IM_MAD (name)
     * @param vmm_mad_name  String	The name of the virtual machine manager mad name (vmm_mad_name), this values are taken from the oned.conf with the tag name VM_MAD (name)
     * @param vnm_mad_name  String	The name of the virtual network manager mad name (vnm_mad_name), see the Networking Subsystem documentation
     * @param cluster_ID    Int	The cluster ID. If it is -1, this host won’t be added to any cluster.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated Host ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String hostname, String im_mad_name, String vmm_mad_name, String vnm_mad_name, int cluster_ID) throws XmlRpcException{
        Object[] params = {session, hostname, im_mad_name, vmm_mad_name, vnm_mad_name, cluster_ID};

        Object[] result = (Object[])this.client.execute("one.host.allocate",params);

        return result;
    }
    
    /**
     * Description: Deletes the given host from the pool
     * @param host_id The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] delete(int host_id) throws XmlRpcException{
        Object[] params = {session, host_id};

        Object[] result = (Object[])this.client.execute("one.host.delete",params);

        return result;
    }    
    
    /**
     * Description: Enables or disables the given host
     * @param id The Host ID.
     * @param enable Set it to true/false to enable or disable the target Host.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] enable(int id, boolean enable) throws XmlRpcException{
        Object[] params = {session, id, enable};

        Object[] result = (Object[])this.client.execute("one.host.enable",params);

        return result;
    }

    /**
     * Description: Replaces the host’s template contents.
     * @param id The object ID.
     * @param template The new template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: Replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int id, String template, int type) throws XmlRpcException{
        Object[] params = {session, id, template, type};

        Object[] result = (Object[])this.client.execute("one.host.update",params);

        return result;
    }

    /**
     * Description: Renames a host.
     * @param id The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int id, String new_name) throws XmlRpcException{
        Object[] params = {session, id, new_name};

        Object[] result = (Object[])this.client.execute("one.host.rename",params);

        return result;
    }

    /**
     * Description: Retrieves information for the host.
     * @param id    Int	The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int id) throws XmlRpcException{
        Object[] params = {session, id};

        Object[] result = (Object[])this.client.execute("one.host.info",params);

        return result;
        
    }
    
    /**
     * Description: Returns the host monitoring records.
     * @param id    Int	The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The monitoring information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */    
    public Object[] monitoring(int id) throws XmlRpcException{
        Object[] params = {session, id};

        Object[] result = (Object[])this.client.execute("one.host.monitoring",params);

        return result;
    }   
}
