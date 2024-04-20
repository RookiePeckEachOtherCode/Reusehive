<template>
    <div class="container" @click="goToItem()">
        <div class="item-image">
            <t-image shape="round" :src="fimage" fit=" cover" :style="{ width: '20vh', height: '25vh' }"></t-image>
        </div>
        <div class="item-desc">
            {{ item!.description }}
        </div>
        <div class="price">
            <span class="symbol">¥</span>
            <span class="data">
                {{ item!.prices }}
            </span>
        </div>
    </div>

</template>

<script setup lang="ts">
import { defineProps, onMounted, ref } from 'vue';
import router from '../router';

onMounted(() => {
    fimage.value = props.images![0].toString() ?? '';
})


const fimage = ref('')

const props = defineProps({
    images: Array<String>,
    item: Object
})

const goToItem = () => {
    const tid: string = props.item?.id.toString() ?? '';
    const uid: string = props.item?.uid.toString() ?? '';
    router.push({
        path: `/item`,
        query: {
            tid: tid,
            uid: uid
        }
    })
}

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    max-width: 20vh;
}

.item-image {
    border-radius: 10px;
}

.item-desc {
    margin-top: 5px;
    margin-left: 5px;
    font-weight: bold;
    max-height: 15vh;
    overflow-y: auto;
}

.price {
    margin-left: 5px;

    .symbol {
        font-size: 15px;
        font-weight: bold;
        color: #F00;
    }

    .data {
        font-size: 25px;
        font-weight: bold;
        color: #F00;
    }
}
</style>
