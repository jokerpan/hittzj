package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import top.hittzj.entity.Commodity_Sell;
import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.User;
import top.hittzj.service.AddCSService;
import top.hittzj.service.FindTypeById;
import top.hittzj.service.GetCNService;
import top.hittzj.service.GetCSService;
import top.hittzj.service.ModifyCNService;
import top.hittzj.service.ModifyCSService;

/**
 * @author zy_q 修改商品信息
 */
public class ModifyCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error/500error.jsp").forward(request,
				response);
		return;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 确认用户是否登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "要登录之后再更改发布哦~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		Commodity_Sell commodity_Sell = null;
		Commodity_Type type = null;
		String desc = null;
		String name = null;
		String money = null;
		String number = null;
		String useTime = null;
		String flaw = null;
		String location = null;

		// 一起处理上传的图片和表单信息
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 5mb
		upload.setFileSizeMax(1024 * 1024 * 5);
		upload.setSizeMax(1024 * 1024 * 5);
		upload.setHeaderEncoding("UTF-8");
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					if (item.isFormField()) {
						String field_name = item.getFieldName();
						if ("CSId".equals(field_name)) {
							// 得到商品，验证所有者
							String id_ = item.getString();
							id_=new String(id_.getBytes("iso8859-1"),"utf-8");
							int id = Integer.parseInt(id_);
							GetCSService service = new GetCSService();
							commodity_Sell = service.get(id);
//							System.out.println(commodity_Sell+"========");
							if (commodity_Sell == null) {
								request.setAttribute("modifyCSResult",
										"没找到这个商品");
								request.getRequestDispatcher("/index.jsp")
										.forward(request, response);
								return;
							}
							if (!user.getCount().equals(
									commodity_Sell.getUser().getCount())) {
								request.setAttribute("modifyCSResult",
										"这个商品不是你的咯");
								request.getRequestDispatcher("/index.jsp")
										.forward(request, response);
								return;
							}

						}
						if ("typeId".equals(field_name)) {
							String typeid_ = item.getString();
							typeid_=new String(typeid_.getBytes("iso8859-1"),"utf-8");
							int typeid = Integer.parseInt(typeid_);
							FindTypeById findTypeById = new FindTypeById();
							type = findTypeById.find(typeid);
							if (type == null) {
								request.getRequestDispatcher("/error.jsp")
										.forward(request, response);
								return;
							}
						}
						if ("desc".equals(field_name)) {
							desc = item.getString();
							desc=new String(desc.getBytes("iso8859-1"),"utf-8");
							
						}
						if ("name".equals(field_name)) {
							name = item.getString();
							name=new String(name.getBytes("iso8859-1"),"utf-8");
						}
						if ("money".equals(field_name)) {
							money = item.getString();
							money=new String(money.getBytes("iso8859-1"),"utf-8");
						}
						if ("number".equals(field_name)) {
							number = item.getString();
							number=new String(number.getBytes("iso8859-1"),"utf-8");
						}
						if ("useTime".equals(field_name)) {
							useTime = item.getString();
							useTime=new String(useTime.getBytes("iso8859-1"),"utf-8");
						}
						if ("flaw".equals(field_name)) {
							flaw = item.getString();
							flaw=new String(flaw.getBytes("iso8859-1"),"utf-8");
						}
						if ("location".equals(field_name)) {
							location = item.getString();
							location=new String(location.getBytes("iso8859-1"),"utf-8");
						}
					} else {
						if (item.getSize() > 10) {
							String rootPath = getServletContext().getRealPath(
									"/");
							String completePath = rootPath
									+ commodity_Sell.getImg();
							File file = new File("completePath");
							file.delete();
							item.write(file);
						}
						continue;
					}
				}
			} catch (FileUploadException e) {
				request.setAttribute("ModifyCNResult", "文将上传失败");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			} catch (Exception e) {
				request.setAttribute("ModifyCNResult", "文将上传失败");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
		}

		commodity_Sell.setType(type);
		commodity_Sell.setName(name);
		commodity_Sell.setDesc(desc);
		commodity_Sell.setLocation(location);
		commodity_Sell.setNumber(number);
		commodity_Sell.setMoney(money);
		commodity_Sell.setTime(new Date());
		ModifyCSService service = new ModifyCSService();
		boolean change = service.change(commodity_Sell);
		if (change) {
			request.setAttribute("modifyCSResult", "修改成功");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		} else {
			request.setAttribute("modifyCSResult", "修改失败");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
	}
}
