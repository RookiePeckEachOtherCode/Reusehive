<template>
    <div class="item-new-container">
        <div class="navbar">
            <t-navbar :fixed="false" title="发布闲置" left-arrow @left-click="goBack" />
        </div>

        <div class="item-form">
            <t-form reset-type="initial" show-error-message label-align="left" @submit="onSubmit">
                <t-form-item label="名称" name="name">
                    <t-input align="right" borderless placeholder="请输入内容" v-model="formData.name"></t-input>
                </t-form-item>
                <p>描述</p>
                <t-form-item name="description" labelWidth="5">
                    <t-textarea class="des" autosize v-model="formData.description"></t-textarea>
                </t-form-item>
                <t-form-item name="prices" label="价格">
                    <t-input :disabled="disablepirce" align="right" placeholder="0.00" suffix="元" v-model="formData.prices" />
                </t-form-item>
                <t-form-item labelWidth="5" label="物品类型">
                  <t-input
                      v-model="formData.itemType" :borderless=false placeholder="选择类型"
                      @click="showCascader"></t-input>
                  <t-cascader
                      v-model:visible="visibleCascader"
                      :options="ItemTypeOption[0]"
                      :ref="type"
                      title="选择物品类型"
                      @change="onChangeCascader"
                  />
                </t-form-item>
                <p>上传图片</p>
                <t-form-item name="images" labelWidth="5">
                    <t-upload multiple :max="15" :autoUpload="false" :beforeUpload="beforeUpload"
                        :onRemove="onRemove"></t-upload>
                </t-form-item>
                <div class="submit">
                    <t-button class="submit-bt" theme="primary" @click="onSubmit">发布</t-button>
                </div>
            </t-form>
        </div>
    </div>
</template>
<script setup lang="ts">
import { reactive,ref } from "vue";
import router from '../router';
import ItemTypeOption from '../const/itemTypeOption';
import { newItemApi } from "../apis/ItemApi";

const disablepirce=ref(false)

const formData = reactive({
    name: '',
    description: '',
    prices: '',
    itemType:'',
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
  if(formData.itemType==='失物招领'){
    formData.prices="0";
    disablepirce.value=true
  }else disablepirce.value=false;
};
const goBack = () => {
    router.back()
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
            path: '/main/item-list'
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
