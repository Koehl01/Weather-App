import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLoaded: false,
    ipAddress: "",
    request: {
      query: "",
      units: "f"
    }
  },
  getters: {
  },
  mutations: {
    SET_REQUEST(state, query = this.state.ipAddress){
      state.request.query = query;
      console.log("request changed");
    },
    SET_IPADDRESS(state, ipAddress){
      state.ipAddress = ipAddress;
    },
    SET_IS_LOADED_TRUE(state){
      state.isLoaded = true;
    },
    SET_IS_LOADED_FALSE(state){
      state.isLoaded = false;
    }
  },
  actions: {
  },
  modules: {
  }
})
