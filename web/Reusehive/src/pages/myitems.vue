<template>
  <t-navbar :fixed="false" left-arrow title="我的出售" @left-click="exit"/>
  <t-list style="max-height: 85vh;overflow: auto;background-color: white">
    <div v-for="info in List" style="margin-top: 15px; margin-bottom: 15px;display: flex">
      <t-cell>

        <t-image :src="info.images[0]" style="width: 72px; height: 72px;"
                 @click="GoItemDetail(info.item.id.toString())"></t-image>
        <div style="flex: 1; margin-left: 10px;margin-top: 15px" @click="GoItemDetail(info.item.id.toString())">
          <el-text style="font-size: 18px;">{{ info.item.name }}</el-text>
          <div style="font-size: 12px;margin-top: 12px">
            {{ info.item.itemType }}
          </div>

        </div>
        <div style="display: grid;margin-right: 15px">
          <el-text style="color:#ea6348;justify-self: center">标价:{{ info.item.prices }}￥</el-text>
          <el-button style="z-index: 1;margin-top: 10px" type="primary" @click="goedit(info.item.id.toString())">编辑
          </el-button>
        </div>

      </t-cell>
      <t-divider/>
    </div>

  </t-list>
</template>
<script lang="js" setup>
import {getUserInfoByName, getUserItemList} from "../apis/UserApi.ts";
import {onMounted, reactive, ref} from "vue";
import {LocalStorage} from "../storage/LocalStorage.ts";
import router from "../router/index.ts";

const userinfo = reactive({
  id: "",
  name: "",
})
const List = ref([])
onMounted(async () => {
  userinfo.name = LocalStorage().getusername()
  let res = await getUserInfoByName({name: LocalStorage().getusername()})
  userinfo.id = res.data.id.toString()
  res = await getUserItemList({id: userinfo.id})
  List.value = res.data

})
const GoItemDetail = (tid) => {
  router.push({name: "item", query: {uid: userinfo.id, tid: tid}})
}
const exit = () => {
  router.back();
}
const goedit = (tid) => {
  // router.push({name:"edititems",query:{tid:tid}})
  router.push({name: "item-edit", query: {tid: tid}})
}
</script>

<style scoped>

</style>