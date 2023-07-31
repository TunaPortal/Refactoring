package co.refactoring.tuna.domain.user.vo;

import co.refactoring.tuna.domain.scholar.vo.ScholarStudentVO;
import co.refactoring.tuna.domain.scholar.vo.ScholarVO;
import co.refactoring.tuna.domain.tuition.vo.TuitionVO;
import co.refactoring.tuna.domain.tuition.vo.tuitionGiveVO;

import java.sql.Date;


public class StudentVO{
	private int no;
	private String pwd;
	private String email;
	private String name;
	private String tel;
	private String zip;
	private String addr;
	private int sy;
	private String stateCode;
	private Date birth;
	private String bacc;
	private String bank;
	private String deptCode;
	private Date enterDate;
	private String role;
	private String chpwd;
	
	private TuitionVO tuitionvo;
	private ScholarStudentVO scholarstudentvo;
	private ScholarVO scholarvo;
	private tuitionGiveVO tuitionGivevo;
	
	public String getChpwd() {
		return chpwd;
	}

	public void setChpwd(String chpwd) {
		this.chpwd = chpwd;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getBacc() {
		return bacc;
	}

	public void setBacc(String bacc) {
		this.bacc = bacc;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TuitionVO getTuitionvo() {
		return tuitionvo;
	}

	public void setTuitionvo(TuitionVO tuitionvo) {
		this.tuitionvo = tuitionvo;
	}

	public ScholarStudentVO getScholarstudentvo() {
		return scholarstudentvo;
	}

	public void setScholarstudentvo(ScholarStudentVO scholarstudentvo) {
		this.scholarstudentvo = scholarstudentvo;
	}

	public ScholarVO getScholarvo() {
		return scholarvo;
	}

	public void setScholarvo(ScholarVO scholarvo) {
		this.scholarvo = scholarvo;
	}

	public tuitionGiveVO getTuitionGivevo() {
		return tuitionGivevo;
	}

	public void setTuitionGivevo(tuitionGiveVO tuitionGivevo) {
		this.tuitionGivevo = tuitionGivevo;
	}

}
