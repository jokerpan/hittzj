$(function() {
	var desc = $('#flag').html();

	for ( var i = 0; i < 10; i++) {
		var test = $('#list li').eq(i).find('.num');
		var test1=$('#list2 li').eq(i).find('.num');
		if (test.html() == '')
			// alert('fuck');
			test.parents('li').hide();
		if(test1.html()=='')
			test1.parents('li').hide();

	}

	// if($('#list li .num').html() == '')
	function postwith(action, name, value) {

		// 创建一个 form
		var form1 = document.createElement("form");
		form1.id = "form1";
		form1.name = "form1";

		// 添加到 body 中
		document.body.appendChild(form1);

		// 创建一个输入
		var input = document.createElement("input");
		// 设置相应参数
		input.type = "text";
		input.name = name;
		input.value = value;

		// 将该输入框插入到 form 中
		form1.appendChild(input);

		// form 的提交方式
		form1.method = "POST";
		// form 提交路径
		form1.action = action;

		// 对该 form 执行提交
		form1.submit();
		// 删除该 form
		document.body.removeChild(form1);
	}

	function postwith1(action, name1, value1, name2, value2) {

		// 创建一个 form
		var form1 = document.createElement("form");
		form1.id = "form1";
		form1.name = "form1";

		// 添加到 body 中
		document.body.appendChild(form1);

		// 创建一个输入
		var input1 = document.createElement("input");
		var input2 = document.createElement("input");
		// 设置相应参数
		input1.type = "text";
		input1.name = name1;
		input1.value = value1;
		input2.type = "text";
		input2.name = name2;
		input2.value = value2;

		// 将该输入框插入到 form 中
		form1.appendChild(input1);
		form1.appendChild(input2);

		// form 的提交方式
		form1.method = "POST";
		// form 提交路径
		form1.action = action;

		// 对该 form 执行提交
		form1.submit();
		// 删除该 form
		document.body.removeChild(form1);
	}

	$('.list li').click(function(event) {
		var id = $(this).find('.num').html();
		var action = 'ShowSingleCS';
		var name = 'CSId';
		// alert(desc);
		// alert(id);
		if (desc == '我收藏的求购商品' || desc == '我发布的求购商品' || desc == '所有求购商品') {
			action = 'ShowSingleCN';
			name = 'CNId';
		}
		postwith(action, name, id);

	});

	$('#pre').click(function(event) {
		var action = 'ShowCNByCollector';
		var page = $('#pagenum').html();
		var typeid = '1';
		if (desc == '我发布的求购商品') {
			action = 'ShowCNByUser';
		} else if (desc == '所有求购商品') {
			action = 'ShowCN';
		} else if (desc == '我收藏的待出售商品') {
			action = 'ShowCSByCollector';
		} else if (desc == '所有待出售商品') {
			action = 'ShowCS';
		} else if (desc == '我发布的待出售商品') {
			action = 'ShowCSByUser';
		} else {
			action = 'ShowCSByType';
			switch (desc) {
			case '女装':
				typeid = 2;
				break;
			case '包':
				typeid = 3;
				break;
			case '数码电器':
				typeid = 4;
				break;
			case '游戏':
				typeid = 5;
				break;
			case '户外运动':
				typeid = 6;
				break;
			case '学习':
				typeid = 7;
				break;
			case '日常用品':
				typeid = 8;
				break;
			case '收藏品':
				typeid = 9;
				break;
			case '食品':
				typeid = 10;
				break;
			case '其他':
				typeid = 11;
				break;
			}
			/*
			 * alert(action); alert(typeid); alert(page-1); alert(desc);
			 */
			postwith1(action, 'nextPage', page - 1, 'typeId', typeid);
			return;
		}
		/*
		 * alert(action); alert(typeid); alert(page-1); alert(desc);
		 */
		postwith(action, 'nextPage', page - 1);
	});

	$('#next').click(function(event) {
		var action = 'ShowCNByCollector';
		var page = parseInt($('#pagenum').html());
		var typeid = 1;
		if (desc == '我发布的求购商品') {
			action = 'ShowCNByUser';
		} else if (desc == '所有求购商品') {
			action = 'ShowCN';
		} else if (desc == '我收藏的待出售商品') {
			action = 'ShowCSByCollector';
		} else if (desc == '所有待出售商品') {
			action = 'ShowCS';
		} else if (desc == '我发布的待出售商品') {
			action = 'ShowCSByUser';
		} else {
			action = 'ShowCSByType';
			switch (desc) {
			case '女装':
				typeid = 2;
				break;
			case '包':
				typeid = 3;
				break;
			case '数码电器':
				typeid = 4;
				break;
			case '游戏':
				typeid = 5;
				break;
			case '户外运动':
				typeid = 6;
				break;
			case '学习':
				typeid = 7;
				break;
			case '日常用品':
				typeid = 8;
				break;
			case '收藏品':
				typeid = 9;
				break;
			case '食品':
				typeid = 10;
				break;
			case '其他':
				typeid = 11;
				break;
			}
			postwith1(action, 'nextPage', page + 1, 'typeId', typeid);
			return;
		}
		postwith(action, 'nextPage', page + 1);
	});

	$('#pagesolr').click(function(event) {
		var action = 'ShowCNByCollector';
		var page = $('#pagetar').val();
		var typeid = 1;
		if (desc == '我发布的求购商品') {
			action = 'ShowCNByUser';
		} else if (desc == '所有求购商品') {
			action = 'ShowCN';
		} else if (desc == '我收藏的待出售商品') {
			action = 'ShowCSByCollector';
		} else if (desc == '所有待出售商品') {
			action = 'ShowCS';
		} else if (desc == '我发布的待出售商品') {
			action = 'ShowCSByUser';
		} else {
			action = 'ShowCSByType';
			switch (desc) {
			case '女装':
				typeid = 2;
				break;
			case '包':
				typeid = 3;
				break;
			case '数码电器':
				typeid = 4;
				break;
			case '游戏':
				typeid = 5;
				break;
			case '户外运动':
				typeid = 6;
				break;
			case '学习':
				typeid = 7;
				break;
			case '日常用品':
				typeid = 8;
				break;
			case '收藏品':
				typeid = 9;
				break;
			case '食品':
				typeid = 10;
				break;
			case '其他':
				typeid = 11;
				break;
			}
			postwith1(action, 'nextPage', page, 'typeId', typeid);
			return;
		}
		postwith(action, 'nextPage', page);
	});
})