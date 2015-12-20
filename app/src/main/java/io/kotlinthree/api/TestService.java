package io.kotlinthree.api;

import retrofit.http.GET;
import retrofit.http.Path;

public interface TestService {
    @GET("stories/before/{date}")
    NewsListData listNews(@Path("date") String user);
}