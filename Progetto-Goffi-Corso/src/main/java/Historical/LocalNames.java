
package Historical;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocalNames {

    @SerializedName("ascii")
    @Expose
    private String ascii;
    @SerializedName("el")
    @Expose
    private String el;
    @SerializedName("feature_name")
    @Expose
    private String featureName;
    @SerializedName("fr")
    @Expose
    private String fr;
    @SerializedName("it")
    @Expose
    private String it;

    public String getAscii() {
        return ascii;
    }

    public void setAscii(String ascii) {
        this.ascii = ascii;
    }

    public String getEl() {
        return el;
    }

    public void setEl(String el) {
        this.el = el;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

}
