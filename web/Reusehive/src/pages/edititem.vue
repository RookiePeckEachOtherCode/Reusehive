<template>
  <t-navbar title="编辑物品" :fixed="false" left-arrow @left-click="exit" />
    <t-form
        :data="form"
        class="formLayout"
        label-align="left"
        reset-type="initial"
        show-error-message
        @reset="onReset"
        @submit="save"
    >
      <t-form-item label="展示图"  >
      <div v-for="img in form.images" >
        <t-image :src="img" style="max-height: 100px;max-width: 100px;margin-left: 15px">
        </t-image>
      </div>
      </t-form-item>
      <t-form-item label="物品名">
        <t-input v-model="form.name" :borderless=false placeholder="请输入内容"></t-input>
      </t-form-item>
      <t-form-item label="价格">
        <t-input v-model="form.prices" :borderless=false placeholder="0.00"></t-input>
      </t-form-item>
      <t-form-item label="描述">
        <t-input v-model="form.description" :borderless=false placeholder="输入描述"></t-input>
      </t-form-item>
      <t-form-item label="类型">
        <t-input
            v-model="form.type" :borderless=false placeholder="选择类型" @click="showCascader"></t-input>
        <t-cascader
            v-model:visible="visibleCascader"
            :options="ItemTypeOption[0]"
            :ref="type"
            title="选择物品类型"
            @change="onChangeCascader"
        />
      </t-form-item>
      <t-form-item label="物品id" name="id" >
        {{form.id}}
      </t-form-item>
    </t-form>
  <div class="button-group">
    <t-button size="large" theme="primary" type="submit" @click="save">提交</t-button>
    <t-button size="large" theme="default" type="reset" variant="base" @click="onReset">重置</t-button>
  </div>
</template>
<script setup lang="ts">
import {reactive, onMounted, ref} from "vue";
import {getItemByItemIdApi,UpdateItemInfo} from "../apis/ItemApi.ts";
import {useRoute} from "vue-router";
import ItemTypeOption from "../const/itemTypeOption.ts";
import router from "../router";
const route=useRoute()
const form=reactive({
  id:"",
  name:"",
  prices:0,
  description:"",
  type:"",
  images:[],
})
const visibleCascader = ref(false)
const showCascader = () => {
  visibleCascader.value = true;
};

const exit=()=>{
  router.back();
}
onMounted(async ()=>{
  form.id=<string>route.query.tid
  const res= await getItemByItemIdApi({id:form.id})
  form.name=res.data.item.name;
  form.type=res.data.item.type;
  form.prices=res.data.item.prices
  form.description=res.data.item.data
  form.images=res.data.images
})

const save=async ()=>{
 const res=await UpdateItemInfo({
   id:form.id,
   name:form.name,
   prices:form.prices,
   type:form.type,
   description:form.description
 })
  if(res){router.back()}
}
const onReset=()=>{
  form.description="";
  form.prices=0;
  form.type="";
  form.name="";
}
const onChangeCascader = (value: string, options: any) => {
  form.type = options?.map((item: any) => item.label).join('/');
  visibleCascader.value = false;
  console.log(value)
  if(form.type==='失物招领'){
    console.log(114514)
  }
};
const type = ref("其他")

</script>
<style scoped>
.button-group {
  background-color: white;
  box-sizing: border-box;
  padding: 16px;
  display: flex;
  justify-content: space-between;
  position: relative;
  border-bottom: 0.5px solid #e7e7e7;

  .t-button {
    height: 32px;
    flex: 1;

    &:not(:last-child) {
      flex: 1;
      margin-right: 16px;
    }
  }
}
</style>