package com.datastax.order.demo;

import org.mortbay.log.Log;

public class SchemaSetupSingle extends SchemaSetup {
		
	private static final String KEYSPACE_SINGLE = "CREATE KEYSPACE order_management WITH replication = "
			+ "{'class' : 'NetworkTopologyStrategy', 'Cassandra' : 1}";
	private static final String DROP_KEYSPACE = "DROP KEYSPACE order_management";

	public void setUp(){
		LOG.info ("Running Single Node DSE setup.");
		
		this.run(DROP_KEYSPACE);

		sleep(1000);

		Log.info("Running : " + KEYSPACE_SINGLE);
		this.run(KEYSPACE_SINGLE);
		
		this.runfile();
		
		LOG.info ("Finished Single Node DSE setup.");
	}

	public static void main(String args[]){
		
		SchemaSetupSingle setup = new SchemaSetupSingle();
		setup.setUp();
		setup.shutdown();
	}
}
