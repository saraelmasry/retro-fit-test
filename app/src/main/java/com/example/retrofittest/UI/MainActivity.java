package com.example.retrofittest.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofittest.Pojo.Post;
import com.example.retrofittest.R;
import com.example.retrofittest.UI.ApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView txtPost;
    Post postObj;
    HashMap<Object,Object>map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPost=findViewById(R.id.txtPost);

        //make object from Post.java class to use it in Post condition(using this when we use method StorePost() )
        postObj =new Post(5,"Retrofit coding by Sara","Hi, this is my first Post");


        //make object from Post.java class to use it in Post condition(using this when we use method StorePost2() )
        map = new HashMap<>();
        map.put("title","Retrofit coding by Sara Ahmed");
        map.put("body","Hi, this is my second Post");
        map.put("userId",12);

        // Build retrofit
        Retrofit retrofit=new Retrofit.Builder()
                // write URL of JSON
                .baseUrl("https://jsonplaceholder.typicode.com/")
                //Convert JSON file to Java class (GSON file)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // init ApiInterface.java && make retrofit(body) fill the interface(ApiInterface.java)
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

//________________________________________Using GET________________________________

//----------[1]---------------
// When we use GET in ApiInterface.java
        // callback post 
       /* Call<Post> call=apiInterface.getPost();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtPost.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtPost.setText(t.getMessage());

            }
        });*/



//----------[2]---------------
// When we use GET && PATH in ApiInterface.java
        // callback post
      /* Call<Post> call=apiInterface.getPost(1);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtPost.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtPost.setText(t.getMessage());

            }
        });*/


//----------[3]---------------
// When we use GET && Query in ApiInterface.java
        // callback post
       /* Call<List<Post>> call=apiInterface.getPost("1");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                txtPost.setText(response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                txtPost.setText(t.getMessage());
            }
        });*/



  //_________________________________________Using POST________________________________
        //----------[1]---------------
        //we use this way when we have items can collect tem in one class
        StorePost();

        //----------[2]---------------
        //we use this way when we have different items can not collect tem in one class
        StorePost2();
    }

    private void StorePost() {


        // Build retrofit
        Retrofit retrofit=new Retrofit.Builder()
                // write URL of JSON
                .baseUrl("https://jsonplaceholder.typicode.com/")
                //Convert JSON file to Java class (GSON file)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // init ApiInterface.java && make retrofit(body) fill the interface(ApiInterface.java)
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        Call<Post>  call   =apiInterface.UploadPost(postObj);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtPost.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtPost.setText(t.getMessage());

            }
        });
    }

    private void StorePost2() {

        // Build retrofit
        Retrofit retrofit=new Retrofit.Builder()
                // write URL of JSON
                .baseUrl("https://jsonplaceholder.typicode.com/")
                //Convert JSON file to Java class (GSON file)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // init ApiInterface.java && make retrofit(body) fill the interface(ApiInterface.java)
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);

        Call<Post>  call   =apiInterface.UploadPost(map);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                txtPost.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                txtPost.setText(t.getMessage());

            }
        });
    }

}
