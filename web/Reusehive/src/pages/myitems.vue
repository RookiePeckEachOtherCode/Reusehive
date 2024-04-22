<template>
  <t-navbar title="我的出售" :fixed="false" left-arrow @left-click="exit" />
  <t-list style="max-height: 85vh;overflow: auto;background-color: white">
    <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex" >
     <t-cell>

      <t-image style="width: 72px; height: 72px;" :src="info.images[0]" @click="GoItemDetail(info.item.id.toString())"></t-image>
      <div style="flex: 1; margin-left: 10px;margin-top: 15px" @click="GoItemDetail(info.item.id.toString())" >
        <el-text style="font-size: 18px;" >{{info.item.name}}</el-text>
        <div style="font-size: 12px;margin-top: 12px">
          {{info.item.itemType}}
        </div>

      </div>
      <div style="display: grid;margin-right: 15px">
        <el-text style="color:#ea6348;justify-self: center">标价:{{info.item.prices}}￥</el-text>
        <el-button type="primary" style="z-index: 1;margin-top: 10px" @click="goedit(info.item.id.toString())">编辑</el-button>
      </div>

     </t-cell>
      <t-divider />
    </div>

  </t-list>
</template>
<script setup lang="js">
import {getUserInfoByName} from "../apis/UserApi.ts";
import {reactive,ref,onMounted} from "vue";
import {LocalStorage} from "../storage/LocalStorage.ts";
import {getUserItemList} from "../apis/UserApi.ts";
import router from "../router/index.ts";
const userinfo=reactive({
  id:"",
  name:"",
})
const List=ref([])
onMounted(async ()=>{
  userinfo.name=LocalStorage().getusername()
  let res=await getUserInfoByName({name:LocalStorage().getusername()})
  userinfo.id=res.data.id.toString()
  res=await getUserItemList({id:userinfo.id})
  List.value=res.data

})
const GoItemDetail=(tid)=>{
  router.push({name:"item",query:{uid:userinfo.id,tid:tid}})
}
const exit=()=>{
  router.back();
}
const goedit=(tid)=>{
  router.push({name:"edititems",query:{tid:tid}})
}
</script>

<style scoped>

</style>