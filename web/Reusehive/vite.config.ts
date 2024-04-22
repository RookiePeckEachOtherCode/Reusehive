import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import { internalIpV4 } from "internal-ip";
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import { TDesignResolver } from 'unplugin-vue-components/resolvers';
import { VantResolver } from '@vant/auto-import-resolver';
// @ts-expect-error process is a nodejs global
const mobile = !!/android|ios/.exec(process.env.TAURI_ENV_PLATFORM);

// https://vitejs.dev/config/
export default defineConfig(async () => ({
    devServer: {
        open: true, // 构建完成自动打开浏览器
        openPage: '/login', // 打开指定页面路径
        //   compress: true,   // 开启gzip压缩
        disableHostCheck: true,
        host: '10.13.123.123',
        port: 1420,
        https: false, // 开启https代理
        hotOnly: false, // 热模块更新作用
        proxy: {
            '/api': {  //这个无中生有的api表示浏览器在请求资源（图片、文件、接口）时检测到请求路径中有api就要将请求的前半部分替换成target配的地址，披着123.123的壳子去请求456.456的资源
                target: 'http://0.0.0.0:8888/',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        },
        before: app => {}
    },
  plugins: [
      vue(),
      AutoImport({
          resolvers: [
              ElementPlusResolver(),
              TDesignResolver({
                  library: 'mobile-vue'
              }),
              VantResolver(),
          ],
      }),
      Components({
          resolvers: [
              ElementPlusResolver(),
              TDesignResolver({
                  library: 'mobile-vue'
              }),
              VantResolver(),
          ],
      }),
  ],

  // Vite options tailored for Tauri development and only applied in `tauri dev` or `tauri build`
  //
  // 1. prevent vite from obscuring rust errors
  clearScreen: false,
  // 2. tauri expects a fixed port, fail if that port is not available
  server: {
    port: 1420,
      open:true,
      openPage:"/login",
      disableHostCheck: true,
    strictPort: true,
    host: mobile ? "0.0.0.0" : false,
    hmr: mobile
      ? {
          protocol: "ws",
          host: await internalIpV4(),
          port: 1421,
        }
      : undefined,
    watch: {
      // 3. tell vite to ignore watching `src-tauri`
      ignored: ["**/src-tauri/**"],
    },
      proxy:{
          '/api': {  //这个无中生有的api表示浏览器在请求资源（图片、文件、接口）时检测到请求路径中有api就要将请求的前半部分替换成target配的地址，披着123.123的壳子去请求456.456的资源
              target: 'http://0.0.0.0:8888/',
              changeOrigin: true,
              pathRewrite: {
                  '^/api': ''
              }
          }
      }
  },
}));
