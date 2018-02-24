package org.rookit.mongodb.test.inject;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("javadoc")
public class MongoDatabaseProvider implements Provider<MongoDatabase> {

	private final MongoClient client;
	
	@Inject
	private MongoDatabaseProvider(final MongoClient client) {
		this.client = client;
	}

	@Override
	public MongoDatabase get() {
		final String dbName = Thread.currentThread().getName();
		return client.getDatabase(dbName);
	}
	
}
