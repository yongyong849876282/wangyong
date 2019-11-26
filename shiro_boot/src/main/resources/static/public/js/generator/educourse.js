$(function () {
    $("#jqGrid").jqGrid({
        url: '../educourse/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '课程讲师ID', name: 'teacherId', index: 'teacher_id', width: 80 }, 			
			{ label: '课程专业ID', name: 'subjectId', index: 'subject_id', width: 80 }, 			
			{ label: '课程专业父级ID', name: 'subjectParentId', index: 'subject_parent_id', width: 80 }, 			
			{ label: '课程标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '课程销售价格，设置为0则可免费观看', name: 'price', index: 'price', width: 80 }, 			
			{ label: '总课时', name: 'lessonNum', index: 'lesson_num', width: 80 }, 			
			{ label: '课程封面图片路径', name: 'cover', index: 'cover', width: 80 }, 			
			{ label: '销售数量', name: 'buyCount', index: 'buy_count', width: 80 }, 			
			{ label: '浏览数量', name: 'viewCount', index: 'view_count', width: 80 }, 			
			{ label: '乐观锁', name: 'version', index: 'version', width: 80 }, 			
			{ label: '课程状态 Draft未发布  Normal已发布', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建时间', name: 'gmtCreate', index: 'gmt_create', width: 80 }, 			
			{ label: '更新时间', name: 'gmtModified', index: 'gmt_modified', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		eduCourse: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.eduCourse = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.eduCourse.id == null ? "../educourse/save" : "../educourse/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.eduCourse),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../educourse/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../educourse/info/"+id, function(r){
                vm.eduCourse = r.eduCourse;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});