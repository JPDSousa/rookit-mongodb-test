package org.rookit.mongodb.test.inject.utils;

import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.CreateViewOptions;

@SuppressWarnings("javadoc")
public class MongoDatabaseNameOnly implements MongoDatabase {
	
	private static final String UNSUPPORTED_ERROR_MESSAGE = "This implementation only stores the name of the database.";

	private final String name;
	
	public MongoDatabaseNameOnly(final String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public CodecRegistry getCodecRegistry() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public ReadPreference getReadPreference() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public WriteConcern getWriteConcern() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public ReadConcern getReadConcern() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public MongoDatabase withCodecRegistry(CodecRegistry codecRegistry) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public MongoDatabase withReadPreference(ReadPreference readPreference) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public MongoDatabase withWriteConcern(WriteConcern writeConcern) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public MongoDatabase withReadConcern(ReadConcern readConcern) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public MongoCollection<Document> getCollection(String collectionName) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public <TDocument> MongoCollection<TDocument> getCollection(String collectionName, Class<TDocument> documentClass) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public Document runCommand(Bson command) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public Document runCommand(Bson command, ReadPreference readPreference) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public <TResult> TResult runCommand(Bson command, Class<TResult> resultClass) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public <TResult> TResult runCommand(Bson command, ReadPreference readPreference, Class<TResult> resultClass) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
	}

	@Override
	public MongoIterable<String> listCollectionNames() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public ListCollectionsIterable<Document> listCollections() {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public <TResult> ListCollectionsIterable<TResult> listCollections(Class<TResult> resultClass) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public void createCollection(String collectionName) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public void createCollection(String collectionName, CreateCollectionOptions createCollectionOptions) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public void createView(String viewName, String viewOn, List<? extends Bson> pipeline) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}

	@Override
	public void createView(String viewName, String viewOn, List<? extends Bson> pipeline,
			CreateViewOptions createViewOptions) {
		throw new UnsupportedOperationException(UNSUPPORTED_ERROR_MESSAGE);
	}
}
