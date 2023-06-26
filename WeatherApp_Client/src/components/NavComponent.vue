<template>
    <div id="nav-bar">
        <img id="navlogo" src="../../public/images/kclogo.png" alt="" height="70">
        <img class="hash" src="../../public/images/hash.png" alt="">
        <img class="hash" src="../../public/images/greyhash.png" alt="">
        <div id="title">
            <p>YOUR HOME</p>
            <p>YOUR WEATHER</p>
        </div>
        <div id="search">
            <form v-on:submit.prevent="updateRequest">
                <input id="search-input" type="text" placeholder="search a city" v-model="searchText">
            </form>

        </div>
        <div id="login-register">
            <img class="hash" src="../../public/images/hash.png" alt="">
            <img class="hash" src="../../public/images/greyhash.png" alt="">
            <div id="nav-buttons">
                <button class="nav-button">login</button>
                <button class="nav-button">register</button>
            </div>

        </div>

    </div>
</template>

<script>


export default{
    data(){
        return {
            searchText: "",
        };
    },
    methods: {
        updateRequest(){
            this.$store.commit("SET_REQUEST", this.searchText);
            this.searchText = "";
            this.$root.$emit("request-update");
        }
    },

}
</script>

<style scoped src="@/../public/css/nav.css">

</style>
