<template>
  <div class="container flex flex-col" @click="goToItem()">
    <div class="item-image">
      <t-image :src="fimage" :style="{ width: '10rem', height: '12rem' }" fit="cover" shape="round"></t-image>
    </div>
    <div class="item-desc">
      {{ item!.name }}
    </div>
    <div class="price">
      <span class="symbol">¥</span>
      <span class="data"> {{ item!.prices }} </span>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import router from '../router';

onMounted(() => {
  fimage.value = props.images![0].toString() ?? '';
})


const fimage = ref('')

const props = defineProps({
  images: Array<String>,
  item: Object
})

const goToItem = () => {
  const tid: string = props.item?.id.toString() ?? '';
  const uid: string = props.item?.uid.toString() ?? '';
  router.push({
    path: `/item`,
    query: {
      tid: tid,
      uid: uid
    }
  })
}

</script>

<style scoped>
.item-desc {
  font-weight: bold;
}

.symbol {
  font-weight: bold;
  color: #F00;
}

.data {
  font-weight: bold;
  color: #F00;
}

</style>