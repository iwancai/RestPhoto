package com.cai.ridwan.restphoto.api;

import com.cai.ridwan.restphoto.models.photoModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ridwan on 2/7/18.
 */

public interface RequestInterface {

    @GET("/photos")
    Call<List<photoModels>> getJSON();
}
