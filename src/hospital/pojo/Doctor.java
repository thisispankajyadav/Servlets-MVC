package hospital.pojo;

public class Doctor {
	private int doc_id;
	private String doc_name;
	private String doc_spl,doc_qual;
	
	public Doctor(){}

	public Doctor(String doc_name, String doc_spl, String doc_qual) {
		super();
		this.doc_name = doc_name;
		this.doc_spl = doc_spl;
		this.doc_qual = doc_qual;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getDoc_spl() {
		return doc_spl;
	}

	public void setDoc_spl(String doc_spl) {
		this.doc_spl = doc_spl;
	}

	public String getDoc_qual() {
		return doc_qual;
	}

	public void setDoc_qual(String doc_qual) {
		this.doc_qual = doc_qual;
	}
	

}