package com.aflr.dao;

import com.aflr.entity.MovieEntity;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.BatchGetResultPageIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.ReadBatch;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class MovieDynamoDBDao implements MovieDao {
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public MovieDynamoDBDao(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        DynamoDbTable<MovieEntity> table = dynamoDbEnhancedClient.table("movie", TableSchema.fromBean(MovieEntity.class));
        Spliterator<MovieEntity> spliterator = table.scan().items().stream().spliterator();
        return StreamSupport.stream(spliterator, false).collect(Collectors.toList());
    }

    public void getBatchesByKeys(List<String> keys) {
        DynamoDbTable<MovieEntity> table = dynamoDbEnhancedClient.table("MyTableName", TableSchema.fromBean(MovieEntity.class));
        ReadBatch.Builder<MovieEntity> readBatchBuilder = ReadBatch.builder(MovieEntity.class);
        keys.stream().forEach(key -> {
            readBatchBuilder.addGetItem(Key.builder().partitionValue(key).build());
        });
        readBatchBuilder.mappedTableResource(table);
        ReadBatch readBatch = readBatchBuilder.build();
        BatchGetResultPageIterable iterable = dynamoDbEnhancedClient.batchGetItem(r -> r.addReadBatch(readBatch));
    }

    @Override
    public MovieEntity getMovieById() {
        return null;
    }
}
