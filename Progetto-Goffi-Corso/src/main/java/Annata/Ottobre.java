
package Annata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ottobre {

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
    public Ottobre() {
    }

    /**
     * 
     * @param average
     * @param min
     * @param max
     * @param variance
     */
    public Ottobre(Integer max, Integer min, Double average, Double variance) {
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

    public Ottobre withMax(Integer max) {
        this.max = max;
        return this;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Ottobre withMin(Integer min) {
        this.min = min;
        return this;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Ottobre withAverage(Double average) {
        this.average = average;
        return this;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public Ottobre withVariance(Double variance) {
        this.variance = variance;
        return this;
    }

}
