
package Current;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentObject {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("rain")
    @Expose
    private Rain rain;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentObject() {
    }

    /**
     * 
     * @param rain
     * @param visibility
     * @param timezone
     * @param main
     * @param clouds
     * @param sys
     * @param dt
     * @param coord
     * @param weather
     * @param name
     * @param cod
     * @param id
     * @param base
     * @param wind
     */
    public CurrentObject(Coord coord, List<Weather> weather, String base, Main main, Integer visibility, Wind wind, Rain rain, Clouds clouds, Integer dt, Sys sys, Integer timezone, Integer id, String name, Integer cod) {
        super();
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public CurrentObject withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public CurrentObject withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public CurrentObject withBase(String base) {
        this.base = base;
        return this;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public CurrentObject withMain(Main main) {
        this.main = main;
        return this;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public CurrentObject withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public CurrentObject withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public CurrentObject withRain(Rain rain) {
        this.rain = rain;
        return this;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public CurrentObject withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public CurrentObject withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public CurrentObject withSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public CurrentObject withTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CurrentObject withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentObject withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public CurrentObject withCod(Integer cod) {
        this.cod = cod;
        return this;
    }

}
