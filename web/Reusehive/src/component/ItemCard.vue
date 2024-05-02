<template>
  <div class="bg-gray-100 p-5 rounded-2xl my-2">
    <div class="container flex flex-col " @click="goToItem()">
      <img :src="fimage" alt="" class="item-image w-40 sm:w-44"/>
      <div class="item-desc">
        {{ item!.name }}
      </div>
      <div class="price">
        <span class="symbol">¥</span>
        <span class="data"> {{ item!.prices }} </span>
      </div>
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
    name: "item-detail",
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
  max-height: 3rem;
  overflow-wrap: break-word;
  overflow-y: hidden;
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