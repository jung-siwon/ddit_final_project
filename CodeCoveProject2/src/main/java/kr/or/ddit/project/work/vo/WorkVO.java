package kr.or.ddit.project.work.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.AttatchVO;
import kr.or.ddit.project.colleague.vo.ColleagueVO;
import kr.or.ddit.project.issue.vo.IssueVO;
import kr.or.ddit.project.project.vo.ExcelColumn;
import kr.or.ddit.project.project.vo.ProjectVO;
import lombok.Data;

@Data
public class WorkVO {
	private String workNum;	//업무번호
	private String pjId;	//프로젝트 아이디
	private String workReq;	//업무요청자 아이디
	private String workContent;	//업무내용
	@ExcelColumn(headerName = "업무명")
	private String workTitle;	//업무명
	@ExcelColumn(headerName = "상태")
	private String workStatusCode;	//업무상태코드
	@ExcelColumn(headerName = "우선순위")
	private String workPriority;	//업무우선순위
	@ExcelColumn(headerName = "시작일")
	private String workStartDate;	//업무시작일
	@ExcelColumn(headerName = "마감일")
	private String workEndDate;		//업무종료일
	@ExcelColumn(headerName = "등록일")
	private String workCreateDate;	//업무생성일
	private String workProgress;
	private String parentWorkNum;	//상위업무번호
	private String workColor;		//업무색상

	private String pjName; //개인업무모음용
	
	private List<IssueVO> issueList;
	private List<ColleagueVO> colleagueVOList;
	private ProjectVO myProjectVO;
	private WorkVO workFile;
	
	private String assignMemId;	//담당자 아이디
	
	private String colNum;
	private String assignmentNum;
	
	private String attatchNum;
	private String memId;	//멤버아이디 첨부파일용
	private MultipartFile[] postFiles;
	
	public void setPostFiles(MultipartFile[] postFiles) {
		if (postFiles == null || postFiles.length == 0)
			return;
		this.postFiles = postFiles;
		this.attatchList = new ArrayList<>();
		for (MultipartFile single : postFiles) {
			if (single.isEmpty())
				continue;
			attatchList.add(new AttatchVO(single));
		}
	}

	private transient List<AttatchVO> attatchList;
}
