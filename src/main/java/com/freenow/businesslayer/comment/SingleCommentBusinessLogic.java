package com.freenow.businesslayer.comment;

import com.freenow.pojo.comment.SingleComment;
import com.freenow.util.PropertyReader;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.freenow.constant.ServiceConstant.BASE_URL;
import static com.freenow.constant.ServiceConstant.COMMENTS_ENDPOINT;
import static io.restassured.RestAssured.when;

public class SingleCommentBusinessLogic extends PropertyReader {

    private static final Logger log = LoggerFactory.getLogger(SingleCommentBusinessLogic.class);

    /**
     * Extract data as Response object
     * Populate Single Comment Response POJOs
     * https://jsonplaceholder.typicode.com/comments/1
     *
     * @param id - comment id to fetch a single comment
     */
    public static SingleComment getSingleCommentById(String id) {
        String baseUrl = prop.getProperty(BASE_URL);
        String commentsEndpoint = prop.getProperty(COMMENTS_ENDPOINT);
        String url = baseUrl + commentsEndpoint + id;
        log.info("API to be hit:" + url);

        Response response = when().get(url);
        SingleComment singleComment = response.getBody().as(SingleComment.class);
        return singleComment;
    }
}
