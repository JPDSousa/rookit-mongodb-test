package org.rookit.mongodb.test.inject;

import java.util.Collections;
import java.util.List;

import com.google.inject.AbstractModule;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("javadoc")
public class MongoDBTestModule extends AbstractModule {

	private static final String HOST = "localhost";
	private static final int PORT = 27020;
	
	private final MongoClient client;

	public MongoDBTestModule() {
		super();
		final List<ServerAddress> address = Collections.singletonList(
				new ServerAddress(HOST, PORT));
		final MongoClientOptions options = MongoClientOptions.builder()
				.connectTimeout(1000)
				.build();
		this.client = new MongoClient(address, options);
	}
	
	@Override
	protected void configure() {
		bind(MongoClient.class).toInstance(this.client);
		bind(MongoDatabase.class).toProvider(MongoDatabaseProvider.class);
	}
}