<template>
  <t-navbar title="我的收藏" :fixed="false" left-arrow @left-click="exit" />
  <t-list style="max-height: 85vh;overflow: auto;background-color: white">
    <div v-for="info in ItemList" style="margin-top: 15px; margin-bottom: 15px;display: flex" @click="GoItemDetail(info.item.id.toString())">
      <t-image style="width: 72px; height: 72px;" :src="info.images[0]"></t-image>
      <div style="flex: 1; margin-left: 10px;margin-top: 15px" >
        <el-text style="font-size: 18px;">{{info.item.name}}</el-text>
        <div style="font-size: 12px;margin-top: 12px">
          {{info.item.itemType}}
        </div>
        <t-divider />
      </div>

    </div>
  </t-list>
</template>
<script setup lang="js">

import {ref} from "vue";
import {getCollections} from "../apis/ItemApi.ts";
import {useRoute} from "vue-router";
import {onMounted} from "vue";
import router from "../router/index.ts";

const route=useRoute();
const ItemList=ref([])
const ImageList=
onMounted(async ()=>{
  await getList()

})
const getList=async ()=>{
  const uid=route.query.uid
  let res
  //if(typeof uid==="string")
     res =await getCollections({uid:uid});
  ItemList.value=res.data
}
const GoItemDetail=(tid)=>{
  const uid=route.query.uid
  router.push({name:"item",query:{uid:uid,tid:tid}})
}
const exit=()=>{
  router.back();
}

</script>
<style scoped>

</style>