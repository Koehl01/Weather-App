

<template>
  <div class="weather">
    <button v-on:click="getWeatherReport">Get Weather</button>
    <p>{{ weather.weatherInfo.weatherCode }}</p>
    <img v-bind:src="this.weather.weatherInfo.weatherIcon"/>
  </div>
</template>

<script>
import weatherService from '@/services/WeatherService';

export default {
  name: 'HelloWorld',
  props:["msg"],
  data(){
    return {
      weather:{
        locationInfo:{
          name: "",
          country: "",
          region: "",
          lat: "",
          lon: "",
          timeZoneId: "",
          localTime: ""
        },
        weatherInfo: {
          observationTime: "",
          temperatur: 0,
          weatherCode: 0,
          weatherIcon: "",
          weatherDescriptions: "",
          windSpeed: 0,
          windDir: "",
          pressure: 0,
          humidity: 0,
          cloudCover: 0,
          feelsLike: 0,
          uvIndex: 0,
          visibility: 0,
          isDay: ""
        }

      },
      request: {
        query: "streetsboro, OH",
        units: "f"
      }
    }
  },
  methods:{
    getWeatherReport() {
      weatherService.getWeatherReport(this.request).then((response) => {
        this.weather = response.data;
      });
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="@/../public/css/weather.css">

</style>
