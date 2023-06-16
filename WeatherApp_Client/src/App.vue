<template>
  <div id="app">
    <nav>
      <h1>Title</h1>
    </nav>
    <news-component />
    <ads-component />
    <router-view id="route-view"/>
    <footer>footer</footer>
  </div>
</template>

<script>
import adsComponent from './components/AdsComponent.vue'
import newsComponent from './components/NewsComponent.vue'
export default{
  components:{
    adsComponent,
    newsComponent
  }
}
</script>

<style src="../public/css/app.css">

</style>
