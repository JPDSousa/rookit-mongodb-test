package org.rookit.mongodb.test.inject;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.rookit.mongodb.test.inject.utils.MongoDatabaseNameOnly;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("javadoc")
public class DefaultTest {
	
	private static Injector injector;
	
	private MongoDatabase database;

	@BeforeClass
	public static void setUpBeforeClass() {
		injector = Guice.createInjector(new TestModule());
	}
	
	@Before
	public final void setUp() {
		database = injector.getInstance(MongoDatabase.class);
	}

	@Test
	public final void testMongoDatabaseProvider() {
		assertThat(database.getName()).isEqualTo(Thread.currentThread().getName());
	}
	
	private static class TestModule extends AbstractModule {

		@Override
		protected void configure() {
			final MongoClient clientMock = mock(MongoClient.class);
			when(clientMock.getDatabase(any())).then(new Answer<MongoDatabase>() {

				@Override
				public MongoDatabase answer(InvocationOnMock invocation) throws Throwable {
					final String name = invocation.getArgumentAt(0, String.class);
					
					return new MongoDatabaseNameOnly(name);
				}
			});
			
			bind(MongoClient.class).toInstance(clientMock);
			bind(MongoDatabase.class).toProvider(MongoDatabaseProvider.class);
			
		}
		
	}
}
