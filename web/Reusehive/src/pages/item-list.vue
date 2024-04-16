<template>
    <div class="item-list-container">
        <div class="item-list" v-for="it in itemDetails">
            <itemCard :item="it.item" :fImage="it.images[0].toString"></itemCard>
        </div>
    </div>
</template>

<script setup lang="ts">
import { getAllItemsApi, getItemImageApi } from '../apis/ItemApi'
import Item from '../model/item';
import { onMounted, ref } from 'vue';
import ItemDetial from '../model/itemDetial';
import itemCard from '../layout/itemCard.vue'
let itemDetails = ref(new Array<ItemDetial>);


onMounted(() => {
    getAll();
})


const getAll = async () => {
    let items = new Array<Item>;
    await getAllItemsApi().then(res => {
        items = res.data;
    });

    items.forEach((item: Item) => {
        getItemImageApi({ id: item.id }).then(res => {
            itemDetails.value.push(
                new ItemDetial(item, res.data)
            )
        });
    })
}

</script>

<style scoped></style>