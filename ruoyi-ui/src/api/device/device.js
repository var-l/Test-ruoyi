import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// 查询用户列表
export function listDevice(query) {
  return request({
    url: '/Device/list',
    method: 'get',
    params: query
  })
}
