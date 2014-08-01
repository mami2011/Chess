package com.kryptonite.init;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;

@Singleton
public class DBInitializer {

	@Produces
	private volatile static GraphDatabaseService graphDb;
	
	@Produces
	private volatile static RestCypherQueryEngine queryEngine;
	//private volatile static RestCypherQueryEngine queryEngine;
	
	static void initDb() {
		
		if(graphDb == null) {
			synchronized (DBInitializer.class) { 
				if(graphDb == null) {
					System.out.println("Starting neo4j....");
					//http://ec2-54-203-127-216.us-west-2.compute.amazonaws.com:7474/db/data		
					System.setProperty("org.neo4j.rest.batch_transaction", "true");
					
					//graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( "/usr/local/Cellar/neo4j/2.0.0/libexec/data/graph.db" );
					//graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( "/Users/saran/db" );
					//queryEngine = new ExecutionEngine(graphDb);
					
					graphDb = new RestGraphDatabase( "http://localhost:7474/db/data/" );
					queryEngine = new RestCypherQueryEngine(((RestGraphDatabase)graphDb).getRestAPI());
					registerShutdownHook(graphDb );
				}
			}
		}
	}
	
	static void shutdownDb() {
		System.out.println("Stopping neo4j..");
		graphDb.shutdown();
	}
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	    		System.out.println("Stopping embedded neo4j via shutdown hook..");
	            graphDb.shutdown();
	        }
	    } );
	}
} 