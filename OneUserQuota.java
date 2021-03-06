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

public class OneUserQuota {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneUserQuota(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }    

    /**
     * Description: Returns the default user quota limits.
     * @return result[0] true or false whenever is successful or not
     * result[1] The quota template contents / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] info() throws XmlRpcException{
        Object[] params = {session};

        Object[] result = (Object[])this.client.execute("one.userquota.info",params);

                return result;
    }

    /**
     * Description: Updates the default user quota limits.
     * @param template The new quota template contents. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The quota template contents / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(String template) throws XmlRpcException{
        Object[] params = {session, template};

        Object[] result = (Object[])this.client.execute("one.userquota.update",params);

                return result;
    }
    
    
}
