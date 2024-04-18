import { $http } from "./index";

export const loginApi = (data: { password: string; username: string }) => {
  return $http({
    method: "post",
    url: "http://127.0.0.1:4523/m1/4280410-3922518-default/user/login",
    params: data,
    headers: {},
  });
};

export const registerApi = (data: { password: string; username: string }) => {
  return $http({
    method: "post",
    url: "http://127.0.0.1:4523/m1/4280410-0-default/user/register",
    params: data,
  });
};

export const userChatInfoApi = () => {
  return $http({
    method: "get",
    url: "http://127.0.0.1:4523/m1/4280410-0-default/user/chatsinfo",
  });
};

export const getUserInfoByUidApi = (data: { id: string }) => {
  const url = "http://127.0.0.1:4523/m1/4280410-0-default/user/" + data.id;
  return $http({
    method: "get",
    url: url,
  });
};
export const getUserInfoByName=(data:{name:string})=>{
    return $http({
      method:"get",
      params:data,
      url:"http://127.0.0.1:4523/m1/4280410-0-default/user/name/1",
    })

}
export const UploadUserInfo=(data:{
  formdata:{
    name:string,
    password:string,
    grade:string,
    academy:string,
    phone_number:string,
    social_info:string,
    avatar_img:string,
    back_img:string,
  }
})=>{
  return $http({
    method:"post",
    params:data,
    url:"http://127.0.0.1:4523/m1/4280410-0-default/user/update",
  })
}