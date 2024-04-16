import Item from "./item";

class ItemDetial {
  item: Item;
  images: Array<String>;

  constructor(item: Item, images: Array<String>) {
    this.item = item;
    this.images = images;
  }
}

export default ItemDetial;
