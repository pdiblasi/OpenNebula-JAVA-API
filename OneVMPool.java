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
public class OneVMPool {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneVMPool(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }

    /**
     * Description: Retrieves information for all or part of the VMs in the pool.
     * @param filter_flag Filter flag &lt; = -3: Connected user’s resources -2: All resources -1: Connected user’s and his group’s resources &gt; = 0: UID User’s Resources
     * @param range_start_ID When the next parameter is &gt;= -1 this is the Range start ID. Can be -1. For smaller values this is the offset used for pagination.
     * @param range_end_ID For values &gt;= -1 this is the Range end ID. Can be -1 to get until the last ID. For values &lt; -1 this is the page size used for pagination. The range can be used to retrieve a subset of the pool, from the ‘start’ to the ‘end’ ID. To retrieve the complete pool, use (-1, -1); to retrieve all the pool from a specific ID to the last one, use (&lt;id&gt;, -1), and to retrieve the first elements up to an ID, use (0, &lt;id&gt;).
     * @param state VM state to filter by.
     * 
The state filter can be one of the following:

Value	State
-2	Any state, including DONE
-1	Any state, except DONE
0	INIT
1	PENDING
2	HOLD
3	ACTIVE
4	STOPPED
5	SUSPENDED
6	DONE
8	POWEROFF
9	UNDEPLOYED
Warning
Value 7 is reserved for FAILED VMs for compatibility reasons.
     * 
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info(int filter_flag, int range_start_ID, int range_end_ID, int state) throws XmlRpcException{
        Object[] params = {session, filter_flag, range_start_ID, range_end_ID, state};

        Object[] result = (Object[])this.client.execute("one.vmpool.info",params);

                return result;
    }    

    /**
     * Description: Returns all the virtual machine monitoring records.
     * @param filter_flag Filter flag - &lt; = -3: Connected user’s resources - -2: All resources - -1: Connected user’s and his group’s resources - &gt; = 0: UID User’s Resources
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] monitoring(int filter_flag) throws XmlRpcException{
        Object[] params = {session, filter_flag};

        Object[] result = (Object[])this.client.execute("one.vmpool.monitoring",params);

                return result;
    }

    /**
     * Description: Returns the virtual machine history records.
     * @param filter_flag Filter flag - &lt; = -3: Connected user’s resources - -2: All resources - -1: Connected user’s and his group’s resources - &gt; = 0: UID User’s Resources
     * @param start_time Start time for the time interval. Can be -1, in which case the time interval won’t have a left boundary.
     * @param end_time End time for the time interval. Can be -1, in which case the time interval won’t have a right boundary.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] accounting(int filter_flag, int start_time, int end_time) throws XmlRpcException{
        Object[] params = {session, filter_flag, start_time, end_time};

        Object[] result = (Object[])this.client.execute("one.vmpool.accounting",params);

                return result;
    }
    
    /**
     * Description: Returns the virtual machine showback records
     * @param first_month First month for the time interval. January is 1. Can be -1, in which case the time interval won’t have a left boundary.
     * @param first_year First year for the time interval. Can be -1, in which case the time interval won’t have a left boundary.
     * @param last_month Last month for the time interval. January is 1. Can be -1, in which case the time interval won’t have a right boundary.
     * @param last_year Last year for the time interval. Can be -1, in which case the time interval won’t have a right boundary.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] showback(int first_month, int first_year, int last_month, int last_year) throws XmlRpcException{
        Object[] params = {session, first_month, first_year, last_month, last_year};

        Object[] result = (Object[])this.client.execute("one.vmpool.showback",params);

                return result;
    }

    /**
     * Description: Processes all the history records, and stores the monthly cost for each VM
     * @param first_month First month for the time interval. January is 1. Can be -1, in which case the time interval won’t have a left boundary.
     * @param first_year First year for the time interval. Can be -1, in which case the time interval won’t have a left boundary.
     * @param last_month Last month for the time interval. January is 1. Can be -1, in which case the time interval won’t have a right boundary.
     * @param last_year Last year for the time interval. Can be -1, in which case the time interval won’t have a right boundary.
     * @return result[0] true or false whenever is successful or not
     * result[1] Empty / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] calculateshowback(int first_month, int first_year, int last_month, int last_year) throws XmlRpcException{
        Object[] params = {session, first_month, first_year, last_month, last_year};

        Object[] result = (Object[])this.client.execute("one.vmpool.calculateshowback",params);

                return result;
    }
    
}
