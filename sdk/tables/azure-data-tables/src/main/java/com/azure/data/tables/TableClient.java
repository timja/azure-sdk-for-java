// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.data.tables;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;
import com.azure.data.tables.models.TableEntityUpdateMode;
import com.azure.data.tables.models.TableItem;
import com.azure.data.tables.models.TableServiceException;
import com.azure.data.tables.models.TableSignedIdentifier;

import java.time.Duration;
import java.util.List;

import static com.azure.data.tables.implementation.TableUtils.applyOptionalTimeout;
import static com.azure.data.tables.implementation.TableUtils.blockWithOptionalTimeout;

/**
 * Provides a synchronous service client for accessing a table in the Azure Tables service.
 *
 * The client encapsulates the URL for the table within the Tables service endpoint, the name of the table, and the
 * credentials for accessing the storage or CosmosDB table API account. It provides methods to create and delete the
 * table itself, as well as methods to create, upsert, update, delete, list, and get entities within the table. These
 * methods invoke REST API operations to make the requests and obtain the results that are returned.
 *
 * Instances of this client are obtained by calling the {@link TableClientBuilder#buildClient()} method on a {@link
 * TableClientBuilder} object.
 */
@ServiceClient(builder = TableClientBuilder.class)
public final class TableClient {
    final TableAsyncClient client;

    TableClient(TableAsyncClient client) {
        this.client = client;
    }

    /**
     * Gets the name of the table.
     *
     * @return The name of the table.
     */
    public String getTableName() {
        return this.client.getTableName();
    }

    /**
     * Gets the name of the account containing the table.
     *
     * @return The name of the account containing the table.
     */
    public String getAccountName() {
        return this.client.getAccountName();
    }

    /**
     * Gets the endpoint for this table.
     *
     * @return The endpoint for this table.
     */
    public String getTableEndpoint() {
        return this.client.getTableEndpoint();
    }

    /**
     * Gets the REST API version used by this client.
     *
     * @return The REST API version used by this client.
     */
    public TableServiceVersion getServiceVersion() {
        return this.client.getServiceVersion();
    }

    /**
     * Creates a new {@link TableBatch} object. Batch objects allow you to enqueue multiple create, update, upsert,
     * and/or delete operations on entities that share the same partition key. When the batch is executed, all of the
     * operations will be performed as part of a single transaction. As a result, either all operations in the batch
     * will succeed, or if a failure occurs, all operations in the batch will be rolled back. Each operation in a batch
     * must operate on a distinct row key. Attempting to add multiple operations to a batch that share the same row key
     * will cause an exception to be thrown.
     *
     * @param partitionKey The partition key shared by all operations in the batch.
     *
     * @return An object representing the batch, to which operations can be added.
     *
     * @throws IllegalArgumentException If the provided partition key is {@code null} or empty.
     */
    public TableBatch createBatch(String partitionKey) {
        return new TableBatch(this.client.createBatch(partitionKey));
    }

