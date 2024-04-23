import BaseItem from "./baseItem.ts";

class ItemDetail {
    item: BaseItem;
    images: Array<String>;

    constructor(item?: BaseItem, images?: Array<String>) {
        this.item = item || new BaseItem();
        this.images = images || [];
    }
}

export default ItemDetail;
