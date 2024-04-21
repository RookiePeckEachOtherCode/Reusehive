import { $http } from "./index";

export const getAllItemsApi = () => {
  return $http({
    method: "get",
    url: "http://127.0.0.1:4523/m1/4280410-0-default/item/all",
  });
};

export const getItemByItemIdApi = (data: { id: string }) => {
  const url = "http://127.0.0.1:4523/m1/4280410-0-default/item/" + data.id;
  return $http({
    method: "get",
    url: url,
  });
};

export const newItemApi = (data: {
  name: String;
  description: String;
  prices: String;
  itemType: String;
  images: Array<any>;
}) => {
  var formData = new FormData();
  for (let i = 0; i < data.images.length; i++) {
    formData.append("images", data.images[i].raw);
  }

  formData.append("name", data.name.toString());
  formData.append("description", data.description.toString());
  formData.append("prices", data.prices.toString());
  formData.append("itemType", data.itemType.toString());

  return $http({
    data: formData,
    method: "post",
    url: "http://127.0.0.1:8888/item/new",
  });
};
export const getCollections=(data:{uid:string})=>{
  return $http({
    url:"http://127.0.0.1:4523/m1/4280410-0-default/item/collection/query",
    method:"get",
    params:data
  })
}
export const isCollected=(data:{uid:string,item_id:string})=>{
  return $http({
    url:"http://127.0.0.1:4523/m1/4280410-0-default/item/collection/collected",
    method:"get",
    params:data
  })
}
export const addCollection=(data:{uid:string,item_id:string})=>{
  return $http({
    url:"http://127.0.0.1:4523/m1/4280410-0-default/item/collection/add",
    method:"post",
    params:data
  })
}
export const deleteCollection=(data:{uid:string,item_id:string})=>{
  return $http({
    url:"http://127.0.0.1:4523/m1/4280410-0-default/item/collection/delete",
    method:"post",
    params:data
  })
}

export const SerachItem=(data:{condition:string})=>{
  return $http({
    url:"http://127.0.0.1:4523/m1/4280410-0-default/item/search",
    method:"get",
    params:data
  })
}