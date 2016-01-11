/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onetest;

import org.opennebula.client.Client;
import org.opennebula.client.vm.VirtualMachine;
import org.opennebula.client.OneResponse;
import org.opennebula.client.host.Host;
import org.opennebula.client.template.Template;
import org.opennebula.client.user.User;
import org.opennebula.client.vnet.VirtualNetwork;
import org.opennebula.client.host.HostPool;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.XmlRpcConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.util.*;
import java.util.Arrays;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.*;
import java.io.*;
import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.*;



/**
 *
 * @author pdiblasi
 * 
 */

public class Onetest {
        private XmlRpcClient client = new XmlRpcClient();
        private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        private String session ="oneadmin:depjouphCaj2";
 
        String schema;
        
    public Onetest(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    
    }

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {

        String secret="oneadmin:depjouphCaj2";
        String endpoint="http://localhost:2633/RPC2";
        
        Client oneClient;
        try
        {
            /**
             * USANDO LA LIBRERIA org.opennebula.client
             */
            
            /*
            
            //Authentication
            oneClient = new Client(secret,endpoint);
            
            OneResponse resp=oneClient.get_version();
            System.out.println(resp.getMessage());
            System.out.println(Host.info(oneClient, 0).getMessage());
            System.out.println(Template.info(oneClient, 2).getMessage());
            System.out.println(User.info(oneClient, 0).getMessage());
            
            String vmTemplate =
            "NAME     = vm_from_java    CPU = 0.1   MEMORY = 64\n"
            +   "DISK     = [IMAGE_ID = \"2\"]\n"
            +   "NIC      = [NETWORK_ID = \"0\"]\n"
            +   "GRAPHICS = [TYPE= \"vnc\" ]\n";
            
            System.out.print("Deploying..\n"+vmTemplate);
            
            OneResponse rc = VirtualMachine.allocate(oneClient, vmTemplate);
            
            if( rc.isError() ){
            System.out.println( "Error!!");
            throw new Exception( rc.getErrorMessage() );
            }
            else{
            System.out.println( "Created! VM ID:"+rc.getMessage());
            }
            
            */

            /**
             * USANDO LA LIBRERIA onetest
             */

            
            OneHost oh=new OneHost(endpoint);
            System.out.println(oh.info(0)[1]);
            
            OneVMPool ovm=new OneVMPool(endpoint);
            System.out.println(ovm.info(0,-1,-1,-2)[1]);
            
            String xml = oh.info(0)[1].toString(); //Populated XML String....
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
            Element rootElement = document.getDocumentElement();
            
            NodeList list = rootElement.getElementsByTagName("NAME");
            
            if (list != null && list.getLength() > 0) {
                NodeList subList = list.item(0).getChildNodes();
                

                if (subList != null && subList.getLength() > 0) {
              //      System.out.println(subList.item(0).getNodeValue());
                }
            }


    
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

}
