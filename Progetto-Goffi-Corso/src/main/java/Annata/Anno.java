
package Annata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Anno {

    @SerializedName("anno")
    @Expose
    private Integer anno;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mesi")
    @Expose
    private Mesi mesi;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Anno() {
    }

    /**
     * 
     * @param anno
     * @param name
     * @param mesi
     */
    public Anno(Integer anno, String name, Mesi mesi) {
        super();
        this.anno = anno;
        this.name = name;
        this.mesi = mesi;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Anno withAnno(Integer anno) {
        this.anno = anno;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Anno withName(String name) {
        this.name = name;
        return this;
    }

    public Mesi getMesi() {
        return mesi;
    }

    public void setMesi(Mesi mesi) {
        this.mesi = mesi;
    }

    public Anno withMesi(Mesi mesi) {
        this.mesi = mesi;
        return this;
    }

}
