package view;

import java.util.ArrayList;

public interface IDiaryView {

	public void setUserInput(String display);
	
	interface IDiaryViewListener{
		void buttonClick(String diariestext) ;
	}
	
	public void addDiaryListener(IDiaryViewListener listener);
	public void showNotification(String notification);
}
