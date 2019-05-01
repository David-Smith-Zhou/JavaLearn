package net.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfoBean {

    /**
     * city_name : 北京
     * forecast_conditions : [{"weather_date":"2019-04-13","weather_week":"星期六","weather_condition":"多云","weather_type":"01","phenomenon_type":"02","low_temperature":"8℃","high_temperature":"23℃","wind_direction":"西北风","wind_force":"7"},{"weather_date":"2019-04-14","weather_week":"星期日","weather_condition":"晴","weather_type":"00","phenomenon_type":"01","low_temperature":"5℃","high_temperature":"19℃","wind_direction":"西北风","wind_force":"8"},{"weather_date":"2019-04-15","weather_week":"星期一","weather_condition":"晴","weather_type":"00","phenomenon_type":"01","low_temperature":"12℃","high_temperature":"27℃","wind_direction":"西南风","wind_force":"5"},{"weather_date":"2019-04-16","weather_week":"星期二","weather_condition":"晴","weather_type":"00","phenomenon_type":"01","low_temperature":"14℃","high_temperature":"27℃","wind_direction":"西南风","wind_force":"5"},{"weather_date":"2019-04-17","weather_week":"星期三","weather_condition":"晴","weather_type":"00","phenomenon_type":"01","low_temperature":"16℃","high_temperature":"28℃","wind_direction":"西南风","wind_force":"5"}]
     * current_conditions : {"high_temperature":"22℃","wind_force":"4","weather_condition":"多云","weather_type":"01","wind_direction":"西南风","exercise_index":"适宜，天气较好，尽情感受运动的快乐吧。","cold_index":"较易发，天凉，较易感冒","current_temperature":"9℃","pm25":"23.0","low_temperature":"8℃","traffic_index":"良好，天气较好，路面较干燥，路况较好。","washcar_index":"适宜，天气较好，适合擦洗汽车。","humidity":"63.8","phenomenon_type":"02","ultravioletray_index":"弱，辐射较弱，涂擦SPF12-15、PA+护肤品。","airpollution_index":"","weather_date":"2019-04-12","dress_index":"较舒适，建议穿薄外套或牛仔裤等服装。"}
     * release_time : 2019-04-11 06:00:00
     */

    @SerializedName("city_name")
    private String city_name;
    @SerializedName("current_conditions")
    private CurrentConditionsBean current_conditions;
    @SerializedName("release_time")
    private String release_time;
    @SerializedName("forecast_conditions")
    private List<ForecastConditionsBean> forecast_conditions;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public CurrentConditionsBean getCurrent_conditions() {
        return current_conditions;
    }

    public void setCurrent_conditions(CurrentConditionsBean current_conditions) {
        this.current_conditions = current_conditions;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public List<ForecastConditionsBean> getForecast_conditions() {
        return forecast_conditions;
    }

    public void setForecast_conditions(List<ForecastConditionsBean> forecast_conditions) {
        this.forecast_conditions = forecast_conditions;
    }

    public static class CurrentConditionsBean {
        /**
         * high_temperature : 22℃
         * wind_force : 4
         * weather_condition : 多云
         * weather_type : 01
         * wind_direction : 西南风
         * exercise_index : 适宜，天气较好，尽情感受运动的快乐吧。
         * cold_index : 较易发，天凉，较易感冒
         * current_temperature : 9℃
         * pm25 : 23.0
         * low_temperature : 8℃
         * traffic_index : 良好，天气较好，路面较干燥，路况较好。
         * washcar_index : 适宜，天气较好，适合擦洗汽车。
         * humidity : 63.8
         * phenomenon_type : 02
         * ultravioletray_index : 弱，辐射较弱，涂擦SPF12-15、PA+护肤品。
         * airpollution_index :
         * weather_date : 2019-04-12
         * dress_index : 较舒适，建议穿薄外套或牛仔裤等服装。
         */

        @SerializedName("high_temperature")
        private String high_temperature;
        @SerializedName("wind_force")
        private String wind_force;
        @SerializedName("weather_condition")
        private String weather_condition;
        @SerializedName("weather_type")
        private String weather_type;
        @SerializedName("wind_direction")
        private String wind_direction;
        @SerializedName("exercise_index")
        private String exercise_index;
        @SerializedName("cold_index")
        private String cold_index;
        @SerializedName("current_temperature")
        private String current_temperature;
        @SerializedName("pm25")
        private String pm25;
        @SerializedName("low_temperature")
        private String low_temperature;
        @SerializedName("traffic_index")
        private String traffic_index;
        @SerializedName("washcar_index")
        private String washcar_index;
        @SerializedName("humidity")
        private String humidity;
        @SerializedName("phenomenon_type")
        private String phenomenon_type;
        @SerializedName("ultravioletray_index")
        private String ultravioletray_index;
        @SerializedName("airpollution_index")
        private String airpollution_index;
        @SerializedName("weather_date")
        private String weather_date;
        @SerializedName("dress_index")
        private String dress_index;

        public String getHigh_temperature() {
            return high_temperature;
        }

        public void setHigh_temperature(String high_temperature) {
            this.high_temperature = high_temperature;
        }

        public String getWind_force() {
            return wind_force;
        }

        public void setWind_force(String wind_force) {
            this.wind_force = wind_force;
        }

        public String getWeather_condition() {
            return weather_condition;
        }

        public void setWeather_condition(String weather_condition) {
            this.weather_condition = weather_condition;
        }

        public String getWeather_type() {
            return weather_type;
        }

        public void setWeather_type(String weather_type) {
            this.weather_type = weather_type;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getExercise_index() {
            return exercise_index;
        }

        public void setExercise_index(String exercise_index) {
            this.exercise_index = exercise_index;
        }

        public String getCold_index() {
            return cold_index;
        }

        public void setCold_index(String cold_index) {
            this.cold_index = cold_index;
        }

        public String getCurrent_temperature() {
            return current_temperature;
        }

        public void setCurrent_temperature(String current_temperature) {
            this.current_temperature = current_temperature;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getLow_temperature() {
            return low_temperature;
        }

        public void setLow_temperature(String low_temperature) {
            this.low_temperature = low_temperature;
        }

        public String getTraffic_index() {
            return traffic_index;
        }

        public void setTraffic_index(String traffic_index) {
            this.traffic_index = traffic_index;
        }

        public String getWashcar_index() {
            return washcar_index;
        }

        public void setWashcar_index(String washcar_index) {
            this.washcar_index = washcar_index;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPhenomenon_type() {
            return phenomenon_type;
        }

        public void setPhenomenon_type(String phenomenon_type) {
            this.phenomenon_type = phenomenon_type;
        }

        public String getUltravioletray_index() {
            return ultravioletray_index;
        }

        public void setUltravioletray_index(String ultravioletray_index) {
            this.ultravioletray_index = ultravioletray_index;
        }

        public String getAirpollution_index() {
            return airpollution_index;
        }

        public void setAirpollution_index(String airpollution_index) {
            this.airpollution_index = airpollution_index;
        }

        public String getWeather_date() {
            return weather_date;
        }

        public void setWeather_date(String weather_date) {
            this.weather_date = weather_date;
        }

        public String getDress_index() {
            return dress_index;
        }

        public void setDress_index(String dress_index) {
            this.dress_index = dress_index;
        }
    }

    public static class ForecastConditionsBean {
        /**
         * weather_date : 2019-04-13
         * weather_week : 星期六
         * weather_condition : 多云
         * weather_type : 01
         * phenomenon_type : 02
         * low_temperature : 8℃
         * high_temperature : 23℃
         * wind_direction : 西北风
         * wind_force : 7
         */

        @SerializedName("weather_date")
        private String weather_date;
        @SerializedName("weather_week")
        private String weather_week;
        @SerializedName("weather_condition")
        private String weather_condition;
        @SerializedName("weather_type")
        private String weather_type;
        @SerializedName("phenomenon_type")
        private String phenomenon_type;
        @SerializedName("low_temperature")
        private String low_temperature;
        @SerializedName("high_temperature")
        private String high_temperature;
        @SerializedName("wind_direction")
        private String wind_direction;
        @SerializedName("wind_force")
        private String wind_force;

        public String getWeather_date() {
            return weather_date;
        }

        public void setWeather_date(String weather_date) {
            this.weather_date = weather_date;
        }

        public String getWeather_week() {
            return weather_week;
        }

        public void setWeather_week(String weather_week) {
            this.weather_week = weather_week;
        }

        public String getWeather_condition() {
            return weather_condition;
        }

        public void setWeather_condition(String weather_condition) {
            this.weather_condition = weather_condition;
        }

        public String getWeather_type() {
            return weather_type;
        }

        public void setWeather_type(String weather_type) {
            this.weather_type = weather_type;
        }

        public String getPhenomenon_type() {
            return phenomenon_type;
        }

        public void setPhenomenon_type(String phenomenon_type) {
            this.phenomenon_type = phenomenon_type;
        }

        public String getLow_temperature() {
            return low_temperature;
        }

        public void setLow_temperature(String low_temperature) {
            this.low_temperature = low_temperature;
        }

        public String getHigh_temperature() {
            return high_temperature;
        }

        public void setHigh_temperature(String high_temperature) {
            this.high_temperature = high_temperature;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getWind_force() {
            return wind_force;
        }

        public void setWind_force(String wind_force) {
            this.wind_force = wind_force;
        }
    }
}
