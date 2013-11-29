package com.datastax.order.demo;

import org.mortbay.log.Log;

public class SchemaSetupMulti extends SchemaSetup {

	private static final String KEYSPACE_MULTI = "CREATE KEYSPACE order_management WITH replication = "
			+ "{'class' : 'NetworkTopologyStrategy', 'Cassandra' : 3, 'Analytics' : 1, 'Solr' : 1}";
	private static final String DROP_KEYSPACE = "DROP KEYSPACE order_management";

	public void setUp() {
		LOG.info ("Starting Multi Center DSE setup.");
		this.runAllowFail(DROP_KEYSPACE);

		sleep(1000);

		Log.info("Running : " + KEYSPACE_MULTI);
		this.run(KEYSPACE_MULTI);

		runfile();
		LOG.info ("Finished Multi Center DSE setup.");
	}


	public static void main(String args[]) {

		SchemaSetupMulti setup = new SchemaSetupMulti();
		setup.setUp();
		setup.shutdown();
	}
}
