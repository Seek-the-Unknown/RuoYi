import request from '@/utils/request'

// 查询图书信息列表
export function listInformation(query) {
  return request({
    url: '/system/information/list',
    method: 'get',
    params: query
  })
}

// 查询图书信息详细
export function getInformation(bookId) {
  return request({
    url: '/system/information/' + bookId,
    method: 'get'
  })
}

// 新增图书信息
export function addInformation(data) {
  return request({
    url: '/system/information',
    method: 'post',
    data: data
  })
}

// 修改图书信息
export function updateInformation(data) {
  return request({
    url: '/system/information',
    method: 'put',
    data: data
  })
}

// 删除图书信息
export function delInformation(bookId) {
  return request({
    url: '/system/information/' + bookId,
    method: 'delete'
  })
}
