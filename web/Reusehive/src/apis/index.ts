import type {AxiosRequestConfig} from 'axios';
import axios, {AxiosError} from "axios";
import JSONbig from 'json-bigint';
import {ElLoading} from "element-plus";
import {Toast} from "tdesign-mobile-vue";

export const httpInstance = axios.create();
// httpInstance.defaults.baseURL = LocalStorage().gethost() ?? "http://127.0.0.1:8888";
httpInstance.defaults.baseURL = "http://127.0.0.1:8888";

httpInstance.defaults.transformResponse = [
    function (data) {
        try {
            return JSONbig.parse(data);
        } catch (error) {
            return data;
        }
    },
];

httpInstance.interceptors.request.use(config => {
    const token = localStorage.getItem('token') ?? '';
    if (token) {
        config.headers['token'] = token;
    }
    return config;
}, error => {
    return Promise.reject(error);
});


export const $http = async (config: AxiosRequestConfig) => {
    const loadingInstance = ElLoading.service();
    //httpInstance.defaults.withCredentials = true;
    try {
        const axiosResponse = await httpInstance(config);
        if (axiosResponse.data.code !== 1) {
            Toast(axiosResponse.data.msg)
        }

        return axiosResponse.data;
    } catch (err) {
        if (err instanceof AxiosError) {
            console.log(err);
            Toast("服务器内部错误,请检查表单是否填满")
        }
    } finally {
        loadingInstance.close();
    }

}
