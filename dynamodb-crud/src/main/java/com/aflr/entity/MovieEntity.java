package com.aflr.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@Setter
@Getter
public class MovieEntity {

    private String filmId;
    private String title;
    @DynamoDBAttribute
    private String releaseYear;
    @DynamoDBAttribute
    private String rated;
    @DynamoDBAttribute
    private String released;

    @DynamoDbPartitionKey
    public String getFilmId() {
        return filmId;
    }

    @DynamoDbSortKey
    public String getTitle() {
        return title;
    }
}
