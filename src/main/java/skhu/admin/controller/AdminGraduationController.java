package skhu.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import skhu.dto.Department;
import skhu.dto.Graduation;
import skhu.dto.GraduationGrade;
import skhu.dto.GraduationSubject;
import skhu.dto.Score;
import skhu.dto.Student;
import skhu.dto.Subject;
import skhu.mapper.DepartmentMapper;
import skhu.mapper.GraduationGradeMapper;
import skhu.mapper.GraduationMapper;
import skhu.mapper.GraduationSubjectMapper;
import skhu.mapper.ScoreMapper;
import skhu.mapper.StudentMapper;
import skhu.mapper.SubjectMapper;
import skhu.vo.Page;

@Controller
@RequestMapping("admin/menu/graduation")
public class AdminGraduationController {
	@Autowired StudentMapper studentMapper;
	@Autowired DepartmentMapper departmentMapper;
	@Autowired GraduationMapper graduationMapper;
	@Autowired GraduationGradeMapper graduationGradeMapper;
	@Autowired GraduationSubjectMapper graduationSubjectMapper;
	@Autowired ScoreMapper scoreMapper;
	@Autowired SubjectMapper subjectMapper;

	@RequestMapping(value="basic", method=RequestMethod.GET)
	public String basic() {
		return "admin/menu/graduation/basic";
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail() {
		return "admin/menu/graduation/detail";
	}

	@RequestMapping(value="yearChoice", method=RequestMethod.GET)
	public String yearChoice() {
		return "admin/menu/graduation/yearChoice";
	}

	@RequestMapping(value="info", method=RequestMethod.GET)
	public String info() {
		return "admin/menu/graduation/info";
	}

	@RequestMapping(value="gradelist", method=RequestMethod.GET)
	public String gradelist(Model model, HttpServletRequest request, GraduationGrade condition, @RequestParam(value="pg", required=false) String pg, @RequestParam(value="searchText", required=false) String searchText) {
		String st = "";
		if(searchText != null)
			st = "%" + searchText + "%";

		else
			searchText = "";

		if(searchText.equals("공통"))
			st = "0";

		Page page = new Page();
		int total = graduationGradeMapper.countByOption(condition, searchText);
		int currentPage = 1;

    	if(pg != null)
    		currentPage = Integer.parseInt(pg);

		List<GraduationGrade> graduationGrades = graduationGradeMapper.findByOption(condition, st);
		List<Department> departments = departmentMapper.findAll();
		List<Graduation> graduations = graduationMapper.findAll();
		ArrayList<Page> pages = page.paging(total, 10, currentPage, request.getQueryString());

		model.addAttribute("condition", condition);
		model.addAttribute("searchText", searchText);
		model.addAttribute("departments", departments);
		model.addAttribute("graduations", graduations);
		model.addAttribute("graduationGrades", graduationGrades);
		model.addAttribute("pages", pages);

		return "admin/menu/graduation/gradelist";
	}

	@RequestMapping(value="editgrade", method=RequestMethod.GET)
	public String editgrade(Model model, @RequestParam("id") int id) {
		GraduationGrade graduationGrade = graduationGradeMapper.findById(id);
		List<Department> departments = departmentMapper.findAll();
		List<Graduation> graduations = graduationMapper.findAll();

		model.addAttribute("graduationSubject", graduationGrade);
		model.addAttribute("departments", departments);
		model.addAttribute("graduations", graduations);

		return "admin/menu/graduation/editgrade";
	}

	@RequestMapping(value="gradeupdate", method=RequestMethod.POST)
	public String gradeupdate(Model model, GraduationGrade graduationGrade) {
		graduationGradeMapper.update(graduationGrade);

		return "redirect:gradelist";
	}

	@RequestMapping(value="subjectlist", method=RequestMethod.GET)
	public String subjectlist(Model model, HttpServletRequest request, GraduationSubject condition, @RequestParam(value="pg", required=false) String pg, @RequestParam(value="searchText", required=false) String searchText) {
		String st = "";
		if(searchText != null)
			st = "%" + searchText + "%";

		else
			searchText = "";

		if(searchText.equals("공통"))
			st = "0";

		Page page = new Page();
		int total = graduationSubjectMapper.countByOption(condition, searchText);
		int currentPage = 1;

    	if(pg != null)
    		currentPage = Integer.parseInt(pg);

		List<GraduationSubject> graduationGrades = graduationSubjectMapper.findByOption(condition, st);
		List<Department> departments = departmentMapper.findAll();
		List<Graduation> graduations = graduationMapper.findAll();
		ArrayList<Page> pages = page.paging(total, 10, currentPage, request.getQueryString());

		model.addAttribute("condition", condition);
		model.addAttribute("searchText", searchText);
		model.addAttribute("departments", departments);
		model.addAttribute("graduations", graduations);
		model.addAttribute("graduationGrades", graduationGrades);
		model.addAttribute("pages", pages);

		return "admin/menu/graduation/subjectlist";
	}

	@RequestMapping(value="editsubject", method=RequestMethod.GET)
	public String editsubject(Model model, @RequestParam("id") int id) {
		GraduationSubject graduationSubject = graduationSubjectMapper.findById(id);
		List<Department> departments = departmentMapper.findAll();
		List<Graduation> graduations = graduationMapper.findAll();

		model.addAttribute("graduationSubject", graduationSubject);
		model.addAttribute("departments", departments);
		model.addAttribute("graduations", graduations);

		return "admin/menu/graduation/editsubject";
	}

	@RequestMapping(value="subjectupdate", method=RequestMethod.POST)
	public String subjectupdate(Model model, GraduationSubject graduationSubject, @RequestParam("code") String code) {
		Subject subject = subjectMapper.findByCode(code);
		graduationSubject.setSubjectId(subject.getId());

		graduationSubjectMapper.update(graduationSubject);

		return "redirect:subjectlist";
	}

	@RequestMapping(value="creategraduation", method=RequestMethod.GET)
	public String creategraduation(Model model) {
		GraduationGrade graduationGrade = new GraduationGrade();
		GraduationSubject graduationSubject = new GraduationSubject();
		List<Department> departments = departmentMapper.findAll();
		List<Graduation> graduations = graduationMapper.findAll();

		model.addAttribute("graduationSubject", graduationSubject);
		model.addAttribute("graduationGrade", graduationGrade);
		model.addAttribute("departments", departments);
		model.addAttribute("graduations", graduations);

		return "admin/menu/graduation/creategraduation";
	}

	@RequestMapping(value="graduationlist", method=RequestMethod.GET)
	public String graduationList(Model model, HttpServletRequest request, Student condition,
		@RequestParam(value="searchText", required=false) String searchText, @RequestParam(value="pg", required=false) String pg,
		@RequestParam(value="searchType", required=false) String searchType,@RequestParam(value="majorCheck", required=false) boolean majorCheck,
		@RequestParam(value="minorCheck", required=false) boolean minorCheck) {

		if(searchText == null)
    		searchText = "";

		if(searchType == null)
    		searchType = "0";

		Page page = new Page();
		int total = studentMapper.countByGraduation(condition, "%" + searchText + "%", searchType, majorCheck, minorCheck);
		int currentPage = 1;

    	if(pg != null)
    		currentPage = Integer.parseInt(pg);

		List<Student> students = studentMapper.findByGraduation((currentPage - 1) * 10, 10, condition, "%" + searchText + "%", searchType, majorCheck, minorCheck);
		List<Department> departments = departmentMapper.findWithoutCommon();
		ArrayList<Page> pages = page.paging(total, 10, currentPage, request.getQueryString());

		model.addAttribute("condition", condition);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchType", searchType);
		model.addAttribute("majorCheck", majorCheck);
		model.addAttribute("minorCheck", minorCheck);
		model.addAttribute("students", students);
		model.addAttribute("departments", departments);
		model.addAttribute("pages", pages);
		return "admin/menu/graduation/graduationList";
	}

	@RequestMapping(value="graduationdetail", method=RequestMethod.GET)
	public String graduationDetail(Model model, @RequestParam("id") int id) {
		Student student = studentMapper.findById(id);
		List<Score> scores = scoreMapper.findByStudentId(student.getId());
		String year = student.getStudentNumber().substring(0, 3);
		List<GraduationGrade> graduationGrades = null;
		List<GraduationSubject> graduationSubjects = null;
		Map<GraduationGrade, Integer> graduationGradeMap = new HashMap<GraduationGrade, Integer>();
		Map<GraduationSubject, Integer> graduationSubjectMap = new HashMap<GraduationSubject, Integer>();

		if(!student.getGraduation().equals("0")) {
			String[] graduations = student.getGraduation().split(" ", 2);
			graduationGrades = graduationGradeMapper.findByStudent(year, student, graduations[0], graduations[1]);
			graduationSubjects = graduationSubjectMapper.findByStudent(year, student, graduations[0], graduations[1]);

			for(GraduationGrade graduationGrade : graduationGrades) {
				int total = 0;
				for(Score score : scores) {
					if(score.getSubstitutionCode().equals("0")) {
						if((graduationGrade.getName().equals(score.getSubject().getDivision())) ||
							graduationGrade.getName().equals(score.getSubject().getSubjectDetail().getSubtitle()) ||
							graduationGrade.getName().equals("졸업") ||
							(graduationGrade.getName().equals("전공") && (score.getSubject().getDivision().equals("전공필수")) || score.getSubject().getDivision().equals("전공선택")) ||
							(graduationGrade.getName().equals("교양") && (score.getSubject().getDivision().equals("교양필수")) || score.getSubject().getDivision().equals("교양선택"))) {

							total += score.getSubject().getScore();
							graduationGradeMap.put(graduationGrade, total);
						}
					}
				}
			}

			for(GraduationSubject graduationSubject : graduationSubjects) {
				for(Score score : scores) {
					if(score.getSubstitutionCode().equals("") && graduationSubject.getSubject().getCode().equals(score.getSubject().getCode()))
						graduationSubjectMap.put(graduationSubject, 1);

					else if(!graduationSubject.getNote().equals(""))
						graduationSubjectMap.put(graduationSubject, 2);

					else
						graduationSubjectMap.put(graduationSubject, 0);
				}
			}


		}

		else
			student.setGraduation("미설정");

		model.addAttribute("student", student);
		model.addAttribute("graduationGrades", graduationGrades);
		model.addAttribute("graduationSubjects", graduationSubjects);
		model.addAttribute("graduationGradeMap", graduationGradeMap);
		model.addAttribute("graduationSubjectMap", graduationSubjectMap);

		return "admin/menu/graduation/graduationDetail";
	}

	@RequestMapping(value="counseling", method=RequestMethod.GET)
	public String counseling() {
		return "admin/menu/graduation/counseling";
	}

	@RequestMapping(value="counselingList", method=RequestMethod.GET)
	public String counselingList() {
		return "admin/menu/graduation/counselingList";
	}

	@RequestMapping(value="counselingDetail", method=RequestMethod.GET)
	public String counselingDetail() {
		return "admin/menu/graduation/counselingDetail";
	}

	@RequestMapping(value="counselingAdd", method=RequestMethod.GET)
	public String counselingAdd() {
		return "admin/menu/graduation/counselingAdd";
	}

}
