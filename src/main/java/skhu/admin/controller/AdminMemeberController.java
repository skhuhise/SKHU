package skhu.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import skhu.dto.Department;
import skhu.dto.Graduation;
import skhu.dto.Student;
import skhu.mapper.DepartmentMapper;
import skhu.mapper.GraduationMapper;
import skhu.mapper.StudentMapper;
import skhu.util.PageOption;
import skhu.vo.Page;

@Controller
@RequestMapping("admin/menu/member")
public class AdminMemeberController {
	@Autowired DepartmentMapper departmentMapper;
	@Autowired StudentMapper studentMapper;
	@Autowired GraduationMapper graduationMapper;

	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, Student condition,
			@RequestParam(value="searchText", required=false) String searchText,
			@RequestParam(value="searchType", required=false) String searchType,
			HttpServletRequest request, @RequestParam(value="pg", required=false) String pg) {

		if(searchText == null)
			searchText = "";

		if(searchType == null)
			searchType = "0";

		Page page = new Page();
		int total = studentMapper.count(condition, searchType, searchText);
		int currentPage = 1;

		if(pg != null)
			currentPage = Integer.parseInt(pg);
		
		List<Department> departments = departmentMapper.findWithoutCommon();
		List<Student> students = studentMapper.findAllWithDepartment((currentPage - 1) * 15, 15, condition, searchType, "%" + searchText + "%");
		ArrayList<Page> pages = page.paging(total, 15, currentPage, request.getQueryString());

		model.addAttribute("condition", condition);
		model.addAttribute("departments", departments);
		model.addAttribute("students", students);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchType", searchType);
		model.addAttribute("pages", pages);

		return "admin/menu/member/list";
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Model model, @RequestParam("id") int id) {
		Student student = studentMapper.findById(id);
		List<Department> departments = departmentMapper.findWithoutCommon();
		List<Graduation> graduations = graduationMapper.findWithoutCommon();
		List<Graduation> mainGraduations = new ArrayList<Graduation>();
		List<Graduation> detailGraduations = new ArrayList<Graduation>();

		for(Graduation graduation : graduations) {
			if(graduation.getDivision().equals("a"))
				mainGraduations.add(graduation);

			else if(graduation.getDivision().equals("c"))
				detailGraduations.add(graduation);
		}

		String[] splitGraduations = student.getGraduation().split(" ", 2);

		if(splitGraduations.length == 1) {
			splitGraduations = new String[2];
			splitGraduations[0] = student.getGraduation();
			splitGraduations[1] = "";
		}


		model.addAttribute("student", student);
		model.addAttribute("mainSelect", splitGraduations[0]);
		model.addAttribute("detailSelect", splitGraduations[1]);
		model.addAttribute("mainGraduations", mainGraduations);
		model.addAttribute("detailGraduations", detailGraduations);
		model.addAttribute("departments", departments);

		return "admin/menu/member/detail";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(Model model, Student student, @RequestParam("mainGraduation") String mainGraduation, @RequestParam("minor") String minor, @RequestParam("doubleMajor1") String doubleMajor1, @RequestParam("doubleMajor2") String doubleMajor2, @RequestParam("detailGraduation") String detailGraduation) {
		student.setSemester((student.getYear() - 1) * 2 + student.getSemester());

		if(detailGraduation.equals("0"))
			student.setGraduation(mainGraduation);

		else
			student.setGraduation(mainGraduation + " " + detailGraduation);

		if((minor.equals("0") && doubleMajor1.equals("0") && doubleMajor2.equals("0")) ||
			(minor.equals("0") && !doubleMajor1.equals("0") && !doubleMajor2.equals("0")) ||
			(!minor.equals("0") && doubleMajor1.equals("0") && doubleMajor2.equals("0"))) {
			if(minor.equals("0"))
				minor = doubleMajor1;

			student.setMinor(minor);
			student.setDoubleMajor(doubleMajor2);
		}

		else {
			student.setMinor("0");
			student.setDoubleMajor("0");
		}

		studentMapper.update(student);

		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id") int id) {
		studentMapper.delete(id);
		return "redirect:list";
	}
}
