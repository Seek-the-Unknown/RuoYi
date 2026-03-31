<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="图书名称" prop="bookName">
        <el-input
          v-model="queryParams.bookName"
          placeholder="请输入图书名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图书类型" prop="booksTypeName">
        <el-input
          v-model="queryParams.booksTypeName"
          placeholder="请输入图书类型名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:information:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate" v-hasPermi="['system:information:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete" v-hasPermi="['system:information:remove']">删除</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="informationId" />
      <el-table-column label="图书名称" align="center" prop="bookName" />
      <el-table-column label="图书类型" align="center" prop="booksTypeName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:information:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:information:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="informationRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图书名称" prop="bookName">
          <el-input v-model="form.bookName" placeholder="请输入图书名称" />
        </el-form-item>
        
        <el-form-item label="图书类型" prop="typeId">
          <el-select 
            v-model="form.typeId" 
            placeholder="请选择或输入图书类型" 
            clearable 
            filterable 
            style="width: 100%"
          >
            <el-option
              v-for="item in typeOptions"
              :key="item.typeId"
              :label="item.typeName"
              :value="item.typeId"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Information">
import { listInformation, getInformation, delInformation, addInformation, updateInformation } from "@/api/system/information";
import { listType } from "@/api/system/type";

const { proxy } = getCurrentInstance();

const informationList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const typeOptions = ref([]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    bookName: null,
    booksTypeName: null, 
  },
  rules: {
    bookName: [
      { required: true, message: "图书名称不能为空", trigger: "blur" }
    ],
    typeId: [
      { required: true, message: "图书类型不能为空", trigger: "change" }
    ]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询图书信息列表 */
function getList() {
  loading.value = true;
  listInformation(queryParams.value).then(response => {
    informationList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

/** 查询分类下拉树列表 */
function getTypeList() {
  listType({ pageNum: 1, pageSize: 1000 }).then(response => {
    typeOptions.value = response.rows;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    informationId: null, // 【修正】：此处清空的是 informationId
    bookName: null,
    typeId: null
  };
  proxy.resetForm("informationRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  // 【修正】：取值从 id 改为 informationId
  ids.value = selection.map(item => item.informationId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加图书信息";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  // 【修正】：取值从 id 改为 informationId
  const informationId = row.informationId || ids.value;
  getInformation(informationId).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改图书信息";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["informationRef"].validate(valid => {
    if (valid) {
      if (form.value.informationId != null) {
        updateInformation(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addInformation(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  // 【修正】：取值从 id 改为 informationId
  const deleteIds = row.informationId || ids.value;
  proxy.$modal.confirm('是否确认删除图书编号为"' + deleteIds + '"的数据项？').then(function() {
    return delInformation(deleteIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

// 页面加载执行
getTypeList();
getList();
</script>