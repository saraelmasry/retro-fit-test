package com.example.retrofittest.UI;

import com.example.retrofittest.Pojo.Post;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
//________________________________________Using GET________________________________

//----------[1]---------------
    // REST API (Retrofit) using GET
    @GET("posts/1")
    public Call<Post> getPost();

//----------[2]---------------
    // REST API (Retrofit) using GET ! when we make post id be dynamically using PATH
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") int postId);

//----------[3]---------------
    // REST API (Retrofit) using GET && Query
    @GET("posts")
    public Call<List<Post>> getPost(@Query("userId") String userId);


//_________________________________________Using POST________________________________

//----------[1]---------------
    //we use this way when we have items can collect tem in one class
    @POST("posts")
    public  Call<Post> UploadPost (@Body Post post);


//----------[2]---------------
    //we use this way when we have different items can not collect tem in one class
    @POST("posts")
    public  Call<Post> UploadPost (@Body HashMap<Object, Object> map);
}
