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
                    <t-input align="right" placeholder="0.00" suffix="元" v-model="formData.prices" />
                </t-form-item>
                <t-form-item labelWidth="5">
                    <t-cell arrow title="选择类型" :note="itemType.type.join('')" @click="itemType.show = true"
                        v-model="formData.itemType" />

                    <t-popup v-model="itemType.show" placement="bottom">
                        <t-picker v-model="itemType.type" :columns="ItemTypeOption" @confirm="onConfirm"
                            @cancel="itemType.show = false" />
                    </t-popup>
                </t-form-item>
                <t-form-item label="上传照片" name="photo">
                    <t-upload class="upload"></t-upload>
                </t-form-item>
                <div class="submit">
                    <t-button class="submit-bt" theme="primary" type="submit">发布</t-button>
                </div>

            </t-form>
        </div>
    </div>
</template>
<script setup lang="ts">
import { reactive } from "vue";
import router from '../router';
import ItemTypeOption from '../const/itemTypeOption';

const itemType = reactive({
    show: false,
    type: []
})

const formData = reactive({
    name: '',
    description: '',
    prices: '',
    itemType: '',
})

const onConfirm = () => {
    itemType.show = false;
}

const goBack = () => {
    router.back()
}

const onSubmit = () => {
    console.log('Dont touch me!!!!!')
    console.log("It is unfinished")
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
