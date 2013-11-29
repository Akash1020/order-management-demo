package com.datastax.order.demo;

public class SchemaSetupSingle extends SchemaSetup {
		
	private static final String KEYSPACE_SINGLE = "CREATE KEYSPACE order_management WITH replication = {'class' : 'NetworkTopologyStrategy', 'Cassandra' : 1}";
	private static final String DROP_KEYSPACE = "DROP KEYSPACE order_management";

	public void setUp(){
		this.run(DROP_KEYSPACE);

		sleep(1000);

		this.run(KEYSPACE_SINGLE);
		
		this.runfile();
	}

	public static void main(String args[]){
		
		SchemaSetupSingle setup = new SchemaSetupSingle();
		setup.setUp();
		setup.shutdown();
	}
}
