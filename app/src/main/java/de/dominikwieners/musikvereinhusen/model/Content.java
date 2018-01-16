package de.dominikwieners.musikvereinhusen.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class Content {

    @SerializedName("rendered")
    String rendered;

    public Content(String rendered) {
        this.rendered = rendered;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }
}
