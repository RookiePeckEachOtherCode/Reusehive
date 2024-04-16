import Item from "./item";

class ItemDetail {
  item: Item;
  images: Array<String>;

  constructor(item: Item, images: Array<String>) {
    this.item = item;
    this.images = images;
  }
}

export default ItemDetail;
