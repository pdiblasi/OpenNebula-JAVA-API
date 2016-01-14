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
public class OneVM {
    private XmlRpcClient client = new XmlRpcClient();
    private XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    private String session ="oneadmin:depjouphCaj2";
    String schema;

    public OneVM(String server_url){
       try{
           this.config.setServerURL(new URL(server_url));
           this.client.setConfig(this.config);
       }
       catch(MalformedURLException e){
            System.err.println(e);
       }
    }

    /**
     * Description: Allocates a new virtual machine in OpenNebula.
     * @param template A string containing the template for the vm. Syntax can be the usual attribute=value or XML.
     * @param hold False to create the VM on pending (default), True to create it on hold.
     * @return result[0] true or false whenever is successful or not
     * result[1] The allocated resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] allocate(String template, boolean hold) throws XmlRpcException{
        Object[] params = {session, template, hold};

        Object[] result = (Object[])this.client.execute("one.vm.allocate",params);

                return result;
    }
    
    /**
     * Description: initiates the instance of the given vmid on the target host.
     * @param ID The object ID.
     * @param Host_ID The Host ID of the target host where the VM will be deployed.
     * @param force true to enforce the Host capacity is not overcommitted.
     * @param datastore_ID The Datastore ID of the target system datastore where the VM will be deployed. It is optional, and can be set to -1 to let OpenNebula choose the datastore.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] deploy(int ID, int Host_ID, boolean force, int datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, Host_ID, force, datastore_ID};

        Object[] result = (Object[])this.client.execute("one.vm.deploy",params);

                return result;
    }
    
    /**
     * Description: submits an action to be performed on a virtual machine.
     * @param action the action name to be performed.
     * The action String must be one of the following:
        shutdown
        shutdown-hard
        hold
        release
        stop
        suspend
        resume
        delete
        delete-recreate
        reboot
        reboot-hard
        resched
        unresched
        poweroff
        poweroff-hard
        undeploy
        undeploy-hard
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] action(String action, int ID) throws XmlRpcException{
        Object[] params = {session, action, ID};

        Object[] result = (Object[])this.client.execute("one.vm.action",params);

                return result;
    }
    
    /**
     * Description: migrates one virtual machine (vid) to the target host (hid).
     * @param ID The object ID.
     * @param target_host_ID the target host id (hid) where we want to migrate the vm.
     * @param live if true we are indicating that we want livemigration, otherwise false.
     * @param force true to enforce the Host capacity is not overcommitted.
     * @param target_datastore_ID 	the target system DS id where we want to migrate the vm.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] migrate(int ID, int target_host_ID, boolean live, boolean force, int target_datastore_ID) throws XmlRpcException{
        Object[] params = {session, ID, target_host_ID, live, force, target_datastore_ID};

        Object[] result = (Object[])this.client.execute("one.vm.migrate",params);

                return result;
    }
    
    /**
     * Description: Sets the disk to be saved in the given image.
     * @param ID The object ID.
     * @param disk_ID Disk ID of the disk we want to save.
     * @param new_image_name Name for the new Image where the disk will be saved.
     * @param new_image_type Type for the new Image. If it is an empty string, then the default one will be used. See the existing types in the Image template reference.
     * @param snapshot_ID Id of the snapshot to export, if -1 the current image state will be used.
     * @return
     * result[0] true or false whenever is successful or not
     * result[1] The new allocated Image ID / The error string.
       If the Template was cloned, the new Template ID is not returned. The Template can be found by name: "&lt;image_name&gt;-&lt;image_id&gt;"
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] disksave(int ID, int disk_ID, String new_image_name, String new_image_type, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, disk_ID, new_image_name, new_image_type, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.vm.disksave",params);

                return result;
    }
    
    /**
     * Description: Takes a new snapshot of the disk image
     * @param ID The object ID.
     * @param disk_ID Disk ID of the disk we want to save.
     * @param snapshot_descr Description for the snapshot.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new snapshot ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] disksnapshotcreate(int ID, int disk_ID, String snapshot_descr) throws XmlRpcException{
        Object[] params = {session, ID, disk_ID, snapshot_descr};

        Object[] result = (Object[])this.client.execute("one.vm.disksnapshotcreate",params);

                return result;
    }
    
    /**
     * Description: Deletes a disk snapshot
     * @param ID The object ID.
     * @param disk_ID_to_save Disk ID of the disk we want to save.
     * @param disk_ID_to_delete ID of the snapshot to be deleted.
     * @return result[0] true or false whenever is successful or not
     * result[1] The ID of the snapshot deleted/ The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] disksnapshotdelete(int ID, int disk_ID_to_save, int disk_ID_to_delete) throws XmlRpcException{
        Object[] params = {session, ID, disk_ID_to_save, disk_ID_to_delete};

        Object[] result = (Object[])this.client.execute("one.vm.disksnapshotdelete",params);

                return result;
    }    
    
    /**
     * Description: Reverts disk state to a previously taken snapshot
     * @param ID The object ID.
     * @param disk_ID_to_revert Disk ID of the disk to revert its state.
     * @param snapshot_ID Snapshot ID to revert the disk state to.
     * @return result[0] true or false whenever is successful or not
     * result[1] The snapshot ID used / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] disksnapshotrevert(int ID, int disk_ID_to_revert, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, disk_ID_to_revert, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.vm.disksnapshotrevert",params);

                return result;
    }

    /**
     * Description: Attaches a new disk to the virtual machine
     * @param ID The object ID.
     * @param DISK A string containing a single DISK vector attribute. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] attach(int ID, String DISK) throws XmlRpcException{
        Object[] params = {session, ID, DISK};

        Object[] result = (Object[])this.client.execute("one.vm.attach",params);

                return result;
    }    
    
    /**
     * Description: Detaches a disk from a virtual machine
     * @param ID The object ID.
     * @param disk_ID The disk ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] detach(int ID, int disk_ID) throws XmlRpcException{
        Object[] params = {session, ID, disk_ID};

        Object[] result = (Object[])this.client.execute("one.vm.detach",params);

                return result;
    }    
    
    /**
     * Description: Attaches a new network interface to the virtual machine
     * @param ID The object ID.
     * @param NIC A string containing a single NIC vector attribute. Syntax can be the usual attribute=value or XML.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] attachnic(int ID, String NIC) throws XmlRpcException{
        Object[] params = {session, ID, NIC};

        Object[] result = (Object[])this.client.execute("one.vm.attachnic",params);

                return result;
    }

    /**
     * Description: Detaches a network interface from a virtual machine
     * @param ID The object ID.
     * @param nic_ID The nic ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] detachnic(int ID, int nic_ID) throws XmlRpcException{
        Object[] params = {session, ID, nic_ID};

        Object[] result = (Object[])this.client.execute("one.vm.detachnic",params);

                return result;
    }

    /**
     * Description: Changes the permission bits of a virtual machine.
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

        Object[] result = (Object[])this.client.execute("one.vm.chmod",params);

                return result;
    }    

    /**
     * Description: Changes the ownership of a virtual machine.
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

        Object[] result = (Object[])this.client.execute("one.vm.chown",params);

                return result;
    }    
    
    /**
     * Description: Renames a virtual machine
     * @param ID The object ID.
     * @param new_name The new name.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] rename(int ID, String new_name) throws XmlRpcException{
        Object[] params = {session, ID, new_name};

        Object[] result = (Object[])this.client.execute("one.vm.rename",params);

                return result;
    }   
    
    /**
     * Description: Creates a new virtual machine snapshot
     * @param ID The object ID.
     * @param snapshot_name The new snapshot name. It can be empty.
     * @return result[0] true or false whenever is successful or not
     * result[1] The new snapshot ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotcreate(int ID, String snapshot_name) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_name};

        Object[] result = (Object[])this.client.execute("one.vm.snapshotcreate",params);

                return result;
    }    
    
    /**
     * Description: Reverts a virtual machine to a snapshot
     * @param ID The object ID.
     * @param snapshot_ID The snapshot ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotrevert(int ID, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.vm.snapshotrevert",params);

                return result;
    } 
    
    /**
     * Description: Deletes a virtual machine snapshot
     * @param ID The object ID.
     * @param snapshot_ID The snapshot ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] snapshotdelete(int ID, int snapshot_ID) throws XmlRpcException{
        Object[] params = {session, ID, snapshot_ID};

        Object[] result = (Object[])this.client.execute("one.vm.snapshotdelete",params);

                return result;
    }    
    
    /**
     * Description: Changes the capacity of the virtual machine
     * @param ID The object ID.
     * @param new_template Template containing the new capacity elements CPU, VCPU, MEMORY. If one of them is not present, or its value is 0, it will not be resized.
     * @param force true to enforce the Host capacity is not overcommitted. This parameter is only acknoledged for users in the oneadmin group, Host capacity will be always enforced for regular users.
     * @return result[0] true or false whenever is successful or not
     * result[1] The VM ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] resize(int ID, String new_template, boolean force) throws XmlRpcException{
        Object[] params = {session, ID, new_template, force};

        Object[] result = (Object[])this.client.execute("one.vm.resize",params);

                return result;
    }    
    
    /**
     * Description: Replaces the user template contents.
     * @param ID The object ID.
     * @param template The new user template contents. Syntax can be the usual attribute=value or XML.
     * @param type Update type: 0: Replace the whole template. 1: Merge new template with the existing one.
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] update(int ID, String template, int type) throws XmlRpcException{
        Object[] params = {session, ID, template, type};

        Object[] result = (Object[])this.client.execute("one.vm.update",params);

                return result;
    }    
 
    /**
     * Description: Recovers a stuck VM that is waiting for a driver operation. The recovery may be done by failing or succeeding the pending operation. You need to manually check the vm status on the host, to decide if the operation was successful or not.
     * @param ID The object ID.
     * @param operation Recover operation: success (1), failure (0) or retry (2)
     * @return result[0] true or false whenever is successful or not
     * result[1] The resource ID / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] recover(int ID, int operation) throws XmlRpcException{
        Object[] params = {session, ID, operation};

        Object[] result = (Object[])this.client.execute("one.vm.recover",params);

                return result;
    }    
    
    /**
     * Description: Retrieves information for the virtual machine.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The information string / The error string.
     * result[2] Error code.     
     * @throws XmlRpcException
     */
    public Object[] info(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.vm.info",params);

                return result;
    }    
    
    /**
     * Description: Returns the virtual machine monitoring records.
     * @param ID The object ID.
     * @return result[0] true or false whenever is successful or not
     * result[1] The monitoring information string / The error string.
     * result[2] Error code.
     * @throws XmlRpcException
     */
    public Object[] monitoring(int ID) throws XmlRpcException{
        Object[] params = {session, ID};

        Object[] result = (Object[])this.client.execute("one.vm.monitoring",params);

                return result;
    }    
    
    
    
}
