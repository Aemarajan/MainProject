package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="external")
public class External {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="user",referencedColumnName="user_id")
	User user;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="semester",referencedColumnName="id")
	Semester semester;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="ma5161",referencedColumnName="id")
	Grade ma5161;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5101",referencedColumnName="id")
	Grade mc5101;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5102",referencedColumnName="id")
	Grade mc5102;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5103",referencedColumnName="id")
	Grade mc5103;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5104",referencedColumnName="id")
	Grade mc5104;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5111",referencedColumnName="id")
	Grade mc5111;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5112",referencedColumnName="id")
	Grade mc5112;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5113",referencedColumnName="id")
	Grade mc5113;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5201",referencedColumnName="id")
	Grade mc5201;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5202",referencedColumnName="id")
	Grade mc5202;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5203",referencedColumnName="id")
	Grade mc5203;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5204",referencedColumnName="id")
	Grade mc5204;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5205",referencedColumnName="id")
	Grade mc5205;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5211",referencedColumnName="id")
	Grade mc5211;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5212",referencedColumnName="id")
	Grade mc5212;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5213",referencedColumnName="id")
	Grade mc5213;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5301",referencedColumnName="id")
	Grade mc5301;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5302",referencedColumnName="id")
	Grade mc5302;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5303",referencedColumnName="id")
	Grade mc5303;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5304",referencedColumnName="id")
	Grade mc5304;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5305",referencedColumnName="id")
	Grade mc5305;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5311",referencedColumnName="id")
	Grade mc5311;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5312",referencedColumnName="id")
	Grade mc5312;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5313",referencedColumnName="id")
	Grade mc5313;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5401",referencedColumnName="id")
	Grade mc5401;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5402",referencedColumnName="id")
	Grade mc5402;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5403",referencedColumnName="id")
	Grade mc5403;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5404",referencedColumnName="id")
	Grade mc5404;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5001",referencedColumnName="id")
	Grade mc5001;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5002",referencedColumnName="id")
	Grade mc5002;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5003",referencedColumnName="id")
	Grade mc5003;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5004",referencedColumnName="id")
	Grade mc5004;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5005",referencedColumnName="id")
	Grade mc5005;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5411",referencedColumnName="id")
	Grade mc5411;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5412",referencedColumnName="id")
	Grade mc5412;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5413",referencedColumnName="id")
	Grade mc5413;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5501",referencedColumnName="id")
	Grade mc5501;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5502",referencedColumnName="id")
	Grade mc5502;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5503",referencedColumnName="id")
	Grade mc5503;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5006",referencedColumnName="id")
	Grade mc5006;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5007",referencedColumnName="id")
	Grade mc5007;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5008",referencedColumnName="id")
	Grade mc5008;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5009",referencedColumnName="id")
	Grade mc5009;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5010",referencedColumnName="id")
	Grade mc5010;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5011",referencedColumnName="id")
	Grade mc5011;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5012",referencedColumnName="id")
	Grade mc5012;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5013",referencedColumnName="id")
	Grade mc5013;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5014",referencedColumnName="id")
	Grade mc5014;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5015",referencedColumnName="id")
	Grade mc5015;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5511",referencedColumnName="id")
	Grade mc5511;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5512",referencedColumnName="id")
	Grade mc5512;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5513",referencedColumnName="id")
	Grade mc5513;
	
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="mc5611",referencedColumnName="id")
	Grade mc5611;
	
	/*
	 * String ma5161; String mc5101; String mc5102; String mc5103; String mc5104;
	 * 
	 * String mc5111; String mc5112; String mc5113;
	 * 
	 * String mc5201; String mc5202; String mc5203; String mc5204; String mc5205;
	 * 
	 * String mc5211; String mc5212; String mc5213;
	 * 
	 * String mc5301; String mc5302; String mc5303; String mc5304; String mc5305;
	 * 
	 * String mc5311; String mc5312; String mc5313;
	 * 
	 * String mc5401; String mc5402; String mc5403; String mc5404;
	 * 
	 * String mc5001; String mc5002; String mc5003; String mc5004; String mc5005;
	 * 
	 * String mc5411; String mc5412; String mc5413;
	 * 
	 * String mc5501; String mc5502; String mc5503;
	 * 
	 * String mc5006; String mc5007; String mc5008; String mc5009; String mc5010;
	 * String mc5011; String mc5012; String mc5013; String mc5014; String mc5015;
	 * 
	 * String mc5511; String mc5512; String mc5513;
		
	 * String mc5611;
	 */
	
	double gpa,cgpa;
	int inn;

	public External() {
		super();
		// TODO Auto-generated constructor stub
	}

	public External(User user, Semester semester, Grade ma5161, Grade mc5101, Grade mc5102, Grade mc5103,
			Grade mc5104, Grade mc5111, Grade mc5112, Grade mc5113, Grade mc5201, Grade mc5202, Grade mc5203,
			Grade mc5204, Grade mc5205, Grade mc5211, Grade mc5212, Grade mc5213, Grade mc5301, Grade mc5302,
			Grade mc5303, Grade mc5304, Grade mc5305, Grade mc5311, Grade mc5312, Grade mc5313, Grade mc5401,
			Grade mc5402, Grade mc5403, Grade mc5404, Grade mc5001, Grade mc5002, Grade mc5003, Grade mc5004,
			Grade mc5005, Grade mc5411, Grade mc5412, Grade mc5413, Grade mc5501, Grade mc5502, Grade mc5503,
			Grade mc5006, Grade mc5007, Grade mc5008, Grade mc5009, Grade mc5010, Grade mc5011, Grade mc5012,
			Grade mc5013, Grade mc5014, Grade mc5015, Grade mc5511, Grade mc5512, Grade mc5513, Grade mc5611, 
			double gpa, double cgpa, int inn) {
		super();
		this.user = user;
		this.semester = semester;
		this.ma5161 = ma5161;
		this.mc5101 = mc5101;
		this.mc5102 = mc5102;
		this.mc5103 = mc5103;
		this.mc5104 = mc5104;
		this.mc5111 = mc5111;
		this.mc5112 = mc5112;
		this.mc5113 = mc5113;
		this.mc5201 = mc5201;
		this.mc5202 = mc5202;
		this.mc5203 = mc5203;
		this.mc5204 = mc5204;
		this.mc5205 = mc5205;
		this.mc5211 = mc5211;
		this.mc5212 = mc5212;
		this.mc5213 = mc5213;
		this.mc5301 = mc5301;
		this.mc5302 = mc5302;
		this.mc5303 = mc5303;
		this.mc5304 = mc5304;
		this.mc5305 = mc5305;
		this.mc5311 = mc5311;
		this.mc5312 = mc5312;
		this.mc5313 = mc5313;
		this.mc5401 = mc5401;
		this.mc5402 = mc5402;
		this.mc5403 = mc5403;
		this.mc5404 = mc5404;
		this.mc5001 = mc5001;
		this.mc5002 = mc5002;
		this.mc5003 = mc5003;
		this.mc5004 = mc5004;
		this.mc5005 = mc5005;
		this.mc5411 = mc5411;
		this.mc5412 = mc5412;
		this.mc5413 = mc5413;
		this.mc5501 = mc5501;
		this.mc5502 = mc5502;
		this.mc5503 = mc5503;
		this.mc5006 = mc5006;
		this.mc5007 = mc5007;
		this.mc5008 = mc5008;
		this.mc5009 = mc5009;
		this.mc5010 = mc5010;
		this.mc5011 = mc5011;
		this.mc5012 = mc5012;
		this.mc5013 = mc5013;
		this.mc5014 = mc5014;
		this.mc5015 = mc5015;
		this.mc5511 = mc5511;
		this.mc5512 = mc5512;
		this.mc5513 = mc5513;
		this.mc5611 = mc5611;
		this.gpa = gpa;
		this.cgpa = cgpa;
		this.inn = inn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Grade getMa5161() {
		return ma5161;
	}

	public void setMa5161(Grade ma5161) {
		this.ma5161 = ma5161;
	}

	public Grade getMc5101() {
		return mc5101;
	}

	public void setMc5101(Grade mc5101) {
		this.mc5101 = mc5101;
	}

	public Grade getMc5102() {
		return mc5102;
	}

	public void setMc5102(Grade mc5102) {
		this.mc5102 = mc5102;
	}

	public Grade getMc5103() {
		return mc5103;
	}

	public void setMc5103(Grade mc5103) {
		this.mc5103 = mc5103;
	}

	public Grade getMc5104() {
		return mc5104;
	}

	public void setMc5104(Grade mc5104) {
		this.mc5104 = mc5104;
	}

	public Grade getMc5111() {
		return mc5111;
	}

	public void setMc5111(Grade mc5111) {
		this.mc5111 = mc5111;
	}

	public Grade getMc5112() {
		return mc5112;
	}

	public void setMc5112(Grade mc5112) {
		this.mc5112 = mc5112;
	}

	public Grade getMc5113() {
		return mc5113;
	}

	public void setMc5113(Grade mc5113) {
		this.mc5113 = mc5113;
	}

	public Grade getMc5201() {
		return mc5201;
	}

	public void setMc5201(Grade mc5201) {
		this.mc5201 = mc5201;
	}

	public Grade getMc5202() {
		return mc5202;
	}

	public void setMc5202(Grade mc5202) {
		this.mc5202 = mc5202;
	}

	public Grade getMc5203() {
		return mc5203;
	}

	public void setMc5203(Grade mc5203) {
		this.mc5203 = mc5203;
	}

	public Grade getMc5204() {
		return mc5204;
	}

	public void setMc5204(Grade mc5204) {
		this.mc5204 = mc5204;
	}

	public Grade getMc5205() {
		return mc5205;
	}

	public void setMc5205(Grade mc5205) {
		this.mc5205 = mc5205;
	}

	public Grade getMc5211() {
		return mc5211;
	}

	public void setMc5211(Grade mc5211) {
		this.mc5211 = mc5211;
	}

	public Grade getMc5212() {
		return mc5212;
	}

	public void setMc5212(Grade mc5212) {
		this.mc5212 = mc5212;
	}

	public Grade getMc5213() {
		return mc5213;
	}

	public void setMc5213(Grade mc5213) {
		this.mc5213 = mc5213;
	}

	public Grade getMc5301() {
		return mc5301;
	}

	public void setMc5301(Grade mc5301) {
		this.mc5301 = mc5301;
	}

	public Grade getMc5302() {
		return mc5302;
	}

	public void setMc5302(Grade mc5302) {
		this.mc5302 = mc5302;
	}

	public Grade getMc5303() {
		return mc5303;
	}

	public void setMc5303(Grade mc5303) {
		this.mc5303 = mc5303;
	}

	public Grade getMc5304() {
		return mc5304;
	}

	public void setMc5304(Grade mc5304) {
		this.mc5304 = mc5304;
	}

	public Grade getMc5305() {
		return mc5305;
	}

	public void setMc5305(Grade mc5305) {
		this.mc5305 = mc5305;
	}

	public Grade getMc5311() {
		return mc5311;
	}

	public void setMc5311(Grade mc5311) {
		this.mc5311 = mc5311;
	}

	public Grade getMc5312() {
		return mc5312;
	}

	public void setMc5312(Grade mc5312) {
		this.mc5312 = mc5312;
	}

	public Grade getMc5313() {
		return mc5313;
	}

	public void setMc5313(Grade mc5313) {
		this.mc5313 = mc5313;
	}

	public Grade getMc5401() {
		return mc5401;
	}

	public void setMc5401(Grade mc5401) {
		this.mc5401 = mc5401;
	}

	public Grade getMc5402() {
		return mc5402;
	}

	public void setMc5402(Grade mc5402) {
		this.mc5402 = mc5402;
	}

	public Grade getMc5403() {
		return mc5403;
	}

	public void setMc5403(Grade mc5403) {
		this.mc5403 = mc5403;
	}

	public Grade getMc5404() {
		return mc5404;
	}

	public void setMc5404(Grade mc5404) {
		this.mc5404 = mc5404;
	}

	public Grade getMc5001() {
		return mc5001;
	}

	public void setMc5001(Grade mc5001) {
		this.mc5001 = mc5001;
	}

	public Grade getMc5002() {
		return mc5002;
	}

	public void setMc5002(Grade mc5002) {
		this.mc5002 = mc5002;
	}

	public Grade getMc5003() {
		return mc5003;
	}

	public void setMc5003(Grade mc5003) {
		this.mc5003 = mc5003;
	}

	public Grade getMc5004() {
		return mc5004;
	}

	public void setMc5004(Grade mc5004) {
		this.mc5004 = mc5004;
	}

	public Grade getMc5005() {
		return mc5005;
	}

	public void setMc5005(Grade mc5005) {
		this.mc5005 = mc5005;
	}

	public Grade getMc5411() {
		return mc5411;
	}

	public void setMc5411(Grade mc5411) {
		this.mc5411 = mc5411;
	}

	public Grade getMc5412() {
		return mc5412;
	}

	public void setMc5412(Grade mc5412) {
		this.mc5412 = mc5412;
	}

	public Grade getMc5413() {
		return mc5413;
	}

	public void setMc5413(Grade mc5413) {
		this.mc5413 = mc5413;
	}

	public Grade getMc5501() {
		return mc5501;
	}

	public void setMc5501(Grade mc5501) {
		this.mc5501 = mc5501;
	}

	public Grade getMc5502() {
		return mc5502;
	}

	public void setMc5502(Grade mc5502) {
		this.mc5502 = mc5502;
	}

	public Grade getMc5503() {
		return mc5503;
	}

	public void setMc5503(Grade mc5503) {
		this.mc5503 = mc5503;
	}

	public Grade getMc5006() {
		return mc5006;
	}

	public void setMc5006(Grade mc5006) {
		this.mc5006 = mc5006;
	}

	public Grade getMc5007() {
		return mc5007;
	}

	public void setMc5007(Grade mc5007) {
		this.mc5007 = mc5007;
	}

	public Grade getMc5008() {
		return mc5008;
	}

	public void setMc5008(Grade mc5008) {
		this.mc5008 = mc5008;
	}

	public Grade getMc5009() {
		return mc5009;
	}

	public void setMc5009(Grade mc5009) {
		this.mc5009 = mc5009;
	}

	public Grade getMc5010() {
		return mc5010;
	}

	public void setMc5010(Grade mc5010) {
		this.mc5010 = mc5010;
	}

	public Grade getMc5011() {
		return mc5011;
	}

	public void setMc5011(Grade mc5011) {
		this.mc5011 = mc5011;
	}

	public Grade getMc5012() {
		return mc5012;
	}

	public void setMc5012(Grade mc5012) {
		this.mc5012 = mc5012;
	}

	public Grade getMc5013() {
		return mc5013;
	}

	public void setMc5013(Grade mc5013) {
		this.mc5013 = mc5013;
	}

	public Grade getMc5014() {
		return mc5014;
	}

	public void setMc5014(Grade mc5014) {
		this.mc5014 = mc5014;
	}

	public Grade getMc5015() {
		return mc5015;
	}

	public void setMc5015(Grade mc5015) {
		this.mc5015 = mc5015;
	}

	public Grade getMc5511() {
		return mc5511;
	}

	public void setMc5511(Grade mc5511) {
		this.mc5511 = mc5511;
	}

	public Grade getMc5512() {
		return mc5512;
	}

	public void setMc5512(Grade mc5512) {
		this.mc5512 = mc5512;
	}

	public Grade getMc5513() {
		return mc5513;
	}

	public void setMc5513(Grade mc5513) {
		this.mc5513 = mc5513;
	}

	public Grade getMc5611() {
		return mc5611;
	}

	public void setMc5611(Grade mc5611) {
		this.mc5611 = mc5611;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public int getInn() {
		return inn;
	}

	public void setInn(boolean inn) {
		this.inn = External.check(inn);
	}
	
	public static int check(boolean bool) {
		int status = 0;
		if(bool == true)
			status = 1;
		else
			status = 0;
		return status;
	}

	@Override
	public String toString() {
		return "External [id=" + id + ", user=" + user + ", semester=" + semester + ", ma5161=" + ma5161 + ", mc5101="
				+ mc5101 + ", mc5102=" + mc5102 + ", mc5103=" + mc5103 + ", mc5104=" + mc5104 + ", mc5111=" + mc5111
				+ ", mc5112=" + mc5112 + ", mc5113=" + mc5113 + ", mc5201=" + mc5201 + ", mc5202=" + mc5202
				+ ", mc5203=" + mc5203 + ", mc5204=" + mc5204 + ", mc5205=" + mc5205 + ", mc5211=" + mc5211
				+ ", mc5212=" + mc5212 + ", mc5213=" + mc5213 + ", mc5301=" + mc5301 + ", mc5302=" + mc5302
				+ ", mc5303=" + mc5303 + ", mc5304=" + mc5304 + ", mc5305=" + mc5305 + ", mc5311=" + mc5311
				+ ", mc5312=" + mc5312 + ", mc5313=" + mc5313 + ", mc5401=" + mc5401 + ", mc5402=" + mc5402
				+ ", mc5403=" + mc5403 + ", mc5404=" + mc5404 + ", mc5001=" + mc5001 + ", mc5002=" + mc5002
				+ ", mc5003=" + mc5003 + ", mc5004=" + mc5004 + ", mc5005=" + mc5005 + ", mc5411=" + mc5411
				+ ", mc5412=" + mc5412 + ", mc5413=" + mc5413 + ", mc5501=" + mc5501 + ", mc5502=" + mc5502
				+ ", mc5503=" + mc5503 + ", mc5006=" + mc5006 + ", mc5007=" + mc5007 + ", mc5008=" + mc5008
				+ ", mc5009=" + mc5009 + ", mc5010=" + mc5010 + ", mc5011=" + mc5011 + ", mc5012=" + mc5012
				+ ", mc5013=" + mc5013 + ", mc5014=" + mc5014 + ", mc5015=" + mc5015 + ", mc5511=" + mc5511
				+ ", mc5512=" + mc5512 + ", mc5513=" + mc5513 + ", mc5611=" + mc5611 + ", gpa=" + gpa + ", cgpa=" + cgpa
				+ ", inn=" + inn + "]";
	}
}