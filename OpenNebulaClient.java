/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetest;

import java.net.MalformedURLException;
import java.net.URL;

import org.jdom2.*;
import org.jdom2.output.*;
import org.jdom2.input.*;
import java.io.*;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 *
 * @author pdiblasi
 */
public class OpenNebulaClient {

    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session = "oneadmin:depjouphCaj2";

    public OpenNebulaClient(String server_url) {

        try {

            this.config.setServerURL(new URL(server_url));
            this.client.setConfig(this.config);

        } catch (MalformedURLException e) {

            System.err.println(e);

        }
    }

    /**
     *
     * @param id user_id 
     * @throws XmlRpcException
     */
    public void getUserInfo(int id) throws XmlRpcException {

        Object[] params = {session, id};

        try {

            Object[] result = (Object[]) this.client.execute("one.user.info", params);

            if (!result[0].equals(null)) {

                boolean success = (Boolean) result[0];
                String str_res = (String) result[1];
                System.out.println("success=" + success);
                System.out.println("result=" + str_res);
            } else {
                System.out.println("success=0");
            }
        } catch (XmlRpcException e) {

            System.err.println(e);
            //e.printStackTrace();
        }

    }
    
    
    public void host_enable(int id, boolean enable) throws XmlRpcException {

        Object[] params = {session, id, enable};

        try {

            Object[] result = (Object[]) this.client.execute("one.host.enable", params);

            if (!result[0].equals(null)) {

                boolean success = (Boolean) result[0];
                String str_res = result[1].toString();
                System.out.println("success=" + success);
                System.out.println("result=" + str_res);
            } else {
                System.out.println("success=0");
            }
        } catch (XmlRpcException e) {

            System.err.println(e);
            //e.printStackTrace();
        }

    }
    
    
    public void host_create(int name, int kvm, int kvm2, int net, int cluster) throws XmlRpcException{
        Object[] params = {session, name, kvm, kvm2, net, cluster};

        try {
            Object[] result = (Object[])this.client.execute("one.host.allocate",params);

                if(!result[0].equals(null)) {
                    boolean success = (Boolean)result[0];
                    String str_res = (String)result[1];
                    System.out.println("success="+success);
                    System.out.println("result="+str_res);
                }
                else{
                    System.out.println("success=0");
                }
        }
        catch (XmlRpcException e) {
            System.err.println(e);
            //e.printStackTrace();
        }
    }    
    

    public static void main(String[] args) {

        OpenNebulaClient on_client = new OpenNebulaClient("http://localhost:2633/RPC2");

        try {
            on_client.getUserInfo(0);
            //on_client.host_enable(0,true);
            //on_client.host_create(1,1,1,1,1);//     DA CORREGGERE GLI ARGOMENTI
            

        } catch (XmlRpcException xmlrpce) {

            System.err.println(xmlrpce);
        }
        
    }
    
    
}
