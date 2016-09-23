package top.hittzj.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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

import top.hittzj.entity.Commodity_Need;
import top.hittzj.entity.User;
import top.hittzj.service.GetCNService;

import top.hittzj.service.ModifyCNService;
import top.hittzj.service.ModifyCSService;

public class ModifyCNServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		} else {

			int cnid;
			String desc = null;
			String name = null;
			String money = null;
			String number = null;
			String location = null;
			Commodity_Need cn = null;
			// 获得原来的商品

			// 一起处理上传的图片和表单信息,删除原来的文件
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
						// 非文件上传部分
						if (item.isFormField()) {
							String field_name = item.getFieldName();
							// 得到参数
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
							if ("location".equals(field_name)) {
								location = item.getString();
								location=new String(location.getBytes("iso8859-1"),"utf-8");
							}
					
							if ("cnid".equals(field_name)) {
								String cnid_ = item.getString();
								cnid_=new String(cnid_.getBytes("iso8859-1"),"utf-8");
								cnid = Integer.parseInt(cnid_);
								GetCNService getCNService = new GetCNService();
								cn = getCNService.get(cnid);
								if (cn == null) {
									request.setAttribute("modifyCNResult",
											"没有找到此商品呢");
									request.getRequestDispatcher("/index.jsp")
											.forward(request, response);
									return;
								}
								if (!cn.getUser().getCount()
										.equals(user.getCount())) {
									request.setAttribute("modifyCNResult",
											"这个商品不是你的~");
									request.getRequestDispatcher("/index.jsp")
											.forward(request, response);
									return;
								}
							}
						} else {
							if (item.getSize() > 10) {
								String rootPath = getServletContext()
										.getRealPath("/");
								String completePath = rootPath + cn.getImg();
								File file = new File(completePath);
								file.delete();
								item.write(file);
							} else {

							}
							continue;
						}
					}
				} catch (FileUploadException e) {
					request.setAttribute("modifyCNResult", "文将上传失败");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				} catch (Exception e) {
					request.setAttribute("modifyCNResult", "文将上传失败");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
					return;
				}
			}
			// 表单信息
			cn.setName(name);
			cn.setDesc(desc);
			cn.setLocation(location);
			cn.setNumber(number);
			cn.setMoney(money);
			cn.setTime(new Date());
			ModifyCNService service = new ModifyCNService();
			boolean change = service.modify(cn);
			if (change) {
				request.setAttribute("modifyCNResult", "修改成功");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			} else {
				request.setAttribute("modifyCNResult", "修改失败");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return;
			}
		}
	}

}
