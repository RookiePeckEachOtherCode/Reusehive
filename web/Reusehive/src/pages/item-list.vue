<template>
    <div class="item-list-container">
        <div class="item-list" v-for="item in items">
            <itemCard :images="item.images" :item="item.item"></itemCard>
        </div>
    </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue';
import itemCard from '../component/itemCard.vue'
import Item from "../model/item.ts";
import { getAllItemsApi } from "../apis/ItemApi.ts";

let items = ref(new Array<Item>());



onMounted(async () => {
    await getAll();
})

let isLoading = ref(false);
const CACHE_DURATION = 5 * 60 * 1000; // 5分钟

const isCacheValid = () => {
    const cacheTimestamp = localStorage.getItem('cacheItemTimestamp');
    if (!cacheTimestamp) return false;
    const timestamp = parseInt(cacheTimestamp);
    return Date.now() - timestamp <= CACHE_DURATION;
};



const getAll = async () => {
    if (isLoading.value || isCacheValid()) {
        items.value = JSON.parse(localStorage.getItem('itemDetails') || '[]');
        return;
    }

    isLoading.value = true;

    items.value = await getAllItemsApi().then(res => {
        console.log(res.data);
        return res.data;
    })

    localStorage.setItem('itemDetails', JSON.stringify(items.value));
    localStorage.setItem('cacheItemTimestamp', Date.now().toString());

    isLoading.value = false;
};


</script>

<style scoped>
.item-list-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-top: 10px;
}
</style>