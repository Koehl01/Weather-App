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
import ipService from '@/services/IPService';

export default{
  components:{
    adsComponent,
    newsComponent,
    navComponent
  },
  created() {
    if (this.$store.state.ipAddress === ""){
      ipService.getIPAddress().then((response) => response.json().then(data => {
        this.$store.commit("SET_IPADDRESS", data.ip);
        this.$store.commit("SET_REQUEST");
        this.$root.$emit("request-update");
      }));
    }
  }

}
</script>

<style src="../public/css/app.css">

</style>
