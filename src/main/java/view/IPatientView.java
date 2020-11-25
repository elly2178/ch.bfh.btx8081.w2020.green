package view;

public interface IPatientView {
	public void showPID(int pid);
	
	interface IPatientViewListener{
		// cahnge char operaiton
		void buttonClick(char opeation);
	}
	
	public void addListener(IPatientViewListener listener);

}
