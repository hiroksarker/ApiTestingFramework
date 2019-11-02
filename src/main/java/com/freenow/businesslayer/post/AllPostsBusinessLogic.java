package com.freenow.businesslayer.post;

import com.freenow.pojo.post.AllPosts;
import com.freenow.pojo.post.SinglePost;
import com.freenow.util.PropertyReader;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static com.freenow.constant.ServiceConstant.*;
import static io.restassured.RestAssured.when;

public class AllPostsBusinessLogic extends PropertyReader {

    private static final Logger log = LoggerFactory.getLogger(AllPostsBusinessLogic.class);

    /**
     * Fetch list of all posts
     * e.g. https://jsonplaceholder.typicode.com/posts
     */
    public static AllPosts getAllPosts() {
        String baseUrl = prop.getProperty(BASE_URL);
        String postsEndpoint = prop.getProperty(POSTS_ENDPOINT);
        String url = baseUrl + postsEndpoint;
        log.info("URL to be hit:" + url);

        Response response = when().get(url);
        List<SinglePost> allSinglePosts = Arrays.asList(response.getBody().as(SinglePost[].class));

        AllPosts allPosts = new AllPosts();
        allPosts.setListOfPosts(allSinglePosts);
        return allPosts;
    }

    /**
     * Fetch list of all posts json set respective to particular userId
     * e.g. https://jsonplaceholder.typicode.com/posts?userId=1
     */
    public static AllPosts getAllPostsForUserId(int userId) {
        String baseUrl = prop.getProperty(BASE_URL);
        String postsEndpointQueryParamUserId = prop.getProperty(POSTS_ENDPOINT_QUERY_PARAM_USERS_ID);
        String url = baseUrl + postsEndpointQueryParamUserId + userId;
        log.info("URL to be hit:" + url);

        Response response = when().get(url);
        List<SinglePost> allSinglePosts = Arrays.asList(response.getBody().as(SinglePost[].class));

        AllPosts allPosts = new AllPosts();
        allPosts.setListOfPosts(allSinglePosts);
        return allPosts;
    }
}
