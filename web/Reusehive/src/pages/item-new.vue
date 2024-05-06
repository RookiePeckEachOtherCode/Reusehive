<template>
  <div class="item-new-container">
    <div class="navbar">
      <t-navbar :fixed="false" left-arrow title="发布闲置" @left-click="goBack"/>
    </div>

    <div class="item-form">
      <t-form label-align="left" reset-type="initial" show-error-message @submit="onSubmit">
        <t-form-item label="名称" name="name">
          <t-input v-model="formData.name" align="right" borderless placeholder="请输入内容"></t-input>
        </t-form-item>
        <p>描述</p>
        <t-form-item labelWidth="5" name="description">
          <t-textarea v-model="formData.description" autosize class="des"></t-textarea>
        </t-form-item>
        <t-form-item label="价格" name="prices">
          <t-input v-model="formData.prices" :disabled="disablepirce" align="right" placeholder="0.00" suffix="元"/>
        </t-form-item>
        <t-form-item label="物品类型" labelWidth="5">
          <t-input
              v-model="formData.itemType" :borderless=false placeholder="选择类型"
              @click="showCascader"></t-input>
          <t-cascader
              :ref="type"
              v-model:visible="visibleCascader"
              :options="ItemTypeOption[0]"
              title="选择物品类型"
              @change="onChangeCascader"
          />
        </t-form-item>
        <p>上传图片</p>
        <t-form-item labelWidth="5" name="images">
          <t-upload :autoUpload="false" :beforeUpload="beforeUpload" :max="15" :onRemove="onRemove"
                    multiple></t-upload>
        </t-form-item>
        <div class="submit">
          <t-button class="submit-bt" theme="primary" @click="onSubmit">发布</t-button>
        </div>
      </t-form>
    </div>
  </div>
</template>
<script lang="ts" setup>
import {reactive, ref} from "vue";
import router from '../router';
import ItemTypeOption from '../const/itemTypeOption';
import {newItemApi} from "../apis/ItemApi";

const disablepirce = ref(false)

const formData = reactive({
  name: '',
  description: '',
  prices: '',
  itemType: '',
})

const visibleCascader = ref(false)
const type = ref("其他")
const showCascader = () => {
  visibleCascader.value = true;
};
const onChangeCascader = (value: string, options: any) => {
  formData.itemType = options?.map((item: any) => item.label).join('/');
  visibleCascader.value = false;
  console.log(value)
  if (formData.itemType === '失物招领') {
    formData.prices = "0";
    disablepirce.value = true
  } else disablepirce.value = false;
};
const goBack = () => {
  router.push({
    path: "/item-list"
  })
}
const onSubmit = () => {

  const data = {
    name: formData.name,
    description: formData.description,
    prices: formData.prices,
    itemType: formData.itemType,
    images: files
  }

  newItemApi(data).then(res => {
    if (res.data.code == 1) {
      console.log('发布成功')
    } else {
      console.log('发布失败')
    }
    router.push({
      path: "/item-list"
    })
  })
}

var files = reactive(Array<any>())
const beforeUpload = (file: any) => {
  files.push(file)
  return true
}
const onRemove = (index: number) => {
  files.splice(index, 1)
}

</script>
<style scoped>
.item-new-container {
  display: flex;
  flex-direction: column;
}

p {
  margin-top: 10px;
  padding-left: 16px;
}

.des {
  height: 25vh;
}

.submit {
  display: flex;
  position: fixed;
  bottom: 5px;
  width: 80%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-left: 10%;
  margin-right: 10%;
}

.submit-bt {
  width: 80%;
  background-color: #a1de93;
  --td-button-primary-border-color: #a1de93;
}

.t-form__controls {
  margin-left: 0px;
}

.t-form__controls {
  margin-left: 0px;

}
</style>
