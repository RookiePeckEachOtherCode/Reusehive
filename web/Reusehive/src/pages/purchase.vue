<template>
  <t-navbar :fixed="false" title="我的订单"/>
  <t-image src="https://iconfont.alicdn.com/auth/illus/file/uROzvnLLp3G9/e4b8fb0e-396d-4954-a52f-7c845aed63c3_origin.svg?auth_key=1713875400-0-0-8cfc0d5f7b01d81a28f5e499acb34075"
           style="position: absolute;z-index: -1;margin-top: 15vh;margin-left: 12vw">
  </t-image>
  <t-list style="max-height: 85vh;overflow: auto;background-color: white;background-color: rgba(255,255,255,0.35)">
    <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex"
         @click="godetail(info.itemId,info.id)">
      <t-image :src="info.imageurl" fit="fill" style="width: 72px; height: 72px;"></t-image>
      <div style="flex: 1; margin-left: 10px;margin-top: 15px">
        <el-text style="font-size: 18px;">{{ info.itemName }}</el-text>
        <div style="font-size: 12px;margin-top: 12px">
          {{ info.createTime }}
        </div>

        <t-divider/>
      </div>

      <div style="margin-right: 16px; display: grid;margin-bottom:12px ">
        <el-text style="color:#000;font-size: 16px">￥{{ info.prices }}</el-text>
        <el-text v-if="info.lock===true" style="color: #40db61;">已完成</el-text>
        <el-text v-if="info.lock!==true" style="color: #eae245">进行中</el-text>
      </div>
    </div>

  </t-list>


</template>
<script lang="js" setup>
import {GetpurchaseList} from "../apis/PurchaseApi.ts";
import {onMounted, ref} from "vue";
import {getItemByItemIdApi} from "../apis/ItemApi.ts";
import router from "../router/index.ts";

const List = ref([]);

onMounted(async () => {
  await refresh()
  //console.log(List.value)
})
const refresh = async () => {
  const res = await GetpurchaseList();
  List.value = []
  console.log(res)
  if (res.data !== null) for (const info of res.data) {
    const iteminfo = await getItemByItemIdApi({id: info.itemId.toString()})
    const purchaseinfo = {
      id: info.id.toString(),
      uid: info.uid.toString(),
      itemId: info.itemId.toString(),
      createTime: info.createTime,
      prices: info.prices,
      lock: info.lock,
      lockTime: info.lockTime,
      itemName: iteminfo.data.item.name,
      itemStatus: iteminfo.data.item.itemStatus,
      imageurl: iteminfo.data.images[0]
    };
    if (purchaseinfo) List.value.push(purchaseinfo);
  }
  return List;
}

const godetail = (itemid, purchaseid) => {
  router.push({name: "PurchaseDetail", query: {itemid: itemid, purchaseid: purchaseid}})
}

</script>
<style scoped>

</style>