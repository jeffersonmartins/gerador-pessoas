package home.com.br.geradordepessoas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jefferson on 13/06/2018.
 */

public class UserUtils {

    public User getUser(){
        String jsonStr = Connection.getUserJson("https://randomuser.me/api/1.1");
        return parseJsonToUser(jsonStr);
    }

    private User parseJsonToUser(String json){
        User user = new User();

        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            JSONObject jsonObjectResult = jsonArray.getJSONObject(0);
            //JSONObject jsonObjectUser = jsonObjectResult.getJSONObject("user");

            user.setFirstName(jsonObjectResult.getJSONObject("name").getString("first"));
            user.setLastName(jsonObjectResult.getJSONObject("name").getString("last"));
            user.setEmail(jsonObjectResult.getString("email"));
            user.setStreet(jsonObjectResult.getJSONObject("location").getString("street"));
            user.setCity(jsonObjectResult.getJSONObject("location").getString("city"));
            user.setState(jsonObjectResult.getJSONObject("location").getString("state"));
            user.setPostCode(jsonObjectResult.getJSONObject("location").getString("postcode"));
            user.setPictureLargeUrl(jsonObjectResult.getJSONObject("picture").getString("large"));
            user.setPicture(getUserPicture(user));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }

    private Bitmap getUserPicture(User user){
        Bitmap bitmap = null;
        try{
            URL url = new URL(user.getPictureLargeUrl());
            InputStream inputStream = url.openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
