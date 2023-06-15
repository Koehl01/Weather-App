

<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{ test }}</h2>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props:["msg", "test"]
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
