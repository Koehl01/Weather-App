

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
import IPService from '@/services/IPService';

export default {
  name: 'HelloWorld',
  props:["msg"],
  data(){
    return {
      ipAddress: 0,
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

      },
      request: {
        query: "New York, New York",
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
  },
  created() {
    IPService.getIPAddress().then((response) => response.json().then(data => {
      this.ipAddress = data.ip;
      this.request.query = this.ipAddress;
      this.getWeatherReport();
    }));

  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped src="@/../public/css/weather.css">

</style>
