
package Annata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Giugno {

    @SerializedName("max")
    @Expose
    private Integer max;
    @SerializedName("min")
    @Expose
    private Integer min;
    @SerializedName("average")
    @Expose
    private Double average;
    @SerializedName("variance")
    @Expose
    private Double variance;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Giugno() {
    }

    /**
     * 
     * @param average
     * @param min
     * @param max
     * @param variance
     */
    public Giugno(Integer max, Integer min, Double average, Double variance) {
        super();
        this.max = max;
        this.min = min;
        this.average = average;
        this.variance = variance;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Giugno withMax(Integer max) {
        this.max = max;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Giugno withMin(Integer min) {
        this.min = min;
        return this;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Giugno withAverage(Double average) {
        this.average = average;
        return this;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public Giugno withVariance(Double variance) {
        this.variance = variance;
        return this;
    }

}
