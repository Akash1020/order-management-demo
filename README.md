## Order Management Demo 

This demo processes an order stream into various tables in Cassandra. There is also some hive scripts and a solr config.

#### Pre-requisites

You will need a java runtime (prefably 7) along with maven 3 to run this demo. You will need to be comfortable installing and starting Cassandra and DSE (hadoop and solr nodes included). 

### Schema Setup

**Note : This will drop the keyspace and create a new one. All existing data will be lost.**

To create the a multi data center cluster with a standard Cassandra, Analytics and Solr set up run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupMulti" -DcontactPoints=192.168.25.1

To create the a single node cluster with replication factor of 1 for standard localhost setup, run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupSingle" -DcontactPoints=192.168.25.1

To start the order processor run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.Main" -DcontactPoints=192.168.25.1

The contact points can take mulitple points in the IP,IP,IP (no spaces).

This will load the reference data for products, users and accounts and will start the order processor batching orders for insertion to Cassandra. It will also start the service to update the account balance at a regular interval. 

### Things to test

For a demo there may be certain things that a client may want to see. Here is a list of some of the common ones.

1. Killing a node 
2. Restarting a node
3. Decommissioning a node
4. Including a new node
5. Flushing/Draining data from a node
6. Metrics within OpsCenter
7. Taking snapshots and backups within OpsCenter
8. Rebalancing a cluster and showing the current/proposed token ranges
9. Using hive to insert aggregated data back into the cluster
10. Running Solr queries against the cluster.

You can tailor this according to the needs to the customer but the idea is to highlight the important features of Cassandra and how easy DSE makes it to integrate Hive and Solr.

### Solr

Within the project structure in src/main/resources/solr there is a commands.txt file which lists the commands needs to create a Solr Core for the Users table in Cassandra. Note - the IP's addresses will be different depending on your installation. Running these commands in order will allow us to query the users table in Cassandra. For demo purposes this can be done through the Solr Web Admin interface at http://<hostname>:8983/solr/#/order_management.users/query

In the query field use the following 'street_address:square' and execute the query. This will return all the users will addresses that contain the word square. To demo the faceting feature, click on Facet and use the facet field 'state_name'. The results will now contain facet results (at the bottom) detailing the states and number of results per state. 




