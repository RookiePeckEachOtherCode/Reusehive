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

export const $http = async (config: AxiosRequestConfig) => {
    const loadingInstance = ElLoading.service();
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
