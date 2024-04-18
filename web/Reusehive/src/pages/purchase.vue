<template>
  <t-navbar title="我的订单" :fixed="false" />
  <t-list style="max-height: 86vh;overflow: auto;background-color: white">
    <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex" @click="godetail(info.itemId,info.id)">
      <t-image style="width: 72px; height: 72px;" :src="info.imageurl"></t-image>
      <div style="flex: 1; margin-left: 10px;margin-top: 15px" >
        <el-text style="font-size: 18px;">{{info.itemName}}</el-text>
        <div style="font-size: 12px;margin-top: 12px">
          {{info.createTime}}
        </div>

        <t-divider />
      </div>

      <div style="margin-right: 16px; display: grid;margin-bottom:12px ">
        <el-text style="color:#000;font-size: 16px">￥{{info.prices}}</el-text>
      <el-text v-if="info.lock===true"style="color: #40db61;">已完成</el-text>
      <el-text v-if="info.lock!==true" style="color: #eae245">进行中</el-text>
      </div>
    </div>

  </t-list>


</template>
<script setup lang="js">
import {GetpurchaseList} from "../apis/PurchaseApi.ts";
import {onMounted,ref} from "vue";
import {getItemByItemIdApi} from "../apis/ItemApi.ts";
import router from "../router/index.ts";

const List=ref([]);
onMounted(async ()=>{
   await refresh()
   //console.log(List.value)
})
const refresh=async ()=>{
  const res=await GetpurchaseList();
  List.value=[]
  console.log(res)
  if(res.data!==null) for (const info of res.data) {
    const iteminfo= await getItemByItemIdApi({id:info.itemId.toString()})
      const purchaseinfo={
        id:info.id.toString(),
        uid:info.uid.toString(),
        itemId:info.itemId.toString(),
        createTime:info.createTime,
        prices:info.prices,
        lock:info.lock,
        lockTime:info.lockTime,
        itemName:iteminfo.data.item.name,
        itemStatus:iteminfo.data.item.itemStatus,
        imageurl:iteminfo.data.images[0]
      };
      if(purchaseinfo)List.value.push(purchaseinfo);
  }
  return  List;
}

const godetail=(itemid,purchaseid)=>{
  router.push({name:"PurchaseDetail",query:{itemid:itemid,purchaseid:purchaseid}})
}

</script>
<style scoped>

</style>