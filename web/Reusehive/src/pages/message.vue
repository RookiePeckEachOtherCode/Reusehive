<template>
  <t-navbar title="消息记录" :fixed="false"></t-navbar>
  <t-pull-down-refresh v-model="refreshing" @refresh="loadData" style="max-height: 688px;min-height: 688px;background-color: white" >
    <t-list :async-loading="loading" >
      <t-cell v-for="item in List" :key="item.id">
        <el-avatar src="{{item.avatar_img}}" style="position: absolute;padding: 0;left: 0;margin-left: 10px"></el-avatar>
        <span class="cell" @click="gochat(item.name)">{{ item.name }}</span>
      </t-cell>
    </t-list>
  </t-pull-down-refresh>
</template>

<script setup lang="ts">
import {userChatInfoApi} from "../apis/UserApi.ts";
import {onMounted, ref} from "vue";
import router from "../router";
const loading = ref('');
const refreshing = ref(false);
const List=ref([])
onMounted(async ()=>{
  await loadData();
})
const loadData=async ()=>{
  const res=await userChatInfoApi();
  List.value=res.data;
  return true;
}
const gochat=(name:string)=>{
  router.push({name:"chat",query:{tousername:name}});

}



</script>
<style scoped>

</style>