import {ElNotification} from 'element-plus'

export function notify_err(msg: string) {
    ElNotification({
        title: 'Error',
        message: msg,
        type: 'error',
        position: 'top-left',
    })
}