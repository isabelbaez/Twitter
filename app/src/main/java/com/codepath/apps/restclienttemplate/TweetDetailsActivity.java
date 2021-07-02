package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class TweetDetailsActivity extends AppCompatActivity {

    Tweet tweet;

    ImageView ivProfile;
    TextView tvUserName;
    TextView tvText;
    ImageView ivMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_details);

        ivProfile = findViewById(R.id.ivProfile);
        tvUserName = findViewById(R.id.tvUserName);
        tvText = findViewById(R.id.tvText);
        ivMedia = findViewById(R.id.ivMedia);

        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        Log.i("ok","ok");

        tvText.setText(tweet.body);
        tvUserName.setText(tweet.user.screenName);
        Glide.with(this)
                .load(tweet.user.profileImageUrl)
                .into(ivProfile);
        if (tweet.media != null) {
            Glide.with(this)
                    .load(tweet.media)
                    .into(ivMedia);
            ivMedia.setVisibility(View.VISIBLE);
        }
        else {
            ivMedia.setVisibility(View.GONE);
        }
    }
}
