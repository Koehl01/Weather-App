

<template>
  <div class="hello">
    <h1>{{ weather }}</h1>
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
        locationInfo:{},
        weatherInfo: {}

      },
      request: {
        query: "streetsboro, OH",
        units: "f"
      }
    }
  },
  created() {
    weatherService.getWeatherReport(this.request).then((response) => {
      this.weather = response.data;
    });
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
