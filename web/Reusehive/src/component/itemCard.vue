<template>
  <div class="container" @click="goToItem()">
    <div class="item-image">
      <t-image :src="fimage" :style="{ width: '20vh', height: '23vh' }" fit=" cover" shape="round"></t-image>
    </div>
    <svg t="1714378888194" class="icon" viewBox="0 0 1540 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13196" width="32" height="32"><path d="M370.651429 619.337143h153.6v53.76h-153.6z" fill="#FFD900" p-id="13197"></path><path d="M389.12 128.365714c-209.737143-2.011429-386.742857 164.571429-389.12 384.182857 2.56 213.577143 170.971429 383.634286 385.645714 383.085715 214.308571-0.365714 381.988571-169.325714 384-379.794286C771.474286 293.668571 593.188571 130.194286 389.12 128.365714z m-114.468571 607.085715h-51.382858V479.634286c-11.337143 16.091429-23.222857 31.817143-34.742857 45.165714-4.754286-12.8-19.931429-42.24-29.074285-55.588571 39.862857-43.337143 77.897143-110.811429 99.84-177.737143l50.468571 15.177143c-10.057143 27.977143-21.394286 56.502857-35.108571 84.114285v344.685715zM573.988571 731.611429H524.068571v-13.348572h-153.6v14.811429h-48.091428V574.171429H573.988571v157.44z m-6.034285-228.205715v44.251429H329.691429v-44.251429H567.954286z m-238.262857-24.685714v-44.251429H567.954286v44.251429H329.691429z m272.457142-69.485714h-305.737142v-46.08h136.045714c-7.131429-17.554286-19.017143-39.497143-29.44-56.502857l48.091428-18.102858c13.348571 19.565714 27.977143 45.714286 34.742858 62.72l-27.062858 11.885715h143.542858v46.08z" fill="#FFD900" p-id="13198"></path><path d="M1161.325714 361.325714h-2.377143c-11.154286 47.36-23.954286 96.548571-36.937142 141.531429l-12.8 47.36H1212.16l-12.8-47.36c-13.531429-44.982857-25.234286-94.72-38.034286-141.531429z" fill="#FFD900" p-id="13199"></path><path d="M1504.914286 169.508571H667.977143c-4.205714 0-8.96-1.645714-12.434286 2.011429 1.462857 4.937143 5.851429 7.497143 9.508572 10.971429 34.56 33.645714 64.731429 70.582857 90.331428 111.177142 39.314286 61.988571 66.011429 128.365714 71.862857 202.24 6.765714 90.514286-20.48 171.702857-71.862857 245.394286-28.708571 40.96-63.085714 76.8-103.314286 113.737143h857.417143c21.394286-0.548571 31.085714-10.605714 31.085715-31.817143V203.885714c-0.365714-24.137143-10.788571-34.377143-35.657143-34.377143zM1261.348571 728.868571l-30.354285-111.177142h-140.434286l-30.354286 111.177142h-87.771428l138.605714-433.005714h101.851429l139.337142 433.005714h-90.88z" fill="#FFD900" p-id="13200"></path></svg>

    <div class="item-desc" style="margin-top: -10px">
      {{ item!.name }}
    </div>
    <div class="price">
      <span class="symbol">
        <el-text>¥</el-text>
      </span>
      <span class="data">
        <el-text>
          {{ item!.prices }}
        </el-text>
            </span>
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
.container {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  max-width: 20vh;
}

.item-image {
  border-radius: 10px;
}

.item-desc {
  margin-top: 5px;
  margin-left: 5px;
  font-weight: bold;
  max-height: 15vh;
  overflow-y: auto;
}

.price {
  margin-left: 5px;

  .symbol {
    font-size: 15px;
    font-weight: bold;
    color: #F00;
  }

  .data {
    font-size: 15px;
    font-weight: bold;
    color: #F00;
  }
}
</style>
