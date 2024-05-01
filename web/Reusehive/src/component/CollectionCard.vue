<template>
  <div class="my-2">
    <div :class="{'opc':props.itemStatus!=0}"
         class="flex flex-row bg-gray-200 p-4 rounded-2xl mx-2">
      <img :src="props.firstImageUrl" alt=""
           class="w-28 h-24 object-cover rounded-xl mx-2">

      <div class="justify-center items-center my-auto ml-5">
        <div class="text-xl">
          {{ props.desc }}
        </div>
        <div class="price">
          <span class="symbol">¥</span>
          <span class="data">{{ props.prices }} </span>
        </div>
        <div>
          {{ status }}
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>

import {computed} from "vue";

const props = defineProps({
  firstImageUrl: String,
  desc: String,
  prices: Number,
  itemStatus: Number
})

const status = computed(() => {
  if (props.itemStatus == 1) {
    return '出售中'
  } else if (props.itemStatus == 2) {
    return '已出售'
  } else {
    return '未出售'
  }
})


</script>

<style scoped>

.symbol {
  font-weight: bold;
  color: #F00;
}

.data {
  font-weight: bold;
  color: #F00;
}

.opc {
  opacity: 0.5;
}

</style>
