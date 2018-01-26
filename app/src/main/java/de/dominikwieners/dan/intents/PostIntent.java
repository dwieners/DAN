package de.dominikwieners.dan.intents;

import android.content.Context;
import android.content.Intent;

/**
 * Created by dominikwieners on 21.01.18.
 */

public class PostIntent extends Intent {

    private final String CURRENT_POST = "arg_current_post";
    private final String CURRENT_IMG_URL = "arg_current_img_url";

    PostIntentData postIntentData;

    public PostIntent(Context packageContext, Class<?> cls, PostIntentData postIntentData) {
        super(packageContext, cls);
        this.postIntentData = postIntentData;
        putExtra(CURRENT_POST, postIntentData.getTitle());
        putExtra(CURRENT_IMG_URL, postIntentData.getThumbnailUrl());
    }

}
