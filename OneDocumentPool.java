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

public class OneDocumentPool {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneDocumentPool(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Retrieves information for all or part of the Resources in the pool.
     * @param filter_flag Filter flag - &lt; = -3: Connected user’s resources - -2: All resources - -1: Connected user’s and his group’s resources - &gt; = 0: UID User’s Resources
     * @param range_start_ID When the next parameter is &gt;= -1 this is the Range start ID. Can be -1. For smaller values this is the offset used for pagination.
     * @param range_end_ID For values &gt;= -1 this is the Range end ID. Can be -1 to get until the last ID. For values &lt; -1 this is the page size used for pagination.
     * The range can be used to retrieve a subset of the pool, from the ‘start’ to the ‘end’ ID. To retrieve the complete pool, use (-1, -1); to retrieve all the pool from a specific ID to the last one, use (&lt;id&gt;, -1), and to retrieve the first elements up to an ID, use (0, &lt;id&gt;).
     * @param type  The document type.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int filter_flag, int range_start_ID, int range_end_ID, int type) throws XmlRpcException{
        Object[] params = {session, filter_flag, range_start_ID, range_end_ID, type};

        Object[] result = (Object[])this.client.execute("one.documentpool.info",params);

        return result;
    }

}
