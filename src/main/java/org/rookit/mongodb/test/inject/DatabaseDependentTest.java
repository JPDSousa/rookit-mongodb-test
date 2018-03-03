package org.rookit.mongodb.test.inject;

import static org.junit.Assume.assumeTrue;

import java.util.Objects;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.rookit.api.storage.DBManager;
import org.rookit.test.AbstractTest;

import com.google.inject.Injector;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("javadoc")
public abstract class DatabaseDependentTest<T> extends AbstractTest<T> {
	
	/**
	 * Logger for DatabaseDependentTest.
	 */
	private static final Logger logger = VALIDATOR.getLogger(DatabaseDependentTest.class);
	
	protected DBManager database;

	@Before
	public final void initDatabase() {
		final Injector injector = getInjector();
		final MongoDatabase database = injector.getInstance(MongoDatabase.class);
		assumeTrue("Database " + database + " is not empty. Please drop all collections or the database itself.", 
				Objects.isNull(database.listCollectionNames().first()));
		
		this.database = injector.getInstance(DBManager.class);
		this.database.init();
		logger.info("Initializing database: " + this.database.getName());
	}

	@After
	public final void afterTest() {
		logger.info("Clearing database: {}", this.database.getName());
		database.clear();
	}
	
	protected abstract Injector getInjector();

}