import type {AxiosRequestConfig} from 'axios';
import axios, {AxiosError} from "axios";
import JSONbig from 'json-bigint';
import {ElLoading, ElMessage} from "element-plus";

export const httpInstance = axios.create();

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
    httpInstance.defaults.withCredentials = true;
    try {
        const axiosResponse = await httpInstance(config);
        return axiosResponse.data;
    } catch (err) {
        if (err instanceof AxiosError) {
            console.log(err);
            ElMessage.error("请求异常")
        }
    } finally {
        loadingInstance.close();
    }

}