    /**
     * Creates the table within the Tables service.
     *
     * @return A {@link TableItem} that represents the table.
     *
     * @throws TableServiceException If a table with the same name already exists within the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TableItem createTable() {
        return client.createTable().block();
    }

    /**
     * Creates the table within the Tables service.
     *
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response containing a {@link TableItem} that represents the table.
     *
     * @throws TableServiceException If a table with the same name already exists within the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TableItem> createTableWithResponse(Duration timeout, Context context) {
        return blockWithOptionalTimeout(client.createTableWithResponse(context), timeout);
    }

    /**
     * Inserts an entity into the table.
     *
     * @param entity The entity to insert.
     *
     * @throws TableServiceException If an entity with the same partition key and row key already exists within the
     * table.
     * @throws IllegalArgumentException If the provided entity is invalid.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void createEntity(TableEntity entity) {
        client.createEntity(entity).block();
    }

    /**
     * Inserts an entity into the table.
     *
     * @param entity The entity to insert.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     *
     * @throws TableServiceException If an entity with the same partition key and row key already exists within the
     * table.
     * @throws IllegalArgumentException If the provided entity is invalid.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> createEntityWithResponse(TableEntity entity, Duration timeout, Context context) {
        return blockWithOptionalTimeout(client.createEntityWithResponse(entity, context), timeout);
    }

    /**
     * Inserts an entity into the table if it does not exist, or merges the entity with the existing entity otherwise.
     *
     * If no entity exists within the table having the same partition key and row key as the provided entity, it will be
     * inserted. Otherwise, the provided entity's properties will be merged into the existing entity.
     *
     * @param entity The entity to upsert.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void upsertEntity(TableEntity entity) {
        client.upsertEntity(entity).block();
    }

    /**
     * Inserts an entity into the table if it does not exist, or updates the existing entity using the specified update
     * mode otherwise.
     *
     * If no entity exists within the table having the same partition key and row key as the provided entity, it will be
     * inserted. Otherwise, the existing entity will be updated according to the specified update mode.
     *
     * When the update mode is 'MERGE', the provided entity's properties will be merged into the existing entity. When
     * the update mode is 'REPLACE', the provided entity's properties will completely replace those in the existing
     * entity.
     *
     * @param entity The entity to upsert.
     * @param updateMode The type of update to perform if the entity already exits.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void upsertEntity(TableEntity entity, TableEntityUpdateMode updateMode) {
        client.upsertEntity(entity, updateMode).block();
    }

    /**
     * Inserts an entity into the table if it does not exist, or updates the existing entity using the specified update
     * mode otherwise.
     *
     * If no entity exists within the table having the same partition key and row key as the provided entity, it will be
     * inserted. Otherwise, the existing entity will be updated according to the specified update mode.
     *
     * When the update mode is 'MERGE', the provided entity's properties will be merged into the existing entity. When
     * the update mode is 'REPLACE', the provided entity's properties will completely replace those in the existing
     * entity.
     *
     * @param entity The entity to upsert.
     * @param updateMode The type of update to perform if the entity already exits.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> upsertEntityWithResponse(TableEntity entity, TableEntityUpdateMode updateMode,
                                                   Duration timeout, Context context) {
        return blockWithOptionalTimeout(client.upsertEntityWithResponse(entity, updateMode, context), timeout);
    }

    /**
     * Updates an existing entity by merging the provided entity with the existing entity.
     *
     * @param entity The entity to update.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If no entity with the same partition key and row key exists within the table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void updateEntity(TableEntity entity) {
        client.updateEntity(entity).block();
    }

    /**
     * Updates an existing entity using the specified update mode.
     *
     * When the update mode is 'MERGE', the provided entity's properties will be merged into the existing entity. When
     * the update mode is 'REPLACE', the provided entity's properties will completely replace those in the existing
     * entity.
     *
     * @param entity The entity to update.
     * @param updateMode which type of mode to execute
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If no entity with the same partition key and row key exists within the table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void updateEntity(TableEntity entity, TableEntityUpdateMode updateMode) {
        client.updateEntity(entity, updateMode).block();
    }

    /**
     * Updates an existing entity using the specified update mode.
     *
     * When the update mode is 'MERGE', the provided entity's properties will be merged into the existing entity. When
     * the update mode is 'REPLACE', the provided entity's properties will completely replace those in the existing
     * entity.
     *
     * @param entity The entity to update.
     * @param updateMode The type of update to perform.
     * @param ifUnchanged When true, the eTag of the provided entity must match the eTag of the entity in the Table
     * service. If the values do not match, the update will not occur and an exception will be thrown.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If no entity with the same partition key and row key exists within the table,
     * or if {@code ifUnchanged} is {@code true} and the existing entity's eTag does not match that of the provided
     * entity.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void updateEntity(TableEntity entity, TableEntityUpdateMode updateMode, boolean ifUnchanged) {
        client.updateEntity(entity, updateMode, ifUnchanged).block();
    }

    /**
     * Updates an existing entity using the specified update mode.
     *
     * When the update mode is 'MERGE', the provided entity's properties will be merged into the existing entity. When
     * the update mode is 'REPLACE', the provided entity's properties will completely replace those in the existing
     * entity.
     *
     * @param entity The entity to update.
     * @param updateMode The type of update to perform.
     * @param ifUnchanged When true, the eTag of the provided entity must match the eTag of the entity in the Table
     * service. If the values do not match, the update will not occur and an exception will be thrown.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     *
     * @throws IllegalArgumentException If the provided entity is invalid.
     * @throws TableServiceException If no entity with the same partition key and row key exists within the table,
     * or if {@code ifUnchanged} is {@code true} and the existing entity's eTag does not match that of the provided
     * entity.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> updateEntityWithResponse(TableEntity entity, TableEntityUpdateMode updateMode,
                                                   boolean ifUnchanged, Duration timeout, Context context) {
        return blockWithOptionalTimeout(
            client.updateEntityWithResponse(entity, updateMode, ifUnchanged, context), timeout);
    }

    /**
     * Deletes the table within the Tables service.
     *
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteTable() {
        client.deleteTable().block();
    }

    /**
     * Deletes the table within the Tables service.
     *
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     *
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteTableWithResponse(Duration timeout, Context context) {
        return blockWithOptionalTimeout(client.deleteTableWithResponse(context), timeout);
    }

    /**
     * Deletes an entity from the table.
     *
     * @param partitionKey The partition key of the entity.
     * @param rowKey The row key of the entity.
     *
     * @throws IllegalArgumentException If the provided partition key or row key are {@code null} or empty.
     * @throws TableServiceException If the request is rejected by the service.
     * table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteEntity(String partitionKey, String rowKey) {
        client.deleteEntity(partitionKey, rowKey).block();
    }

    /**
     * Deletes an entity from the table.
     *
     * @param tableEntity The table entity to delete.
     *
     * @throws IllegalArgumentException If the {@link TableEntity provided entity}'s partition key or row key are
     * {@code null} or empty.
     * @throws TableServiceException If the request is rejected by the service.
     * table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteEntity(TableEntity tableEntity) {
        client.deleteEntityWithResponse(tableEntity.getPartitionKey(), tableEntity.getRowKey(), tableEntity.getETag(),
            null).block();
    }

    /**
     * Deletes an entity from the table.
     *
     * @param partitionKey The partition key of the entity.
     * @param rowKey The row key of the entity.
     * @param eTag The value to compare with the eTag of the entity in the Tables service. If the values do not match,
     * the delete will not occur and an exception will be thrown.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     *
     * @throws IllegalArgumentException If the provided partition key or row key are {@code null} or empty.
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteEntityWithResponse(String partitionKey, String rowKey, String eTag, Duration timeout,
                                                   Context context) {
        return blockWithOptionalTimeout(client.deleteEntityWithResponse(partitionKey, rowKey, eTag, context), timeout);
    }

    /**
     * Lists all entities within the table.
     *
     * @return A paged iterable containing all entities within the table.
     *
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TableEntity> listEntities() {
        return new PagedIterable<>(client.listEntities());
    }

    /**
     * Lists entities using the parameters in the provided options.
     *
     * If the `filter` parameter in the options is set, only entities matching the filter will be returned. If the
     * `select` parameter is set, only the properties included in the select parameter will be returned for each entity.
     * If the `top` parameter is set, the number of returned entities will be limited to that value.
     *
     * @param options The `filter`, `select`, and `top` OData query options to apply to this operation.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return A paged iterable containing matching entities within the table.
     *
     * @throws IllegalArgumentException If one or more of the OData query options in {@code options} is malformed.
     * @throws TableServiceException If the request is rejected by the service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TableEntity> listEntities(ListEntitiesOptions options, Duration timeout, Context context) {
        return new PagedIterable<>(applyOptionalTimeout(client.listEntities(options, context), timeout));
    }

    /**
     * Gets a single entity from the table.
     *
     * @param partitionKey The partition key of the entity.
     * @param rowKey The partition key of the entity.
     *
     * @return The entity.
     *
     * @throws IllegalArgumentException If the provided partition key or row key are {@code null} or empty.
     * @throws TableServiceException If no entity with the provided partition key and row key exists within the
     * table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TableEntity getEntity(String partitionKey, String rowKey) {
        return client.getEntity(partitionKey, rowKey).block();
    }

    /**
     * Gets a single entity from the table.
     *
     * @param partitionKey The partition key of the entity.
     * @param rowKey The partition key of the entity.
     * @param select A list of properties to select on the entity.
     *
     * @return The entity.
     *
     * @throws IllegalArgumentException If the provided partition key or row key are {@code null} or empty, or if the
     * {@code select} OData query option is malformed.
     * @throws TableServiceException If no entity with the provided partition key and row key exists within the
     * table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TableEntity getEntity(String partitionKey, String rowKey, List<String> select) {
        return client.getEntity(partitionKey, rowKey, select).block();
    }

    /**
     * Gets a single entity from the table.
     *
     * @param partitionKey The partition key of the entity.
     * @param rowKey The partition key of the entity.
     * @param select A list of properties to select on the entity.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response containing the entity.
     *
     * @throws IllegalArgumentException If the provided partition key or row key are {@code null} or empty, or if the
     * {@code select} OData query option is malformed.
     * @throws TableServiceException If no entity with the provided partition key and row key exists within the
     * table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TableEntity> getEntityWithResponse(String partitionKey, String rowKey, List<String> select,
                                                       Duration timeout, Context context) {
        return blockWithOptionalTimeout(
            client.getEntityWithResponse(partitionKey, rowKey, select, TableEntity.class, context), timeout);
    }

    /**
     * Retrieves details about any stored access policies specified on the table that may be used with Shared Access
     * Signatures.
     *
     * @return A reactive result containing the HTTP response and the table's
     * {@link TableSignedIdentifier access policies}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TableSignedIdentifier> getAccessPolicy() {
        return new PagedIterable<>(client.getAccessPolicy());
    }

    /**
     * Retrieves details about any stored access policies specified on the table that may be used with Shared Access
     * Signatures.
     *
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return A reactive result containing the HTTP response and the table's
     * {@link TableSignedIdentifier access policies}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TableSignedIdentifier> getAccessPolicy(Duration timeout, Context context) {
        return new PagedIterable<>(applyOptionalTimeout(client.getAccessPolicy(context), timeout));
    }

    /**
     * Sets stored access policies for the table that may be used with Shared Access Signatures.
     *
     * @param tableSignedIdentifiers The {@link TableSignedIdentifier access policies} for the table.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void setAccessPolicy(List<TableSignedIdentifier> tableSignedIdentifiers) {
        client.setAccessPolicy(tableSignedIdentifiers).block();
    }

    /**
     * Retrieves details about any stored access policies specified on the table that may be used with Shared Access
     * Signatures.
     *
     * @param tableSignedIdentifiers The {@link TableSignedIdentifier access policies} for the table.
     * @param timeout An optional timeout value beyond which a {@link RuntimeException} will be raised.
     * @param context Additional context that is passed through the HTTP pipeline during the service call.
     *
     * @return The HTTP response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> setAccessPolicyWithResponse(List<TableSignedIdentifier> tableSignedIdentifiers,
                                                      Duration timeout, Context context) {
        return blockWithOptionalTimeout(client.setAccessPolicyWithResponse(tableSignedIdentifiers, context), timeout);
    }
}
