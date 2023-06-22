<template>
  <div id="app">
    <nav-component />
    <news-component />
    <ads-component />
    <router-view id="route-view"/>
    <footer>footer</footer>
  </div>
</template>

<script>
import adsComponent from './components/AdsComponent.vue'
import newsComponent from './components/NewsComponent.vue'
import navComponent from './components/NavComponent.vue'
export default{
  components:{
    adsComponent,
    newsComponent,
    navComponent
  }
}
</script>

<style src="../public/css/app.css">

</style>
