<template>
  <div>
    <div class="h-screen">
      <keep-alive>
        <RouterView></RouterView>
      </keep-alive>
    </div>
    <div>
      <TabBar/>
    </div>
  </div>
</template>


<script lang="ts" setup>
import TabBar from "./TabBar.vue";
</script>