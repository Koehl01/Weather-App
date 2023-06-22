<template>
  <div>
    <Weather msg="Here is the weather"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Weather from '@/components/Weather.vue'

export default {
  name: 'HomeView',
  components: {
    Weather
  }
}
</script>
