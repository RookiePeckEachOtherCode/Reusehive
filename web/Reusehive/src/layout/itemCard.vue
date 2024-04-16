<template>
    <div class="container">
        <div class="item-card">
            <div class="item-card-image">
                <img :src="props.fImage" alt="item image">
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import Item from '../model/item.ts'

let props = defineProps({
    item: Item,
    fImage: String
})
</script>
