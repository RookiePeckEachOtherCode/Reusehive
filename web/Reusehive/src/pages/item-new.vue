<template>
    <div class="item-new-container">
        <div class="navbar">
            <t-navbar :fixed="false" title="发布闲置" left-arrow @left-click="goBack" />
        </div>

        <div class="item-form">
            <t-form ref="form" reset-type="initial" show-error-message label-align="left">
                <t-form-item label="名称" name="name">
                    <t-input align="right" borderless placeholder="请输入内容"></t-input>
                </t-form-item>
                <p>描述</p>
                <t-form-item name="description" labelWidth="5">
                    <t-textarea class=" des" autosize></t-textarea>
                </t-form-item>
                <t-form-item name="prices" label="价格">
                    <t-input align="right" placeholder="0.00" suffix="元" />
                </t-form-item>
                <t-form-item labelWidth="5">
                    <t-cell arrow title="选择类型" :note="itemTypeStatus.type" @click="itemTypeStatus.show = true" />
                </t-form-item>
                <div class="submit">
                    <t-button class="submit-bt" theme="primary">发布</t-button>
                </div>
            </t-form>
        </div>
    </div>
</template>
<script setup lang="ts">
import { reactive } from "vue";
import router from '../router';

const itemTypeStatus = reactive({
    show: false,
    type: ''
})

const form = reactive({
    name: String,
    description: String,
    prices: Number,
    itemType: String
})

const goBack = () => {
    router.back()
}

</script>
<style scoped>
.item-new-container {
    display: flex;
    flex-direction: column;
}

p {
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
