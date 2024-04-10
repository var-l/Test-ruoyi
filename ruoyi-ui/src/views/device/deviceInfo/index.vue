<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true">
      <el-form-item label="角色名称" prop="roleName">
        <el-input
          v-model="queryParams.roleName"
          placeholder="请输入角色名称"
          clearable
          style="width: 240px"

        />
      </el-form-item>
      <el-form-item label="权限字符" prop="roleKey">
        <el-input
          v-model="queryParams.roleKey"
          placeholder="请输入权限字符"
          clearable
          style="width: 240px"

        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="角色状态"
          clearable
          style="width: 240px"
        >
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:role:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:role:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:role:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:role:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="设备名称" prop="roleId" width="120" />
      <el-table-column label="设备状态" prop="roleName" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="位置信息" prop="roleKey" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="显示顺序" prop="roleSort" width="100" />
      <el-table-column label="状态" align="center" width="100">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            active-value="0"
            inactive-value="1"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope" v-if="scope.row.roleId !== 1">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:role:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:role:remove']"
          >删除</el-button>
          <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)" v-hasPermi="['system:role:edit']">
            <el-button size="mini" type="text" icon="el-icon-d-arrow-right">更多</el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="handleDataScope" icon="el-icon-circle-check"
                                v-hasPermi="['system:role:edit']">数据权限</el-dropdown-item>
              <el-dropdown-item command="handleAuthUser" icon="el-icon-user"
                                v-hasPermi="['system:role:edit']">分配用户</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
import { getRole } from '@/api/system/role'

export default {
  name: 'deviceInfo',
   data(){
     return {
       // 查询参数
       queryParams: {
         deviceName: ''  ,
         pageNum: 1,
         pageSize: 10,
         caregiver:'',
         userName: undefined,
         location: undefined,
         status: undefined,
         deptId: undefined
       },
       // 列信息
       columns: [
         { key: 0, label: `用户编号`, visible: true },
         { key: 1, label: `用户名称`, visible: true },
         { key: 2, label: `用户昵称`, visible: true },
         { key: 3, label: `部门`, visible: true },
         { key: 4, label: `手机号码`, visible: true },
         { key: 5, label: `状态`, visible: true },
         { key: 6, label: `创建时间`, visible: true }
       ],
       // 表单校验
       rules: {
         userName: [
           { required: true, message: "用户名称不能为空", trigger: "blur" },
           { min: 2, max: 20, message: '用户名称长度必须介于 2 和 20 之间', trigger: 'blur' }
         ],
         nickName: [
           { required: true, message: "用户昵称不能为空", trigger: "blur" }
         ],
         password: [
           { required: true, message: "用户密码不能为空", trigger: "blur" },
           { min: 5, max: 20, message: '用户密码长度必须介于 5 和 20 之间', trigger: 'blur' },
           { pattern: /^[^<>"'|\\]+$/, message: "不能包含非法字符：< > \" ' \\\ |", trigger: "blur" }
         ],
         email: [
           {
             type: "email",
             message: "请输入正确的邮箱地址",
             trigger: ["blur", "change"]
           }
         ],
         phonenumber: [
           {
             pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
             message: "请输入正确的手机号码",
             trigger: "blur"
           }
         ]
       }
     };
   },
   methods:{
    getHello(){
      console.log("Hello")
    },

     /** 修改按钮操作 */
     handleUpdate(row) {
       this.reset();
       const roleId = row.roleId || this.ids
       const roleMenu = this.getRoleMenuTreeselect(roleId);
       getRole(roleId).then(response => {
         this.form = response.data;
         this.open = true;
         this.$nextTick(() => {
           roleMenu.then(res => {
             let checkedKeys = res.checkedKeys
             checkedKeys.forEach((v) => {
               this.$nextTick(()=>{
                 this.$refs.menu.setChecked(v, true ,false);
               })
             })
           });
         });
         this.title = "修改角色";
       });
     },
   },
   created() {
      this.getHello()
   }
}
</script>

<style rel="stylesheet/scss" lang="scss" >

.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>
