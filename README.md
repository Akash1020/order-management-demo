## Order Management Demo 

This demo processes an order stream into various tables in Cassandra. There is also some hive scripts and a solr config.

### Schema Setup

** Note : This will drop the keyspace and create a new one. All existing data will be lost. **

To create the a multi data center cluster with a standard Cassandra, Analytics and Solr set up run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupMulti"

To create the a single node cluster with replication factor of 1 for standard localhost setup, run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupSingle"

To start the order processor run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.Main"

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
11. ........



