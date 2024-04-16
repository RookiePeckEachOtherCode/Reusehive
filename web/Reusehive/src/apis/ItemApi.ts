import { $http } from "./index";

export const getAllItemsApi = () => {
  return $http({
    method: "get",
    url: "http://127.0.0.1:4523/m1/4280410-0-default/item/all",
    headers: {},
  });
};

export const getItemImageApi = (data: { id: String }) => {
  return $http({
    method: "get",
    url: "http://127.0.0.1:4523/m1/4280410-0-default/item/image",
    params: data,
    headers: {},
  });
};
