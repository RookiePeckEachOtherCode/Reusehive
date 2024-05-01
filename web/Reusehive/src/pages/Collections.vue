<template>
  <div class="flex flex-col">
    <t-navbar :fixed="false" title="我的收藏"/>
    <div v-for="(itemDetail,index) in itemDetails" :key="index">
      <CollectionCard
          :desc="itemDetail.item.description.toString()"
          :firstImageUrl="itemDetail.images[0].toString()"
          :itemStatus="itemDetail.item.itemStatus"
          :prices="itemDetail.item.prices"
      />
    </div>
  </div>
  <!--  <t-list style="max-height: 85vh;overflow: auto;background-color: white">-->
  <!--    <div v-for="info in ItemList" style="margin-top: 15px; margin-bottom: 15px;display: flex"-->
  <!--         @click="GoItemDetail(info.item.id.toString())">-->
  <!--      <t-image :src="info.images[0]" style="width: 72px; height: 72px;"></t-image>-->
  <!--      <div style="flex: 1; margin-left: 10px;margin-top: 15px">-->
  <!--        <el-text style="font-size: 18px;">{{ info.item.name }}</el-text>-->
  <!--        <div style="font-size: 12px;margin-top: 12px">-->
  <!--          {{ info.item.itemType }}-->
  <!--        </div>-->
  <!--        <t-divider/>-->
  <!--      </div>-->

  <!--    </div>-->
  <!--  </t-list>-->
</template>
<script lang="ts" setup>
import {getCollections} from "../apis/ItemApi.ts";
import ItemDetail from "../model/itemDetail.ts";
import {onMounted, ref} from 'vue';
import CollectionCard from "../component/CollectionCard.vue";

const itemDetails = ref(new Array<ItemDetail>());
onMounted(async () => {
  await getCollections().then((res) => {
    if (res.code === 1) {
      itemDetails.value = res.data
    }
  })
})

// const GoItemDetail = (tid) => {
//   const uid = route.query.uid
//   router.push({name: "item", query: {uid: uid, tid: tid}})
// }

</script>
<style scoped>

</style>