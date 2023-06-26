

<template>
  <div id="weather-overview">
      <div id="weather">
      <div id="temp">
        <p id="temp-number">{{ weather.weatherInfo.temperature }}</p>
        <p id="weather-description">{{ weather.weatherInfo.weatherDescriptions }}</p>
      </div>

      <div id="wind">
        <p id="wind-direction"><span>{{ weather.weatherInfo.windDir }}</span></p>
        <p id="wind-speed"><span>{{ weather.weatherInfo.windSpeed }}</span>  mph</p>
      </div>
    </div>
    <div id="location">
      {{ weather.locationInfo.name }}, {{ weather.locationInfo.region }}
    </div>
    <div id="forcast">
      7-day forcast
    </div>
  </div>

</template>

<script>
import weatherService from '@/services/WeatherService';


export default {
  name: 'WeatherComponent',
  data(){
    return {
      weather:{
        locationInfo:{
          name: "Streetsboro",
          country: "",
          region: "Ohio",
          lat: "",
          lon: "",
          timeZoneId: "",
          localTime: ""
        },
        weatherInfo: {
          observationTime: "",
          temperature: 72,
          weatherCode: 0,
          weatherIcon: "",
          weatherDescriptions: "sunny",
          windSpeed: 3,
          windDir: "N",
          pressure: 0,
          humidity: 0,
          cloudCover: 0,
          feelsLike: 0,
          uvIndex: 0,
          visibility: 0,
          isDay: ""
        }

      }
    }
  },
  methods:{
    getWeatherReport() {
      weatherService.getWeatherReport(this.$store.state.request).then((response) => {
        this.weather = response.data;
      });
    }
  },
  mounted(){
    this.$root.$on("request-update", this.getWeatherReport)
  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="@/../public/css/weather.css">

</style>
