Order Management Demo 
---------------


To create the a multi data center cluster with a standard Cassandra, Analytics and Solr set up run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupMulti"

To create the a single node cluster with replication factor of 1 for standard localhost setup, run the following

    mvn clean compile exec:java -Dexec.mainClass="com.datastax.order.demo.SchemaSetupSingle"
