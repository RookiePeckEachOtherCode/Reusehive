<template>
  <t-navbar :fixed="false" left-arrow title="我的收藏" @left-click="exit"/>
  <t-list style="max-height: 85vh;overflow: auto;background-color: white">
    <div v-for="info in ItemList" style="margin-top: 15px; margin-bottom: 15px;display: flex"
         @click="GoItemDetail(info.item.id.toString())">
      <t-image :src="info.images[0]" style="width: 72px; height: 72px;"></t-image>
      <div style="flex: 1; margin-left: 10px;margin-top: 15px">
        <el-text style="font-size: 18px;">{{ info.item.name }}</el-text>
        <div style="font-size: 12px;margin-top: 12px">
          {{ info.item.itemType }}
        </div>
        <t-divider/>
      </div>

    </div>
  </t-list>
</template>
<script lang="js" setup>

import {onMounted, ref} from "vue";
import {getCollections} from "../apis/ItemApi.ts";
import {useRoute} from "vue-router";
import router from "../router/index.ts";

const route = useRoute();
const ItemList = ref([])
const ImageList =
    onMounted(async () => {
      await getList()

    })
const getList = async () => {
  await getCollections().then(res => {
    ItemList.value = res.data
  })
}
const GoItemDetail = (tid) => {
  const uid = route.query.uid
  router.replace({name: "item", query: {uid: uid, tid: tid}})
}
const exit = () => {
  router.back();
}

</script>
<style scoped>

</style>