package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

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

import top.hittzj.entity.Commodity_Type;
import top.hittzj.entity.User;
import top.hittzj.service.AddCSService;
import top.hittzj.service.FindTypeById;

/**
 * @author zy_q
 * 
 */
// 处理上传出售商品的servlet （表单和文件上传）
public class AddCSServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commodity_Type type = null;
		String desc = null;
		String name = null;
		String money = null;
		String number = null;
		String useTime = null;
		String flaw = null;
		String location = null;
		String relativePath = null;
		// 确认用户是否登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.setAttribute("loginResult", "要登录之后再发布哦~");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		}
		// 获得类型
		boolean haveImg = false;
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
					// 如果是非文件
					if (item.isFormField()) {
						String field_name = item.getFieldName();
						if ("typeId".equals(field_name)) {
							String typeid_ = item.getString();
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
						long size = item.getSize();
						if (size > 10) {
							haveImg = true;
							// 获得文件名称
							// 创建一个唯一标记，防止重名
							String id = UUID.randomUUID().toString();
							String fileName = id;
							// 得到web项目目录
							String rootPath = getServletContext().getRealPath(
									"/");
							// System.out.println(path);
							// 得到完整的路径
							String completePath = rootPath + "s_img\\"
									+ fileName + ".jpg";
							// System.out.println("路径" + completePath);
							File file = new File(completePath);
							file.createNewFile();
							item.write(file);
							item.delete();
							relativePath = "s_img\\" + fileName + ".jpg";
							// System.out.println(relativePath);
						}
					}
				}
				if (!haveImg) {
					request.setAttribute("addCSResult", "请添加真实图片哦");
					request.getRequestDispatcher("/addCS.jsp").forward(request,
							response);
					return;
				}
			} catch (FileUploadException e) {
				request.setAttribute("addCSResult", "上传图片失败了");
				request.getRequestDispatcher("/addCS.jsp").forward(request,
						response);
				return;
			} catch (Exception e) {
				request.setAttribute("addCSResult", "商品发布失败");
				request.getRequestDispatcher("/addCS.jsp").forward(request,
						response);
				return;
			}

		}
		// 表单信息

		AddCSService service = new AddCSService();
		boolean add = service.add(name, money, useTime, number, flaw, desc,
				location, relativePath, user, type);
		if (add) {
			request.setAttribute("addCSResult", "发布成功");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		request.setAttribute("addCSResult", "发布失败");
		request.getRequestDispatcher("/addCS.jsp").forward(request, response);
		return;
	}

}
