<template>
  <div class="flex flex-col">
    <t-navbar :fixed="false" title="我的订单"/>

    <svg class="icon" height="256" p-id="5466"
         style="position: absolute;z-index: -1;margin-top: 20vh;margin-left: 18vw" t="1713924219532" version="1.1"
         viewBox="0 0 1024 1024" width="256" xmlns="http://www.w3.org/2000/svg">
      <path
          d="M608.8 336.8h29.5c8 0 14.5 6.9 14.5 15.5v350.6c0 8.5-6.5 15.5-14.5 15.5H353.4c-8 0-14.5-6.9-14.5-15.5V352.3c0-8.5 6.5-15.5 14.5-15.5h31.1"
          fill="#BAF4EA" p-id="5467"></path>
      <path
          d="M686.4 805.8H305.3c-32 0-58.1-26.1-58.1-58.1v-443c0-32 26.1-58.1 58.1-58.1h34c15.5 0 28 12.5 28 28s-12.5 28-28 28h-34c-1.2 0-2.1 0.9-2.1 2.1v443c0 1.2 0.9 2.1 2.1 2.1h381.1c1.2 0 2.1-0.9 2.1-2.1v-443c0-1.2-0.9-2.1-2.1-2.1h-31.8c-15.5 0-28-12.5-28-28s12.5-28 28-28h31.8c32 0 58.1 26.1 58.1 58.1v443c0 32.1-26 58.1-58.1 58.1z"
          fill="#2D5B56" p-id="5468"></path>
      <path
          d="M548.3 302.6h-119c-15.5 0-28-12.5-28-28s12.5-28 28-28h119c15.5 0 28 12.5 28 28s-12.5 28-28 28zM498.9 656.5h-95.5c-15.5 0-28-12.5-28-28s12.5-28 28-28h95.5c15.5 0 28 12.5 28 28s-12.5 28-28 28zM588.3 550.9H403.4c-15.5 0-28-12.5-28-28s12.5-28 28-28h184.9c15.5 0 28 12.5 28 28s-12.5 28-28 28zM588.3 443.6H403.4c-15.5 0-28-12.5-28-28s12.5-28 28-28h184.9c15.5 0 28 12.5 28 28s-12.5 28-28 28zM151.3 124.3c12 0 21.7 9.7 21.7 21.7s-9.7 21.7-21.7 21.7-21.7-9.7-21.7-21.7 9.8-21.7 21.7-21.7m0-40c-34 0-61.7 27.7-61.7 61.7s27.7 61.7 61.7 61.7S213 180 213 146s-27.6-61.7-61.7-61.7zM834.8 186.9h-0.2c-8.3-0.1-14.9-6.9-14.8-15.2l1-69.5c0.1-8.2 6.8-14.8 15-14.8h0.2c8.3 0.1 14.9 6.9 14.8 15.2l-1 69.5c-0.1 8.2-6.8 14.8-15 14.8z"
          fill="#2D5B56" p-id="5469"></path>
      <path
          d="M885.1 137.6v0.2c-0.1 8.3-6.9 14.9-15.2 14.8l-69.5-1c-8.2-0.1-14.8-6.8-14.8-15v-0.2c0.1-8.3 6.9-14.9 15.2-14.8l69.5 1c8.2 0.1 14.8 6.8 14.8 15z"
          fill="#2D5B56" p-id="5470"></path>
      <path d="M867.6 483.6m-30.9 0a30.9 30.9 0 1 0 61.8 0 30.9 30.9 0 1 0-61.8 0Z" fill="#2D5B56" p-id="5471"></path>
      <path d="M888.6 898.1m-20.7 0a20.7 20.7 0 1 0 41.4 0 20.7 20.7 0 1 0-41.4 0Z" fill="#2D5B56" p-id="5472"></path>
      <path
          d="M123.6 837.6v30.8M123.6 878.4c-5.5 0-10-4.5-10-10v-30.8c0-5.5 4.5-10 10-10s10 4.5 10 10v30.8c0 5.5-4.4 10-10 10zM123.6 920.2v30.7M123.6 960.9c-5.5 0-10-4.5-10-10v-30.8c0-5.5 4.5-10 10-10s10 4.5 10 10v30.8c0 5.6-4.4 10-10 10zM67 894.3h30.7M97.7 904.3H67c-5.5 0-10-4.5-10-10s4.5-10 10-10h30.8c5.5 0 10 4.5 10 10s-4.5 10-10.1 10zM149.5 894.3h30.8M180.3 904.3h-30.8c-5.5 0-10-4.5-10-10s4.5-10 10-10h30.8c5.5 0 10 4.5 10 10s-4.5 10-10 10z"
          fill="#2D5B56" p-id="5473"></path>
      <path
          d="M83.6 934.3l21.7-21.7M83.6 944.3c-2.6 0-5.1-1-7.1-2.9-3.9-3.9-3.9-10.2 0-14.1l21.8-21.8c3.9-3.9 10.2-3.9 14.1 0 3.9 3.9 3.9 10.2 0 14.1l-21.8 21.8c-1.9 2-4.5 2.9-7 2.9z"
          fill="#2D5B56" p-id="5474"></path>
      <path
          d="M142 876l21.7-21.8M142 886c-2.6 0-5.1-1-7.1-2.9-3.9-3.9-3.9-10.2 0-14.1l21.8-21.8c3.9-3.9 10.2-3.9 14.1 0 3.9 3.9 3.9 10.2 0 14.1L149 883c-1.9 2-4.5 3-7 3z"
          fill="#2D5B56" p-id="5475"></path>
      <path
          d="M163.7 934.3L142 912.6M163.7 944.3c-2.6 0-5.1-1-7.1-2.9l-21.8-21.8c-3.9-3.9-3.9-10.2 0-14.1 3.9-3.9 10.2-3.9 14.1 0l21.8 21.8c3.9 3.9 3.9 10.2 0 14.1-1.9 2-4.4 2.9-7 2.9z"
          fill="#2D5B56" p-id="5476"></path>
      <path
          d="M105.3 876l-21.7-21.8M105.3 886c-2.6 0-5.1-1-7.1-2.9l-21.8-21.8c-3.9-3.9-3.9-10.2 0-14.1 3.9-3.9 10.2-3.9 14.1 0l21.8 21.8c3.9 3.9 3.9 10.2 0 14.1-1.8 1.9-4.4 2.9-7 2.9z"
          fill="#2D5B56" p-id="5477"></path>
    </svg>
    <t-list style="max-height: 85vh;overflow: auto;background-color: white;background-color: rgba(255,255,255,0.35)">
      <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex"
           @click="godetail(info.itemId,info.id)">
        <!--        <t-image :src="info.imageurl" fit="fill" style="width: 72px; height: 72px;"></t-image>-->
        <img :src="info.imageurl" alt=""
             class="w-28 h-24 object-cover rounded-xl mx-2">
        <div style="flex: 1; margin-left: 10px;margin-top: 15px">
          <el-text style="font-size: 18px;">{{ info.itemName }}</el-text>
          <div style="font-size: 12px;margin-top: 12px">
            {{ info.createTime }}
          </div>

          <t-divider/>
        </div>

        <div style="margin-right: 16px; display: grid;margin-bottom:12px ">
          <el-text style="color:#ff0000;font-size: 16px">￥{{ info.prices }}</el-text>
          <el-text v-if="info.lock===true" style="color: #84cc16;">已完成</el-text>
          <el-text v-if="info.lock!==true" style="color: #f59e0b">进行中</el-text>
        </div>
      </div>

    </t-list>
  </div>

</template>
<script lang="js" setup>
import {GetpurchaseList} from "../apis/PurchaseApi.ts";
import {onMounted, ref} from "vue";
import {getItemByItemIdApi} from "../apis/ItemApi.ts";
import router from "../router/index.ts";
import {Toast} from "tdesign-mobile-vue";

const List = ref([]);

onMounted(async () => {
  await refresh()
  //console.log(List.value)
})
const refresh = async () => {
  const res = await GetpurchaseList();
  if (res.code !== 1) Toast(res.msg)
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