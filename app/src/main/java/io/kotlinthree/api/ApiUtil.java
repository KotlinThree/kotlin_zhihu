package io.kotlinthree.api;


import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by jameson on 12/19/15.
 */
public class ApiUtil {
    public static final String BASE_URL = "http://news-at.zhihu.com/api/4/";

    public interface ApiService {
        // 20151220
        @GET("stories/before/{date}")
        Call<NewsListData> listNews(@Path("date") String date);

        @GET("story/{id}")
        Call<News> getNewsDetail(@Path("id") int id);
    }

    public static ApiService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }

}
