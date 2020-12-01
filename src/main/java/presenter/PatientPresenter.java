//package presenter;

//import model.PatientModel;
//import view.IPatientView;
//
//public class PatientPresenter implements IPatientView.IPatientViewListener {
//
//	private PatientModel model;
//	private IPatientView view;
//	private int ipdValue = 0;
//	private String reset = "Reset";
//	
//	public PatientPresenter(PatientModel model, IPatientView view) {
//		this.model = model;
//		this.view = view;
//		
//		view.showPID(ipdValue);
//		view.addListener(this);
//	}
//	@Override
//	public void buttonClick(char opeation) {
//		this.ipdValue = ipdValue;
//		view.showPID(ipdValue);
//		
//		switch (reset) {
//		case "Reset":
//			model.setPID(ipdValue);
//			break;
//
//		default:
//			break;
//		}
//		 
//		 
//		
//	}
//	
//
//}
